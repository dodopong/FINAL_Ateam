// 드롭박스 이벤트 (난이도,카테고리 선택)
//.quizlevelselect 버튼 클릭 시 .droplist 가 보이게끔
const levelbtns = document.querySelector('.quizlevelselect');
const categorybtns = document.querySelector('.quizcategoryselect');

levelbtns.addEventListener('click',()=>{
    levelbtns.nextElementSibling.classList.toggle('off');
    //nextElementSibling : 다음 요소를 가르킴
});

categorybtns.addEventListener('click',()=>{
    categorybtns.nextElementSibling.classList.toggle('off');
    //nextElementSibling : 다음 요소를 가르킴
});



