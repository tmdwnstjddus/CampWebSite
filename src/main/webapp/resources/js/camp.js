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
		var CampFileNo = $(this).attr('data-fileNo');
		var deleteBtn = $(this).parent().parent();
		$.ajax({
			url: "/CampWebSite/camp/delete-file",
			method: "GET",
			data: {"CampFileNo" : CampFileNo },
			success: function(data, status, xhr){
				deleteBtn.remove();
			},
			error: function(xhr, status, err){
				alert('삭제 실패');
			}
		});
	   
	});
	
});


