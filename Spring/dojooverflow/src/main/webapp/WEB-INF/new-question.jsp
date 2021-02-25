<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                        style="font-size: xx-large;">DojoOverflow</a>
                </div>
            </nav>
            <div class="container">
                <h2 class="mt-4">What is your question?</h2>
            </div>
            <div class="row justify-content-center mt-5">
                <div class="col-xl-6">
                    <form:form action="/questions/new" method="post" modelAttribute="question">
                        <div class="form-group">
                            <div class="form-row mb-4">
                                <div class="col col-2"><label class="col-form-label">Question:</label></div>

                                <div class="col col-5">
                                    <form:errors path="title" class="text-danger" />
                                    <textarea class="form-control" name="title"></textarea>
                                </div>
                            </div>
                            <div class="form-row mb-4">
                                <div class="col col-2"><label class="col-form-label">Tags:</label></div>
                                <div class="col col-3">
                                    <input style="text-transform: lowercase;" class="form-control" type="text"
                                        name="tags">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col text-center col ml-5"><button
                                        class="btn btn-outline-secondary btn-sm ml-5" type="submit">Submit</button>
                                </div>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
            <script src="/assets/js/jquery.min.js"></script>
            <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
        </body>

        </html>