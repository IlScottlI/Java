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
                <form:form action="/ninjas/new" method="post" modelAttribute="ninja">
                    <div class="form-group">
                        <h3 class="ml-4">New Ninja</h3>
                        <div class="form-row p-3">
                            <div class="col-xl-2 text-right">
                                <form:label path="dojo" class="col-form-label h1" style="font-size: 17px;">Dojo
                                </form:label>
                            </div>
                            <div class="col-xl-3">
                                <form:errors path="dojo" class="text-danger" />
                                <form:select path="dojo" class="form-control">
                                    <form:options items="${dojos}" itemValue="id" itemLabel="name" />
                                </form:select>
                            </div>
                        </div>
                        <div class="form-row p-3">
                            <div class="col-xl-2 text-right">
                                <form:label path="firstName" class="col-form-label h1" style="font-size: 17px;">First
                                    Name
                                </form:label>
                            </div>
                            <div class="col-xl-3">
                                <form:errors path="firstName" class="text-danger" />
                                <form:input class="form-control" path="firstName" />
                            </div>
                        </div>
                        <div class="form-row p-3">
                            <div class="col-xl-2 text-right">
                                <form:label path="lastName" class="col-form-label h1" style="font-size: 17px;">Last
                                    Name
                                </form:label>
                            </div>
                            <div class="col-xl-3">
                                <form:errors path="lastName" class="text-danger" />
                                <form:input class="form-control" path="lastName" />
                            </div>
                        </div>
                        <div class="form-row p-3">
                            <div class="col-xl-2 text-right">
                                <form:label path="age" class="col-form-label h1" style="font-size: 17px;">
                                    Age
                                </form:label>
                            </div>
                            <div class="col-xl-3">
                                <form:errors path="age" class="text-danger" />
                                <form:input class="form-control" path="age" type="number" />
                            </div>
                        </div>
                        <div class="form-row p-3">
                            <div class="col-xl-2"><label class="col-form-label"></label></div>
                            <div class="col-xl-3 text-center"><button class="btn btn-outline-secondary btn-block"
                                    type="submit">Create</button></div>
                        </div>
                    </div>
                </form:form>
            </div>
            <script src="/assets/js/jquery.min.js"></script>
            <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
        </body>

        </html>