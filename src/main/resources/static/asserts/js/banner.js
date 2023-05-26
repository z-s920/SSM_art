/**
 * $.xBanner
 * @author  xwk
 * @since   2011-12-07
 * @qq      56433593
 * @link    http://xwk.me
 * */
/**
eg:
$.xBanner({
	idSlider:'#idSlider2',
	idNum:'#idNum2',
	current:'on',
	effect:'fadeIn' // fadeIn or animate
});
 */
$.xBanner = function(options){
	var sleep = options.sleep?options.sleep:5000;
	var idSlider = $(options.idSlider);
	var idNum = $(options.idNum);
	var current = options.current;
	var effect = options.effect?options.effect:'animate';
	var width = parseInt(idSlider.children().first().width());
	var sto = null;
	idSlider.append(idSlider.children().first().clone());
	if(effect == 'animate'){
		idSlider.width(idSlider.children().size() * width);
	}
	var next = $(options.next);
	var prev = $(options.prev);
	function go(n,callback){
		var n1 = n;
		if(n == idNum.children().size()){
			n1 = 0;
		}
		idNum.children().eq(n1).addClass(current).siblings().removeClass(current);
		if(effect == 'fadeIn'){
			$(idSlider.children()[n1]).stop(true,true).fadeIn(500,function(){
				callback && callback();
			}).siblings().stop(true,true).fadeOut(500);
		}else{
			idSlider.stop(true,true).animate({
				marginLeft:-width*n
			},'normal',function(){
				if(n == idNum.children().size()){
					idSlider.css({marginLeft:0});
				}
				callback && callback();
			});
		}
	};
	function go_auto(n){
		sto && clearTimeout(sto);
		sto = setTimeout(function(){
			n = n+1;
			if(n > idNum.children().size()){
				n = 0;
			}
			go(n,function(){
				if(n == idNum.children().size()){
					n = 0;
				}
				go_auto(n);
			});
		},sleep);
	};
	
	//start
	$(document).ready(function(){
		if(idNum.children().size() <= 1){
			next.hide();
			prev.hide();
			idNum.hide();
		}else{
			idNum.children().hover(function(){
				sto && clearInterval(sto);
				go($(this).index());
			},function(){
				sto && clearInterval(sto);
				go_auto($(this).index());
			});
		
			if(effect == 'fadeIn'){
				idSlider.children().css({
					position:'absolute'
				}).hide().eq(0).fadeIn();
			}else{
				idSlider.children().css({
					float:'left',
					position:'relative'
				});
			}
			idNum.children().eq(0).addClass(current).siblings().removeClass(current);
			go_auto(0);
		}
	});
	
	next.click(function(){
		var idx = idNum.children('.'+current).index();
		idx = idx + 1;
		if(idx >= idNum.children().size()) idx = 0;
		sto && clearInterval(sto);
		go(idx);
		go_auto(idx);
	})
	
	prev.click(function(){
		var idx = idNum.children('.'+current).index();
		idx = idx - 1;
		if(idx < 0) idx = idNum.children().size() - 1;
		sto && clearInterval(sto);
		go(idx);
		go_auto(idx);
	})
}