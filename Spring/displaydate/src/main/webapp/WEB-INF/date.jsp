<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Display Date</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/Features-Boxed.css">
    <link rel="stylesheet" href="css/styles.css">
</head>

<body >
    <section class="features-boxed">
        <div class="container">
            <div class="intro"></div>
            <div class="row justify-content-center features">
                <div class="col-sm-6 col-md-5 col-lg-4 col-xl-9 item">
                    <div class="shadow box">
                        <h3 class="name"></h3><a class="h1"><c:out value="${date}"/></a>
                    </div>
                </div>
            </div>
        </div>
	</section>
	
</body>

</html>
