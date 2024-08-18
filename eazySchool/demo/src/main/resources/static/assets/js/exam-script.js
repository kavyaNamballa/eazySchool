document.addEventListener("DOMContentLoaded", function() {
    // Request full screen mode
    var elem = document.documentElement;
    elem.requestFullscreen = elem.requestFullscreen || elem.mozRequestFullScreen || elem.webkitRequestFullscreen || elem.msRequestFullscreen;

    if (elem.requestFullscreen) {
        elem.requestFullscreen();
    }

    // Detect exit full screen
    document.addEventListener("fullscreenchange", function() {
        if (!document.fullscreenElement) {
            // User exited full screen, perform actions like logging them out
            alert("You are removed from the test for exiting full screen mode.");
            // Redirect or perform other actions
            window.location.href = "/logout"; // Redirect to logout endpoint
        }
    });

    // Detect tab switching
    document.addEventListener("visibilitychange", function() {
        if (document.visibilityState === 'hidden') {
            // User switched tabs, perform actions like logging them out
            alert("You are removed from the test for switching tabs.");
            // Redirect or perform other actions
            window.location.href = "/logout"; // Redirect to logout endpoint
        }
    });
});
