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
const BannerSlidenextBtn = document.querySelector(".slideContainer").querySelector('.nextBtn');
const BannerSlideprevBtn = document.querySelector(".slideContainer").querySelector('.preBtn');

BannerSlidenextBtn.addEventListener('click', () => {
    stopSlide();
    slideGo();
    startSlide();
});

BannerSlideprevBtn.addEventListener('click', () => {
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

//*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* section Slide Setting *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
const sectionContainerAll = document.querySelectorAll(".sectionContainer");
const sectionContainer = document.querySelector(".sectionContainer");
const sectionSlidesAll = document.querySelectorAll(".sectionSlides");
const sectionSlides = document.querySelector(".sectionSlides");
const sectionSlideAll = document.querySelectorAll(".sectionSlide");
const sectionslide = document.querySelector(".sectionSlide");

function sectionSlide_sizeSetting() {
    sectionSlideAll.forEach(slide => {
        slide.style.width = sectionContainer.offsetWidth / 5 + "px";
    });
    sectionContainerAll.forEach(container => {
        container.style.height = sectionSlides.offsetHeight + "px";
        container.querySelector(".sectionSlides").style.left = -sectionslide.offsetWidth + "px";
    });
}

sectionSlide_sizeSetting();
sectionSlidesAll.forEach(container => {
    container.prepend(container.lastElementChild);
});

window.addEventListener('resize', () => {
    sectionSlide_sizeSetting();
});

//*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* Section01slide 이벤트 *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
const section01 = document.querySelector(".section01");
const section01_Container = section01.querySelector(".sectionContainer");
const section01_Container_sectionSlides = section01_Container.querySelector(".sectionSlides");
const section01_Container_sectionSlides_slide = section01_Container_sectionSlides.querySelector(".sectionSlide");
let setion01_Slide_Trans = false;
let setion01_Slide_Timer;

function section01_slideGo() {
    if (setion01_Slide_Trans) return; // 전환 중이면 함수 종료

    setion01_Slide_Trans = true;
    section01_Container_sectionSlides.style.transition = "left 0.5s ease";
    section01_Container_sectionSlides.style.left = `-${section01_Container_sectionSlides_slide.offsetWidth * 2}px`;

    section01_Container_sectionSlides.addEventListener('transitionend', () => {
        section01_Container_sectionSlides.style.transition = 'none';
        section01_Container_sectionSlides.appendChild(section01_Container_sectionSlides.firstElementChild);
        section01_Container_sectionSlides.style.left = `-${section01_Container_sectionSlides_slide.offsetWidth}px`;
        setion01_Slide_Trans = false; // 전환 완료 후 플래그 리셋
    }, { once: true });
}

function section01_slidePrev() {
    if (setion01_Slide_Trans) return; // 전환 중이면 함수 종료

    setion01_Slide_Trans = true;
    section01_Container_sectionSlides.style.transition = "left 0.5s ease";
    section01_Container_sectionSlides.style.left = `0px`;

    section01_Container_sectionSlides.addEventListener('transitionend', () => {
        section01_Container_sectionSlides.style.transition = 'none';
        section01_Container_sectionSlides.prepend(section01_Container_sectionSlides.lastElementChild);
        section01_Container_sectionSlides.style.left = `-${section01_Container_sectionSlides_slide.offsetWidth}px`;
        setion01_Slide_Trans = false; // 전환 완료 후 플래그 리셋
    }, { once: true });
}

function startSection01() {
    setion01_Slide_Timer = setInterval(section01_slideGo, 4000);
}

function stopSection01() {
    clearInterval(setion01_Slide_Timer);
}

startSection01();

window.addEventListener('resize', () => {
    stopSection01();
    startSection01();
});

//*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* Section02slide 이벤트 *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
const section02 = document.querySelector(".section02");
const section02_Container = section02.querySelector(".sectionContainer");
const section02_Container_sectionSlides = section02_Container.querySelector(".sectionSlides");
const section02_Container_sectionSlides_slide = section02_Container_sectionSlides.querySelector(".sectionSlide");
let setion02_Slide_Trans = false;
let setion02_Slide_Timer;

function section02_slideGo() {
    if (setion02_Slide_Trans) return; // 전환 중이면 함수 종료

    setion02_Slide_Trans = true;
    section02_Container_sectionSlides.style.transition = "left 0.5s ease";
    section02_Container_sectionSlides.style.left = `-${section02_Container_sectionSlides_slide.offsetWidth * 2}px`;

    section02_Container_sectionSlides.addEventListener('transitionend', () => {
        section02_Container_sectionSlides.style.transition = 'none';
        section02_Container_sectionSlides.appendChild(section02_Container_sectionSlides.firstElementChild);
        section02_Container_sectionSlides.style.left = `-${section02_Container_sectionSlides_slide.offsetWidth}px`;
        setion02_Slide_Trans = false; // 전환 완료 후 플래그 리셋
    }, { once: true });
}

function section02_slidePrev() {
    if (setion02_Slide_Trans) return; // 전환 중이면 함수 종료

    setion02_Slide_Trans = true;
    section02_Container_sectionSlides.style.transition = "left 0.5s ease";
    section02_Container_sectionSlides.style.left = `0px`;

    section02_Container_sectionSlides.addEventListener('transitionend', () => {
        section02_Container_sectionSlides.style.transition = 'none';
        section02_Container_sectionSlides.prepend(section02_Container_sectionSlides.lastElementChild);
        section02_Container_sectionSlides.style.left = `-${section02_Container_sectionSlides_slide.offsetWidth}px`;
        setion02_Slide_Trans = false; // 전환 완료 후 플래그 리셋
    }, { once: true });
}

function startSection02() {
    setion02_Slide_Timer = setInterval(section02_slidePrev, 4000);
}

function stopSection02() {
    clearInterval(setion02_Slide_Timer);
}

startSection02();

window.addEventListener('resize', () => {
    stopSection02();
    startSection02();
});


//*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* sectionSlide Btn 이벤트 *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*


const section01_nextBtn = section01_Container.querySelector(".nextBtn");
const section01_preBtn = section01_Container.querySelector('.preBtn');
const section02_nextBtn = section02_Container.querySelector(".nextBtn");
const section02_preBtn = section02_Container.querySelector('.preBtn');

section01_nextBtn.addEventListener('click', () => {
    stopSection01();
    stopSection02();
    section01_slideGo();
    startSection01();
    startSection02();
});


section01_preBtn.addEventListener('click', () => {
    stopSection01();
    stopSection02();
    section01_slidePrev();
    startSection01();
    startSection02();
});

section02_nextBtn.addEventListener('click', () => {
    stopSection01();
    stopSection02();
    section02_slideGo();
    startSection01();
    startSection02();
});


section02_preBtn.addEventListener('click', () => {
    stopSection01();
    stopSection02();
    section02_slidePrev();
    startSection01();
    startSection02();
});