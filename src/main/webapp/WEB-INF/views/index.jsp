<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Job Listing App</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }
    .container {
        width: 100%;
        max-width: 600px;
        margin: 50px auto;
        padding: 20px;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        border-radius: 5px;
    }
    .header {
        text-align: center;
        margin-bottom: 20px;
    }
    .header h1 {
        margin: 0;
    }
    .buttons {
        text-align: center;
        margin-bottom: 20px;
    }
    .buttons button {
        padding: 10px 20px;
        margin: 5px;
        border: none;
        background-color: #007bff;
        color: #fff;
        cursor: pointer;
        border-radius: 5px;
    }
    .buttons button:hover {
        background-color: #0056b3;
    }
    .form-container {
        display: none;
        margin-bottom: 20px;
    }
    .form-container label {
        display: block;
        margin-bottom: 5px;
    }
    .form-container input {
        width: 100%;
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    .form-container button {
        width: 100%;
        padding: 10px;
        border: none;
        background-color: #28a745;
        color: #fff;
        cursor: pointer;
        border-radius: 5px;
    }
    .form-container button:hover {
        background-color: #218838;
    }
</style>
<script>
    function toggleForm(formId) {
        document.getElementById('loginForm').style.display = 'none';
        document.getElementById('signInForm').style.display = 'none';
        document.getElementById(formId).style.display = 'block';
    }
</script>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Welcome to Job Listing App</h1>
            <h2>${error}</h2>
        </div>
        <div class="buttons">
            <button onclick="toggleForm('loginForm')">Login</button>
            <button onclick="toggleForm('signInForm')">Sign In</button>
        </div>
        <div id="loginForm" class="form-container">
            <h2>Login</h2>
            <form action="loginUser" method="get">
                <label for="user_email">Email:</label>
                <input type="email" id="login_user_email" name="user_email" required>
                <label for="user_password">Password:</label>
                <input type="password" id="login_user_password" name="user_password" required>
                <button type="submit">Login</button>
            </form>
        </div>
        <div id="signInForm" class="form-container">
            <h2>Sign In</h2>
            <form action="signInUser" method="post">
                <label for="user_name">Username:</label>
                <input type="text" id="signIn_user_name" name="user_name" required>
                <label for="user_email">Email:</label>
                <input type="email" id="signIn_user_email" name="user_email" required>
                <label for="user_password">Password:</label>
                <input type="password" id="signIn_user_password" name="user_password" required>
                <button type="submit">Sign In</button>
            </form>
        </div>
    </div>
</body>
</html>
