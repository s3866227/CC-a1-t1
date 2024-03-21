<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF=8">
    <title>Login</title>
</head>
<body>
    <script type="module">

        // Import the functions you need from the SDKs you need
      
        import { initializeApp } from "https://www.gstatic.com/firebasejs/10.9.0/firebase-app.js";
      
        import { getAnalytics } from "https://www.gstatic.com/firebasejs/10.9.0/firebase-analytics.js";
      
        // TODO: Add SDKs for Firebase products that you want to use
      
        // https://firebase.google.com/docs/web/setup#available-libraries
      
      
        // Your web app's Firebase configuration
      
        // For Firebase JS SDK v7.20.0 and later, measurementId is optional
      
        const firebaseConfig = {
      
          apiKey: "AIzaSyCG1nGs508arURZM50jZamCIng2zl-eQns",
      
          authDomain: "assignment1task1-417104.firebaseapp.com",
      
          projectId: "assignment1task1-417104",
      
          storageBucket: "assignment1task1-417104.appspot.com",
      
          messagingSenderId: "645742426193",
      
          appId: "1:645742426193:web:9e78f638bd314bcfede070",
      
          measurementId: "G-Q9DFJJKS39"
      
        };
      
      
        // Initialize Firebase
      
        const app = initializeApp(firebaseConfig);
      
        const analytics = getAnalytics(app);
      
      </script>
    <h2>Welcome! Please log in</h2>
    <!-- submits form to IndexServlet class -->
    <form action="index" method="post">
        <label for="ID">User ID:</label>
        <input type="text" name="ID"><br>
        <label for="Password">Password:</label>
        <input type="password" name="Password"><br>
        <input type="submit" value="Login">
    </form>

    <% if(request.getAttribute("loginError") != null) { %>
        <p style="color: red;"><%= request.getAttribute("loginError") %></p>
    <% } %>

    <% if(request.getAttribute("loginMessage") != null) { %>
        <p style="color: green;"><%= request.getAttribute("loginMessage") %></p>
    <% } %>

    <p><a href="register.jsp">Register</a></p> 
</body>
</html>