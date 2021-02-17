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
                    <div class="col-sm-6 col-md-5 col-lg-4 col-xl-8 item mt-5"
                        style="box-shadow: 0px 0px 6px 3px var(--gray-dark);">
                        <div class="box">
                            <form action="/process" method="post">
                                <div class="form-row m-3">
                                    <div class="col-xl-4 text-left"><label class="col-form-label">Your Name:</label>
                                    </div>
                                    <div class="col"><input class="form-control" type="text" name="name"></div>
                                </div>
                                <div class="form-row m-3">
                                    <div class="col-xl-4 text-left"><label class="col-form-label">Dojo Location:</label>
                                    </div>
                                    <div class="col">
                                        <select class="form-control" name="location">
                                            <option value="San Jose" selected>San Jose</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-row m-3">
                                    <div class="col-xl-4 text-left"><label class="col-form-label">Favorite
                                            Language:</label></div>
                                    <div class="col">
                                        <select class="form-control" name="language">
                                            <option value="Python" selected="">Python</option>
                                            <option value="Java">Java</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-row m-3">
                                    <div class="col-xl-4 text-left"><label class="col-form-label">Comment
                                            (optional):</label></div>
                                    <div class="col-xl-12 mt-3">
                                        <div class="form-group">
                                            <textarea class="form-control" name="comment"></textarea>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="col text-right m-3"><button class="btn btn-info"
                                            type="submit">Button</button></div>
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