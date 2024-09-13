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

//let keepbtn = document.querySelector('.keepbtn');
let orderbtn = document.querySelector('.orderbtn');
        //keepbtn.addEventListener('click', ()=>{
           // alert("쇼핑 계속하기 누름");
       // });

// 구매하기 버튼 누르면 체크한 항목 courseKey 가져와서 저장

        orderbtn.addEventListener('click', (e)=>{
		e.preventDefault();	
          const checkedbox = document.querySelectorAll('input[name="cartbox"]:checked');
          const keyarr = new Array;
          if(checkedbox.length<=0){
				alert("선택된 강의가 없습니다");
				return false;
			}
			else{
				checkedbox.forEach((checkedbox2) => {
           		keyarr.push(checkedbox2.value);
            		})
			}
 
          document.getElementById('jsonData').value = JSON.stringify(keyarr);
          document.getElementById('myForm').submit();
          // cart.html 구매하기 버튼 위의 hidden input의 밸류를 keyarr로
          // JSON.stringify : JavaScript 값이나 객체를 JSON 문자열로 변환

        });