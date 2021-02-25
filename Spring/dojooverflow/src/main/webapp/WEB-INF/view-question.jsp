<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>DojoOverflow</title>
        <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/assets/css/Navigation-Clean.css">
        <link rel="stylesheet" href="/assets/css/styles.css">
    </head>

    <body>
        <nav class="navbar navbar-light navbar-expand-md navigation-clean">
            <div class="container"><a class="navbar-brand" href="/questions"
                    style="font-size: xx-large;">DojoOverflow</a></div>
        </nav>
        <div class="container">
            <h2 class="mt-4">What is the best programming language?</h2>
            <div class="row justify-content-center">
                <div class="col col-1">
                    <h3>Tags:</h3>
                </div>
                <div class="col pt-1">
                    <ul class="list-inline">
                        <li class="list-inline-item"><button class="btn btn-outline-dark disabled btn-sm shadow"
                                type="button" disabled="">cs</button></li>
                        <li class="list-inline-item"><button class="btn btn-outline-dark disabled btn-sm shadow"
                                type="button" disabled="">programming</button></li>
                    </ul>
                </div>
            </div>
            <div class="row justify-content-center mt-4">
                <div class="col-xl-5">
                    <div class="table-responsive">
                        <table class="table table-striped table-sm">
                            <thead>
                                <tr class="table-active">
                                    <th>Answers</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Java is the best language!</td>
                                </tr>
                                <tr>
                                    <td>Ruby is the best!</td>
                                </tr>
                                <tr>
                                    <td>C! The father of all languages</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col">
                    <form>
                        <div class="form-row">
                            <div class="col">
                                <h3>Add your answer:</h3>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="col col-2"><label class="col-form-label">Answer:</label></div>
                            <div class="col col-6"><textarea class="form-control"></textarea></div>
                        </div>
                        <div class="form-row mt-3">
                            <div class="col col-2">
                                <div></div>
                            </div>
                            <div class="col text-right col-6"><button class="btn btn-outline-secondary btn-sm"
                                    type="button">Answer it!</button></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="/assets/js/jquery.min.js"></script>
        <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
    </body>

    </html>