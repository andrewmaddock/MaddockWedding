<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html lang="en">

<jsp:include page="/WEB-INF/jsp/fragments/header.jsp"/>

<body class="preload">

    <!-- main body -->
    <div id="main_container">

        <jsp:include page="/WEB-INF/jsp/fragments/navbar.jsp"/>

        <section style="min-height: 1420px !important;" class="bottomrow">

            <div style="text-align:center;padding-top:75px;" id="bottomelements">
                <img src="<spring:url value='/images/accommodation/wedding-accommodation-title.jpg'/>" alt="wedding-accommodation-title" width="202" height="44">

                <h1 style="margin-top: 40px;">
                    THE RICHMOND GATE HOTEL
                </h1>

                <p style="margin-top: 20px;">
                    We have secured a rate of £130 for a standard double with breakfast and £170 for an executive with breakfast.
                    <br>
                    Please ask about cots and beds for little ones.
                    <br><br>
                    Quote <span style="font-weight:bold;">"Maddy & Andy Wedding"</span> to get this rate.
                    <br><br>
                    Contact: Emily<br>
                    Phone Number (Direct): 0208 940 0061<br>
                    Phone Number (Reception): 0844 855 9121<br>
                    <a href="http://www.akkeronhotels.com/Hotels/Southern-England/The-Richmond-Gate-Hotel">Visit Website</a>
                </p>

                <div style="margin-top:60px;">
                    <iframe style="float:left;" width="725" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"
                            src="http://maps.google.co.uk/maps?f=d&amp;source=s_d&amp;saddr=richmond+gate+hotel&amp;daddr=&amp;hl=en&amp;geocode=FeIUEQMdXXf7_yF6ytJZFkUQZCm_TXElFgx2SDF6ytJZFkUQZA&amp;sll=51.451106,-0.297123&amp;sspn=0.016301,0.018797&amp;mra=ls&amp;ie=UTF8&amp;t=m&amp;z=14&amp;output=embed">
                    </iframe>

                    <br/><br/>

                    <div style="text-align:left;">
                        <p style="margin-top:20px;float:right">
                            View a larger
                            <a style="font-family:'times new roman',sans-serif !important;font-size:14px !important;font-size:14px; color:#5c85a4 !important" href="http://maps.google.co.uk/maps?saddr=richmond+gate+hotel&hl=en&sll=51.451106,-0.297123&sspn=0.016301,0.018797&geocode=FeIUEQMdXXf7_yF6ytJZFkUQZCm_TXElFgx2SDF6ytJZFkUQZA&mra=ls&t=m&z=16">
                                map
                            </a>
                            <span style="text-align:left !important;">
                                <br><br>
                                The Richmond Gate Hotel,<br>
                                152-158 Richmond Hill,<br>
                                Richmond,<br>
                                TW10 6RP
                            </span>
                        </p>
                    </div>


                    <div style="float:left;text-align:center;padding-top:75px;" id="bottomelements">

                        <h1 style="margin-top: 40px;">
                            TRAVELODGE LONDON TWICKENHAM HOTEL
                        </h1>

                        <p style="margin-top: 20px;">
                            Alternatively there's a Travelodge 3 miles from the Richmond Gate Hotel.<br>
                            Phone Number (Direct): 0871 984 6503<br>
                            <a href="http://www.travelodge.co.uk/hotels/537/London-Twickenham-hotel">
                                Visit Website
                            </a>
                        </p>

                        <div style="margin-top:60px;">
                            <iframe style="float:left;" width="725" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"
                                    src="http://maps.google.co.uk/maps?f=d&amp;source=s_d&amp;saddr=Travelodge+London+Twickenham+Hotel&amp;daddr=&amp;hl=en&amp;geocode=FRYPEQMdU_j6_yEEZRBm6RbqHil_KVU29Qx2SDEEZRBm6RbqHg&amp;aq=0&amp;oq=RICHMON&amp;sll=51.444432,-0.314269&amp;sspn=0.032606,0.093513&amp;mra=prev&amp;ie=UTF8&amp;t=m&amp;ll=51.450905,-0.330963&amp;spn=0.037442,0.072956&amp;z=13&amp;output=embed">
                            </iframe>

                            <br/><br/>

                            <div style="text-align:left;">
                                <p style="margin-top:20px;float:right">
                                    View a larger
                                    <a style="font-family:'times new roman',sans-serif !important;font-size:14px !important;font-size:14px; color:#5c85a4 !important" href="http://maps.google.co.uk/maps?saddr=Travelodge+London+Twickenham+Hotel&hl=en&ll=51.444432,-0.314269&spn=0.032606,0.093513&sll=51.444432,-0.314269&sspn=0.032606,0.093513&geocode=FRYPEQMdU_j6_yEEZRBm6RbqHil_KVU29Qx2SDEEZRBm6RbqHg&oq=RICHMON&mra=prev&t=m&z=15">
                                        map
                                    </a>
                                    <span style="text-align:left !important;">
                                        <br><br>
                                        Travelodge,<br>
                                        London Twickenham Hotel,<br>
                                        London Road,<br>
                                        Twickenham,<br>
                                        TW1 3QS
                                    </span>
                                </p>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

         </section>

        <jsp:include page="/WEB-INF/jsp/fragments/footer.jsp"/>

    </div>

    <jsp:include page="/WEB-INF/jsp/fragments/scripts.jsp"/>
    <script type="text/javascript">activateNavItem("navAccommodation");</script>

</body>
</html>