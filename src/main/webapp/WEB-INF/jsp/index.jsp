
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<style>

.button1:hover {
    background-color: #4CAF50;
    color: white;
}

.button2:hover {
    background-color: #f44336;
    color: white;
}


div
{
padding:15px;
}

html,body
{
height:100%
}
form{
background: rgba(255,255,255,0.5);
width: 320px;
opacity:0.9;
box-shadow:0 0 20px black;
}


#background {
    background: url("scbbg.jpg") no-repeat bottom left;
    background-size: cover;
    width: 100%;
    height: 100%;
	min-height:100%;
}
</style>

</head>
<body id="background">
<div class="container" align="center">
<img src="standard-chartered-intership-programme-2016.jpg" alt="Standard Chartered" width="200" height="100" padding="150px">
</div>
<div align="center">

<form action="/welcome" method="post">
<h1><strong> Online Banking Login</strong></h1>

<div><label>Username</label>
<input type="text" name="user" required="required">
</div>
<div>
<label>Password</label>
<input type="password" name="pass" required="required">
</div>
<div>
<input type="submit" value="Login" class="w3-btn w3-border button1">
<input type="reset" value="Cancel" class="w3-btn w3-border button2">
</div>
</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
</body>
</html>