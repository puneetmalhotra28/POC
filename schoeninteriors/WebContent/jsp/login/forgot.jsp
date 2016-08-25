<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
<script src="resources/js/prefixfree.min.js"></script>


</head>

<body>

	<div class="body"></div>
	<div class="grad"></div>
	<div class="header">
		<div>
			Schoen<span>Interiors</span>
		</div>
	</div>
	<br>
	<div class="login">
	<p class="error">${information}</p>
		<form action="/schoeninteriros/forgotpassword" method="post" name="myform">
		<br>	
			<input type="text" placeholder="username" name="username"><br>
			<input type="button" value="Forgot"
				onclick="document.forms['myform'].submit();"><br /> <br/><a
				href="/schoeninteriros/login" class="text" />Login</a>
		</form>
	</div>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>





</body>
</html>