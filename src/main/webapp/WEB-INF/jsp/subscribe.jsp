<!DOCTYPE html>
<html lang="en">
<head>
  <title>Card Lock</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
 
  <style>
      input[type=number]::-webkit-inner-spin-button, 
input[type=number]::-webkit-outer-spin-button { 
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
    margin: 0; 
}
      .button1:hover {
    background-color: green;
	 color: white;
	}
	.button2:hover {
    background-color: red;
	 color: white;
	}
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height:585px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    .navbarinvert
    {
      background-color:ghostwhite;
      color:black;
    }
    .navbarheader0{
      height: 70px;
    }
    .navbarheader1{
      height: 30px;
      background-color:dimgrey;
    }
  
}
.india
{
  color:green;
}
.left
{
  width:12%;
  height:100%;
  background-color:whitesmoke;
  float:left;
  text-align:left;
}
.right
{
  width:88%;
}
.top
{
  height:3%;
}
a{
    color:white;
}
a:hover{
  color: white;
}
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
</head>
<body>
    <div class="navbarheader0">

<img src="logo.png" style="height:70px"></img>
<ul style="margin-top:-2%; margin-left:10%; color:limegreen;font-size:17px"><b>India</b></ul>
 <ul style="margin-top: -4%;margin-left:81%;color:gray;font-size:26px;font-family:Arial"><b>Online Banking</b></ul>
    </div>




    <div class="navbarheader1" style="padding-top: 2px">
       <p style="margin-left:81%; display: inline;font-family:Times New Roman;font-size:16px"><a href="welcome"><span class="glyphicon glyphicon-home"></span> Home</a>
      <a href="#" style="padding-left:20px"><span class="glyphicon glyphicon-cog"></span> Settings</a>
       <a href="logout.html" style="padding-left:20px"><span class="glyphicon glyphicon-log-out"></span> Logout</a></p>
    </div>

  
<div class="container-fluid text-center">    
  <div class="row content">
   <div class="left">

<p style="line-height:28px;padding-left:8px">
<a href="#" style="color:black; font-size:13px"><span class="glyphicon glyphicon-chevron-right" style="font-size:13px"></span> Overview</a><br>
<a href="#" style="color:black; font-size:13px"><span class="glyphicon glyphicon-chevron-right" style="font-size:13px"></span> Accounts</a><br>
<a href="#" style="color:black; font-size:13px"><span class="glyphicon glyphicon-chevron-right" style="font-size:13px"></span> Open Term Deposit</a><br>
<a href="#" style="color:black; font-size:13px"><span class="glyphicon glyphicon-chevron-right" style="font-size:13px"></span> Payments</a><br>
<a href="#" style="color:black; font-size:13px"><span class="glyphicon glyphicon-chevron-right" style="font-size:13px"></span> Online Mutual Fund</a><br>
<a href="#" style="color:black; font-size:13px"><span class="glyphicon glyphicon-chevron-right" style="font-size:13px"></span> Investment</a><br>
<a href="#" style="color:black; font-size:13px"><span class="glyphicon glyphicon-chevron-right" style="font-size:13px"></span> Insurance</a><br>
<a href="#" style="color:black; font-size:13px"><span class="glyphicon glyphicon-chevron-right" style="font-size:13px"></span> Digital Signature</a><br>
<a href="#" style="color:black; font-size:13px"><span class="glyphicon glyphicon-chevron-right" style="font-size:13px"></span> Profile</a><br>
<a href="#" style="color:black; font-size:13px"><span class="glyphicon glyphicon-chevron-right" style="font-size:13px"></span> Online Rewards</a><br>
</p>
<hr>
<p style="line-height:28px;padding-left:8px">
  <a href="subscribe" style="color:black; font-size:13px"><span class="glyphicon glyphicon-chevron-right" style="font-size:13px"></span> Card Lock Service<br/>
  <a href="unlock" style="color:black; font-size:13px"><span class="glyphicon glyphicon-chevron-right" style="font-size:13px"></span> Unlock Debit Card</a><br>
</p><hr>
<p style="line-height:28px;padding-left:8px">
  <a href="#" style="color:black; font-size:13px"><span class="glyphicon glyphicon-chevron-right" style="font-size:13px"></span> e-Statements</a><br>
  <a href="#" style="color:black; font-size:13px"><span class="glyphicon glyphicon-chevron-right" style="font-size:13px"></span> Applications</a><br>
  <a href="#" style="color:black; font-size:13px"><span class="glyphicon glyphicon-chevron-right" style="font-size:13px"></span> Rates</a><br>
  </p>

    </div></br></br>
   <form action="locked" method="POST">
  Enter your Card Number: <input type="text" name="card_no" required="required" pattern="[0-9]{16}" title=" Enter 16 digit Card Number">
  </br>
  </br>
  Enter your Mobile Number: <input type="text" name="mob_no" required="required" pattern="[0-9]{10}" title=" Enter 10 digit Mobile Number">
    </br></br>
    <input type="submit" value="Lock_Card" class="button1">
    </form></br>
     Your card has to unlocked through OTP after it is locked
  </div>

</div>
</body>
</html>
