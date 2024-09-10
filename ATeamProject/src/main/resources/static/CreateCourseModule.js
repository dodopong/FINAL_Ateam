let btns = document.querySelector('#nofree');
let ins = document.querySelector('.nofree');

btns.addEventListener('click', function(){
        ins.classList.add('on');

})

let btnss = document.querySelector('#free');
 let isShoww = true;
btnss.addEventListener('click', function(){
      ins.classList.remove('on');

})
