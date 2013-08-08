<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html lang="en">

<jsp:include page="/WEB-INF/jsp/fragments/header.jsp"/>

<body class="preload">

    <!-- main body -->
    <div id="main_container">

        <jsp:include page="/WEB-INF/jsp/fragments/navbar.jsp"/>

        <section class="floralrow">
            <div id="floralelements">
                <img src="<spring:url value="/images/maw-feature-graphic2.jpg"/>" alt="maw-feature-graphic" width="875" height="313">
            </div>
        </section>


        <section style="min-height: 320px !important;" class="bottomrow">
            <div style="padding-top:75px;" id="bottomelements">
                <img src="<spring:url value="/images/maw-itinerary.png"/>" alt="maw-itinerary" width="875" height="412">
            </div>
        </section>

        <jsp:include page="/WEB-INF/jsp/fragments/footer.jsp"/>

    </div>

    <jsp:include page="/WEB-INF/jsp/fragments/scripts.jsp"/>
    <script type="text/javascript">activateNavItem("navHome");</script>

</body>
</html>
