setTimeout(function () {
    $("body").removeClass("preload").addClass('done');
}, 800);

function activateNavItem (item) {
   $("#" + item).addClass("current");
}
