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
    <nav class="navbar navbar-light navbar-expand-md navigation-clean-search bg-light-gray">
        <div class="container"><a class="navbar-brand text-primary" href="home.html">Lookify</a></div>
    </nav>
    <div class="container">
        <nav class="navbar navbar-light navbar-expand-md navigation-clean">
            <div class="container">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item"><a class="nav-link">Songs by artist: Sheeran</a></li>
                    <li class="nav-item"></li>
                    <li class="nav-item text-secondary"><i class="fa fa-search p-2 pt-3"></i></li>
                </ul>
                <form class="form-inline" method="post"><input class="form-control form-control-sm" type="search" value="Sheeran"><button class="btn btn-outline-secondary btn-sm ml-2" type="submit">New Search</button></form>
                <div class="collapse navbar-collapse d-xl-flex justify-content-xl-end" id="navcol-1">
                    <ul class="navbar-nav float-right">
                        <li class="nav-item"><a class="navbar-brand text-primary" href="/dashboard">Lookify</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="card">
            <div class="card-body">
                <div class="table-responsive table-bordered">
                    <table class="table table-bordered table-hover">
                        <thead class="thead-light">
                            <tr>
                                <th>Name</th>
                                <th>Rating</th>
                                <th>actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><a href="view-song.html">Shape of you</a></td>
                                <td style="max-width: 1rem;"><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star"></span><span class="fa fa-star"></span>&nbsp; &nbsp; 8/10</td>
                                <td style="max-width: 1rem;"><button class="btn btn-outline-primary btn-block" type="button">Delete</button></td>
                            </tr>
                            <tr>
                                <td><a href="#">Castle on the Hill</a></td>
                                <td style="max-width: 1rem;"><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star checked"></span><span class="fa fa-star"></span>&nbsp; &nbsp; 9/10</td>
                                <td style="max-width: 1rem;"><button class="btn btn-outline-primary btn-block" type="button">Delete</button></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>