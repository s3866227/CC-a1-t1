<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF=8">
        <title>Edit Post</title>
    </head>
    <body>
        <h1>Edit post</h1>
        <!-- prefill with selected post details -->
        <form action="edit-post" method="post">
            <label for="subject">Subject:</label>
            <input type="text" name="subject" value="${subject}"><br>
            <label for="message">Message:</label>
            <input type="text" name="message" value="${message}"><br>
            <input type="hidden" name="docId" value="${docId}">
            <input type="submit" value="Update">
        </form>
    </body>
</html>