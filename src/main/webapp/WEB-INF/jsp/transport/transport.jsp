<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html lang="en">

<jsp:include page="/WEB-INF/jsp/fragments/header.jsp"/>

<body class="preload">

    <!-- main body -->
    <div id="main_container">

        <jsp:include page="/WEB-INF/jsp/fragments/navbar.jsp"/>

        <section style="min-height: 1000px !important;" class="bottomrow">

            <div style="text-align:center;padding-top:75px;" id="bottomelements">
                <img src="<spring:url value='/images/transport/wedding-transport-title.jpg'/>" alt="wedding-transport-title" width="136" height="44">

                <h1 style="margin-top: 40px;">
                    HAMPTON COURT RAIL STATION
                </h1>

                <p style="margin-top: 20px;">
                    There will be an old London Routemaster bus waiting at Hampton Court Rail station, just across the bridge from the Palace,
                    <br>
                    to take everyone from there to the evening venue. Refreshments will be provided on route!
                </p>

                <img style="margin-top:60px" src="<spring:url value='/images/transport/wedding-transport-bus.jpg'/>" alt="wedding-transport-bus" width="412" height="292">

                <div style="margin-top:90px;">
                    <iframe style="float:left;" width="725" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"
                            src="http://maps.google.co.uk/maps/ms?msid=201706753745679489536.0004e20852b16a017ae02&amp;msa=0&amp;ie=UTF8&amp;t=m&amp;z=17&amp;output=embed">
                    </iframe>

                    <br/><br/>

                    <div style="text-align:left;">
                        <p style="margin-top:20px;float:right">
                            View a larger
                            <a style="font-family:'times new roman',sans-serif !important;font-size:14px !important;font-size:14px; color:#5c85a4 !important" href="http://maps.google.co.uk/maps/ms?msid=201706753745679489536.0004e20852b16a017ae02&msa=0">
                                map
                            </a>
                            <span style="text-align:left !important;">
                                <br><br>
                                Hampton Court Rail Station,<br>
                                Hampton Court Way,<br>
                                East Molesey,<br>
                                KT8 9AE
                            </span>
                        </p>
                    </div>
                </div>
            </div>

        </section>

        <jsp:include page="/WEB-INF/jsp/fragments/footer.jsp"/>

    </div>

    <jsp:include page="/WEB-INF/jsp/fragments/scripts.jsp"/>
    <script type="text/javascript">activateNavItem("navTransport");</script>

</body>
</html>
