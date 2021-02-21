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
        <nav class="navbar navbar-light navbar-expand-md navigation-clean-search bg-light-gray">
            <div class="container"><a class="navbar-brand text-primary" href="/dashboard">Lookify</a></div>
        </nav>
        <div class="container">
            <nav class="navbar navbar-light navbar-expand-md navigation-clean">
                <div class="container">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item"><a class="nav-link text-primary" href="/songs/new">Add New</a></li>
                        <li class="nav-item"><a class="nav-link text-primary" href="/search/topTen">Top Songs</a></li>
                        <li class="nav-item"></li>
                        <li class="nav-item text-secondary"><i class="fa fa-search p-2 pt-3"></i></li>
                    </ul>
                    <form class="form-inline" method="post" action="/search">
                        <input class="form-control form-control-sm" type="search" name="term">
                        <button class="btn btn-outline-secondary btn-sm ml-2" type="submit">Search Artists</button>
                    </form>
                    <div class="collapse navbar-collapse" id="navcol-1"></div>
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
                                <c:forEach items="${songs}" var="song">
                                    <tr>
                                        <td><a href="/songs/${song.id}">${song.name}</a></td>
                                        <td style="max-width: 1rem;">${song.ratingStars}&nbsp; &nbsp; ${song.rating}/10
                                        </td>
                                        <td style="max-width: 1rem;">
                                            <form action="/songs/${song.id}" method="post">
                                                <input type="hidden" name="_method" value="delete">
                                                <button class="btn btn-outline-primary btn-block"
                                                    type="submit">Delete</button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <script src="/assets/js/jquery.min.js"></script>
        <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
    </body>

    </html>