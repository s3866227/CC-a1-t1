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
        <% com.google.cloud.firestore.QuerySnapshot posts = (com.google.cloud.firestore.QuerySnapshot) request.getAttribute("userPosts");
            if(posts != null){ for (com.google.cloud.firestore.QueryDocumentSnapshot post : posts.getDocuments()) { %>
                <article>
                    <header>
                        <p><%= post.getTimestamp("date_time") %></p>
                    </header>
                    <h5><%= post.getString("subject") %></h5>
                    <p><%= post.getString("message") %></p>
                    <form action="edit-post" method="post">
                        <input type="hidden" name="docId" value="<%= post.getId() %>">
                        <input type="submit" value="Edit">
                    </form>
                </article><br>
            <% } 
            } %>
    </section>
</body>
</html>