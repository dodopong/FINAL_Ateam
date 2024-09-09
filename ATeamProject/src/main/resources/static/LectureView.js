let btn1 = document.querySelector('.ahrckbtn');
let ahrckli = document.querySelector('.ahrckli');
let isShow = false;
// 목차가 안 보이는 상태로 초기 설정

btn1.addEventListener('click', function(){
    // btn1 = .ahrckbtn을 클릭했을 때
    if (isShow) {
        // isShow가 True면
        ahrckli.style.maxHeight = '0';
        // ahrckli의 maxHeight를 0으로 변경
        btn1.textContent = '목차';
        // 텍스트를 목차로 바꿈
    } else {
        // isSshow가 false면
        ahrckli.style.maxHeight = ahrckli.scrollHeight + 'px';
        // ahrckli의 maxHeight를 요소에 들어있는 컨텐츠의 전체 높이 px만큼으로 변경
        btn1.textContent = '목차 숨기기';
        // 텍스트를 목차 숨기기로 변경
    }
    isShow = !isShow;
})

const header = document.querySelector(".header");
//Header 스크롤 이벤트 리스너
document.addEventListener('scroll', function() {
    const scrollTop = window.scrollY;
    // 스크롤 위치에 따라 헤더의 클래스 추가 및 삭제
    if (scrollTop > 0) {
        header.classList.add('down');
    } else {
        header.classList.remove('down');
    }

    // 현재 스크롤 위치를 콘솔에 출력
    console.log('Current scroll position:', scrollTop);
});



