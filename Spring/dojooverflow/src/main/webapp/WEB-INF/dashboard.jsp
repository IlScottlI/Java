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
                    style="font-size: xx-large;">DojoOverflow</a>
            </div>
        </nav>
        <div class="container">
            <h2 class="mt-4">Questions Dashboard</h2>
        </div>
        <div class="row justify-content-center mt-5">
            <div class="col-xl-7">
                <div class="table-responsive table-borderless">
                    <table class="table table-striped table-bordered table-sm">
                        <thead>
                            <tr class="table-active">
                                <th>Question</th>
                                <th>Tags</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${questions}" var="question">
                                <tr>
                                    <td class="pl-4"><a class="underlined"
                                            href="/questions/${question.id}">${question.title}</a></td>
                                    <td>${question.getTagsString()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-xl-7 text-right"><a class="underlined" href="/questions/new">New Question</a></div>
        </div>
        <script src="/assets/js/jquery.min.js"></script>
        <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
    </body>

    </html>