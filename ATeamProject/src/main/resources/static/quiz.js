//*-*-*-*-*-*-*-*-*-*-*--*-*-*-*메인영역3 이벤트 *-*-*-*-*-*-*-*-*--*-*-*-*-*-*-*-*
//왼쪽
document.querySelectorAll('.nav-left a').forEach((item, index) => {
    item.addEventListener('click', function(event) {
        event.preventDefault();
        // 클릭한 영역에 대해
        // 1. 이전 영역은 삭제하고
        // 2. 클릭한 영역에 클래스 on을 붙여서 실행.
        //  클릭한 영역을 구분하는 방법?
        const boxs = document.querySelectorAll('.leftbox');

        document.querySelectorAll('.leftbox').forEach(container => {
            if(container.classList.value === 'leftbox on'){
                container.classList.remove('on');
            }else{
                container.classList.add('on');
            }
        });
    });
});

//오른쪽
document.querySelectorAll('.nav-right a').forEach((item, index) => {
    item.addEventListener('click', function(event) {
        event.preventDefault();

        const boxs = document.querySelectorAll('.rightbox');

        document.querySelectorAll('.rightbox').forEach(container => {
            if(container.classList.value === 'rightbox on'){
                container.classList.remove('on');
            }else{
                container.classList.add('on');
            }
        });
    });
});

