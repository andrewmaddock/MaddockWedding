<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

<jsp:include page="/WEB-INF/jsp/fragments/header.jsp"/>

<body class="preload">

    <!-- main body -->
    <div id="main_container">

        <jsp:include page="/WEB-INF/jsp/fragments/navbar.jsp"/>

        <section style="min-height: 820px !important;" class="bottomrow">
            <div style="text-align:center;padding-top:75px;" id="bottomelements">
                <img src="<spring:url value='/images/playlist/wedding-playlist-title.jpg'/>" alt="wedding-playlist-title" width="129" height="44">

                <div class="formo">
                    <div class="form-header2"><p>Please Request Songs For The After Party</p></div>
                    <form:form id="playlistForm" modelAttribute="playList" cssClass="form">
                        <div class="heado"></div>
                        <div class="divider"></div>

                        <form:input path="requester" cssClass="fname" cssErrorClass="fname error" placeholder="  Your name:" required="true"/>
                        <div class="divider"></div>

                        <form:input path="artist" cssClass="artist" cssErrorClass="artist error" placeholder="  Artist:" required="true"/>
                        <br />
                        <form:input path="track" cssClass="song" cssErrorClass="song error" placeholder="  Track:" required="true"/>

                        <div class="divider"></div>
                        <input type="submit" class="subt" name="submit" value="Submit" />
                    </form:form>
                    <div class="form-footer"></div>
                </div>


            </div>
        </section>

        <jsp:include page="/WEB-INF/jsp/fragments/footer.jsp"/>

    </div>

    <jsp:include page="/WEB-INF/jsp/fragments/scripts.jsp"/>
    <script type="text/javascript">activateNavItem("navPlaylist");</script>

</body>
</html>