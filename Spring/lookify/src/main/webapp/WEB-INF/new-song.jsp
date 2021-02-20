<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Lookify</title>
        <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/assets/css/FontAwesome.css">
        <link rel="stylesheet" href="/assets/fonts/font-awesome.min.css">
        <link rel="stylesheet" href="/assets/css/Navigation-Clean.css">
        <link rel="stylesheet" href="/assets/css/Navigation-with-Search.css">
        <link rel="stylesheet" href="/assets/css/Registration-Form-with-Photo.css">
        <link rel="stylesheet" href="/assets/css/styles.css">
        <link rel="stylesheet" href="/assets/css/User-Rating-F19690.css">
    </head>

    <body>
        <nav class="navbar navbar-light navbar-expand-md shadow-sm navigation-clean-search bg-light-gray">
            <div class="container"><a class="navbar-brand text-primary" href="/dashboard">Lookify</a></div>
        </nav>
        <section class="register-photo">
            <div class="row row-cols-1 justify-content-center align-items-center p-4">
                <div class="col-xl-6 text-right align-self-end"><a class="btn btn-outline-primary text-right"
                        role="button" href="/dashboard">Dashboard</a></div>
            </div>
            <div class="form-container">
                <form:form action="/songs/new" class="shadow-sm" method="post" modelAttribute="song">
                    <div class="form-row">
                        <div class="col p-3">
                            <div class="form-group">
                                <form:label path="name">Name</form:label>
                            </div>
                        </div>
                        <div class="col pt-3">
                            <div class="form-group">
                                <form:errors path="name" class="text-danger" />
                                <form:input class="form-control" path="name" />
                            </div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col p-3">
                            <div class="form-group">
                                <form:label path="artist">Artist</form:label>
                            </div>
                        </div>
                        <div class="col pt-3">
                            <div class="form-group">
                                <form:errors path="artist" class="text-danger" />
                                <form:input class="form-control" path="artist" />
                            </div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col p-3">
                            <div class="form-group">
                                <label>Rating (1-10)</label>
                            </div>
                        </div>
                        <div class="col">
                            <div class="form-group">
                                <form:errors path="rating" class="text-danger" />
                                <form:input class="form-control" type="number" path="rating" style="max-width: 5rem;" />
                            </div>
                        </div>
                    </div>
                    <div class="form-row p-4">
                        <div class="col text-right"><button class="btn btn-outline-primary" type="submit">Add
                                Song</button></div>
                    </div>
                </form:form>
            </div>
        </section>
        <script src="/assets/js/jquery.min.js"></script>
        <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
    </body>

    </html>