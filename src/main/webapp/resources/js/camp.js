$(function () {
/* ----------- textCount ---------- */
	$("#camp_name").keyup(function (e) {
		var content = $(this).val();
		$(this).height(((content.split('\n').length + 1) * 1.5) + 'em');
		$("#campNameCnt").html(content.length);
	});
	$("#camp_name").keyup();

	$("#camp_text").keyup(function (e) {
		var content = $(this).val();
		$(this).height(((content.split('\n').length + 1) * 1.5) + 'em');
		$("#campContentCnt").html(content.length);
	});
	$("#camp_text").keyup();
	
});