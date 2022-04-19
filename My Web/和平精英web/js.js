window.addEventListener('load',function (){
    // var d1 = document.getElementsByClassName("d1")[0];
    // d1.style.width = d1.style.width*(window.screen.width/document.body.offsetWidth)+"px";
    var u6=document.querySelector(".u6")

    var u7=document.querySelector(".u7");
    var count=1;
    var is01turn=true;
     var turn01=setInterval(function (){
         if(is01turn){

             if(count===3){

                 for(var j=0;j<u7.children.length;j++){
                     u7.children[j].className="";
                 }
                 u7.children[0].className="pointer";
                 animate(u6,-(3*590),function (){
                     u6.style.left=197+"px";

                 });
                 count=1;
             }else{
                 for(var j=0;j<u7.children.length;j++){
                     u7.children[j].className="";
                 }
                 u7.children[count].className="pointer";
                 animate(u6,-(count*590));
                 count++;
             }

         }



    },5000);
    var u7li=u7.querySelectorAll("li")
    for(var i=0;i<u7li.length;i++){
        u7li[i].num=i;
        u7li[i].addEventListener('click',function (){
            is01turn=false;
            count=this.num+1;
            animate(u6,-(this.num*590),function (){
                is01turn=true
            });
            for(var j=0;j<u7.children.length;j++){
                u7.children[j].className="";
            }
            this.className="pointer";
        });
    }

function animate(obj,target,callback){
       clearInterval(obj.timer);
       obj.timer=setInterval(function (){
           if(obj.offsetLeft===target){

               if(callback){
                   callback();
               }
               clearInterval(obj.timer);

           }
var step=(target-obj.offsetLeft)/10;
step=step>0?Math.ceil(step):Math.floor(step);
obj.style.left=obj.offsetLeft+step+"px";
        },15)

}
var u8=document.querySelector(".u8");
    var l8=document.querySelector(".l8");
    var l8div=document.querySelectorAll(".d12");
for(var i=0;i<u8.children.length-1;i++) {
    u8.children[i].num = i;
    u8.children[i].addEventListener('click', function () {
        var count=this.num;
for(var j=0;j<l8div.length;j++){
    l8div[j].style.display="none";
}
l8div[count].style.display="block";
for(var j=0;j<u8.children.length;j++){
    u8.children[j].className="";
}
u8.children[count].className="botom";
    })

}
var l10s=document.querySelectorAll(".l10");
var u12=document.querySelector(".u12");
var u12lis=u12.querySelectorAll("li");
for(var i=0;i<l10s.length;i++){

    l10s[i].flag=false;

}
    l10s[0].flag=true;

for(var i=0;i<l10s.length;i++){
    l10s[i].num=i;


l10s[i].addEventListener('click',function (){
    for(var j=0;j<l10s.length;j++){
        l10s[j].flag=false;
        l10s[j].className="l10";

    }
    this.flag=true;
    this.className="l10 dot l10botom";

    for(var j=0;j<u12lis.length;j++){
        u12lis[j].style.display="none";
    }
u12lis[this.num].style.display="block";


})

}

var u13=document.querySelector(".u13");
var u13lis=u13.querySelectorAll("li");
var l11lis=document.querySelectorAll(".l11button");
for(var i=0;i<u13lis.length;i++){
    u13lis[i].num=i;
    u13lis[i].addEventListener('click',function (){
        for(var j=0;j<u13lis.length;j++){
            u13lis[j].className="";
        }
        this.className="underline turnboldyellow";
for(var j=0;j<2;j++){
    l11lis[j].style.display="none";
}
l11lis[this.num].style.display="block";


    })




}
var u19=document.querySelector(".u19");
var d27s=document.querySelectorAll(".d27");
for(var i=0;i<4;i++){
    u19.children[i].num=i;
    u19.children[i].addEventListener('click',function (){
        for(var j=0;j<4;j++){
            u19.children[j].className="";
            d27s[j].style.display="none";
        }

        u19.children[this.num].className="u19click";
d27s[this.num].style.display="block";

    })




}
var l13s=document.querySelectorAll(".l13");
var u22s=document.querySelectorAll(".u22");
for(var i=0;i<l13s.length;i++){
    l13s[i].num=i;
    l13s[i].addEventListener('click',function (){
        for(var j=0;j<3;j++){
            u22s[j].style.display="none";
        }
        for(var j=0;j<3;j++){
            l13s[j].className="l13";
        }
        u22s[this.num].style.display="block";
       this.className="l13 l13click";

    });



}
 function photomove(obj,target,position,callback){

     clearInterval(obj.timer);

     obj.timer=setInterval(function (){

         if(obj.offsetLeft<=target&&position===-1){

             if(callback){
                 callback();
             }
             clearInterval(obj.timer);
             console.log(target)
         }else if(obj.offsetLeft>=target&&position===1){

             if(callback){
                 callback();
             }
             clearInterval(obj.timer);
             console.log(target)
         }

         // if(Math.abs(target-obj.offsetLeft)>10){
             obj.style.left=obj.offsetLeft+position*10+"px";
         // }else{
         //     obj.style.left=target;
         // }
         // var step=(target-obj.offsetLeft)/10;
         // step=step>0?Math.ceil(step):Math.floor(step);
         // obj.style.left=obj.offsetLeft+step+"px";

     },3);



    }
var u24=document.querySelector(".u24");
var d35=document.querySelector(".d35");
var d36=document.querySelector(".d36");
var move=1;
var isd36automove=true;
d35.addEventListener('click',function (){
if(isd36automove){
    isd36automove=false;
    if(move===1){
        move--;
        photomove(u24,-(move*1200),1,function (){
            move=6;
            u24.style.left=-1200*6+"px";
            isd36automove=true;
        });
    }else{
        move--;
        photomove(u24,-(move*1200),1,function (){
            isd36automove=true;
        });
    }
}

})

    d36.addEventListener('click',function (){
if(isd36automove){
    isd36automove=false;
    if(move===6){
        move++;
        photomove(u24,-(move*1200),-1,function (){
            move=1;
            u24.style.left=-1200+"px";
            isd36automove=true;
        });
    }else{
        move++;
        photomove(u24,-(move*1200),-1,function (){
            isd36automove=true;
        });
    }
}


    })

 var d36auto=setInterval(function (){
     if(isd36automove){
         d36.click();
     }

},4000);


var u25=document.querySelector(".u25");
var u25lis=u25.querySelectorAll("li");

for(var i=0;i<u25lis.length;i++){
    u25lis[i].num=i;
    u25lis[i].addEventListener('mouseenter',function (){
this.children[0].children[0].src="img/yellow1"+(this.num+1)+".png";


    })
u25lis[i].addEventListener('mouseleave',function (){
    this.children[0].children[0].src="img/normal1"+(this.num+1)+".png";



})


}
// ***************
    var u2502=document.querySelector(".u2502");
    var u2502lis=u2502.querySelectorAll("li");

    for(var i=0;i<u2502lis.length;i++){
        u2502lis[i].num=i;
        u2502lis[i].addEventListener('mouseenter',function (){
            this.children[0].children[0].src="img/yellow2"+(this.num+1)+".png";


        })
        u2502lis[i].addEventListener('mouseleave',function (){
            this.children[0].children[0].src="img/normal2"+(this.num+1)+".png";



        })


    }
    var change=1;
    var d44=document.querySelector(".d44");
var d46=document.querySelector(".d46");
    var d47=document.querySelector(".d47");
    d46.addEventListener('click',function (){
        d44.style.display="none";
        d47.style.display="block";
change=2;
    })

    d47.addEventListener('click',function (){
        d44.style.display="block";
        d47.style.display="none";
change=1;
    })
    addEventListener('mousewheel',function (){
        if(document.documentElement.scrollTop>500&& change===1){
            d44.style.display="block";

        }else if(document.documentElement.scrollTop>500&& change===2){
            d47.style.display="block";
        }else if(document.documentElement.scrollTop<=500){
            d44.style.display="none";
            d47.style.display="none";
        }


    })
})