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

//*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* Category 이벤트 *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
const categoryBtn = document.querySelector(".categoryBtn");
const categoryContainer = document.querySelector(".categoryContainer");
const windowHeight = window.innerHeight;
const headerHeight = header.offsetHeight;
const categoryContainerHeight = windowHeight - headerHeight;

let categoryOn = false;


categoryBtn.addEventListener('click', function () {
    if (categoryOn === false) {
        categoryContainer.classList.add('on');
        categoryContainer.style.height =  "100vh";
        document.querySelector('body').classList.add("stopScolling");
        categoryOn = true;
    }else{
        categoryContainer.classList.remove('on');
        categoryContainer.style.height ="0px";
        document.querySelector('body').classList.remove("stopScolling");
        categoryOn = false;
    }
});
// 화면 사이즈 변화 처리
// window.addEventListener('resize', () => {
//     windowHeight = window.innerHeight;
//     headerHeight = header.offsetHeight;
//     categoryContainerHeight = windowHeight - headerHeight;

//     categoryContainer.style.height = categoryContainerHeight + "px";
// });