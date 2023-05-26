var odiv=document.getElementById("div");
var ocar=document.getElementsByTagName("a");
var osp=document.getElementById("span");
var newDiv1=document.createElement('div');
var oa1=document.getElementById("a1");
var oa2=document.getElementById("a2");
var onews_left=document.getElementById("news_left");
var oimg1=document.getElementById("img1");
var oimg2=document.getElementById("img2");
var oimg3=document.getElementById("img3");
var oimg4=document.getElementById("img4");
var oimg5=document.getElementById("img5");
var oimg6=document.getElementById("img6");
var oimg7=document.getElementById("img7");
var oimg8=document.getElementById("img8");
//鼠标触摸艺术品显示信息
oimg1.onmouseover=function()
{
    oimg1.src="/asserts/image/center_11.png"
}
oimg1.onmouseout=function()
{
    oimg1.src="/asserts/image/center_1.jpg"
}

oimg2.onmouseover=function()
{
    oimg2.src="/asserts/image/center_22.png"
}
oimg2.onmouseout=function()
{
    oimg2.src="/asserts/image/center_2.jpg"
}

oimg3.onmouseover=function()
{
    oimg3.src="/asserts/image/center_33.png"
}
oimg3.onmouseout=function()
{
    oimg3.src="/asserts/image/center_3.jpg"
}

oimg4.onmouseover=function()
{
    oimg4.src="/asserts/image/center_44.png"
}
oimg4.onmouseout=function()
{
    oimg4.src="/asserts/image/center_4.jpg"
}

oimg5.onmouseover=function()
{
    oimg5.src="/asserts/image/center_55.png"
}

oimg5.onmouseout=function()
{
    oimg5.src="/asserts/image/center_5.jpg"
}

oimg6.onmouseover=function()
{
    oimg6.src="/asserts/image/center_66.png"
}
oimg6.onmouseout=function()
{
    oimg6.src="/asserts/image/center_6.jpg"
}

oimg7.onmouseover=function()
{
    oimg7.src="/asserts/image/center_77.png"
}
oimg7.onmouseout=function()
{
    oimg7.src="/asserts/image/center_7.jpg"
}

oimg8.onmouseover=function()
{
    oimg8.src="/asserts/image/center_88.png"
}
oimg8.onmouseout=function()
{
    oimg8.src="/asserts/image/center_8.jpg"
}
//右边艺术品的展示
var new_x=0;
function shownews()
{
    var s1=onews_left.children[new_x].children[0].innerHTML;//获取标题
    onews_left.children[new_x%4].style.border="3px solid pink";
    onews_left.children[(new_x+1)%4].style.border="";
    onews_left.children[(new_x+2)%4].style.border="";
    onews_left.children[(new_x+3)%4].style.border="";
    new_x++;
    if(new_x==4)
    {
        new_x=0;
    }
}
news_t=setInterval(shownews, 1000);
onews_left.onmouseover=function()
{
    clearInterval(news_t);
}
onews_left.onmouseout=function()
{
    news_t=setInterval(shownews, 3000);
}
onews_left.children[0].onclick=function()
{
    onews_right.children[0].innerHTML=onews_left.children[0].children[0].innerHTML;
    onews_right.children[1].innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+news_txt[0];
    onews_left.children[0].style.border="3px solid pink";
    onews_left.children[1].style.border="";
    onews_left.children[2].style.border="";
    onews_left.children[3].style.border="";
    new_x=0;
}
onews_left.children[1].onclick=function()
{
    onews_right.children[0].innerHTML=onews_left.children[1].children[0].innerHTML;
    onews_right.children[1].innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+news_txt[1];
    onews_left.children[1].style.border="3px solid pink";
    onews_left.children[0].style.border="";
    onews_left.children[2].style.border="";
    onews_left.children[3].style.border="";
    new_x=1;
}
onews_left.children[2].onclick=function()
{
    onews_right.children[0].innerHTML=onews_left.children[2].children[0].innerHTML;
    onews_right.children[1].innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+news_txt[2];
    onews_left.children[2].style.border="3px solid pink";
    onews_left.children[1].style.border="";
    onews_left.children[0].style.border="";
    onews_left.children[3].style.border="";
    new_x=2;
}
onews_left.children[3].onclick=function()
{
    onews_right.children[0].innerHTML=onews_left.children[3].children[0].innerHTML;
    onews_right.children[1].innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+news_txt[3];
    onews_left.children[3].style.border="3px solid pink";
    onews_left.children[1].style.border="";
    onews_left.children[2].style.border="";
    onews_left.children[0].style.border="";
    new_x=3;
}
//导航栏标签
oa1.onmouseover=function(){
    oa1.style.color="#FF0099";
}
oa2.onmouseover=function()
{
    oa2.style.color="#FF0099";
}
oa1.onmouseout=function(){
    oa1.style.color="white";
}
oa2.onmouseout=function(){
    oa2.style.color="white";
}
//中间广告

document.body.appendChild(newDiv1);
newDiv1.setAttribute("style","width:991px;height:468px;background:url(/asserts/image/mount.jpg);position:absolute;")
window.onload=window.onscroll=window.onresize=function()
{
    var t=document.body.scrollTop||document.documentElement.scrollTop;
    var l=document.body.scrollLeft||document.documentElement.scrollLeft ;
    newDiv1.style.top=parseInt((document.documentElement.clientHeight-newDiv1.offsetHeight)/2)+t+"px";
    newDiv1.style.left=parseInt((document.documentElement.clientWidth-newDiv1.offsetWidth)/2)+l+"px";
}
//中间广告的去除
newDiv1.onclick=function()
{
    newDiv1.style.display="none";
}
//商品的滑动
var imgs=["1.jpg","2.jpg","3.jpg","4.jpg","5.jpg"];
var i=0;
var t=null;
odiv.onmouseover=function()
{
    clearInterval(t);
}

odiv.onmouseout=function()
{
    t=setInterval(change, 1000);

}
function change()
{

    odiv.style.background='url("/asserts/image/'+imgs[i%imgs.length]+'")';
    i++;
}
