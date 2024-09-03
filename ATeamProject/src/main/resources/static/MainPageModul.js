
//*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* slide 이벤트 *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
const slides = document.querySelector('.slides');

let slideWidth = document.querySelector('.slide').offsetWidth;
let timer;
let isTransitioning = false; // 전환 진행 중인지 추적하는 플래그

function settingSlide() {
    slideWidth = document.querySelector('.slide').offsetWidth;
    slides.style.left = `-${slideWidth}px`;
}

function slideGo() {
    if (isTransitioning) return; // 전환 중이면 함수 종료

    isTransitioning = true;
    slides.style.transition = "left 0.5s ease";
    slides.style.left = `-${slideWidth * 2}px`;

    slides.addEventListener('transitionend', () => {
        slides.style.transition = 'none';
        slides.appendChild(slides.firstElementChild);
        slides.style.left = `-${slideWidth}px`;
        isTransitioning = false; // 전환 완료 후 플래그 리셋
    }, { once: true });
}

function slidePrev() {
    if (isTransitioning) return; // 전환 중이면 함수 종료

    isTransitioning = true;
    slides.style.transition = "left 0.5s ease";
    slides.style.left = `0px`;

    slides.addEventListener('transitionend', () => {
        slides.style.transition = 'none';
        slides.prepend(slides.lastElementChild);
        slides.style.left = `-${slideWidth}px`;
        isTransitioning = false; // 전환 완료 후 플래그 리셋
    }, { once: true });
}

function startSlide() {
    timer = setInterval(slideGo, 4000);
}

function stopSlide() {
    clearInterval(timer);
}

// 버튼 이벤트 리스너
const nextBtn = document.querySelector('.nextBtn');
const prevBtn = document.querySelector('.preBtn');

nextBtn.addEventListener('click', () => {
    stopSlide();
    slideGo();
    startSlide();
});

prevBtn.addEventListener('click', () => {
    stopSlide();
    slidePrev();
    startSlide();
});

// 슬라이더 초기화
settingSlide();
slides.prepend(slides.lastElementChild);
startSlide();

// 화면 사이즈 변화 처리
window.addEventListener('resize', () => {
    stopSlide();
    settingSlide();
    startSlide();
});

