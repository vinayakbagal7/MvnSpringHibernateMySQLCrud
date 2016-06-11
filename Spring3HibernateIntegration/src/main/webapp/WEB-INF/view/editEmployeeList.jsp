<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Spring 3 hibernate integration example on www.howtodoinjava.com</title>
</head>
<body>
 
<h2>Employee Management Screen : Spring 3 hibernate integration example on www.howtodoinjava.com</h2>
 
<form:form method="post" action="/Spring3HibernateIntegration/add" commandName="employee">
    <table>
    <tr>
        <td><form:label path="firstname"><spring:message code="label.firstname"/></form:label></td>
        <td><form:input path="firstname" /></td>
    </tr>
    <tr>
        <td><form:label path="lastname"><spring:message code="label.lastname"/></form:label></td>
        <td><form:input path="lastname" /></td>
    </tr>
    <tr>
        <td><form:label path="email"><spring:message code="label.email"/></form:label></td>
        <td><form:input path="email" /></td>
    </tr>
    <tr>
        <td><form:label path="telephone"><spring:message code="label.telephone"/></form:label></td>
        <td><form:input path="telephone" /></td>
    </tr>
    <tr>
        <td colspan="2">
           <c:choose>
      			<c:when test="${empty employee.id}">
      				<input type="submit" value="<spring:message code="label.add"/>"/>
      			</c:when>
			    <c:otherwise>
			    	<input type="submit" value="<spring:message code="label.update"/>"/>
      			</c:otherwise>
      		</c:choose>
        </td>
    </tr>
</table>
<form:hidden path="id" readonly="true"/>
</form:form>
     
<h3>Employees</h3>
<c:if  test="${!empty employeeList}">
<table class="data">
<tr>
    <th>Name</th>
    <th>Email</th>
    <th>Telephone</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${employeeList}" var="emp">
    <tr>
        <td>${emp.lastname}, ${emp.firstname} </td>
        <td>${emp.email}</td>
        <td>${emp.telephone}</td>
        <td><a href="/Spring3HibernateIntegration/update/${emp.id}">update</a></td>
        <td><a href="/Spring3HibernateIntegration/delete/${emp.id}">delete</a></td>
    </tr>
</c:forEach>
</table>
</c:if>
<br/>
<a href="/Spring3HibernateIntegration/">Home Page</a>
</body>
</html>