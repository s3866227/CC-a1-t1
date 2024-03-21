<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF=8">
    <title>Forum</title>
</head>
<body>
    <header><h2>Forum page</h2></header>
    <nav>
        <% String id = (String) getServletContext().getAttribute("uId"); %>
        <a href="index.jsp">Logout</a>
        <a href="admin.jsp"><%= id %></a>
        <!-- display user image-->
    </nav>
    <section name="message-posting">
        <h3>What are you thinking about..?</h3>
        <form action="admin" method="post">
            <label for="subject">Subject:</label>
            <input type="text" name="subject"><br>
            <label for="message">Message:</label>
            <input type="text" name="message"><br>
            <input type="submit" value="Submit" name="Submit">
            <!-- add input for image -->
        </form>
    </section>
    <section name="message-display">
        <h3>What others are thinking about!</h3>
        <!-- show articles of messages -->
    </section>
</body>
</html>