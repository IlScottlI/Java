<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Lookify</title>
        <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/assets/css/FontAwesome.css">
        <link rel="stylesheet" href="/assets/fonts/font-awesome.min.css">
        <link rel="stylesheet" href="/assets/css/Navigation-Clean.css">
        <link rel="stylesheet" href="/assets/css/Navigation-with-Search.css">
        <link rel="stylesheet" href="/assets/css/Registration-Form-with-Photo.css">
        <link rel="stylesheet" href="/assets/css/styles.css">
        <link rel="stylesheet" href="/assets/css/User-Rating-F19690.css">
    </head>

    <body>
        <nav class="navbar navbar-light navbar-expand-md shadow-sm navigation-clean-search bg-light-gray">
            <div class="container"><a class="navbar-brand text-primary" href="/dashboard">Lookify</a><button
                    class="navbar-toggler" data-toggle="collapse"><span class="sr-only">Toggle navigation</span><span
                        class="navbar-toggler-icon"></span></button></div>
        </nav>
        <section class="register-photo">
            <div class="row justify-content-center align-items-center p-4">
                <div class="col-xl-3 align-self-end">
                    <h5 class="text-left">Top Ten Songs</h5>
                </div>
                <div class="col-xl-3 text-right align-self-end"><a class="btn btn-outline-primary text-right"
                        role="button" href="/dashboard">Dashboard</a></div>
            </div>
            <div class="form-container bg-light-gray">
                <form class="shadow-sm" method="post">
                    <ul class="list-unstyled">
                        <c:forEach items="${songs}" var="song">
                            <li>${song.rating} -&nbsp;<a href="/songs/${song.id}">${song.name}</a>&nbsp;- ${song.artist}
                            </li>
                        </c:forEach>
                    </ul>
                </form>
            </div>
        </section>
        <script src="/assets/js/jquery.min.js"></script>
        <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
    </body>

    </html>