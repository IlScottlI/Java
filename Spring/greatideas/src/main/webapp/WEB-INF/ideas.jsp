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
                        <div class="col mt-5 p-4">
                            <h2 class="mb-2"><strong>Welcome, ${user.getName()}</strong></h2>
                            <nav class="navbar navbar-light navbar-expand-md">
                                <div class="container-fluid"><a class="navbar-brand"><strong>Ideas</strong></a>
                                    <ul class="navbar-nav">
                                        <li class="nav-item"><a class="nav-link text-primary underline" href="">Low
                                                Likes</a></li>
                                        <li class="nav-item"><a class="nav-link text-primary underline" href="">High
                                                Likes</a></li>
                                    </ul>
                                </div>
                            </nav>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr class="table-active">
                                            <th class="text-light">Idea</th>
                                            <th class="text-light">Created By:</th>
                                            <th class="text-light">Likes</th>
                                            <th class="text-light">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${ideas}" var="idea">
                                            <tr>
                                                <td><a class="underline" href="/ideas/${idea.id}">${idea.name}</a></td>
                                                <td>${idea.getUsers().get(0).getName()}</td>
                                                <td>${idea.getLikes().size()}</td>
                                                <td>

                                                    <a class="underline" href="">Like</a>

                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col"><button class="btn btn-secondary border rounded-pill" type="button"
                                onclick="window.location = '/ideas/new';"><strong>Create an
                                    idea</strong></button></div>
                    </div>
                </div>
            </main>
            <script src="/assets/js/jquery.min.js"></script>
            <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
        </body>

        </html>