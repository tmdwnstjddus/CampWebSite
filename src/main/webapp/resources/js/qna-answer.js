	<script type="text/javascript">
	$(function() {
		$("#answerSubmitButton").on("click", function(event){
			event.preventDefault();
			submitAnswer();
		});
		
		function submitAnswer() {
			
			//var formData = $('#answerform').serialize();
			
			var writer = $("#memberId").text();
			var answerQaNo = $("#qaNo").text();
			var answerText = $("#answerText").val();

			var formData = {
				"memberId":writer,
				"qaNo":answerQaNo,
				"answerText":answerText
				 }
			
			
			$.ajax({
				type: "post",
				url: "/qna/answer",
				contentType: "application/json;charset=UTF-8",
				dataType: "text",
				data: JSON.stringify(formData),
		//		data: formData,
				success: function(data, status, xhr) {
					//$("#success-anser").load('/qna/qna-answer', 
					//		{ "qaNo" : ${ qna.qaNo } },
					alert("성공"); 
				},
				error: function(err) {
					console.log(err);
				}
			});
			
		}


		})
		
	</script>
	
	