/* Global Variables */
var position = 0;
var initialWidth = window.innerWidth * 5.2;

// RWD check
if($(window).width() < 640){
	// mobile
	console.log('mobile mode');
	$('.scrolling-img').attr("src","img/ConceptD-Family-Mobile.jpg");
} else {
	// desktop
	console.log('desktop mode');
	$('.scrolling-img').attr("src","img/ConceptD-Family-Desktop.jpg");
}

$(window).ready(function(){	
	position = $(window).scrollTop();
	$('.scrolling-img').width(initialWidth);
	
	// default initial
	scrollImage(position);
			
	// main scroll event
	$(window).scroll(scrollEvent);
});

// avoid too many scroll events triggered 
var timerStart = false;
function scrollEvent(){
	if(!timerStart){		
		scrollImage(position, true);
		timerStart = true;
		window.setTimeout(function(){			
			timerStart = false;
			position = $(window).scrollTop();
		}, 500);
	}
}

function scrollImage(position, animated=false){	
	var scroll = $(window).scrollTop();
	var scale = 1;
	var width = $('.scrolling-img').width();
    if(scroll > position) {
        console.log('scrollDown');
        scale = 0.625;
    } else if(scroll < position) {
        console.log('scrollUp');
        scale = 1.6;
    }    
    
	var wh = window.innerHeight;
    ww = window.innerWidth;
    // limit
    if($('.scrolling-img').width() * scale > initialWidth*1.2){
    	scale = 1;
    }else if($('.scrolling-img').width() * scale < window.innerWidth*0.7){
    	scale = 1;
    }    
    // offset shift to center when scroll up
    var shift = 0;
    if($('.scrolling-img').width() * scale < initialWidth * 0.24 ){
    	shift = 0.5;
    }else if($('.scrolling-img').width() * scale < initialWidth * 0.39 ){
    	shift = 0.42;
    }else if($('.scrolling-img').width() * scale < initialWidth * 0.62 ){
    	shift = 0.35;
    }else{
    	shift = 0.29;
    }
    ch = $('.scrolling-img').height() * scale;
    cw = $('.scrolling-img').width() * scale;
    t = wh / 2 - ch * 0.46;
    l = ww / 2 - cw * shift;
    
    if(animated){
    	$('.scrolling-img').animate({
        	width:cw,
        	left: l,
    		top: t
        });	
    }else{
    	$('.scrolling-img').width(cw);
    	$('.scrolling-img').offset({
        	left: l,
    		top: t
        });
    }  	
}
