/**
 * 
 */
//jQuery used for simplicity
$(window).scroll(function(){
  $('#header-inner').toggleClass('scrolling', $(window).scrollTop() > $('#header').offset().top);

  //can be rewritten long form as:
  var scrollPosition, headerOffset, isScrolling;
  scrollPosition = $(window).scrollTop();
  headerOffset = $('#header').offset().top;
  isScrolling = scrollPosition > headerOffset;
  $('#header-inner').toggleClass('scrolling', isScrolling);
});