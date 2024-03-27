<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF=8">
        <title>Task 2</title>
    </head>
    <body>
        <section>
            <h2>Assignment 1 Task 2</h2>
        </section>
        <section>
            <article>
                <h3>2.2.1</h3>
                <table border="1">
                    <tr>
                        <th>Time Ref</th>
                        <th>Trade Value</th>
                    </tr>
                    <c:forEach var="timeref" items="${task2-1}">
                        <tr>
                            <td>${timeref.get("time_ref").getStringValue()}</td>
                            <td>${timeref.get("trade_value").getDoubleValue()}</td>
                        </tr>
                    </c:forEach>
                </table>
            </article>
            <article>
                <h3>2.2.2</h3>
                <!--2.2.2-->
            </article>
        </section>
    </body>
</html>