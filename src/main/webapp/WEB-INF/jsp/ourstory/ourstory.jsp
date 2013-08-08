<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html lang="en">

<jsp:include page="/WEB-INF/jsp/fragments/header.jsp"/>

<body class="preload">

    <!-- main body -->
    <div id="main_container">

        <jsp:include page="/WEB-INF/jsp/fragments/navbar.jsp"/>

        <section class="bottomrow">
            <div style="text-align:center;padding-top:75px;" id="bottomelements">
                <img src="<spring:url value='/images/maw-ourstory-title.jpg'/>" alt="maw-ourstory-title" width="129" height="42"><br>
                <img style="margin-top:60px" src="<spring:url value='/images/maw-ourstory.jpg'/>" alt="maw-ourstory" width="960" height="454">
            </div>
        </section>

        <jsp:include page="/WEB-INF/jsp/fragments/footer.jsp"/>

    </div>
    
    <jsp:include page="/WEB-INF/jsp/fragments/scripts.jsp"/>
    <script type="text/javascript">activateNavItem("navOurStory");</script>

</body>
</html>