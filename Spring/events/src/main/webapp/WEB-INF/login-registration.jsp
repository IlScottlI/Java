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
                <main class="mt-5">
                    <div class="container mt-5">
                        <div class="row mt-5">
                            <div class="col mt-5 p-4">
                                <h2 class="mb-5"><strong>Register</strong></h2>
                                <form:form method="POST" action="/" modelAttribute="user">
                                    <div class="form-row p-2">
                                        <div class="col-xl-3"><label
                                                class="col-form-label"><strong>Name:</strong></label></div>
                                        <div class="col-xl-6">
                                            <form:errors path="name" class="text-danger" />
                                            <form:input path="name" class="form-control" />
                                        </div>
                                    </div>
                                    <c-if test="${emailError != null}">
                                        <label class="text-danger">${emailError}</label>
                                    </c-if>
                                    <div class="form-row p-2">
                                        <div class="col-xl-3"><label
                                                class="col-form-label"><strong>Email:</strong></label></div>
                                        <div class="col-xl-6">
                                            <form:errors path="email" class="text-danger" />
                                            <form:input type="email" path="email" class="form-control"
                                                autocomplete="off" value="" />
                                        </div>
                                    </div>
                                    <c-if test="${passwordError != null}">
                                        <label class="text-danger">${passwordError}</label>
                                    </c-if>
                                    <div class="form-row p-2">
                                        <div class="col-xl-3"><label
                                                class="col-form-label"><strong>Password:</strong></label></div>
                                        <div class="col-xl-6">
                                            <form:errors path="password" class="text-danger" />
                                            <form:password class="form-control" path="password" />
                                        </div>
                                    </div>

                                    <c-if test="${passwordConfirmationError != null}">
                                        <label class="text-danger">${passwordConfirmationError}</label>
                                    </c-if>
                                    <div class="form-row p-2">
                                        <div class="col-xl-3"><label class="col-form-label"><strong>Password
                                                    Conf:</strong></label></div>

                                        <div class="col-xl-6">
                                            <form:errors path="passwordConfirmation" class="text-danger" />
                                            <form:password class="form-control" path="passwordConfirmation" />
                                        </div>
                                    </div>

                                    <div class="form-row p-2">
                                        <div class="col-xl-3 offset-xl-1"><label class="col-form-label"><br></label>
                                        </div>
                                        <div class="col-xl-5 text-right"><button
                                                class="btn btn-secondary btn-block border rounded-pill"
                                                type="submit"><strong>Register</strong></button></div>
                                    </div>
                                </form:form>
                            </div>
                            <div class="col mt-5 p-4">
                                <h2><strong>Login</strong></h2>
                                ${error}
                                <form method="post" action="/login">
                                    <div class="form-row p-2 mt-5">
                                        <div class="col-xl-3"><label
                                                class="col-form-label"><strong>Email:</strong></label></div>
                                        <div class="col-xl-5"><input class="form-control form-control-sm" type="email"
                                                required="true" name="email"></div>
                                    </div>
                                    <div class="form-row p-2">
                                        <div class="col-xl-3"><label
                                                class="col-form-label"><strong>Password:</strong></label></div>
                                        <div class="col-xl-5">
                                            <input class="form-control form-control-sm" type="password" name="password"
                                                required="true">
                                        </div>
                                    </div>
                                    <div class="form-row p-2">
                                        <div class="col-xl-3 offset-xl-2"><label class="col-form-label"><br></label>
                                        </div>
                                        <div class="col-xl-3 text-right"><button
                                                class="btn btn-secondary btn-block border rounded-pill"
                                                type="submit"><strong>Login</strong></button></div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </main>
                <script src="/assets/js/jquery.min.js"></script>
                <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
            </body>

            </html>