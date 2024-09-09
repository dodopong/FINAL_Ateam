
// 리뷰 별점 색칠하기
function fillReviewStar(rateElement, reviewRate) {
	// starColor 요소에 적용할 ".review-rate-color"의 요소값 선택
    const starColorElement = rateElement.previousElementSibling.querySelector('.review-rate-color');
    if (starColorElement && reviewRate > 0) {  // starColor 요소와 reviewRate가 0 이상이면
        const starWidth = (reviewRate / 5) * 100;  // starColor의 너비(색상)는 reviewRate %값으로 환산 
        starColorElement.style.width = `${starWidth}%`; // reviewRate 평균값을 starWidth에 백분율로 변환.
    } else { // starColor 요소와 reviewRate가 0이면
        starColorElement.style.width = '0';  // starColor 색상 값은 0
    }
}

// 전체 리뷰 평점 계산하기
function calculateTotalAndCount(rates) {
    let totalRate = 0; // 전체 평점의 합
    let count = 0; 		// 평점 개수

    rates.forEach(rate => {
        const reviewRate = parseFloat(rate.textContent.trim());
        totalRate += reviewRate; // totalRate =  reviewRate 값 누적 계산
        count++;

        // 각 리뷰의 별점 색칠
        fillReviewStar(rate, reviewRate);
    });

    return { totalRate, count }; 
}

// 전체 평균 평점 출력하기
function displayAverageRate(averageRate) {
    const pointElement = document.querySelector('.point'); 
    if (!isNaN(averageRate)) { // 평균 평점의 값이 0이 아니면
        pointElement.textContent = `평점 ${averageRate.toFixed(1)}점`; //평점 표시)
    } else { 
        pointElement.textContent = "평점 0점"; // 리뷰 없을때
    }
}

// 메인 별점 색칠하기
function fillMainStar(averageRate) {
    const mainStarColorElement = document.querySelector('.starcolor'); // 꽉찬별(★) 호출
    if (mainStarColorElement && averageRate > 0) {  // mainstarColor와 평균평점이 0 이상이면 
        const mainStarWidth = (averageRate / 5) * 100;  // mainstarColor의 너비(색상)는 reviewRate %값으로 환산 
        mainStarColorElement.style.width = `${mainStarWidth}%`; // averageRate 평균값을 mainStarWidth에 백분율로 변환.
    } else {
        mainStarColorElement.style.width = '0'; // 리뷰 없을때
    }
}

// 전체 평균 평점 계산 후 출력
function calculateAverageRate() {
    const rates = document.querySelectorAll('.review-rate');
    
    // 리뷰 평점 합산 및 카운트 계산
    const { totalRate, count } = calculateTotalAndCount(rates);
    
    // 평균 계산
    const averageRate = totalRate / count;

    return averageRate;
}

// 별 색칠 및 평점 출력 메소드 호출
function callDisplayStar(){
  const averageRate = calculateAverageRate();
    // 평균 평점 출력
    displayAverageRate(averageRate);

    // 메인 별점 색칠
    fillMainStar(averageRate);
}

// 페이지가 로드되면 평점 평균 계산 함수 호출
document.addEventListener('DOMContentLoaded', callDisplayStar);
