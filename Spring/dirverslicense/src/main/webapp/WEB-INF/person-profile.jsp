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
                    <h2 onclick="window.location = '/'" style="cursor: pointer;" class="text-center">
                        Drivers|<strong>License</strong>
                    </h2>
                </div>
                <h1>${person.firstName} ${person.lastName}</h1>
                <div class="row justify-content-start features p-3">
                    <div class="col-sm-6 col-md-5 col-lg-4 col-xl-5 item">
                        <div class="shadow box">
                            <form>
                                <div class="form-group">
                                    <div class="form-row p-1">
                                        <div class="col text-left"><label class="col-form-label">License Number</label>
                                        </div>
                                        <div class="col text-left"><label class="col-form-label"></label></div>
                                    </div>
                                    <div class="form-row p-1">
                                        <div class="col text-left"><label class="col-form-label">State:</label></div>
                                        <div class="col text-left"><label class="col-form-label"></label></div>
                                    </div>
                                    <div class="form-row p-1">
                                        <div class="col text-left"><label class="col-form-label">Expiration
                                                Date:&nbsp;</label></div>
                                        <div class="col text-left"><label class="col-form-label"></label>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script src="/assets/js/jquery.min.js"></script>
        <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
    </body>

    </html>