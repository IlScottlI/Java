<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <h1>
        <c:out value="${entity.name}" />
    </h1>
    <p>Name:
        <c:out value="${entity.name}" />
    </p>
    <p>Creator:
        <c:out value="${entity.creator}" />
    </p>
    <p>Current Version:
        <c:out value="${entity.currentVersion}" />
    </p>
    <a href="/languages/${entity.id}/edit">Edit</a>
    <form action="/languages/${entity.id}" method="post">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="Delete">
    </form>