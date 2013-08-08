<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html lang="en">

    <jsp:include page="/WEB-INF/jsp/fragments/header.jsp"/>

    <body class="preload">

    <!-- main body -->
    <div id="main_container">

        <jsp:include page="/WEB-INF/jsp/fragments/navbar.jsp"/>


        <section style="min-height: 820px !important;" class="bottomrow">

            <div style="text-align:center;padding-top:75px;" id="bottomelements">
                <img src="<spring:url value='/images/giftlist/maw-giftlist-title.jpeg'/>" alt="maw-venues-title" width="129" height="45"/>

                <p style="margin-top: 40px;">
                    Your presence at our wedding is gift enough but if you do wish to buy us something, we have registered a small gift list at John Lewis.
                    <br><br>
                    <img src="<spring:url value='/images/giftlist/maw-giftlist-johnlewis.jpeg'/>" alt="maw-giftlist-johnlewis" width="200" height="47"/>
                    <br>
                    <a href="http://www.johnlewisgiftlist.com/">
                        See our List
                    </a>
                    <br>
                    Gift List Number: 561721
                </p>

                <div>
                    <img style="margin-top:60px;" src="<spring:url value='/images/giftlist/maw-giftlist-presents.jpg'/>" alt="maw-giftlist-presents" width="749" height="217"/>
                </div>
            </div>

        </section>

        <jsp:include page="/WEB-INF/jsp/fragments/footer.jsp"/>

    </div>

    <jsp:include page="/WEB-INF/jsp/fragments/scripts.jsp"/>
    <script type="text/javascript">activateNavItem("navGiftlist");</script>

</body>
</html>