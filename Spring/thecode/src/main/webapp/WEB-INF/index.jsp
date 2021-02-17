<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Untitled</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/fonts/ionicons.min.css">
    <link rel="stylesheet" href="assets/css/Login-Form-Dark.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>
    <section class="login-dark">
		<form method="post" action="/trycode">
			${errormessage}
            <div class="illustration">
                <h1><i class="icon ion-ios-locked-outline"></i>&nbsp;The Code</h1>
            </div>
            <div class="form-group">
				<sub class="d-flex justify-content-xl-center align-items-xl-center">What is the code?</sub>
				<input class="form-control" type="code" name="code" placeholder="Code">
			</div>
            <div class="form-group">
				<button class="btn btn-primary btn-block" type="submit">Try Code</button>
			</div>
        </form>
    </section>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>