<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html lang="en">

<jsp:include page="/WEB-INF/jsp/fragments/header.jsp"/>

<body class="preload">

    <!-- main body -->
    <div id="main_container">

        <jsp:include page="/WEB-INF/jsp/fragments/navbar.jsp"/>

        <section style="min-height: 520px !important;" class="bottomrow">

            <div style="text-align:center;padding-top:75px;" id="bottomelements">
                <img src="<spring:url value='/images/getinvolved/wedding-getinvolved-title.jpg'/>" alt="wedding-getinvolved-title" width="164" height="44">

                <h1 style="margin-top: 40px;">
                    PHOTOGRAPHS
                </h1>

                <p style="margin-top: 20px;">
                    On the day it would be great if you can bring cameras and take as many pics as you can.
                    <br>
                    We will then provide a link for people to upload photos.
                </p>

                <h1 style="margin-top: 40px;">
                    HELPING OUT
                </h1>

                <p style="margin-top: 20px;">
                    We will need to put the decorations up in the conservatory room at
                    <br>
                    The Richmond Gate Hotel on the morning of September 20th.
                    <br><br>
                    If anyone is staying at the hotel and is willing to help with this we will be forever in your debt!
                </p>
            </div>

        </section>

        <jsp:include page="/WEB-INF/jsp/fragments/footer.jsp"/>

    </div>

    <jsp:include page="/WEB-INF/jsp/fragments/scripts.jsp"/>
    <script type="text/javascript">activateNavItem("navGetInvolved");</script>

</body>
</html>