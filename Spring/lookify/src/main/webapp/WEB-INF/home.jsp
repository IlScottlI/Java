<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Lookify</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/FontAwesome.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/Navigation-Clean.css">
    <link rel="stylesheet" href="assets/css/Navigation-with-Search.css">
    <link rel="stylesheet" href="assets/css/Registration-Form-with-Photo.css">
    <link rel="stylesheet" href="assets/css/styles.css">
    <link rel="stylesheet" href="assets/css/User-Rating-F19690.css">
</head>

<body>
    <nav class="navbar navbar-light navbar-expand-md shadow-sm navigation-clean-search bg-light-gray">
        <div class="container"><a class="navbar-brand text-primary" href="/dashboard">Lookify</a><button class="navbar-toggler" data-toggle="collapse"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button></div>
    </nav>
    <section class="register-photo">
        <div class="form-container bg-light-gray">
            <form class="shadow-sm" method="post">
                <h1 class="text-center">Welcome&nbsp;to <strong>Lookify</strong>!</h1>
                <div class="form-group mt-5"><a class="btn btn-outline-primary btn-block btn-lg" role="button" href="/dashboard">Start Looking!</a></div>
            </form>
        </div>
    </section>

    <div>${message}</div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>