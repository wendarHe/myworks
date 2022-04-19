window.onload=function (){
    var d1=document.querySelector(".d1");

    setInterval(function (){
        var scrollTop;
         scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
        //var scrollTop=document.documentElement.scrollTop;
d1.style.top="-"+scrollTop+"px";
        // console.log(scrollTop)

    },50);
// window.onscroll=function (){
//
//     var scrollTop;
//     scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
//     var scrollTop=document.documentElement.scrollTop;
//     d1.style.top="-"+scrollTop+"px";
// }
    // https://blog.csdn.net/qq_40020447/article/details/107835026

var index=0;
    var lunbotu;
    var isChanging=false;
var u2=document.querySelector(".u2");
    var u3=document.querySelector(".u3");
    for (let i = 0; i < u3.children.length; i++) {
        u3.children[i].num=i;
        u3.children[i].addEventListener("click",function (){
            if(!isChanging){
                isChanging=!isChanging;
                clearInterval(lunbotu);

                setTimeout(function (){
                    activite();
isChanging=!isChanging;

                },400);
            }


            for (let j = 0; j < u3.children.length; j++) {
                if(j!==this.num){
                    u3.children[j].className="";

                }else{
                    u3.children[j].className="pointer";
                }
            }

            u2.style.transform="translateX(-"+1240*this.num+"px)"
           // index++;
           //  if(index===u3.children.length){
           //      index=0;
           //  }
            index=this.num;
        })

    }

    function activite(){

         lunbotu=setInterval(function (){

            index++;
            if(index===u3.children.length){
                index=0;
            }
            u3.children[index].click();

        },5000);
    }

   activite();
    function animate(obj,target,callback){
        clearInterval(obj.timer);
        obj.timer=setInterval(function (){
            if(obj.offsetLeft===target){

                if(callback){
                    callback();
                }
                clearInterval(obj.timer);

            }
            let step = (target - obj.offsetLeft) / 10;
            step=step>0?Math.ceil(step):Math.floor(step);
            obj.style.left=obj.offsetLeft+step+"px";
        },15)

    }

    var starttime=new Date().getTime();
    console.log(typeof starttime)
   // console.log(timestamp);
var targetTIme=getTargetTime("2022-02-04 20:00:00");
    console.log(typeof targetTIme)
// console.log(starttime);
// console.log(targetTIme);
var inter=targetTIme-starttime;
console.log(inter);
    //5052411000

var interval=intervalTime(inter);
// console.log("shijian"+interval);
console.log("interval[0]"+interval[0]);
    console.log(interval[1]);
    console.log(interval[2]);
    console.log(interval[3]);
// *************************
    var day=interval[0];
    var hour=interval[1]
    var minute=interval[2]
    var second=interval[3]

var dayTag=document.querySelector(".days");
var hourTag=document.querySelector(".hour")
    var minutesTag=document.querySelector(".minutes")
    var secondsTag=document.querySelector(".seconds")
//     dayTag.innerHTML=day;
// hourTag.innerHTML=hour;
// minutesTag.innerHTML=minute;
// secondsTag.innerHTML=second;
    if(day<10){
        dayTag.innerHTML="0"+day;
    }else{
        dayTag.innerHTML=day;
    }
    if(hour<10){
        hourTag.innerHTML="0"+hour;
    }else{
        hourTag.innerHTML=hour;
    }
    if(minute<10){
        minutesTag.innerHTML="0"+minute;
    }else{
        minutesTag.innerHTML=minute;
    }
    if(second<10){
        secondsTag.innerHTML="0"+second;
    }else{
        secondsTag.innerHTML=second;
    }

 setInterval(function (){    //做时间倒数的计时器
     second--;
     if(second===-1){
         second=59
         minute--;
     }
     if(minute===-1){
         minute=59
         hour--;
     }
     if(hour===-1){
         hour=59;
         day--
     }
if(day<10){
    dayTag.innerHTML="0"+day;
}else{
    dayTag.innerHTML=day;
}
     if(hour<10){
         hourTag.innerHTML="0"+hour;
     }else{
         hourTag.innerHTML=hour;
     }
     if(minute<10){
         minutesTag.innerHTML="0"+minute;
     }else{
         minutesTag.innerHTML=minute;
     }
     if(second<10){
         secondsTag.innerHTML="0"+second;
     }else{
         secondsTag.innerHTML=second;
     }





 },1000)
    // ************************
    var firstTurn=document.querySelectorAll(".firstTurn");
    var secongTurn=document.querySelectorAll(".secondTurn");
    var thirdTurn=document.querySelectorAll(".thirdTurn");
    var isFront=true;
    setInterval(function (){
        if(isFront){
            firstTur();
            setTimeout(function (){
                secondTur();
            },600)
            setTimeout(function (){
                thirdTur();
            },1400)

        }else{
            removefirstTur()
            setTimeout(function (){
                removesecondTur()
            },600)
            setTimeout(function (){
               removethirdTur()
            },1400)
        }

isFront=!isFront;

    },8000)
    function firstTur(){
        for (var i = 0; i < firstTurn.length; i++) {
            firstTurn[i].classList.add("turn");
        }
    }
    function removefirstTur(){
        for (var i = 0; i < firstTurn.length; i++) {
            firstTurn[i].classList.remove("turn");
        }
    }

    function secondTur(){
        for (var i = 0; i < secongTurn.length; i++) {
            secongTurn[i].classList.add("turn");
        }
    }
    function removesecondTur(){
        for (var i = 0; i < secongTurn.length; i++) {
            secongTurn[i].classList.remove("turn");
        }
    }

    function thirdTur(){
        for (var i = 0; i < thirdTurn.length; i++) {
           thirdTurn[i].classList.add("turn");
        }
    }
    function removethirdTur(){
        for (var i = 0; i < thirdTurn.length; i++) {
            thirdTurn[i].classList.remove("turn");
        }
    }
// *******************
    var imgturn;
var imgArray=[];
    var imgSrc=[];
    var index2=3;
    var iscanclick=true;
    for (var k = 0; k < 17; k++) {
        if(k===2||k===6||k===7||k===10||k===13){
            var src="img/6"+(1+k)+".png";
        }else{
            var src="img/6"+(1+k)+".jpg";
        }

        imgSrc.push(src);

    }
    var l1=document.querySelector(".l1");
    var l2=document.querySelector(".l2");
    var l3=document.querySelector(".l3");
    imgArray.push(l1);
    imgArray.push(l2);
    imgArray.push(l3);
    var buttonLeft=document.querySelector(".i1")
    var buttonRight=document.querySelector(".i2")

    buttonRight.addEventListener("click",function (){

        if(iscanclick){

            clearInterval(imgturn);
            imgArray[0].children[0].src=imgSrc[index2];
            index2++;
            if(index2===imgSrc.length){
                index2=0;
            }

            var fir=imgArray.shift();
            imgArray.push(fir);

            // imgArray[0].className="l1 imgTransition";
            // imgArray[1].className="l2 imgTransition";
            // imgArray[2].className="l3 imgTransition";
            imgArray[0].style.cssText="left: -400px;z-index: 0;filter: brightness(0.7); ";
            imgArray[1].style.cssText="transform: scale(1.6);left: 0;z-index: 2";
            imgArray[2].style.cssText="left: 400px;filter: brightness(0.7);";
            imgturn=setInterval(function (){
                buttonRight.click();
            },4500)

            iscanclick=false;
            setTimeout(function (){
                iscanclick=true
            },500)

        }


    })
    buttonLeft.addEventListener("click",function (){
        if(iscanclick){



            clearInterval(imgturn)
            imgArray[2].children[0].src=imgSrc[index2];
            index2++;
            if(index2===imgSrc.length){
                index2=0;
            }

            var last=imgArray.pop();
            imgArray.unshift(last);

            // imgArray[0].className="l1 imgTransition";
            // imgArray[1].className="l2 imgTransition";
            // imgArray[2].className="l3 imgTransition";
            imgArray[0].style.cssText="left: -400px;filter: brightness(0.7) ";
            imgArray[1].style.cssText="transform: scale(1.6);left: 0;z-index: 2";
            imgArray[2].style.cssText="left: 400px;z-index: 0;filter: brightness(0.7)";
            imgturn=setInterval(function (){
                buttonRight.click();
            },4500)


            iscanclick=false;
            setTimeout(function (){
                iscanclick=true
            },500)




        }




    })

 imgturn=setInterval(function (){
    buttonRight.click();
},4500)
// ******************************
var count=0;
    var isfir=true;
    var d4001=document.querySelector(".d4001");
    var d4002=document.querySelector(".d4002");

    var img8=document.querySelector(".img8")
    var img9=document.querySelector(".img9")

    var img10=document.querySelector(".img10")
    var img11=document.querySelector(".img11")

    setInterval(function (){
        if(count===0&&isfir){
            // d4001.style.cssText="top:-360px";
            img8.style.cssText="opacity:1";
            img9.style.cssText="opacity:1";
        }else if(count===3&&isfir){
            // img8.style.cssText="opacity:1";
            // img9.style.cssText="opacity:1";
            img8.style.cssText="opacity:0";
            img9.style.cssText="opacity:0";
        }else if(count===4&&isfir){
            // img8.style.cssText="opacity:0";
            // img9.style.cssText="opacity:0";
            d4001.style.cssText="top:-160px;";
            d4002.style.cssText="top:-360px";
        }else if(count===7&&isfir){
            // d4001.style.cssText="";
            // d4002.style.cssText="top:-360px";
        }else if(count===0&&!isfir){
            img10.style.cssText="opacity:1";
            img11.style.cssText="opacity:1";
        }else if(count===3&&!isfir){
            img10.style.cssText="opacity:0";
            img11.style.cssText="opacity:0";
        }else if(count===4&&!isfir){
            d4002.style.cssText="";
            d4001.style.cssText="top:-360px";
        }else if(count===7&&!isfir){

        }
        count++;
if(count===5){
    count=0
    isfir=!isfir
}

    },1000)

    // *************************
    var deg=0;
    var isthisSide=true;
    var pointer=document.querySelectorAll(".m");
var index3=1;
    var title=["云顶滑雪公园","国家冬季两项中心","国家跳台滑雪中心","国家越野滑雪中心","国家高山滑雪中心","国家雪车雪橇中心","国家速滑馆","国家体育馆","国家游泳中心","国家体育场","首都体育馆","五棵松体育中心","首钢滑雪大跳台"];
    var musumeImgSrc=[];
    for (var l = 0; l < 13; l++) {
        musumeImgSrc[l]="img/7"+(l+1)+".jpg";

    }
    var introduce=["云顶滑雪公园包括U型场地技巧、坡面障碍技巧、雪上技巧、空中技巧、障碍追逐、平行大回转六条赛道，共计产生20块金牌。张家口山地媒体中心位于场馆群内，由云顶大酒店改建而成。云顶滑雪公园不仅是自由式滑雪及单板滑雪国家队的训练基地，也为大众冰雪运动提供了优质场地。","国家冬季两项中心位于张家口市崇礼区太子城区域东北侧山谷，依次布置靶场、赛道与起终点区、场馆技术楼等。国家冬季两项中心将承担北京冬奥会冬季两项以及冬残奥会冬季两项的比赛。","国家跳台滑雪中心将承担北京冬奥会跳台滑雪、北欧两项的比赛。国家跳台滑雪中心是我国首座符合国际标准的跳台滑雪场地，也是张家口赛区冬奥会场馆群建设中工程量最大、技术难度最高的竞赛场馆。跳台剖面因与中国传统吉祥饰物“如意”的S形曲线契合，因此被形象地称为“雪如意”。","国家越野滑雪中心将承担北京冬奥会越野滑雪和北欧两项的比赛。越野滑雪是冬季项目中的马拉松，赛道路线长、运动员比赛时间长，是典型的耐力项目。","高山滑雪被誉为“冬奥会皇冠上的明珠”。国家高山滑雪中心设7条雪道，雪道坡度大、落差大，建设难度极高，主要承担高山滑雪赛事。同时国家高山滑雪中心还包括山顶出发区、中间平台、竞技结束区、集散广场、索道等配套设施，最多同时容纳8000人观赛。","国家雪车雪橇中心是北京冬奥会雪车、雪橇、钢架雪车项目比赛场地。场馆共有16个角度、坡度不同的弯道，2020年10月赛道制冰完成后，迎来国家队入驻训练，成为北京冬奥会首个国家队入驻训练的竞赛场馆。","国家速滑馆又称“冰丝带”，是本届赛事唯一新建冰上竞赛场馆，与“鸟巢”、“水立方”共同组成“双奥”之城的标志性建筑群。“冰丝带”是冬奥历史上第一个使用二氧化碳作为制冷剂的速滑场馆，将承担速度滑冰项目的比赛，产生14块金牌，是冬奥会产生金牌数量最多的单个场馆。","国家体育馆作为北京2008年奥运会及残奥会的竞赛场馆之一，曾经举办体操、蹦床等项目。改造后将举办北京2022年冬奥会男子冰球和女子冰球部分比赛、冬残奥会残疾人冰球比赛。场馆赛后除开展冰球运动外，还可以开展花样滑冰、短道速滑等项目，还具有开展夏季运动的多功能转换能力。","“双奥场馆”国家游泳中心在2019年首次通过“水冰转换”制出4条冬奥标准的冰壶赛道。“水冰转换”让国家游泳中心可以在“水上功能”和“冰上功能“之间自由切换，可以同时具备开展水上运动、冰上运动，及各类大型活动的能力。场馆泳池正常向公众开放。","国家体育场位于北京奥林匹克公园中心区南部，为2008年北京奥运会的主体育场，占地20.4公顷，建筑面积25.8万平方米，可容纳观众9.1万人。根据规划，国家体育场成为北京冬奥会开、闭幕式的场馆。","1968年建成，国内第一座人工室内冰场，曾举办2008年北京奥运会排球比赛。2022年北京冬奥会期间将承担短道速滑和花样滑冰比赛任务，产生14枚金牌。这是北京冬奥会第一项完工的改扩建竞赛场馆工程：外观“修旧如旧”，延续经典；场馆内着力打造“最美的冰”，营造更好观赛体验。","五棵松体育中心可在6小时内实现冰球、篮球两种比赛模式的转换，是国内首个在一块比赛场地同时举办篮球、冰球两种职业体育赛事的场馆。按超低能耗建筑标准设计建造的五棵松冰上运动中心在北京冬奥会期间将作为冰球训练馆使用，其特殊设计的多彩外幕墙体系，让场馆得名“冰菱花”。","首钢滑雪大跳台将在北京冬奥会期间承担单板和自由式滑雪大跳台比赛项目，设计理念源自中国敦煌壁画中传统的飞天造型，从侧面看去又犹如一只灵动的“水晶鞋”。赛道结束区未来还可举办演唱会、发布会等大型户外活动。"];

    var title1=document.querySelector(".title1")
    var museumImg1=document.querySelector(".museumImg1")
    var introduce1=document.querySelector(".introduce1")

    var title2=document.querySelector(".title2")
    var museumImg2=document.querySelector(".museumImg2")
    var introduce2=document.querySelector(".introduce2")
    var d45=document.querySelector(".d45")
var card1=document.querySelector(".card1")
    var card2=document.querySelector(".card2")

    for (var a = 0; a < pointer.length; a++) {
        pointer[a].num=a;
        pointer[a].addEventListener("click",function (){
            if(isthisSide){
deg+=180;
title1.innerHTML=title[this.num];
                museumImg1.src=musumeImgSrc[this.num]
                introduce1.innerHTML=introduce[this.num]
                d45.style.cssText=" transform: rotateY("+deg+"deg)"
// card1.style.zIndex="2";
// card2.style.zIndex="1";
            }else{
                deg+=180;
                title2.innerHTML=title[this.num];
                museumImg2.src=musumeImgSrc[this.num]
                introduce2.innerHTML=introduce[this.num]
                d45.style.cssText=" transform: rotateY("+deg+"deg)"
                // card1.style.zIndex="1";
                // card2.style.zIndex="2";
            }
isthisSide=!isthisSide


            for (var z = 0; z < pointer.length; z++) {

                if(z!==this.num){
                    pointer[z].classList.remove("location")
                }else{
                    pointer[z].classList.add("location")
                }
            }

        })



    }
    // ***********************
    var videoSrc=[];
    var videoLists=document.querySelectorAll(".video");
    var videoPlayer=document.querySelector(".d56")
    var closeButton=document.querySelectorAll(".close")

    for (var i = 1; i <=4; i++) {
        videoSrc[i-1]="video/v"+i+".mp4";

    }
    for (var s = 0; s < videoLists.length; s++) {
        videoLists[s].num=s;
        videoLists[s].addEventListener("click",function (){
            videoPlayer.children[0].src=videoSrc[this.num];
            videoPlayer.style.cssText="z-index: 2;opacity: 1;"
        })
    }
closeButton[1].addEventListener("click",function (){
    videoPlayer.style.cssText="z-index: -1;opacity: 0;"
    videoPlayer.children[0].src="";

})
    // *********************
    var videoSrc2=[];
    var videoLists2=document.querySelectorAll(".video2");
    var videoPlayer2=document.querySelector(".d57");
    var closeButton2=document.querySelectorAll(".close")

    for (var i = 5; i <=6; i++) {
        videoSrc2[i-5]="video/v"+i+".mp4";

    }
    for (var s = 0; s < videoLists2.length; s++) {
        videoLists2[s].num=s;
        videoLists2[s].addEventListener("click",function (){
            videoPlayer2.children[0].src=videoSrc2[this.num];
            videoPlayer2.style.cssText="z-index: 2;opacity: 1;"
        })
    }
    closeButton[0].addEventListener("click",function (){
        videoPlayer2.style.cssText="z-index: -1;opacity: 0;"
        videoPlayer2.children[0].src="";
    })
}