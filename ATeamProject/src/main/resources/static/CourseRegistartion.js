
// 리뷰 별점 색칠하기
function fillReviewStar(rateElement, reviewRate) {
    const starColorElement = rateElement.previousElementSibling.querySelector('.review-rate-color');
    if (starColorElement && reviewRate > 0) { 
        const starWidth = (reviewRate / 5) * 100; 
        starColorElement.style.width = `${starWidth}%`; 
    } else {
        starColorElement.style.width = '0'; 
    }
}

// 전체 리뷰 평점 계산하기
function calculateTotalAndCount(rates) {
    let totalRate = 0;
    let count = 0;

    rates.forEach(rate => {
        const reviewRate = parseFloat(rate.textContent.trim());
        totalRate += reviewRate;
        count++;

        // 각 리뷰의 별점 색칠
        fillReviewStar(rate, reviewRate);
    });

    return { totalRate, count };
}

// 평균 평점 계산 후 출력하기
function displayAverageRate(averageRate) {
    const pointElement = document.querySelector('.point');
    if (!isNaN(averageRate)) {
        pointElement.textContent = `평점 ${averageRate.toFixed(1)}점`;
    } else {
        pointElement.textContent = "평점 0점"; // 리뷰가 없을 때
    }
}

// 메인 별점 색칠하기
function fillMainStar(averageRate) {
    const mainStarColorElement = document.querySelector('.starcolor');
    if (mainStarColorElement && averageRate > 0) { 
        const mainStarWidth = (averageRate / 5) * 100; 
        mainStarColorElement.style.width = `${mainStarWidth}%`; // averageRate 평균값을 mainStarWidth에 표기 시 100분율로 환산.
    } else {
        mainStarColorElement.style.width = '0'; 
    }
}

// 전체 평점 계산 및 표시
function calculateAverageRate() {
    const rates = document.querySelectorAll('.review-rate');
    
    // 리뷰 평점 합산 및 카운트 계산
    const { totalRate, count } = calculateTotalAndCount(rates);
    
    // 평균 계산
    const averageRate = totalRate / count;

    // 평균 평점 출력
    displayAverageRate(averageRate);

    // 메인 별점 색칠
    fillMainStar(averageRate);
}

// 페이지가 로드되면 평점 평균 계산 함수 호출
document.addEventListener('DOMContentLoaded', calculateAverageRate);
