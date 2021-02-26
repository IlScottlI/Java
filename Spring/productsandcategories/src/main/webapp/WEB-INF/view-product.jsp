<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <h1>${product.name} - ${product.description}</h1>
                    </div>
                </div>
                <div class="row">
                    <div class="col mt-4">
                        <h3>Categories:</h3>
                        <ul class="list-unstyled mt-4">
                            <c:forEach items="${product.getCategories()}" var="item">
                                <li class="h4"><i class="icon ion-android-remove mr-1 small"></i>${item.name}</li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="col mt-5">
                        <form:form action="/categoryproduct/new" method="post" modelAttribute="categoryproduct">
                            <div class="form-group">
                                <div class="form-row">
                                    <div class="col col-3">
                                        <label class="col-form-label" path="category">Add Category:</label>
                                    </div>
                                    <div class="col col-6">
                                        <form:errors path="category" class="text-danger" />
                                        <form:select path="category" class="form-control">
                                            <form:options items="${categories}" itemValue="id" itemLabel="name" />
                                        </form:select>
                                    </div>
                                    <input type="hidden" name="product" value="${product.id}">
                                    <input type="hidden" name="id" value="${product.id}">
                                    <input type="hidden" name="type" value="products">
                                    <input type="hidden" name="page" value="view-product.jsp">
                                </div>
                                <div class="form-row">
                                    <div class="col offset-xl-3 col-6 mt-4"><button
                                            class="btn btn-outline-secondary shadow" type="submit">Add</button></div>
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