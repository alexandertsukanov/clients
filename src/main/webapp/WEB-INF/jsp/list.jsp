<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<table border="1">
    <tr>
        <td>Firstname</td>
        <td>Lastname</td>
        <td>Email</td>
        <td>Age</td>
        <td>Sex</td>
        <td>Delete</td>
        <td><a href="/addClient">+</a></td>
    </tr>

    <s:iterator value="clientList" status="rowstatus">
        <tr>
        <td><s:property value="firstName" /></td>
        <td><s:property value="lastName" /></td>
        <td><s:property value="email" /></td>
        <td><s:property value="age" /></td>
        <td><s:property value="sex" /></td>
        <td><a href="/deleteClient/<s:property value="id"/>"> X </a></td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
