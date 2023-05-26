/**
 * @author  xwk
 * @qq      56433593
 * @mail    x@xwk.me
 * @since   2013-09-29
 * @version 2.0
 * */
$(document).ready(function(){
	$('label[for]').each(function(){
		var _this = $(this);
		if(_this.siblings('input').size()){
			_this.siblings('input').blur(function(){
				$(this).removeClass('focus');
				if($(this).val() != ''){
					_this.hide();
				}else{
					_this.show();
				}
			}).focus(function(){
				_this.hide();
				$(this).addClass('focus');
			});
			_this.click(function(){
				_this.siblings('input').focus();
			});
		}
	});
});