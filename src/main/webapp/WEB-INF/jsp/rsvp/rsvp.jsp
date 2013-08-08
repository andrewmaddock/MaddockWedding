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
                <img src="<spring:url value='/images/rsvp/wedding-RSVP-title.jpg'/>" alt="wedding-RSVP-title" width="129" height="44">

                <div class="formo">
                    <div class="form-header"><p>Please Let Us Know Your Plans</p></div>
                    <form:form id="rsvpForm" modelAttribute="rsvp" cssClass="form">
                        <div class="heado"></div>
                        <div class="divider"></div>

                        <form:input path="names" placeholder="  Names of who's attending:" cssClass="fname" cssErrorClass="fname error" required="true"/>
                        <div></div>

                        <form:radiobutton id="attendingTrue" path="attending" value="true" checked=""/><span>&nbsp;&nbsp;I am happily attending</span>
                        <form:radiobutton id="attendingTrue" path="attending" value="false" /><span>&nbsp;&nbsp;I am sadly not attending</span>

                        <div class="divider2"></div>
                        
                        <div id="attendingGroup">
                            
                            <form:select path="adults" cssClass="choice" cssErrorClass="choice error" required="true" min="0" max="4">
                                <form:option value="1" label="How Many Adults Attending?  1" selected="true"/>
                                <form:option value="2" label="How Many Adults Attending?  2"/>
                                <form:option value="3" label="How Many Adults Attending?  3"/>
                                <form:option value="4" label="How Many Adults Attending?  4"/>
                            </form:select>
                            <br />
    
                            <form:select path="children" cssClass="choice2" cssErrorClass="choice2 error" required="true" min="0" max="4">
                                <form:option value="0" label="How Many Children Attending?" selected="true"/>
                                <form:option value="1" label="How Many Children Attending?  1"/>
                                <form:option value="2" label="How Many Children Attending?  2"/>
                                <form:option value="3" label="How Many Children Attending?  3"/>
                                <form:option value="4" label="How Many Children Attending?  4"/>
                            </form:select>
    
                            <div>
                                <form:select path="transport" cssClass="choice2" cssErrorClass="choice2 error" required="true">
                                    <form:option value="true"  label="We'd like to get the bus?  Yes" selected="true"/>
                                    <form:option value="false" label="We'd like to get the bus?  No"/>
                                </form:select>
                            </div>
                            
                        </div>
                        
                        <form:textarea path="message" cssClass="message" cssErrorClass="message error" placeholder="Any thing you'd like to tell us?" rows="8" cols="47" maxlength="500"/>
                        
                        <div class="divider"></div>
                        <input class="subt" type="submit" value="Respond" />
                    </form:form>
                    <div class="form-footer"></div>
                </div>                                            

            </div>
        </section>

        <jsp:include page="/WEB-INF/jsp/fragments/footer.jsp"/>

    </div>

    <jsp:include page="/WEB-INF/jsp/fragments/scripts.jsp"/>
    <script type="text/javascript" src="<spring:url value='/js/rsvp/rsvp.js'/>"></script>
    <script type="text/javascript">activateNavItem("navRsvp");</script>

</body>
</html>