<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <div class="col mt-5">
                            <h2 class="mb-2"><strong>${idea.name}</strong></h2>
                            <nav class="navbar navbar-light navbar-expand-md mt-5">
                                <div class="container-fluid">
                                    <h4>Created By:<span class="ml-5 h5">${idea.getUsers().get(0).name}</span></h4>
                                </div>
                            </nav>
                            <div class="row">
                                <div class="col col-12">
                                    <h3 class="ml-3"><strong>Users who liked your idea:</strong></h3>
                                </div>
                                <div class="col col-8">
                                    <div class="table-responsive mt-4">
                                        <table class="table">
                                            <thead>
                                                <tr class="table-active">
                                                    <th class="text-light">Name</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${idea.getLikes()}" var="like">
                                                    <tr>
                                                        <td>${like.users.get(0).name}</td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col"><button class="btn btn-secondary border rounded-pill pl-5 pr-5" type="button"
                                onclick="window.location = '/ideas/${idea.id}/edit'"><strong>Edit</strong></button>
                        </div>
                    </div>
                </div>
            </main>
            <script src="/assets/js/jquery.min.js"></script>
            <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
        </body>

        </html>