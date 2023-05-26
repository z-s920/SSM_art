jwplayer.key="6RfMdMqZkkH88h026pcTaaEtxNCWrhiF6ACoxKXjjiI=";

function __Year_Month_day_Check(__type,__yearId,__monthId,__dayId){
	__year = document.getElementById(__yearId);
	__month = document.getElementById(__monthId);
	__day = document.getElementById(__dayId);
	__yearValue = Number(__year.value);
	__monthValue = Number(__month.value);
	__dayValue = Number(__day.value);
	if(__type == 'year'){
		for (var i = __month.options.length;i > 1;i--){
			__month.remove(i-1);
		}
		for (var i = __day.options.length;i > 1;i--){
			__day.remove(i-1);
		}
		if (__yearValue != '0000') {
			for (var i = 0;i < 12;i++){
				var n = i<9?'0'+(i+1):(i+1);
				__month.options[i+1] = new Option(n,n);
			}
		}
	}else if(__type == 'month'){
		if (__monthValue == '00') {
			for (var i = __day.options.length;i > 1;i--){
				__day.remove(i-1);
			}
		}else{
			var __monthDays = new Array(31,29,31,30,31,30,31,31,30,31,30,31);
			__monthDays[1] = (__yearValue % 4 == 0)&&(__yearValue % 100 != 0)||(__yearValue % 400 == 0)?29:28;
			var __newDay = __monthDays[__monthValue-1];
			for (var i = __day.options.length;i > __newDay +1 ;i--){
				__day.remove(i-1);
			}
			for (var i = __day.options.length;i < __newDay +1 ;i++){
				var n = i<10?'0'+ i:i;
				__day.options[i] = new Option(n,n);
			}
		}
	}
}

$('window').resize(function(){
	if($('window').width() >= 1680){
		$('#topKvBg').css('width','1680px');
	}else{
		$('#topKvBg').css('width','');
	}	
});

$.lang = function () {
	return location.pathname.split("/")[1];
};

$.gurl = function(url){
	return '/'+$.lang()+url;
};

$.get = function(url,_data,callback,dataType){
	var data = {};
	if(!callback){
		callback = _data;
	}else{
		data = _data;
	};
	if(!dataType){
		dataType = 'html';
	};
	var url_tmp = url;
	for(var d in data){
		url_tmp = url_tmp + ':' + d + '=' + data[d];
	};
	$.ajax({
		url: url,
		data: data,
		type: "GET",
		dataType: dataType,
		success: function(data){
			if(data == 'NEED_LOGIN'){
				if(top.location == self.location){
					location.reload();
				}else{
					parent.location.reload();
				};
			}else{
				callback && callback(data);
			};
		}
	});
};

$.post = function(url,_data,callback){
	var data = {};
	if(!callback){
		callback = _data;
	}else{
		data = _data;
	};
	var url_tmp = url;
	for(var d in data){
		url_tmp = url_tmp + ':' + d + '=' + data[d];
	};
	$.ajax({
		url: url,
		data: data,
		type: "POST",
		dataType: "html",
		success: function(data){
			if(data == 'NEED_LOGIN'){
				if(top.location == self.location){
					location.reload();
				}else{
					parent.location.reload();
				};
			}else{
				callback && callback(data);
			};
		}
	});
};
$.sub_share = function(str,len){
	if(!len){
		len = 120;
	}
	str = str.replace(/\n|\r|\t/g,"");
	var rtn = str.substr(0,len);
	if(rtn.length != str.length){
		rtn = rtn + '...';
	}
	return rtn;
}
$(document).ready(function() {
	$.lang = function () {
		return location.pathname.split("/")[1];
	};
	$.gurl = function(url){
		return '/'+$.lang()+url;
	};
	//菜单
	$('.topMenu .menu>li').hover(function() {
		$(this).children('div').stop().slideDown('fast');
	},
	function(){
		$(this).children('div').stop().slideUp('fast');
	});
	
	//首页
	$(this).find('.indexList .column3 .con p').slideUp();
	$('.column3 .con').hover(function() {
		$(this).find('p').stop().slideDown();
	},
	function(){
		$(this).find('p').stop().slideUp();
	});	
	
	//语音
	audiojs.events.ready(function() {
		audiojs.createAll();
	});
	
	//fancybox
	$('.fancyboxIframe').size() && $('.fancyboxIframe').fancybox({
		padding : 0,
		margin : 0,
		scrolling : 'no',
		width : '100%',
		height : '100%',
		openSpeed  : 150,
		closeSpeed  : 150,
		type : 'iframe',
		iframe : {
			scrolling : 'auto',
			preload   : true
		},
		title : null,
		tpl: {
			closeBtn : '<a class="fancybox-item fancybox-close fancybox-close2" href="javascript:;"></a>',
			next     : '<a class="fancybox-nav fancybox-nav2 fancybox-next fancybox-next2" href="javascript:;"><span></span></a>',
			prev     : '<a class="fancybox-nav fancybox-nav2 fancybox-prev fancybox-prev2" href="javascript:;"><span></span></a>'
		}
	});
	
	$('.fancyboxMap').size() && $('.fancyboxMap').fancybox({
		autoSize:false,
		padding : 5,
		margin : 0,
		scrolling : 'no',
		width : '60%',
		height : '60%',
		openSpeed  : 150,
		closeSpeed  : 150,
		type : 'iframe'
	});
	
	function isIpad() {
		return navigator.userAgent.match(/iPad/i) != null;
	}
	$.fn.xLazyLoad = function (options) {
		var _this = $(this);
		var defaults = {
			style: "top",
			offset: 200,
			trigger_element: null,
			callback: null,
			"": ""
		};
		var settings = $.extend({}, defaults, options);
		var stime = null;

		function loadImg() {
			_this.each(function () {
				if ($(this).attr("_effect")) {
					var y = isIpad() ? window.pageYOffset + 50 : Math.max(document.documentElement.scrollTop, document.body.scrollTop);
					var x = isIpad() ? window.pageXOffset + 50 : Math.max(document.documentElement.scrollLeft, document.body.scrollLeft);
					if (settings.trigger_element) {
						y = $(settings.trigger_element).offset().top;
						x = $(settings.trigger_element).offset().left;
					}
					var test = false;
					if (settings.style == "top") {
						test = $(this).offset().top <= document.documentElement.clientHeight + y + settings.offset && $(this).offset().top >= y - settings.offset;
					} else {
						test = $(this).offset().left <= document.documentElement.clientWidth - x + settings.offset && $(this).offset().left >= x - settings.offset;
					}
					if (test) {
						$(this).removeAttr('_effect');
						var self = this;
						var img = $(self).find('img[_src]');
						if(img.size()){
							var _src = $(img).attr("_src");
							$(img).removeAttr("_src");
							setTimeout(function () {
								$(img).load(function(){
									$(self).find('.div_hide_img').fadeIn();
								}).attr("src", _src);
								settings.callback && settings.callback.call($(self));
							}, Math.random() * 1000);
						}
					}
				}
			});
		}

		if (!settings.trigger_element) {
			$(window).bind("scroll.xLazyLoad", function () {
				if (stime) {
					clearTimeout(stime);
				}
				stime = setTimeout(function () {
					loadImg();
				}, 200);
			});
		}
		loadImg();
		return this;
	};
	
	function init_scroll(){
		var str = '#content .subnav,#content .subnav2,#content .regExplain,.div_user_left_menu';
		if($(str).size() && !$(str).hasClass('nofixed')){
			$(window).bind('scroll.show_fixedTop', function (){
				if($(document).scrollTop() > 320){
					$(str).parent().addClass('fixed');
				}else{
					$(str).parent().removeClass('fixed');
				}
			});
		}
	}
	init_scroll();
	
	
	$.fn.xScroll = function(callback){
		if($(this).size() == 0){
			return;
		}
		var _this = this;
		var ele = 'body';
		if($.browser.msie){
			ele = 'html';
		}
		$(ele).animate({
			scrollTop: $(this).offset().top
		}, 1000,function(){
			callback && callback.call($(_this));
		});
	};
	
	$.pageEnd = function (offset) {
		var scrollTop = 0;
		var clientHeight = 0;
		var scrollHeight = 0;
		if(!offset){
			offset = 500;
		}
		if (document.documentElement && document.documentElement.scrollTop) {
			scrollTop = document.documentElement.scrollTop;
		} else if (document.body) {
			scrollTop = document.body.scrollTop;
		}
		if (document.body.clientHeight && document.documentElement.clientHeight) {
			clientHeight = (document.body.clientHeight < document.documentElement.clientHeight) ? document.body.clientHeight : document.documentElement.clientHeight;
		} else {
			clientHeight = (document.body.clientHeight > document.documentElement.clientHeight) ? document.body.clientHeight : document.documentElement.clientHeight;
		}
		scrollHeight = Math.max(document.body.scrollHeight, document.documentElement.scrollHeight);
		if (scrollTop + clientHeight >= scrollHeight - offset) {
			return true;
		}
		return false;
	};
	
	$.params = function(name){
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null){
			return unescape(r[2]);
		}
		return null;
	}
	
	$.check_email = function (ipt_txt){
		var ipt_txt = $(ipt_txt);
		ipt_txt.val($.trim(ipt_txt.val()));
		if(!/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(ipt_txt.val())){
			ipt_txt.focus();
			return false;
		}
		return true;
	};
	$.check_password = function (ipt_txt){
		var ipt_txt = $(ipt_txt);
		ipt_txt.val($.trim(ipt_txt.val()));
		if(ipt_txt.val().length < 6 || ipt_txt.val().length > 20){
			ipt_txt.focus();
			return false;
		}
		return true;
	};
	$.check_mobile = function (ipt_txt){
		var ipt_txt = $(ipt_txt);
		ipt_txt.val($.trim(ipt_txt.val()));
		if(isNaN(ipt_txt.val()) || ipt_txt.val().length != 11){
			ipt_txt.focus();
			return false;
		}
		return true;
	};
	$.check_empty = function (ipt_txt){
		var ipt_txt = $(ipt_txt);
		ipt_txt.val($.trim(ipt_txt.val()));
		if(ipt_txt.val() == ''){
			ipt_txt.focus();
			return false;
		}
		return true;
	};
	
	$.fn.xNumber = function(){
		var bindStr = "input.validNumber propertychange.validNumber keyup.validNumber";
		$(this).on(bindStr,function(e){
			if(/[^\d]/g.test($(this).val())){
				$(this).val($(this).val().replace(/[^\d]/g,''));
			}
        });
	};
});