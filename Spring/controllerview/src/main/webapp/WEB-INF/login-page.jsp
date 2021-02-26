<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                                    <h4 class="text-center">Login</h4>
                                </div>
                                <div class="card-body">
                                    ${error}
                                    <form method="post" action="/login">
                                        <div class="form-group">
                                            <div class="form-row">
                                                <div class="col mb-4"><input class="form-control" type="email"
                                                        name="email" id="email" placeholder="Email" required="true"
                                                        value="${userEmail}">
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="col"><input class="form-control" type="password"
                                                        name="password" id="password" placeholder="Password"
                                                        required="true"></div>
                                            </div>
                                            <div class="form-row">
                                                <div class="col mt-4"><button class="btn btn-primary btn-block"
                                                        type="submit">Login</button></div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="card-footer text-center"><a class="text-center text-secondary"
                                        href="/registration">Need to register?</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
            <script src="/assets/js/jquery.min.js"></script>
            <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
        </body>

        </html>