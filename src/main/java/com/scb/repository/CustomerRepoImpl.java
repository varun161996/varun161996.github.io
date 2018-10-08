package com.scb.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.scb.model.Customer;

@Repository("custRepository")
public class CustomerRepoImpl implements CustomerRepository {
	
	@Autowired
	JdbcTemplate jt;
	
	@Override
	public String getMobNumFromJdbc(Customer cust) {
		 
		String res =  jt.queryForObject("select mobileNumber from customerscb where username = ?",new Object[]{cust.getUser()}, String.class);
		return res;/*(String)jt.query("select mob_num from cust where username ="+cust.getUser(), new myRowMapper());*/
	}

	@Override
	public String getPassFromDb(Customer cust) {
		// TODO Auto-generated method stub
		return jt.queryForObject("select password from customerSCB where username = ?",new Object[]{cust.getUser()}, String.class);
	}

	@Override
	public List<Customer> getCardDetsFromDb(Customer cust) {
		// TODO Auto-generated method stub
		System.out.println("Entered");
		return jt.query("select card1, card2 from CardDetails where uname = ?" ,new Object[]{cust.getUser()}, new myRowMapper());
	}
	@Override
	public String getNameFromDb(Customer cust) {
		// TODO Auto-generated method stub
		return jt.queryForObject("select name from customerSCB where username = ?",new Object[]{cust.getUser()}, String.class);
	}

	@Override
	public int enterDetsToDb(Customer cust) {
		int res = 0;
		if(jt.update("update customerSCB set mobilenumber=? where username = ?",cust.getMobilenumber(), cust.getUser())>0){
		   res = jt.update("update cardDetails set card1=? where uname = ?",cust.getCard1(), cust.getUser());
		}
		return res;
	}

	@Override
	public String getSubDetails(Customer cust) {
		// TODO Auto-generated method stub
		return jt.queryForObject("select subscribe from customerSCB where username = ?",new Object[]{cust.getUser()}, String.class);
	}
}


class myRowMapper implements RowMapper<Customer>{

	@Override
	public Customer mapRow(ResultSet arg0, int arg1) throws SQLException {
		Customer cust = new Customer();
		cust.setCard1(arg0.getString(1));
		cust.setCard2(arg0.getString(2));
		return cust;
	}
}


