<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- header -->
<section class="header_nav">
    <div style="text-align:center;" id="header_container">
        <img style="margin-top:22px;" src="<spring:url value='/images/maw-maw.png'/>" alt="maw-maw" width="331" height="33">
    </div>
</section>


<section class="feature_box2">

    <div id="nav_menu">
        <nav id="menu">
            <a id="navHome" href="<spring:url value='/'/>">Home</a>
            <a id="navOurStory" href="<spring:url value='/ourstory'/>">Our Story</a>
            <a id="navOurDay" href="<spring:url value='/ourday'/>">Our Day</a>
            <a id="navVenues" href="<spring:url value='/venues'/>">Venues</a>
            <a id="navTransport" href="<spring:url value='/transport'/>">Transport</a>
            <a id="navAccommodation" href="<spring:url value='/accommodation'/>">Accommodation</a>
            <a id="navGetInvolved" href="<spring:url value='/getinvolved'/>">Get Involved</a>
            <a id="navPlaylist" href="<spring:url value='/playlist'/>">Playlist</a>
            <a id="navRsvp" href="<spring:url value='/rsvp'/>">RSVP</a>
            <a id="navGiftlist" href="<spring:url value='/giftlist'/>">Gift List</a>
        </nav>
    </div>

</section>
