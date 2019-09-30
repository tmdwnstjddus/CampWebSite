/* ----------- Img preview ---------- */
function readURL(input, target) {
	if (input.files && input.files[0]) {
		var imgfiles = [];
		var files = input.files;
		var filesArr = Array.prototype.slice.call(files);
		var index = 0;

		filesArr.forEach(function (f) {
			if (!f.type.match("image.*")) {
				alert("확장자는 이미지 확장자만 가능합니다.");
				return;
			}

			imgfiles.push(f);

			var reader = new FileReader();
			reader.onload = function (e) {
				var result = "<img class='fileImg' src='" + e.target.result + "' style='width:200px; height:200px'>";
				target.append(result);
				index++;
			}
			reader.readAsDataURL(f);
		});
	}
}

/* ----------- camp (write, update) ---------- */
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
	
	
	/* ----------- Img preview ---------- */
	$("#writeForm").on("change", "#titleImgFile", function (event) {
		$('.inner_img').empty();
		readURL(this, $(".inner_img"));
	});
	$("#writeForm").on("change", "#imgFile", function (event) {
		$('.inner_imgs').empty();
		readURL(this, $(".inner_imgs"));
	});

	$("#updateForm").on("change", "#titleImgFile", function (event) {
		$(".inner_img").empty();
	    readURL(this, $(".inner_img"));
	});
	$("#updateForm").on("change", "#imgFile", function (event) {
	    readURL(this, $(".inner_imgs"));
	});

	//이미지 삭제
	$('.img-wrap .close').on('click', function() {
		var campFileNo = $(this).attr('data-fileNo');
		var deleteBtn = $(this).parent().parent();
		$.ajax({
			url: "/camp/delete-file",
			method: "GET",
			data: {"campFileNo" : campFileNo },
			success: function(data, status, xhr){
				deleteBtn.remove();
			},
			error: function(xhr, status, err){
				alert('삭제 실패');
			}
		});
	   
	});
	
});

/* ----------- year & monthChange ---------- */
function change() {
	$('#calendar-table').load("/camp/calendar", {
		"year": $('#y').val(),
		"month": $('#m').val(),
		"campNo": $('#campNo').val()
	});
}

/* ----------- dayChange ---------- */
function dayCheck(i) {
	if ($('#day' + i).is(":checked")) {
		$('td').removeClass('datepick');
		$('#day' + i).parent().addClass('datepick');
	} else {
		$('#day' + i).parent().removeClass('datepick');
	}

	$('#time-table').load("/camp/time", {
		"year": $('#y').val(),
		"month": $('#m').val(),
		"day": $('#day' + i).val(),
		"campNo": $('#campNo').val()
	});
}

/* ----------- timeChange ---------- */
var n = 0, s_t = 0, e_t = 0;
function timeClick(time) {
	n++;

	$('label').removeClass('timepick');
	if (n % 2 == 1) {
		s_t = time;
		startTime(time, s_t);
	} else if (n % 2 == 0) {
		e_t = time;
		endTime(time, s_t, e_t);
	}
}

function startTime(time, s_t) {// 시작시간 선택
	$('#timelabel' + time).addClass('timepick');
	$('#startTime').attr('value', s_t);
	$('#endTime').attr('value', s_t);
}

function endTime(time, s_t, e_t) {// 끝나는시간 선택
	for (var t = s_t; t <= e_t; t++) {
		$('#timelabel' + t).addClass('timepick');
	}
	$('#endTime').attr('value', e_t);
}


