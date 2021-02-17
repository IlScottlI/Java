<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Untitled</title>
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/Features-Boxed.css">
        <link rel="stylesheet" href="assets/css/styles.css">
    </head>

    <body>
        <section class="features-boxed">
            <div class="container">
                <div class="intro">
                    <p class="text-center"></p>
                </div>
                <div class="row justify-content-center features">
                    <div class="col-sm-6 col-md-5 col-lg-4 col-xl-8 item"
                        style="box-shadow: 0px 0px 6px 3px var(--gray-dark);">
                        <div class="box">
                            <h4 class="text-left text-underline">Submitted Info</h4>
                            <form action="/process/" method="post">
                                <div class="form-row m-3">
                                    <div class="col-xl-4 text-left"><label class="col-form-label">Name:</label></div>
                                    <div class="col text-left">
                                        <p class="text-left">${name}</p>
                                    </div>
                                </div>
                                <div class="form-row m-3">
                                    <div class="col-xl-4 text-left"><label class="col-form-label">Dojo Location:</label>
                                    </div>
                                    <div class="col">
                                        <p class="text-left">${location}</p>
                                    </div>
                                </div>
                                <div class="form-row m-3">
                                    <div class="col-xl-4 text-left"><label class="col-form-label">Favorite
                                            Language:</label>
                                    </div>
                                    <div class="col">
                                        <p class="text-left">${language}</p>
                                    </div>
                                </div>
                                <div class="form-row m-3">
                                    <div class="col-xl-4 text-left"><label class="col-form-label">Comment
                                            (optional):</label></div>
                                    <div class="col-xl-8">
                                        <p class="text-left">${comment}</p>
                                    </div>
                                </div>
                                <div class="form-row m-3">
                                    <div class="col text-right m-3">
                                        <button class="btn btn-info" type="button" onclick="window.location = '/'">
                                            Go Back
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    </body>

    </html>