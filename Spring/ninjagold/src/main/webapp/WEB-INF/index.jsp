<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Ninja Gold</title>
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/Features-Boxed.css">
        <link rel="stylesheet" href="assets/css/styles.css">
    </head>

    <body>
        <section class="features-boxed">
            <div class="container">
                <div class="row">
                    <div class="col mt-4">
                        <h3>Your Gold:<input class="form-control-sm ml-2 mt-0 h1 pl-1 pt-0 pb-0" type="text" readonly=""
                                style="width: 5rem;font-size: 19px;font-weight: bold;font-style: normal;text-align: left;"
                                value="${total}">&nbsp;</h3>
                    </div>
                </div>
                <div class="row row-cols-4 justify-content-around features">
                    <div class="col-sm-6 col-md-5 col-lg-4 col-xl-2 offset-xl-0 item p-0"
                        style="box-shadow: 0px 0px 6px 3px var(--gray-dark);">
                        <h3>Farm</h3>
                        <h6 class="text-nowrap">(earns 10-20 gold)</h6>
                        <form method="POST" action="/process">
                            <input type="hidden" name="type" value="farm">
                            <button class="btn btn-outline-secondary btn-sm shadow mb-2 mt-2" type="buttonm-5">Find
                                Gold!</button>
                        </form>
                    </div>
                    <div class="col-sm-6 col-md-5 col-lg-4 col-xl-2 item"
                        style="box-shadow: 0px 0px 6px 3px var(--gray-dark);">
                        <h3>Cave</h3>
                        <h6 class="text-nowrap">(earns 5-10 gold)</h6>
                        <form method="POST" action="/process">
                            <input type="hidden" name="type" value="cave">
                            <button class="btn btn-outline-secondary btn-sm shadow mb-2 mt-2" type="buttonm-5">Find
                                Gold!</button>
                        </form>
                    </div>
                    <div class="col-sm-6 col-md-5 col-lg-4 col-xl-2 item"
                        style="box-shadow: 0px 0px 6px 3px var(--gray-dark);">
                        <h3>House</h3>
                        <h6 class="text-nowrap">(earns 2-5 gold)</h6>
                        <form method="POST" action="/process">
                            <input type="hidden" name="type" value="house">
                            <button class="btn btn-outline-secondary btn-sm shadow mb-2 mt-2" type="buttonm-5">Find
                                Gold!</button>
                        </form>
                    </div>
                    <div class="col-sm-6 col-md-5 col-lg-4 col-xl-2 item"
                        style="box-shadow: 0px 0px 6px 3px var(--gray-dark);">
                        <h3>Casino!</h3>
                        <h6 class="text-nowrap">(earns/takes 0-50 gold)</h6>
                        <form method="POST" action="/process">
                            <input type="hidden" name="type" value="casino">
                            <button class="btn btn-outline-secondary btn-sm shadow mb-2 mt-2" type="buttonm-5">Find
                                Gold!</button>
                        </form>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <h3>Activities:</h3>
                    </div>
                </div>
                <div class="row row-cols-4 justify-content-around features">
                    <div class="col-sm-6 col-md-5 col-lg-4 col-xl-11 item mt-0"
                        style="box-shadow: 0px 0px 6px 3px var(--gray-dark);margin-top: -1rem !important;max-height: 15rem !important;">
                        <ul class="list-unstyled text-left mt-1" style="max-height: 15rem !important;overflow: auto;">
                            <c:forEach items="${entries}" var="entry">
                                <li class="text-${entry.sign}">${entry.output}</li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </section>
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    </body>

    </html>