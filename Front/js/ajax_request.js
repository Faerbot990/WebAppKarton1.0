function ajax_request(callback, data, url, form = false){
	if(form != false){
		$(form).on('submit', function(e){
			e.preventDefault();
			do_request();
			return false;
		});
	}
}

function do_request(data, url){
	$.ajax({
		url: url,
		type: 'post',
		data: data,
		success: function(json){
			callback(json);
		},
		error: function (xhr, str) {
			alert('Возникла ошибка: ' + xhr.responseCode);
		}
	});
}






