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
                                <h2 class="mb-2"><strong>Edit ${ideaEdit.name}</strong></h2>
                                <div class="row mt-5">
                                    <div class="col-xl-5">
                                        <c:if test="${ideaEdit.getUsers().get(0).getId() == user.id}">
                                            <form:form action="/ideas/${idea.id}/edit" method="post"
                                                modelAttribute="idea">
                                                <input type="hidden" name="_method" value="put">
                                                <div class="form-row">
                                                    <div class="col-xl-3 h4"><label
                                                            class="col-form-label">Content:</label>
                                                    </div>
                                                    <div class="col-xl-6">
                                                        <form:errors path="name" class="text-danger" />
                                                        <form:input class="form-control mt-2" type="text" path="name"
                                                            value="${ideaEdit.name}" />
                                                    </div>
                                                    <input type="hidden" name="userId" value="${user.id}" />
                                                </div>

                                                <div class="form-row">
                                                    <div class="col-xl-3 h4"><label class="col-form-label"></label>
                                                    </div>
                                                    <div class="col-xl-6 pl-4 pr-4 mt-4">
                                                        <button class="btn btn-secondary btn-block border rounded-pill"
                                                            type="submit"><strong>Update</strong></button>
                                                    </div>
                                                </div>

                                            </form:form>
                                        </c:if>
                                        <c:if test="${ideaEdit.getUsers().get(0).getId() == user.id}">
                                            <form action="/ideas/${idea.id}/delete" method="post">
                                                <div class="form-row">
                                                    <div class="col-xl-3 h4"><label class="col-form-label"></label>
                                                    </div>
                                                    <div class="col-xl-6 pl-4 pr-4 mt-4">
                                                        <input type="hidden" name="_method" value="delete">
                                                        <button class="btn btn-secondary btn-block border rounded-pill"
                                                            type="submit"><strong>Delete</strong></button>
                                                    </div>
                                                </div>
                                            </form>
                                        </c:if>
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