$(function() {
    
    // set current menu item to active
    activateNavItem("rsvp");
    
    // show/hide attending group of fields
    $('input:radio[name="attending"]').change(function() {
        $('#attendingGroup').toggle();   
    });

    $('#rsvpForm').submit(function() {
        // Clear attending fields if not attending
        if($('#attendingFalse').is(':checked')) {
            $('#adults, #children').val(0);
            $('#transport').val(false);
            //$('#message').val("");        
        }
        
        return true
    });
    
//    // setup form validation
//    $('#rsvpForm').validate({
//        submitHandler: function(form) {
//            
//            // Clear attending fields if not attending
//            if($('#attendingFalse').is(':checked')) {
//                $('#adults, #children').val(0);        
//                $('#transport').val(false);     
//                //$('#message').val("");        
//            }
//
//            return true
//            
//        }  
//    });
    
});