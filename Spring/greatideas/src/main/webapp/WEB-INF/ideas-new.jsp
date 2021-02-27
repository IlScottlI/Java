<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
                <title>Great Ideas</title>
                <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
                <link rel="stylesheet" href="/assets/css/styles.css">
            </head>

            <body>
                <nav class="navbar navbar-light navbar-expand-md">
                    <div class="container-fluid"><a class="navbar-brand"><strong>Great Ideas</strong></a></div>
                </nav>
                <main class="mt-5">
                    <div class="container mt-5">
                        <div class="row mt-5">
                            <div class="col mt-5 p-4">
                                <h2 class="mb-2"><strong>Create a new idea</strong></h2>
                                <div class="row mt-5">
                                    <div class="col-xl-5">
                                        <form:form action="/ideas/new" method="post" modelAttribute="idea">
                                            <div class="form-row">
                                                <div class="col-xl-3 h4"><label class="col-form-label">Content:</label>
                                                </div>
                                                <div class="col-xl-6">
                                                    <form:errors path="name" class="text-danger" />
                                                    <form:input class="form-control mt-2" type="text" path="name" />
                                                </div>
                                                <input type="hidden" name="userId" value="${user.id}" />
                                            </div>
                                            <div class="form-row">
                                                <div class="col-xl-3 h4"><label class="col-form-label"></label></div>
                                                <div class="col-xl-6 pl-4 pr-4 mt-4">
                                                    <button class="btn btn-secondary btn-block border rounded-pill"
                                                        type="submit"><strong>Create</strong></button>
                                                </div>
                                            </div>
                                        </form:form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
                <script src="/assets/js/jquery.min.js"></script>
                <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
            </body>

            </html>