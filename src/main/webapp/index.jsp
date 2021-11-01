<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hico Test Demo</title>
</head>
<body>
<h1><%= "API List" %>
</h1>
<br/>
<a href="getemployeelist">Get employee array API</a>
<br>
<a href="addnewemployee?employeeID=123&firstName=Test&lastName=Surname&salutation=Mr&profileColour=Blue&gender=Male&grossSalary=123456">Add new employee API</a>
<br>
<a href="updateemployeerecord?employeeID=123&firstName=Billy&lastName=Surname&salutation=Dr&profileColour=White&gender=Male&grossSalary=654321">Update existing employee API</a>
</body>
</html>