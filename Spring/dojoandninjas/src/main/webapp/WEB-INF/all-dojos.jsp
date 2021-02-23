<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Dojo and Ninjas</title>
        <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/assets/css/Navigation-Clean.css">
        <link rel="stylesheet" href="/assets/css/styles.css">
    </head>

    <body>
        <nav class="navbar navbar-light navbar-expand-md navigation-clean">
            <div class="container"><a class="navbar-brand" href="/">Dojos and Ninja</a><button data-toggle="collapse"
                    class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span
                        class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navcol-1">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item"><a class="nav-link" href="/dojos/new">New Dojo</a></li>
                        <li class="nav-item"><a class="nav-link" href="/ninjas/new">New Ninja</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <h2>Dojos</h2>
            <div class="table-responsive">
                <table class="table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Dojo Name</th>
                            <th>Ninja Count</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${dojos}" var="dojo">
                            <tr>
                                <td><a href="/dojos/${dojo.id}">${dojo.id}</a></td>
                                <td>${dojo.name}</td>
                                <td>${dojo.ninjas.size()}</td>
                            </tr>
                        </c:forEach>
                        <tr></tr>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="/assets/js/jquery.min.js"></script>
        <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
    </body>

    </html>