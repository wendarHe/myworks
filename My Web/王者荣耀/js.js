window.onload=function (){
    var i=0;
    var index=0;
    var formerindex=0;
    var ismoving=false;

var i1=document.querySelector(".i1");
var i3=document.querySelector(".i3vac")
    var i4=document.querySelector(".i4vac")
    var i5=document.querySelector(".i5vac")
    var d5=document.querySelector(".d5vac")
    var arrowleft=document.querySelector(".arrowleftvac")
    var arrowright=document.querySelector(".arrowrightvac")
    var i6=document.querySelector(".i6vac");
    var i7=document.querySelector(".i7vac");
    var i8=document.querySelector(".i8vac");
    var i9=document.querySelector(".i9vac");
    var i10=document.querySelector(".i10vac");
    var i11=document.querySelector(".i11vac");
    var i12=document.querySelector(".i12vac");
    var i13=document.querySelector(".i13vac");
    var i14=document.querySelector(".i14vac");
    var i15=document.querySelector(".i15vac");
    var i16=document.querySelector(".i16vac");
    var i17=document.querySelector(".i17vac");
    var i18=document.querySelector(".i18vac");
    var i19=document.querySelector(".i19vac");
    var i20=document.querySelector(".i20vac");

    var i21=document.querySelector(".i21vac");
    var i22=document.querySelector(".i22vac");
    var i23=document.querySelector(".i23vac");


var btn1=document.querySelector(".btn1");
btn1.addEventListener("click",function (){
    console.log("aaaaaaaaaaaaaaaa")
})
    var btn2=document.querySelector(".btn2");
    var btn3=document.querySelector(".btn3");
    var btn4=document.querySelector(".btn4");
    var btn5=document.querySelector(".btn5");
    var btn6=document.querySelector(".btn6");
    var btn7=document.querySelector(".btn7");
var arraybutton=[];



for(var j=0;j<7;j++){
    var btn=document.querySelector(".btn"+(j+1));
    btn.num=j;
    arraybutton.push(btn);
    arraybutton[j].addEventListener("click",function (){

ismoving=true;
formerindex=index;
index=this.num;
i=825*index;
        if(formerindex===0){

            btn1.style.backgroundPosition=" -239px 0";
        }else if(formerindex===1){

            btn2.style.backgroundPosition=" -239px -58px";
        }else if(formerindex===2){

            btn3.style.backgroundPosition=" -239px -137px"
        }else if(formerindex===3){

            btn4.style.backgroundPosition=" -239px -221px"
        }else if(formerindex===4){

            btn5.style.backgroundPosition=" -239px -305px"
        }else if(formerindex===5){

            btn6.style.backgroundPosition=" -239px -387px"
        }else if(formerindex===6){

            btn7.style.backgroundPosition=" -239px -467px"
        }




        if(index===0){

            btn1.style.backgroundPosition=" -1px 0"
        }else if(index===1){


            btn2.style.backgroundPosition=" -1px -58px"
        }else if(index===2){

            btn3.style.backgroundPosition=" -1px -137px"
        }else if(index===3){

            btn4.style.backgroundPosition=" -1px -221px"
        }else if(index===4){

            btn5.style.backgroundPosition=" -1px -305px"
        }else if(index===5){

            btn6.style.backgroundPosition=" -1px -387px"
        }else if(index===6){

            btn7.style.backgroundPosition=" -1px -467px"
        }


bigmove(index,formerindex,function () {
    ismoving=false;
    if(formerindex===0){
        i1.className="displaynone";
        btn1.style.backgroundPosition=" -239px 0";
    }else if(formerindex===1){
        i3.className="displaynone";
        i4.className="displaynone";
        d5.className="displaynone"
        arrowleft.className="displaynone";
        arrowright.className="displaynone";
        i5.className="displaynone";
        btn2.style.backgroundPosition=" -239px -58px";
    }else if(formerindex===2){
        i6.className="displaynone";
        i7.className="displaynone";
        i8.className="displaynone";
        btn3.style.backgroundPosition=" -239px -137px"
    }else if(formerindex===3){
        i9.className="displaynone";
        i10.className="displaynone";
        i11.className="displaynone";
        i12.className="displaynone";
        btn4.style.backgroundPosition=" -239px -221px"
    }else if(formerindex===4){
        i13.className="displaynone";
        i14.className="displaynone";
        i15.className="displaynone";
        i16.className="displaynone";
        btn5.style.backgroundPosition=" -239px -305px"
    }else if(formerindex===5){
        i17.className="displaynone";
        i18.className="displaynone";
        i19.className="displaynone";
        i20.className="displaynone";
        btn6.style.backgroundPosition=" -239px -387px"
    }else if(formerindex===6){
        i21.className="displaynone";
        i22.className="displaynone";
        i23.className="displaynone";
        btn7.style.backgroundPosition=" -239px -467px"
    }




    if(index===0){
        i1.className="i1 i1animation";
        btn1.style.backgroundPosition=" -1px 0"
    }else if(index===1){

        i3.className="i3";
        i4.className="i4";
        d5.className="d5"
        arrowleft.className="arrowleft";
        arrowright.className="arrowright";
        i5.className="i5";
// console.log("index===1")
        btn2.style.backgroundPosition=" -1px -58px"
    }else if(index===2){
        i6.className="i6";
        i7.className="i7";
        i8.className="i8";
        btn3.style.backgroundPosition=" -1px -137px"
    }else if(index===3){
        i9.className="i9";
        i10.className="i10";
        i11.className="i11";
        i12.className="i12";
        btn4.style.backgroundPosition=" -1px -221px"
    }else if(index===4){
        i13.className="i13";
        i14.className="i14";
        i15.className="i15";
        i16.className="i16";
        btn5.style.backgroundPosition=" -1px -305px"
    }else if(index===5){
        i17.className="i17";
        i18.className="i18";
        i19.className="i19";
        i20.className="i20";
        btn6.style.backgroundPosition=" -1px -387px"
    }else if(index===6){
        i21.className="i21";
        i22.className="i22";
        i23.className="i23";
        btn7.style.backgroundPosition=" -1px -467px"
    }
})
    })


}
console.log(arraybutton[1])


    // console.log(document.body.clientWidth);
    // console.log(document.body.clientHeight);
    var body=document.querySelector('body');
    var d1=document.querySelector(".d1");
  console.log(d1.offsetHeight);
    var d2=document.querySelector(".d2");
    console.log(d2.clientHeight);

    function bigmove(index, formerindex, callback) {
        ismoving=true;
       var final=index*852;
       var fomer=formerindex*852;
        var step;
       var timer = setInterval(function () {
            if (final - fomer > 0) {
                step= Math.ceil((final - fomer) / 10);
            } else {
                step = Math.floor((final - fomer) / 10);
            }

            if (fomer ===final) {
                clearInterval(timer);
               callback();
            }
            // obj.style.top = obj.offsetHeight + step + 'px';
           fomer+=step;
           window.scrollTo(0,fomer);
        }, 10);
    }

function move(target,callback){
ismoving=true;

    var x=setInterval(function () {
if(i<target&&Math.abs(target-i)>10){
    i+=10;
    window.scrollTo(0,i);
}else if(i>target&&Math.abs(target-i)>10){
    i-=10;
    window.scrollTo(0,i);
}else{
    i=target;
    window.scrollTo(0,i);
    clearInterval(x);
    callback();
}



    }, 3)

}
addEventListener('mousewheel',function (e){
    console.log(window.scrollX);
if(!ismoving){

    if(e.wheelDelta<0&&index<=5){
        formerindex=index;
        index++;
      console.log(formerindex)
    }else if(e.wheelDelta>0&&index>=1){

        formerindex=index;
        index--;
        console.log(formerindex)
    }

    move(index*852,function (){
        ismoving=false;
        if(formerindex===0){
            i1.className="displaynone";
            btn1.style.backgroundPosition=" -239px 0";
        }else if(formerindex===1){
            i3.className="displaynone";
            i4.className="displaynone";
            d5.className="displaynone"
            arrowleft.className="displaynone";
            arrowright.className="displaynone";
            i5.className="displaynone";
            btn2.style.backgroundPosition=" -239px -58px";
        }else if(formerindex===2){
            i6.className="displaynone";
            i7.className="displaynone";
            i8.className="displaynone";
            btn3.style.backgroundPosition=" -239px -137px"
        }else if(formerindex===3){
            i9.className="displaynone";
            i10.className="displaynone";
            i11.className="displaynone";
            i12.className="displaynone";
            btn4.style.backgroundPosition=" -239px -221px"
        }else if(formerindex===4){
            i13.className="displaynone";
            i14.className="displaynone";
            i15.className="displaynone";
            i16.className="displaynone";
            btn5.style.backgroundPosition=" -239px -305px"
        }else if(formerindex===5){
            i17.className="displaynone";
            i18.className="displaynone";
            i19.className="displaynone";
            i20.className="displaynone";
            btn6.style.backgroundPosition=" -239px -387px"
        }else if(formerindex===6){
            i21.className="displaynone";
            i22.className="displaynone";
            i23.className="displaynone";
            btn7.style.backgroundPosition=" -239px -467px"
        }




        if(index===0){
            i1.className="i1 i1animation";
            btn1.style.backgroundPosition=" -1px 0"
        }else if(index===1){

i3.className="i3";
i4.className="i4";
d5.className="d5"
            arrowleft.className="arrowleft";
arrowright.className="arrowright";
i5.className="i5";
// console.log("index===1")
            btn2.style.backgroundPosition=" -1px -58px"
        }else if(index===2){
            i6.className="i6";
            i7.className="i7";
            i8.className="i8";
            btn3.style.backgroundPosition=" -1px -137px"
        }else if(index===3){
            i9.className="i9";
            i10.className="i10";
            i11.className="i11";
            i12.className="i12";
            btn4.style.backgroundPosition=" -1px -221px"
        }else if(index===4){
            i13.className="i13";
            i14.className="i14";
            i15.className="i15";
            i16.className="i16";
            btn5.style.backgroundPosition=" -1px -305px"
        }else if(index===5){
            i17.className="i17";
            i18.className="i18";
            i19.className="i19";
            i20.className="i20";
            btn6.style.backgroundPosition=" -1px -387px"
        }else if(index===6){
            i21.className="i21";
            i22.className="i22";
            i23.className="i23";
            btn7.style.backgroundPosition=" -1px -467px"
        }
    });

}

})
//**************************************

    var array=[];
    for (let i = 0; i < 4; i++) {
        var l=document.querySelector(".l"+(i+1));
        array.push(l);


    }
    function next(){
        var first=array.shift();
        // first.style.transitionDuration="unset"

        // first.style.transform= "perspective(1200px) translate3d(640px, 0, 0px)"

        array.push(first);
        for(var i=0 ;i<array.length;i++){
            // array[i].style.perspective="1200px"
            // array[i].style.transform=" translate3d(0, 0, 0px)"
            array[i].className=l+""+(i+1);
            array[i].style.zIndex=-1;
            array[i].style.transitionDuration="unset"
        }
        // array[0].style.transform= "perspective(1200px) translate3d(640px, 0, 0px)"


        array[0].style.zIndex=1;
        array[0].style.transitionDuration="300ms"
        array[0].style.transform= "perspective(1200px) translate3d(-315px, 0, 0px)"

        array[1].style.zIndex=1;
        array[1].style.transitionDuration="300ms"
        array[1].style.transform= "perspective(1200px) translate3d(-105px, 0, 0px)"
        array[1].style.filter="brightness(70%)"
        array[2].style.zIndex=2;
        array[2].style.transitionDuration="300ms"
        array[2].style.transform= "perspective(1200px) translate3d(105px, 0,100px)"
        array[2].style.filter="brightness(100%)"
        // array[3].style.zIndex=1;
        // array[3].style.transform= "perspective(1200px) translate3d(640px, 0, 0px)"
        //
        //
        // array[3].style.transform= "perspective(1200px) translate3d(384px, 0, 0px)"
        // // array[3].style.transitionDuration="300ms"
        var l=array[3].className;
        array[3].className=l+" lfirst";
        array[3].style.transform= "perspective(1200px) translate3d(315px, 0,0)"
        array[3].style.filter="brightness(70%)"
    }



    function pre(){
        var last=array.pop();
        // first.style.transitionDuration="unset"

        // first.style.transform= "perspective(1200px) translate3d(640px, 0, 0px)"

        array.unshift(last);
        for(var i=0 ;i<array.length;i++){
            // array[i].style.perspective="1200px"
            // array[i].style.transform=" translate3d(0, 0, 0px)"
            array[i].className=l+""+(i+1);
            array[i].style.zIndex=-1;
            array[i].style.transitionDuration="unset"
        }
        // array[0].style.transform= "perspective(1200px) translate3d(640px, 0, 0px)"

        var l=array[0].className;
        array[0].className=l+" llast";
        array[0].style.zIndex=1;
        // array[0].style.transitionDuration="300ms"
        array[0].style.transform= "perspective(1200px) translate3d(-315px, 0, 0px)"

        array[1].style.zIndex=1;
        array[1].style.transitionDuration="300ms"
        array[1].style.transform= "perspective(1200px) translate3d(-105px, 0, 0px)"
        array[1].style.filter="brightness(70%)"
        array[2].style.zIndex=2;
        array[2].style.transitionDuration="300ms"
        array[2].style.transform= "perspective(1200px) translate3d(105px, 0,100px)"
        array[2].style.filter="brightness(100%)"
        // array[3].style.zIndex=1;
        // array[3].style.transform= "perspective(1200px) translate3d(640px, 0, 0px)"
        //
        //
        // array[3].style.transform= "perspective(1200px) translate3d(384px, 0, 0px)"
        // // array[3].style.transitionDuration="300ms"
        array[3].style.transitionDuration="300ms"
        array[3].style.transform= "perspective(1200px) translate3d(315px, 0,0)"
        array[3].style.filter="brightness(70%)"
    }




    var b1=document.querySelector(".arrowleftvac")
    var b2=document.querySelector(".arrowrightvac")
    b1.addEventListener("click",function (){
        pre();

    })
    b2.addEventListener("click",function (){
        next();

    })








}