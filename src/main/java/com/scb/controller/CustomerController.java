package com.scb.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.scb.model.Customer;
import com.scb.model.OtpSystem;
import com.scb.service.CustomerService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Controller
//@RequestMapping(value = "/a")
public class CustomerController {
	
	@Autowired
	private CustomerService custService;
	
	private Map<String, OtpSystem> otp_data = new HashMap();
	public final static String ACC_SID = "AC94e9372726a9c514a69dac9701198152";
	public final static String ACC_KEY = "5d335847d77f7433be0ac2e734e5a909";
	
	static{
		Twilio.init(ACC_SID, ACC_KEY);
	}

	
	//index page to welcome page	
	@RequestMapping("/welcome")
	public ModelAndView login(HttpServletRequest req, @RequestParam(name="user")String user,@RequestParam(name="pass")String pass, Model model, Customer cust) {
        
		ModelAndView mav=new ModelAndView();
        HttpSession hs = req.getSession();
		model.addAttribute("user",user);
        model.addAttribute("pass",pass);
        System.out.println("passfrompage"+pass);
        cust.setUser(user);
        String pass_db = custService.getPassword(cust);
        System.out.println("passfromdb"+pass_db);
        hs.setAttribute("newSession", user);
	
			if(pass.compareTo(pass_db)==0){
				mav.setViewName("welcome");
				// #########################################################3
		    	cust.setUser(user);
				String name = custService.getName(cust);
				mav.addObject("name",name);
				//#########################################################
				System.out.println("succesful");
				
			}
			else{
				mav.setViewName("index");
				String error = null;
				//mav.addObject("error please enter correctly",error);
				System.out.println("unsuccessful");}
		return mav;
	}
	
	
	//welcome to wattounlock page
	@RequestMapping("/wattounlock")
	public ModelAndView choice(HttpServletRequest request,ModelAndView m, Customer cust){
    	
		HttpSession hs = request.getSession();
		String user =(String)hs.getAttribute("newSession");  
        
    	cust.setUser(user);
    	
    	List<Customer> card = custService.getCardDets(cust);
    	String card1 = card.get(0).getCard1();
    	System.out.println(card1);
    	String x="xxxxxxxxxxxx";
    	
    	String mcard1="";
    	mcard1=x.concat(card1.substring(card1.length() - 4));
    	System.out.println(mcard1);
    	m.addObject("card1",mcard1);
    	String card2 = card.get(0).getCard2();
    	String mcard2="";
    	mcard2=x.concat(card2.substring(card1.length() - 4));
    	m.addObject("card2", mcard2);
		m.setViewName("wattounlock");
		return m;
	}
	
    
  //wattounlock to otp
    @RequestMapping(value="/enterotp", method = RequestMethod.POST)
    public ModelAndView generateOTP(HttpServletRequest request,Customer cust , Model model){
    	HttpSession hs = request.getSession();
    	ModelAndView m = new ModelAndView();
    	String user =(String)hs.getAttribute("newSession");  
        
    	cust.setUser(user);
    	
    	String mobilenumber = custService.getMobileNumber(cust); 
    	System.out.println("Mobile number:"+mobilenumber);
    	OtpSystem otpsys = new OtpSystem();
		otpsys.setExpiryTime(System.currentTimeMillis()+40000);
		otpsys.setMobilenumber(mobilenumber);
		otpsys.setOtp(String.valueOf(((int)(Math.random()*(10000-1000))) + 1000));
		otp_data.put(mobilenumber,otpsys);
		System.out.println(otpsys.getOtp());
		
			if(Message.creator(new PhoneNumber("+919717987586"), new PhoneNumber("+18506798536"),"Your OTP is: " + otpsys.getOtp()).create() != null)
				System.out.println("Successful");
    	ResponseEntity re = new ResponseEntity<>("OTP is sent succesfully", HttpStatus.OK);
        System.out.println(re.getStatusCodeValue());
    	if(re.getStatusCodeValue()==200)
        {
        	m.setViewName("enterotp");
        }
        else
        {
        	String error1 = null;
        	m.addObject("Please choose a valid card", error1);
        	m.setViewName("wattounlock");
        }
        return m;
    }
    
    @RequestMapping(value = "/unlocked", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ModelAndView verifyOtp(Customer cust,HttpServletRequest req /*@RequestBody OtpSystem reqOtpsys*/, @RequestParam(value = "otp") String otp){
 
    	System.out.println("-----Verify----");
    	ModelAndView m = new ModelAndView();
    	HttpSession hs = req.getSession();
    	
    	String user_otp = otp;
    	String user =(String)hs.getAttribute("newSession");
    	ResponseEntity re;
    	//System.out.println(reqOtpsys.getOtp());
        cust.setUser(user);
    	System.out.println(cust.getUser());
    	String mobilenumber = custService.getMobileNumber(cust); 
    	OtpSystem otpsys = otp_data.get(mobilenumber);
        System.out.println(mobilenumber);
        
        
        System.out.println(user_otp+" "+ otpsys.getOtp());
        if(user_otp.compareTo(otpsys.getOtp())==0)
        {
        	m.setViewName("unlocked");
        }
        else{
        	m.setViewName("wattounlock");
        }
        return m;
    	
    	/*if(reqOtpsys.getOtp()==null||reqOtpsys.getOtp().trim().length()<=0)
    	{
    		re =  new ResponseEntity<>("Please enter OTP", HttpStatus.BAD_REQUEST);
    		if(re.getStatusCodeValue()==400)
    		{
    			m.setViewName("wattounlock");
    		}
    	}
    	
    	if(otp_data.containsKey(mobilenumber)){
    		OtpSystem otpsys = otp_data.get(mobilenumber);
    		if(otpsys!=null)
    		{
    			if(otpsys.getExpiryTime()>=System.currentTimeMillis())
    			{
    				if(reqOtpsys.getOtp().equals(otpsys.getOtp()))
    				{
    					otp_data.remove(mobilenumber);
    					re =  new ResponseEntity<>("OTP verfied susccefully", HttpStatus.OK);
                        if(re.getStatusCodeValue()==200)
                        {
                        	m.setViewName("unlocked");
                        }
    				}
    			}
    			re =  new ResponseEntity<>("OTP expired", HttpStatus.BAD_REQUEST);
        		if(re.getStatusCodeValue()==400)
        		{
        			m.setViewName("wattounlock");
        		}
    		}
    	    re = new ResponseEntity<>("Something went wrong...", HttpStatus.BAD_REQUEST);
    		if(re.getStatusCodeValue()==400)
    		{
    			m.setViewName("wattounlock");
    		}
    	}
    	re = new ResponseEntity<>("Mobile Number not found.", HttpStatus.NOT_FOUND);
		if(re.getStatusCodeValue()==404)
		{
			m.setViewName("wattounlock");
		}
		return m;
 */   }
    
    @RequestMapping(value="/logout")
    public ModelAndView logout(HttpServletRequest req, Customer cust)
    {
    	ModelAndView m = new ModelAndView();
    	
    	HttpSession hs = req.getSession();
    	String user =(String)hs.getAttribute("newSession");
    	hs.removeAttribute("newSession");
        m.setViewName("logout");
        String logOut = "";
        m.addObject("Successfully Logged Out", logOut);
        return m;
    }
    
    @RequestMapping(value="/unlock")
    public ModelAndView unlock(HttpServletRequest req, Customer cust){
    	ModelAndView m = new ModelAndView();
    	HttpSession hs = req.getSession();
		String user =(String)hs.getAttribute("newSession");
		cust.setUser(user);
			m.setViewName("unlock");

		return m;
    }
    
    @RequestMapping(value="/idoremail")
    public ModelAndView dispnum(HttpServletRequest request,ModelAndView m, Customer cust){
    	HttpSession hs = request.getSession();
		String user =(String)hs.getAttribute("newSession");
    	cust.setUser(user);
    	String mobilenumber = custService.getMobileNumber(cust);
    	m.addObject("num",mobilenumber);
    	m.setViewName("idoremail");
		return m;
    }
    // ########################################################################
    @RequestMapping(value="/subscribe")
    public ModelAndView subscribe(HttpServletRequest req,Customer cust) {    
		System.out.println("hello");
    	ModelAndView a =new ModelAndView();
    	a.setViewName("subscribe");
    	return a;
    	//#######################################################################
    }
    
    @RequestMapping(value="/locked")
    public ModelAndView locked(HttpServletRequest req, @RequestParam(name="card_no")String card_no,@RequestParam(name="mob_no")String mob_no, Model model,Customer cust) {    
		System.out.println("hello");
    	ModelAndView a =new ModelAndView();
    	
    	HttpSession hs = req.getSession();
    	String user =(String)hs.getAttribute("newSession");
    	cust.setUser(user);
        cust.setCard1(card_no);
        String b;
        b=("+91"+mob_no);
        System.out.println(b);
        cust.setMobilenumber(b);
        int res = custService.enterDets(cust);
        if(res>0)
        {
        	a.setViewName("locked");
        }
        
    	return a;
    }
}
