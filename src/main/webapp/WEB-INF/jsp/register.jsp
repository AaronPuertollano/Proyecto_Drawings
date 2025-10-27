<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>

<h2>REGISTER USER</h2>

<div class="form">
    <form method="post">

        <p>NAME</p>

        <input type="text" name="name">

        <p>USERNAME</p>

        <input type="text" name="username">

        <p>PASSWORD</p>

        <input type="password" name="password">
        <p></p>
        <input type="submit" name="SEND">
    </form>

    <p>Ya tienes cuenta? <a href="login">Login</a></p>
</div>

</body>
</html>