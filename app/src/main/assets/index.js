function load (event){
    var plugin = document.getElementById("plugin-live-player");
    plugin.addEventListener('touchstart',touch);
    plugin.addEventListener('touchmove',touch);
    plugin.addEventListener('touchend',touch);
    plugin.addEventListener("touchcancel",touch);
    plugin.addEventListener("touchleave",touch);

    function touch (event){
    }
}
window.addEventListener('load',load, false);