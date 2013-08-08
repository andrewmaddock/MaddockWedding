<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<jsp:include page="/WEB-INF/jsp/fragments/header.jsp"/>

<body class="preload">

    <!-- main body -->
    <div id="main_container">
    
        <jsp:include page="/WEB-INF/jsp/fragments/navbar.jsp"/>       
    
        <section style="min-height: 520px !important;" class="bottomrow">
            <div style="padding-top:75px;" id="bottomelements">

                <h1>Sorry an unexpected error has occurred: </h1>
                <br />
                <pre>
                    ${exception}
                    <c:forEach items="${exception.stackTrace}" var="trace">
                         <c:out value="${trace}"/>
                    </c:forEach>
                </pre>

            </div>
        </section>

        <jsp:include page="/WEB-INF/jsp/fragments/footer.jsp"/>

    </div>
    
    <jsp:include page="/WEB-INF/jsp/fragments/scripts.jsp"/>
    <script type="text/javascript">activateNavItem("navOurDay");</script>

</body>
</html>