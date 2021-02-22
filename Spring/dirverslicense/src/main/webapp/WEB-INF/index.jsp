<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Drivers License</title>
        <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/assets/css/Features-Boxed.css">
        <link rel="stylesheet" href="/assets/css/styles.css">
    </head>

    <body>
        <section class="features-boxed">
            <div class="container">
                <div class="intro">
                    <h2 class="text-center">Drivers|<strong>License</strong><br></h2>
                </div>
                <div class="row justify-content-start features p-3">
                    <div class="col-2">
                        <button class="btn text-primary" onclick="window.location = '/persons/new'">New Person</button>
                    </div>
                    <div class="col-2">
                        <button class="btn text-primary" onclick="window.location = '/licenses/new'">New
                            License</button>
                    </div>
                    <div class="col-8">

                    </div>
                    <div class="col-sm-6 col-md-5 col-lg-4 col-xl-9 item">

                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>First Name</th>
                                        <th>Last Name</th>
                                        <th>License #</th>
                                        <th>Expiration Date</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${licenses}" var="license">
                                        <tr>
                                            <td>${license.person.firstName}</td>
                                            <td>${license.person.lastName}</td>
                                            <td>${license.number}</td>
                                            <td>${license.expirationDate}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script src="/assets/js/jquery.min.js"></script>
        <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
    </body>

    </html>