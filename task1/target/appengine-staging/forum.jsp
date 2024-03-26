<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF=8">
    <title>Forum</title>
</head>
<body>
    <header><h2>Forum page</h2></header>
    <nav>
        <% String username = (String) getServletContext().getAttribute("user"); %>
        <a href="index.jsp">Logout</a>
        <a href="AdminServlet"><%= username %></a>
        <!-- display user image-->
    </nav>
    <section name="message-posting">
        <h3>What are you thinking about..?</h3>
        <form action="message" method="post">
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
        <% com.google.cloud.firestore.QuerySnapshot posts = (com.google.cloud.firestore.QuerySnapshot) request.getAttribute("posts");
            if(posts != null){ for (com.google.cloud.firestore.QueryDocumentSnapshot post : posts.getDocuments()) { %>
                <article>
                    <header>
                        <h4><%= post.getString("author") %></h4>
                        <p><%= post.getTimestamp("date_time") %></p>
                    </header>
                    <h5><%= post.getString("subject") %></h5>
                    <p><%= post.getString("message") %></p>
                </article><br>
            <% } 
            } %>

           
    </section>
</body>
</html>