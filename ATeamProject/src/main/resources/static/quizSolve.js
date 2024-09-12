//*-*-*-*-*-*-*-*-*-*-*--*-*-*-*메인영역 이벤트 *-*-*-*-*-*-*-*-*--*-*-*-*-*-*-*-*
//왼쪽
document.querySelectorAll('.nav-left a').forEach((item, index) => {
    item.addEventListener('click', function(event) {
        event.preventDefault();

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