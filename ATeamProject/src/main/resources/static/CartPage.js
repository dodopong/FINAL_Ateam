//*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* header 이벤트 *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
const headerDown = document.querySelector(".headerDown");
const header = document.querySelector(".header");
const headerDownHeight = headerDown.querySelector("ul").offsetHeight;
let isScrolling = false;


headerDown.style.height = `${headerDownHeight}px`;

// header Scroll event
document.addEventListener('scroll', () => {
    if (!isScrolling) {
        isScrolling = true;
        requestAnimationFrame(() => {
            const scrollTop = window.scrollY;
            if (scrollTop > 0) {
                headerDown.style.height = "0";
                header.classList.add("color");
            } else {
                headerDown.style.height = `${headerDownHeight}px`;
                header.classList.remove("color");
            }
            isScrolling = false;
        });
    }
});

// 하단 체크박스 중 하나라도 풀리면 전체선택 체크박스 자동 해제

  function checkSelectAll(checkbox)  {
    const selectall = document.querySelector('input[name="selectall"]');
    
    if(checkbox.checked === false)  {
      selectall.checked = false;
    }
  }
  
// 체크박스 전체선택, 해제

  function selectAll(selectAll)  {
    const checkboxes = document.getElementsByName('cartbox');
    
    checkboxes.forEach((checkbox) => {
      checkbox.checked = selectAll.checked
    })
  }

// 장바구니 버튼

let keepbtn = document.querySelector('.keepbtn');
let orderbtn = document.querySelector('.orderbtn');
        keepbtn.addEventListener('click', ()=>{
            alert("쇼핑 계속하기 누름");
        });

// 구매하기 버튼 누르면 체크한 항목 courseKey 가져와서 저장

        orderbtn.addEventListener('click', ()=>{
          const checkedbox = document.querySelectorAll('input[name="cartbox"]:checked');
          const keyarr = new Array;

          checkedbox.forEach((checkedbox1) => {
            keyarr.push(checkedbox1.value);
          })
          document.getElementById('jsonData').value = JSON.stringify(keyarr);
          // cart.html 구매하기 버튼 위의 hidden input의 밸류를 keyarr로
          // JSON.stringify : JavaScript 값이나 객체를 JSON 문자열로 변환

        });