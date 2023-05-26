/**
 * Autocomplete jQuery version
 * @author xwk
 * @since 2011-07-04
 * @qq 56433593
 * @version 0.5
 * @version $Id: xAutocomplete_JQ.js 10166 2013-06-16 15:33:34Z xwk $
 */
(function($){
	$.fn.xAutocomplete = function(options){
		var defaults = {
			ul: null,
			loading: null,
			url: null,
			delay : 200,
			beforeFilter:function(){return true},
			start:function(){},
			end:function(){},
			timeout_id : null,
			isLoading : false,
			1:1
		};
		var settings = $.extend({}, defaults, options);
		var ipt = $(this).find('.ipt_search_text');
		settings.ul = $(this).find('.div_search_result');
		settings.loading = $(this).find('.loading');
		var bindStr = "input.xAutocomplete propertychange.xAutocomplete keyup.xAutocomplete";
		$(ipt).bind(bindStr,function(evt){
			if(!settings.beforeFilter()){
				return true;
			}
			if(evt.keyCode == 37
			|| evt.keyCode == 38
			|| evt.keyCode == 39
			|| evt.keyCode == 40){
				return true;
			}
			if(settings.timeout_id){
				clearTimeout(settings.timeout_id);
			}
			settings.timeout_id = setTimeout(function(evt){
				if(!settings.isLoading){
					if(ipt.val() == ""){
						settings.ul.hide();
						return ;
					}
					settings.isLoading = true;
					settings.loading && settings.loading.show();
					
					var url = settings.url + encodeURIComponent(ipt.val());
					settings.start();
					$.get(url, function(data){
						settings.ul.html(data);
						if(data == ''){
							settings.ul.hide();
						}else{
							settings.ul.show();
						}
						settings.isLoading = false;
						settings.loading && settings.loading.hide();
					});
				}
			},settings.delay);
		});
		$(document).bind("click.xAutocomplete",function(){
			settings.ul.hide();
		}).trigger("click.xAutocomplete");
		
		return this;
	};
})(jQuery);