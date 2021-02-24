<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="container-fulid ml-5 mr-5">
            <div class="row">
                <div class="col-md-7 m-2">
                    <h1>Products</h1>
                </div>
                <div class="col m-2">
                    <h1>Categories</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-md-7 m-2">
                    <div class="table-responsive table-borderless shadow">
                        <table class="table table-striped table-bordered table-hover table-sm">
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Description</th>
                                    <th>Price</th>
                                    <th>Category Count</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${products}" var="product">
                                    <tr>
                                        <td>${product.name}</td>
                                        <td>${product.description}</td>
                                        <td>${product.price}</td>
                                        <td>${product.getCategories().size()} categories</td>
                                        <td class="text-center">
                                            <button class="btn btn-sm shadow"
                                                onclick="window.location='/products/${product.id}'" type="button"><i
                                                    class="fa fa-tasks mr-1"></i>View
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col">
                    <div class="table-responsive table-borderless shadow m-2">
                        <table class="table table-striped table-bordered table-hover table-sm">
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Product Count</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${categories}" var="category">
                                    <tr>
                                        <td>${category.name}</td>
                                        <td>${category.getProducts().size()}</td>
                                        <td class="text-center">
                                            <button class="btn  btn-sm shadow"
                                                onclick="window.location='/categories/${category.id}'" type="button"><i
                                                    class="fa fa-tasks mr-1"></i>View
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <script src="/assets/js/jquery.min.js"></script>
        <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
    </body>

    </html>