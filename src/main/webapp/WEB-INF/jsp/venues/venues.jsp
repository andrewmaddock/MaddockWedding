<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html lang="en">

<jsp:include page="/WEB-INF/jsp/fragments/header.jsp"/>

<body class="preload">

    <!-- main body -->
    <div id="main_container">

        <jsp:include page="/WEB-INF/jsp/fragments/navbar.jsp"/>

        <section style="min-height: 3050px !important;" class="bottomrow">
            <div style="text-align:center;padding-top:75px;" id="bottomelements">
                <img src="<spring:url value='/images/venues/maw-venues-title.jpg'/>" alt="maw-venues-title" width="129" height="45">

                <h1 style="margin-top: 40px;">
                    WEDDING CEREMONY: THE LITTLE BANQUETING HOUSE, HAMPTON COURT PALACE
                </h1>

                <p style="margin-top: 20px;">
                    We are really thrilled to invite you to join us for our wedding ceremony at The Little Banqueting House at the beautiful and historic Hampton Court Palace.
                    <br><br>
                    Entrance to this late 17th century building overlooking the river is reached by following the path along the south side of the palace and through the Vine Gate.
                    <br>
                    A member of palace staff will be outside the gate and will direct you inside, past the Pond Gardens, towards the Little Banqueting House.
                </p>

                <div>
                    <img style="margin-top:60px;" src="<spring:url value='/images/venues/maw-venues-map.jpg'/>" alt="maw-venues-map" width="960" height="532">
                    <img style="margin-top:60px;" src="<spring:url value='/images/venues/maw-venues-LBH.jpg'/>" alt="maw-venues-LBH" width="960" height="280">
                </div>

                <img style="margin-top:60px;" src="<spring:url value='/images/venues/maw-venues-travel.jpg'/>" alt="maw-venues-travel" width="875" height="170">

                <p style="margin-top:60px">
                    Coming by public transport means that you can join us on the provided transport
                    between the ceremony and the evening celebration. There will also be some much needed refreshments while
                    travelling on the bus and it would be great if you can join us.
                </p>

                <div style="margin-top:60px;">
                    <iframe style="float:left;" width="725" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"
                            src="http://maps.google.co.uk/maps/ms?msid=201706753745679489536.0004e206759707327686e&amp;msa=0&amp;ie=UTF8&amp;t=m&amp;z=15&amp;output=embed">
                    </iframe>

                    <br/><br/>

                    <div style="text-align:left;">
                        <p style="margin-top:20px;float:right">
                            View a larger
                            <a style="font-family:'times new roman',sans-serif !important;font-size:14px !important;font-size:14px; color:#5c85a4 !important" href="http://maps.google.co.uk/maps/ms?ll=51.403248,-0.337958&amp;spn=0.01518,0.042272&amp;t=m&amp;z=15&amp;msa=0&amp;msid=201706753745679489536.0004e206759707327686e&amp;source=embed">
                                map
                            </a>
                            <span style="text-align:left !important;">
                                <br><br>
                                Hampton Court Palace,<br>
                                The Little Banqueting House,<br>
                                East Molesey,<br>
                                Surrey,<br>
                                KT8 9AU
                            </span>
                        </p>
                    </div>

                    <div style="text-align:center !important;  display:inline-block;">
                        <h1 style="margin-top: 90px;">
                            EVENING RECEPTION: THE RICHMOND GATE HOTEL
                        </h1>

                        <p style="margin-top: 20px;">
                            Our evening drinks, buffet reception and DJ will be held in the Conservatory and Victorian walled gardens at The Richmond Gate Hotel.
                        </p>
                        <img style="margin-top:60px;" src="<spring:url value='/images/venues/maw-venues-RGH.jpg'/>" alt="maw-venues-RGH" width="960" height="277">

                        <p style="margin-top: 60px">
                            For those staying at the hotel who are not driving the hotel is 5 minutes from Richmond station by taxi or a 25 minute walk.
                            <br>
                            Limited parking is available at The Richmond Gate Hotel at a cost of £5 per day
                            <br><br>
                            After the ceremony transport to the Richmond Gate Hotel will be  provided.
                        </p>
                    </div>

                    <div style="margin-top:60px;text-align:left;">
                        <iframe style="float:left;" width="725" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"
                                src="http://maps.google.co.uk/maps/ms?msid=201706753745679489536.0004e207263115e79c586&amp;msa=0&amp;ie=UTF8&amp;t=m&amp;ll=51.457537,-0.302038&amp;spn=0.018718,0.062227&amp;z=14&amp;output=embed">
                        </iframe>

                        <br/><br/>

                        <div style="margin-top:60px;text-align:left;">
                            <p style="float:right">
                                View a larger
                                <a style="font-family:'times new roman',sans-serif !important;font-size:14px !important;font-size:14px; color:#5c85a4 !important" href="http://maps.google.co.uk/maps/ms?msid=201706753745679489536.0004e207263115e79c586&msa=0&ll=51.451025,-0.294893&spn=0.007582,0.021136&dg=feature">
                                    map
                                </a>
                                <span style="text-align:left !important;">
                                    <br><br>
                                    Richmond Gate Hotel,<br>
                                    152-158 Richmond Hill,<br>
                                    Richmond,<br>
                                    TW10 6RP
                                </span>
                            </p>
                        </div>
                    </div>

                </div>
            </div>
        </section>

        <jsp:include page="/WEB-INF/jsp/fragments/footer.jsp"/>

    </div>

    <jsp:include page="/WEB-INF/jsp/fragments/scripts.jsp"/>
    <script type="text/javascript">activateNavItem("navVenues");</script>

</body>
</html>