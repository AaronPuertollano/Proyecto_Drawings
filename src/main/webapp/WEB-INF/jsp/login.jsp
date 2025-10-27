<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>

    <h2>LOGIN</h2>

    <div class="form">
        <form method="post">

            <p>USERNAME</p>

            <input type="text" name="username">

            <p>PASSWORD</p>

            <input type="password" name="password">
            <p> </p>
            <input type="submit" name="SEND">

        </form>

        <p>No tienes cuenta? <a href="register">Registrate</a></p>

    </div>
</body>
</html>