<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                    <h2 onclick="window.location = '/'" style="cursor: pointer;" class="text-center">
                        Drivers|<strong>License</strong>
                    </h2>
                </div>
                <h1>New License</h1>
                <div class="row justify-content-start features p-3">
                    <div class="col-sm-6 col-md-5 col-lg-4 col-xl-5 item">
                        <div class="shadow box">
                            <form:form action="/licenses/new" method="post" modelAttribute="license">
                                <div class="form-group">
                                    <div class="form-row p-3">
                                        <div class="col">
                                            <form:label path="person" class="col-form-label">Person:</form:label>
                                        </div>
                                        <div class="col">
                                            <form:select path="person" class="form-control">
                                                <form:options items="${persons}" itemValue="id" itemLabel="fullName" />
                                            </form:select>
                                        </div>
                                    </div>
                                    <div class="form-row p-3">
                                        <div class="col">
                                            <form:label path="state" class="col-form-label">State:</form:label>
                                        </div>
                                        <div class="col">
                                            <form:errors path="state" class="text-danger" />
                                            <form:input class="form-control" path="state" />
                                        </div>
                                    </div>
                                    <div class="form-row p-3">
                                        <div class="col">
                                            <label path="expirationDate" class="col-form-label">Expiration
                                                Date:</label>
                                        </div>
                                        <div class="col">
                                            <form:errors path="expirationDate" class="text-danger" />
                                            <form:input class="form-control" path="expirationDate" type="date" />
                                        </div>
                                    </div>
                                    <div class="form-row justify-content-end">
                                        <div class="col-xl-6"><button class="btn btn-outline-secondary"
                                                type="submit">Create</button></div>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script src="/assets/js/jquery.min.js"></script>
        <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
    </body>

    </html>