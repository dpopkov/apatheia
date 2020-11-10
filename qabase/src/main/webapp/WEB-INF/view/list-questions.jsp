<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>List Questions</title>
</head>
<body>

<div>
    <div>
        <h2>List Questions</h2>
    </div>
    <div>
        <table>
            <tr>
                <th>Wording</th>
                <th>Category</th>
            </tr>
            <c:forEach var="question" items="${allQuestions}">
                <tr>
                    <td>${question.wording}</td>
                    <td>${question.category}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>

