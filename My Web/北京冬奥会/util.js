//计算两个时间之间的时间差 多少天时分秒
// function intervalTime(startTime,endTime) {
//     // var timestamp=new Date().getTime(); //计算当前时间戳
//     var timestamp = (Date.parse(new Date()))/1000;//计算当前时间戳 (毫秒级)
//     var date1 = ""; //开始时间
//     if(timestamp<startTime){
//         date1=startTime;
//     }else{
//         date1 = timestamp; //开始时间
//     }
//     var date2 = endTime; //结束时间
//     // var date3 = date2.getTime() - date1.getTime(); //时间差的毫秒数
//     var date3 =  (date2- date1)*1000; //时间差的毫秒数
//     //计算出相差天数
//     var days = Math.floor(date3 / (24 * 3600 * 1000));
//     //计算出小时数
//
//     var leave1 = date3 % (24 * 3600 * 1000); //计算天数后剩余的毫秒数
//     var hours = Math.floor(leave1 / (3600 * 1000));
//     //计算相差分钟数
//     var leave2 = leave1 % (3600 * 1000); //计算小时数后剩余的毫秒数
//     var minutes = Math.floor(leave2 / (60 * 1000));
//
//     //计算相差秒数
//
//     var leave3 = leave2 % (60 * 1000); //计算分钟数后剩余的毫秒数
//     var seconds = Math.round(leave3 / 1000);
//     console.log(days + "天 " + hours + "小时 ")
//     return   days + "天 " + hours + "小时 " + minutes + " 分钟" + seconds + " 秒"
//     // return   days + "天 " + hours + "小时 "
// }

function getTargetTime(t){
    var d = t.split(" ")[0],
        h = t.split(" ")[1],
        date = new Date()

    date.setYear(d.split("-")[0])
    date.setMonth(d.split("-")[1] - 1)
    date.setDate(d.split("-")[2])

    date.setHours(h.split(":")[0])
    date.setMinutes(h.split(":")[1])
    date.setSeconds(h.split(":")[2])

    return date.getTime()
}
function intervalTime(inter){
   var array=[];
    var rest;
    array.push(Math.floor(inter/(1000*60*60*24)));
   console.log("days"+array[0]);
    rest=inter%(1000*60*60*24);
    array.push(Math.floor(rest/(1000*60*60)))
    console.log("honr"+array[1])
    rest=rest%(1000*60*60);
    array.push(Math.floor(rest/(1000*60)))
    console.log("minites"+array[2])
    rest=rest%(1000*60);

    array.push(Math.floor(rest/(1000)))
    console.log("seconds"+array[3])
return array;

}
