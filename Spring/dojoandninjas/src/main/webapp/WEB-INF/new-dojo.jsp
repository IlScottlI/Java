<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                <div class="container"><a class="navbar-brand" href="/">Dojos and Ninja</a><button
                        data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span
                            class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                    <div class="collapse navbar-collapse" id="navcol-1">
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item"><a class="nav-link" href="/dojos/new">New Dojo</a></li>
                            <li class="nav-item"><a class="nav-link" href="/ninjas/new">New Ninja</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
            <div class="container">
                <form:form action="/dojos/new" method="post" modelAttribute="dojo">
                    <div class="form-group">
                        <h3 class="ml-4">New Dojo</h3>
                        <div class="row p-3">
                            <div class="col-xl-2 text-right">
                                <form:label path="name" class="col-form-label">Name:</form:label>
                            </div>
                            <div class="col-xl-3">
                                <form:errors path="name" class="text-danger" />
                                <form:input class="form-control" path="name" />
                            </div>
                        </div>
                        <div class="row p-3">
                            <div class="col-2"></div>
                            <div class="col-3 text-center">
                                <button class="btn btn-outline-secondary btn-block" type="submit">Create</button>
                            </div>
                        </div>
                </form:form>
            </div>
            <script src="/assets/js/jquery.min.js"></script>
            <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
        </body>

        </html>