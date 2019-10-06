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
	
	/* ----------- calendar -----------	*/
	$("#startDate").datepicker({ 
		dateFormat: 'yy-mm-dd'
        ,showOtherMonths: true
        ,showMonthAfterYear:true
        ,changeYear: true 
        ,changeMonth: true               
        ,showOn: "both" 
        ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif"
        ,buttonImageOnly: true
        ,buttonText: "선택"              
        ,yearSuffix: "년"
        ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12']
        ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
        ,dayNamesMin: ['일','월','화','수','목','금','토']
        ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일']
        ,minDate: "-1M" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
        ,maxDate: "+1Y" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)
		,onClose: function (selectedDate) { 
		    $('#endDate').datepicker("option", 'minDate', selectedDate); 
		    $("#startDate").attr('value', selectedDate);
		}
	}); 

   $("#endDate").datepicker({ 
	   dateFormat: 'yy-mm-dd'
        ,showOtherMonths: true
        ,showMonthAfterYear:true
        ,changeYear: true 
        ,changeMonth: true               
        ,showOn: "both" 
        ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif"
        ,buttonImageOnly: true
        ,buttonText: "선택"              
        ,yearSuffix: "년"
        ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12']
        ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
        ,dayNamesMin: ['일','월','화','수','목','금','토']
        ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일']
        ,maxDate: "+1Y" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후) 
	    ,onClose: function (selectedDate) { 
	     $('#startDate').datepicker("option", 'maxDate', selectedDate); 
	     $("#endDate").attr('value', selectedDate);
	    }
   }); 
   
   /* ----------- rent ---------- */
   $('#rent_submit').on('click', function (event) {
	   // serialize() : <form에 포함된 입력 요소의 값을 이름=값&이름=값&... 형식으로 만드는 함수
	   var formData = $('#rentform').serialize();

	   $.ajax({
		   url: "/camp/campRent",
		   method: "POST",
		   data: formData,
		   success: function (data, status, xhr) {
			   alert("예약되었습니다!");
			   window.location.href = '/member/rentList';
		   },
		   error: function (xhr, status, err) {
			   alert(err);
		   }
	   });
   });	

});


function call()
{
	var sdd = document.getElementById("startDate").value;
    var edd = document.getElementById("endDate").value;
    var ar1 = sdd.split('-');
    var ar2 = edd.split('-');
    var da1 = new Date(ar1[0], ar1[1], ar1[2]);
    var da2 = new Date(ar2[0], ar2[1], ar2[2]);
    var dif = da2 - da1;
    var cDay = 24 * 60 * 60 * 1000;// 시 * 분 * 초 * 밀리세컨
    
    if(sdd && edd) {
    	document.getElementById('rentDate').value = parseInt(dif/cDay)
 	}
}

