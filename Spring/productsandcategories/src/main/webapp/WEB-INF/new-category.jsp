<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Products and Categories</title>
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="/assets/fonts/ionicons.min.css">
    <link rel="stylesheet" href="/assets/css/Navigation-Clean.css">
    <link rel="stylesheet" href="/assets/css/styles.css">
</head>

<body>
      <nav class="navbar navbar-light navbar-expand-md navigation-clean">
        <div class="container">
            <a class="navbar-brand" href="/" style="cursor: pointer;">Products and Categories</a>
            <div class="collapse navbar-collapse" id="navcol-1">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/products/new">New Product</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/categories/new">New Category</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container">
        <div class="row">
            <div class="col">
                <h1>New Category</h1>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <form:form action="/categories/new" method="post" modelAttribute="category">
                    <div class="form-group">
                        <div class="form-row p-1">
                            <div class="col col-2 h4">
                                <form:label path="name" class="col-form-label">Name:</form:label>
                            </div>
                            <div class="col col-3">
                                <form:errors path="name" class="text-danger" />
                                <form:input class="form-control" path="name" />
                            </div>
                        </div>
                        <div class="form-row p-2">
                            <div class="col offset-xl-2"><button class="btn btn-outline-secondary shadow" type="submit">Create</button></div>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
    <script src="/assets/js/jquery.min.js"></script>
    <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>