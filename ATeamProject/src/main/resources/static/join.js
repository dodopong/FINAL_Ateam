/////////////////////////////////////////////////////////////////
//약관동의 하지 않을 시 회원가입 불가능

function AlertCheckbox(){
   
	const checkboxes = document.querySelectorAll('.agree');
	alert("으하하하");
	if(checkboxes.unchecked == true){ // 조건문 안먹음 checkboxes 벨류?
		alert('약관 동의는 필수입니다.');
	return false;	
	}		
}

let nBtns = document.querySelector(".next-btn");
nBtns.addEventListener("click", function(e){
	e.preventDefault();
	AlertCheckbox();
	//document.(폼name).submit();
})
    
//문제 : 
/*	const checkboxes = document.querySelectorAll('.agree');

	if(checkboxes.checked === true){
		return;	
       //checked가 있으면 바로 return!!
	}
	// 체크없으면 바로 return해서 alert 띄우기
	alert('약관 동의는 필수입니다.');  */


/////////////////////////////////////////////////////////////////
//이메일-도메인 선택박스
// 도메인 직접 입력 or domain option 선택
const domainListEl = document.querySelector('#domain-list')
const domainInputEl = document.querySelector('#domain-txt')
// select 옵션 변경 시
domainListEl.addEventListener('change', (event) => {
  // option에 있는 도메인 선택 시
  if(event.target.value !== "type") {
    // 선택한 도메인을 input에 입력하고 disabled
    console.log(event.target.value)
    domainInputEl.value = event.target.value
    //domainInputEl.disabled = true
  } else { // 직접 입력 시
    // input 내용 초기화 & 입력 가능하도록 변경
    domainInputEl.value = ""
    //domainInputEl.disabled = false
  }
});
////////////////////////////////////////////////////////////////
//전화번호입력 정규 표현식
function oninputPhone(target) {
  target.value = target.value
      .replace(/[^0-9]/g, '')
      .replace(/(\..*?)\..*/g, '$1')  //숫자 외 입력방지
      .replace(/(^02.{0}|^01.{1}|[0-9]{3,4})([0-9]{4})([0-9]{4})/g, "$1-$2-$3"); //자동 하이픈 생성
}


////////////////////////////////////////////////////////////////
//가입유형-강사를 선택했을 때만 서류제출란이 보이게

let btns = document.querySelector('#instructor');
let ins = document.querySelector('.instructor');

btns.addEventListener('click', function(){
        ins.classList.add('on');

})

let btnss = document.querySelector('#student');
 let isShoww = true;
btnss.addEventListener('click', function(){
      ins.classList.remove('on');

})


