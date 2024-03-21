<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF=8">
    <title>User Admin</title>
</head>
<body>
    <header><h2>User Admin Page</h2></header>
    <nav>
        <a href="index.jsp">Logout</a>
        <a href="forum.jsp">Home</a>
    </nav>
    <section>
        <h3>Edit Password</h3>
        <form action="password" method="post">
            <label for="oldPassword">Enter existing password:</label>
            <input type="password" name="oldPassword"><br>
            <label for="newPassword">Enter new password:</label>
            <input type="password" name="newPassword"><br>
            <input type="submit" value="Change">
        </form>
        <% if(request.getAttribute("changePwError") != null) { %>
            <p style="color: red;"><%= request.getAttribute("changePwError") %></p>
        <% } %>
    </section>
    <section>
        <h3>Edit posted messages</h3>
    </section>
</body>
</html>