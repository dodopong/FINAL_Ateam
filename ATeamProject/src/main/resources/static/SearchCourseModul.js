let filterselects = document.querySelectorAll(".filterselect");
//필터 셀렉트 이벤트
filterselects.forEach(filterselect => {
    filterselect.addEventListener('click',()=>{
        filterselects.forEach((e)=>{
            e.classList.remove('active');
        })
        filterselect.classList.add('active');
    })
});

