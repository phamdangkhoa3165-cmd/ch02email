<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css" type="text/css"/>
</head>
<body>
    <h1>Thanks for joining our email list</h1>

    <p>Here is the information that you entered:</p>

    <label>Email:</label>
    <span>${sessionScope.user.email}</span><br>
    <label>First Name:</label>
    <span>${sessionScope.user.firstName}</span><br>
    <label>Last Name:</label>
    <span>${sessionScope.user.lastName}</span><br>

    <p>To enter another email address, click on the Back
    button in your browser or the Return button shown below.</p>

    <form action="${pageContext.request.contextPath}/emailList" method="get">
        <input type="hidden" name="action" value="join">
        <input type="submit" value="Return">
    </form>
</body>
</html>