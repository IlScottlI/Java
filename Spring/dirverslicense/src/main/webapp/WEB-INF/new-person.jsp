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
                <h1>New Person</h1>
                <div class="row justify-content-start features p-3">
                    <div class="col-sm-6 col-md-5 col-lg-4 col-xl-5 item">
                        <div class="shadow box">
                            <form:form action="/persons/new" method="post" modelAttribute="person" autocomplete="off">
                                <div class="form-group">
                                    <div class="form-row p-3">
                                        <div class="col">
                                            <form:label path="firstName" class="col-form-label">First Name:</form:label>
                                        </div>
                                        <div class="col">
                                            <form:errors path="firstName" class="text-danger" />
                                            <form:input class="form-control" path="firstName" autocomplete="off" />
                                        </div>
                                    </div>
                                    <div class="form-row p-3">
                                        <div class="col">
                                            <form:label path="lastName" class="col-form-label">Last Name:</form:label>
                                        </div>
                                        <div class="col">
                                            <form:errors path="lastName" class="text-danger" />
                                            <form:input class="form-control" path="lastName" autocomplete="off" />
                                        </div>
                                    </div>
                                    <div class="form-row justify-content-end">
                                        <div class="col-xl-6">
                                            <button class="btn btn-outline-secondary" type="submit">Create</button>
                                        </div>
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