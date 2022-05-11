/**
 *  register.html의 form 유효성 검정
 *  jquery validation plug-in 사용
 */
$(function(){
    $("#modifyform").validate({
        // rules 정하기 - 유효성 검증 규칙 지정
        // form 요소 이름 사용
        rules:{
            current_password:{
                required:true,
                validPwd:true
            },
            new_password:{
                required:true,
                validPwd:true
            },
            confirm_password:{
                required:true,
                equalTo: "#new_password",    // 현재 요소가 어떤 요소와 값이 같아야 하는가? (아이디 사용해서)
                validPwd:true
            }

        }, // rules 종료

        // 규칙이 맞지 않을 경우 보여줄 메세지 작성
        messages:{
            current_password:{
                required:"현재 비밀번호는 필수 입력 요소입니다."

            },
            new_password:{
                required:"새 비밀번호는 필수 입력 요소입니다.",
            },
            confirm_password:{
                required:"비밀번호 확인은 필수 입력 요소입니다.",
                equalTo: "비밀번호가 일치하지 않습니다."
            }
        },
        
        errorPlacement:function(error, element){
			$(element).closest("form").find("small[id='"+element.attr('id')+"']").append(error);
		}
        
    });
});

$.validator.addMethod("validPwd",function(data){
    const regPwd = /^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%^&*])[A-Za-z0-9!@#$%^&*]{8,15}$/;
    return regPwd.test(data);
},"비밀번호는 영문자, 숫자, 특수문자를 포함해 8~15자리로 만들어야 합니다.");

