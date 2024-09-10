
// 현금영수증 양식에 기능 부여를 위해 요소 접근
document.addEventListener("DOMContentLoaded", function() {
    const applyRadio = document.getElementById("apply");
    const notApplyRadio = document.getElementById("not-apply");
    const formSection = document.getElementById("form-section");

    // '신청' 버튼 체크 시 form-section 부분 요소 표시
    if (applyRadio.checked) {
        formSection.style.display = "block";
    } else { // 체크 안될 경우 요소 표시되지 않음
        formSection.style.display = "none";
    }

    // 폼 이벤트 change 기능 설정
    applyRadio.addEventListener("change", function() {
        if (this.checked) { // '신청' 버튼 체크 시 formSection 부분 화면에 표시
            formSection.style.display = "block";
        }
    });

    notApplyRadio.addEventListener("change", function() {
        if (this.checked) {//  '미신청' 버튼 체크 시 formSection 부분 화면에 표시되지 않음
            formSection.style.display = "none";
        }
    });
});

function totalPrice(){
    let totalPrice = 0;
    let priceelement = document.querySelectorAll('.price');
    let totalPricePrint = document.querySelector('.totalPrice');
    priceelement.forEach((priceelements) =>{
	  let price = parseInt(priceelements.innerHTML, 10);
      totalPrice += price;
      console.log(totalPrice);	

})
totalPricePrint.innerHTML = totalPrice;
}
totalPrice();