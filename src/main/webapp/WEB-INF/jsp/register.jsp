<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <title>Register user</title>
    <style>
        * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        body {
        background-color: #f4f4f9;
        color: #333;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
        }

        h2 {
        font-size: 2rem;
        margin-bottom: 1rem;
        color: #222;
        letter-spacing: 1px;
        }

        .form {
        background-color: white;
        padding: 2rem 3rem;
        border-radius: 10px;
        box-shadow: 0 4px 10px rgba(0,0,0,0.15);
        width: 300px;
        text-align: center;
        }

        .form p {
        margin: 0.5rem 0;
        font-weight: 500;
        }

        /* ===== Inputs ===== */
        input[type="text"],
        input[type="password"] {
        width: 100%;
        padding: 0.6rem;
        border-radius: 6px;
        border: 1px solid #ccc;
        margin-top: 0.3rem;
        margin-bottom: 0.8rem;
        font-size: 1rem;
        transition: border-color 0.3s;
        }

        input[type="text"]:focus,
        input[type="password"]:focus {
        border-color: #00bfff;
        outline: none;
        }

        input[type="submit"] {
        width: 100%;
        padding: 0.7rem;
        background-color: #222;
        color: white;
        border: none;
        border-radius: 6px;
        font-weight: bold;
        cursor: pointer;
        transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
        background-color: #00bfff;
        }

        /* ===== Enlace de registro ===== */
        .form a {
        color: #00bfff;
        text-decoration: none;
        font-weight: bold;
        transition: color 0.3s;
        }

        .form a:hover {
        color: #007acc;
        text-decoration: underline;
        }

        @media (max-width: 400px) {
        .form {
            width: 90%;
            padding: 1.5rem;
        }
        }
    </style>

</head>

<body>

<h2>REGISTER USER</h2>

<div class="form">
    <form method="post">

        <p>NAME</p>

        <input type="text" name="name" required>

        <p>USERNAME</p>

        <input type="text" name="username" required>

        <p>PASSWORD</p>

        <input type="password" name="password" minlength="5" required>
        <p></p>
        <input type="submit" name="SEND">
    </form>

    <c:if test="${not empty message}">
        <div style="color: red;">
            ${message}
        </div>
    </c:if>

    <p>Ya tienes cuenta? <a href="login">Login</a></p>
</div>

</body>
</html>