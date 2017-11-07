<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
    <sx:head />
    <title>Add a client</title>
</head>
<body>
<h2>Add a client</h2>
<a href="/listClients">To list</a>
<s:form action="saveClient" method="post" validate="true">
    <s:textfield label="Username" name="client.firstName" />
    <s:textfield label="Lastname" name="client.lastName" />
    <sx:datetimepicker label="Format (yyyy-MM-dd)" displayFormat="yyyy-MM-dd" value="%{'today'}" name="date"/>
    <s:textfield label="Email" name="client.email" />
    <s:select label="Sex" list="sexList" name="client.sex"/>
    <s:submit value="Add" />
</s:form>
</body>
</html>
