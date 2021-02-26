<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
                <title>Login|Registration</title>
                <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
                <link rel="stylesheet" href="/assets/css/styles.css">
            </head>

            <body>
                <main>
                    <div class="container login-form">
                        <div class="row justify-content-center">
                            <div class="col col-4">
                                <div class="card">
                                    <div class="card-header text-center">
                                        <h4 class="text-center">Registration</h4>
                                    </div>
                                    <div class="card-body">
                                        <form:form method="POST" action="/registration" modelAttribute="user">
                                            <div class="form-group">
                                                <div class="form-row">
                                                    <div class="col mb-4">
                                                        <form:errors path="firstName" class="text-danger" />
                                                        <form:input path="firstName" class="form-control"
                                                            placeholder="First Name" />
                                                    </div>
                                                </div>
                                                <div class="form-row">
                                                    <div class="col mb-4">
                                                        <form:errors path="lastName" class="text-danger" />
                                                        <form:input path="lastName" class="form-control"
                                                            placeholder="Last Name" />
                                                    </div>
                                                </div>
                                                <div class="form-row">
                                                    <c-if test="${emailError != null}">
                                                        <label class="text-danger">${emailError}</label>
                                                    </c-if>
                                                    <div class="col-12 mb-4">
                                                        <form:errors path="email" class="text-danger" />
                                                        <form:input type="email" path="email" class="form-control"
                                                            placeholder="Email" />
                                                    </div>
                                                </div>
                                                <div class="form-row">
                                                    <c-if test="${passwordError != null}">
                                                        <label class="text-danger">${passwordError}</label>
                                                    </c-if>
                                                    <div class="col-12 mb-4">
                                                        <form:errors path="password" class="text-danger" />
                                                        <form:password class="form-control" path="password"
                                                            placeholder="Password" />
                                                    </div>
                                                </div>
                                                <div class=" form-row">
                                                    <c-if test="${passwordConfirmationError != null}">
                                                        <label class="text-danger">${passwordConfirmationError}</label>
                                                    </c-if>
                                                    <div class="col-12">
                                                        <form:errors path="passwordConfirmation" class="text-danger" />
                                                        <form:password class="form-control"
                                                            placeholder="Confirm Password" path="passwordConfirmation"
                                                            id="passwordConfirmation" />
                                                    </div>

                                                </div>
                                                <div class="form-row">
                                                    <div class="col mt-4"><button class="btn btn-primary btn-block"
                                                            type="submit">Register!</button></div>
                                                </div>
                                            </div>
                                        </form:form>
                                    </div>
                                    <div class="card-footer text-center"><a class="text-center text-secondary"
                                            href="/login">Already
                                            have an account?</a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
                <script src="/assets/js/jquery.min.js"></script>
                <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
            </body>

            </html>