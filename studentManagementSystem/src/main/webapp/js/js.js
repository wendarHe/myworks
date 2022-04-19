window.onload=function (){


var changeWindow=document.querySelector(".changeWindow");
var funA=document.querySelector(".funA");
var DID=document.querySelector("#DID");
 var Dname=document.querySelector("#Dname");

 var Dsex=document.querySelector("#Dsex");
 var DworkName=document.querySelector("#DworkName");
 var Dscore=document.querySelector("#Dscore");
 var db1=document.querySelector(".db1");
 var img1=document.querySelector(".img1");


 var Aname=document.querySelector("#Aname");

 var Asex=document.querySelector("#Asex");
 var AworkName=document.querySelector("#AworkName");
 var Ascore=document.querySelector("#Ascore");
 var addBtn=document.querySelector(".addBtn");
 var img2=document.querySelector(".img2");
 img1.addEventListener("click",function (){
  changeWindow.style.display="none";


 })


 var changeBtns=document.querySelectorAll(".changeBtn");
 for (var i = 0; i < changeBtns.length; i++) {
  changeBtns[i].num=i;
  changeBtns[i].addEventListener("click",function (){

   DID.value=changeBtns[this.num].parentElement.parentElement.children[0].innerHTML;
   Dname.value=changeBtns[this.num].parentElement.parentElement.children[1].innerHTML;
   Dsex.value=changeBtns[this.num].parentElement.parentElement.children[2].innerHTML;
   DworkName.value=changeBtns[this.num].parentElement.parentElement.children[3].innerHTML;
   Dscore.value=changeBtns[this.num].parentElement.parentElement.children[4].innerHTML;
   changeWindow.style.display="block";

  })
 }
 db1.addEventListener("click",function (){

  changeInformation();
 })
function changeBtn(){


}

function changeInformation(){
 funA.href="/studentManagementSystem/items/edit?id="+DID.value+"&name="+Dname.value+"&sex="+Dsex.value+"&workName="+DworkName.value+"&score="+Dscore.value;
funA.click();
}

 // ****************
 var addWindow=document.querySelector(".addWindow")
 var add=document.querySelector(".add")
 add.addEventListener("click",function () {
  addWindow.style.display="block";
 })
function addInformation(){

 funA.href="/studentManagementSystem/items/add?"+"&name="+Aname.value+"&sex="+Asex.value+"&workName="+AworkName.value+"&score="+Ascore.value;
 funA.click();
 addWindow.style.display="none";
 console.log("11111111111")




}
 img2.addEventListener("click",function (){
  addWindow.style.display="none";
 })
 addBtn.addEventListener("click",function () {
  addInformation();
 })

 // ***************
 var searchInformation=document.querySelector(".searchInformation");
 var searchBtn=document.querySelector(".searchBtn");
 searchBtn.addEventListener("click",function (){
  funA.href="/studentManagementSystem/items/search?keyWords="+searchInformation.value;
funA.click();
  searchBtn.value="";
 })




}