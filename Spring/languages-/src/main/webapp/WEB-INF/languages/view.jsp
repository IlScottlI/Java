<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Languages</title>
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/fonts/ionicons.min.css">
        <link rel="stylesheet" href="assets/css/styles.css">
    </head>

    <body>
        <div>
            <div>
                <div class="row padMar colorCajasBlancas modalInferior">
                    <div class="col modal-content">
                        <div class="row">
                            <div class="col">
                                <nav class="navbar navbar-light navbar-expand-md navigation-clean">
                                    <div class="container"><a class="navbar-brand" href="#">Languages</a><button
                                            data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span
                                                class="sr-only">Toggle navigation</span><span
                                                class="navbar-toggler-icon"></span></button>
                                        <div class="collapse navbar-collapse" id="navcol-1">
                                            <ul class="navbar-nav ml-auto">
                                                <li class="nav-item"><a
                                                        class="nav-link active btn-sm btn-primary text-white"
                                                        href="/languages/new">Add Language</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="sombraModales" class="sombraModales"></div>
            <div class="row mx-auto">
                <div class="col-12 col-lg-8 col-xl-8 colorCajasBlancas mx-auto">
                    <div class="row">
                        <div class="col">
                            <div class="row">
                                <div class="col">
                                    <div class="table-responsive txtsGrises pasos">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th>Name</th>
                                                    <th>Creator</th>
                                                    <th>Version</th>
                                                    <th>action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${entities}" var="entity">
                                                    <tr>
                                                        <td>${entity.name}</td>
                                                        <td>${entity.creator}</td>
                                                        <td>${entity.currentVersion}</td>
                                                        <td>
                                                            <button class="btn btn-primary btn-sm btn-Oscuro"
                                                                type="button"
                                                                onclick="window.location = '/languages/' + '${entity.id}' + '/edit' ">
                                                                <i class="icon ion-edit"></i>
                                                            </button>
                                                            <button class="btn btn-primary btn-sm btn-Oscuro"
                                                                type="button"
                                                                onclick="window.location = '/languages/' + '${entity.id}'">
                                                                <i class="icon ion-ios-list-outline"></i>
                                                            </button>
                                                            <form action="/languages/${entity.id}" method="post"
                                                                class="mt-2">
                                                                <input type="hidden" name="_method" value="delete">
                                                                <button class="btn btn-primary btn-sm btn-Oscuro"
                                                                    type="submit">
                                                                    <i class="icon ion-trash-a"></i>
                                                                </button>
                                                            </form>

                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <hr />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    </body>

    </html>