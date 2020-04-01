function id_check(){
	var check_nick=/^[0-9a-zA-Z]{5,15}$/;
	if(!(check_nick.test(info_form.stu_nickName.value))){
		alert("아이디를 사용할수 없습니다.");
		info_form.stu_nickName.value="";
		info_form.stu_nickName.focus();
		return false;
	};
		window.open("stu_input_idcheck.html","id_check",
		"width=600px,height=400px,resizable=no,scrollbars=no");
	};
	

	
function nick_ch(){
	var check_nick=/^[0-9a-zA-Z]{5,15}$/;
	if(!(check_nick.test(info_form.stu_nickName.value))){
		alert("닉네임을 사용할수 없습니다.");
		info_form.stu_nickName.value="";
		info_form.stu_nickName.focus();
		return false;
	};
		window.open("stu_input_nickcheck.html","nick_check",
		"width=600px,height=400px,resizable=no,scrollbars=no");
};


function all_check(){
	var pw_check=(/(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@\#$%<>^&*]).{3,10}$/);
	var name_kor_check=/^[가-힣]{1,}$/;
	var name_eng_check=/^[a-zA-Z]{1,}$/;
	var tel_check=/^[0-9]{3,}$/;
	var email_check=/^[0-9a-zA-Z]{1,}$/;
	if(!(pw_check.test(info_form.stu_pw.vlaue))){
		alert("비밀번호를 다시 입력해 주세요.");
		info_form.stu_pw.vlaue="";
		info_form.stu_pw.focus();
		return false;
	}
	
	if(info_form.stu_pw.vlaue!=info_form.stu_pw_check){
		alert("비밀번호가 맞지 않습니다.");
		info_form.stu_pw_check.vlaue="";
		info_form.stu_pw_check.focus();
		return false;
	}
	
	if(!(name_kor_check.test(info_form.stu_krname.vlaue))){
		alert("이름을 다시 입력해 주세요.");
		info_form.stu_krname.vlaue="";
		info_form.stu_krname.focus();
		return false;
	}
	if(!(name_eng_check.test(info_form.stu_engName.vlaue))){
		alert("이름을 다시 입력해 주세요.");
		info_form.stu_engName.vlaue="";
		info_form.stu_engName.focus();
		return false;
	}
	if(info_form.birth.vlaue==null){
		alert("생년월일을 입력해 주세요.");
		info_form.birth.vlaue="";
		return false;
	}
	
	if(!(tel_check.test(info_form.stu_tel_middle.vlaue))){
		alert("전화번호를 다시 입력해 주세요.");
		info_form.stu_tel_middle.vlaue="";
		info_form.stu_tel_middle.focus();
		return false;
	}
	if(!(tel_check.test(info_form.stu_tel_last.vlaue))){
		alert("전화번호를 다시 입력해 주세요.");
		info_form.stu_tel_last.vlaue="";
		info_form.stu_tel_last.focus();
		return false;
	}
	if((info_form.stu_pw_hint.vlaue=="")&&(info_form.stu_pw_hint_ans.vlaue=="")){
		alert("힌트를 입력 해주세요.");
		info_form.stu_pw_hint_ans.vlaue="";
		info_form.stu_pw_hint_ans.focus();
		return false;
	}
	if(!(email_check.test(info_form.email_head.vlaue))){
		alert("이메일을 다시 입력해 주세요.");
		info_form.email_head.vlaue="";
		info_form.email_head.focus();
		return false;
	}
	if(!(email_check.test(info_form.email_tail.vlaue))){
		alert("이메일을 다시 입력해 주세요.");
		info_form.email_tail.vlaue="";
		info_form.email_tail.focus();
		return false;
	}
	if(!(tel_check.test(info_form.tel_head.vlaue))){
		alert("전화번호를 다시 입력해 주세요.");
		info_form.tel_head.vlaue="";
		info_form.tel_head.focus();
		return false;
	}
	if(!(tel_check.test(info_form.tel_mid.vlaue))){
		alert("전화번호를 다시 입력해 주세요.");
		info_form.tel_mid.vlaue="";
		info_form.tel_mid.focus();
		return false;
	}
	if(!(tel_check.test(info_form.tel_tail.vlaue))){
		alert("전화번호를 다시 입력해 주세요.");
		info_form.tel_tail.vlaue="";
		info_form.tel_tail.focus();
		return false;
	}
	if(!(name_eng_check.test(info_form.parent_name.vlaue))){
		alert("이름을 다시 입력해 주세요.");
		info_form.parent_name.vlaue="";
		info_form.parent_name.focus();
		return false;
	}
	if(!(tel_check.test(info_form.parent_tel_mid.vlaue))){
		alert("전화번호를 다시 입력해 주세요.");
		info_form.parent_tel_mid.vlaue="";
		info_form.parent_tel_mid.focus();
		return false;
	}
	if(!(tel_check.test(info_form.parent_tel_tail.vlaue))){
		alert("전화번호를 다시 입력해 주세요.");
		info_form.parent_tel_tail.vlaue="";
		info_form.parent_tel_tail.focus();
		return false;
	}
	
	
	
	
}
