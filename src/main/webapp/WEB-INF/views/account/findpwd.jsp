<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
   $(function(){
      $("#findBtn").click(function(){
         $.ajax({
            url : "/account/findpwd",
            type : "POST",
            data : {
               memberId : $("#memberId").val(),
               email : $("#email").val()
            },
            success : function(result) {
               alert(result);
            },
         })
      });
   })
</script>
<title>비밀번호 찾기</title>
</head>
<body>
   <div class="w3-content w3-container w3-margin-top">
      <div class="w3-container w3-card-4">
         <div class="w3-center w3-large w3-margin-top">
            <h3>비밀번호 찾기</h3>
         </div>
         <div>
            <p>
               <label>아이디</label>
               <input class="w3-input" type="text" id="memberId" name="memberId" required>
            </p>
            <p>
               <label>이메일</label>
               <input class="w3-input" type="text" id="email" name="email" required>
            </p>
            <p class="w3-center">
               <button type="button" id=findBtn class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round">찾기</button>
               <button type="button" onclick="history.go(-1);" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-margin-bottom w3-round">취소</button>
            </p>
         </div>
      </div>
   </div>
</body>
</html>