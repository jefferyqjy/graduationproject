lastScrollY=0;
function heartBeat(){ 
var diffY;
if (document.documentElement && document.documentElement.scrollTop)
    diffY = document.documentElement.scrollTop;
else if (document.body)
    diffY = document.body.scrollTop
else
    {/*Netscape stuff*/}
    
//alert(diffY);
percent=.1*(diffY-lastScrollY); 
if(percent>0)percent=Math.ceil(percent); 
else percent=Math.floor(percent); 
document.getElementById("lovexin12").style.top=parseInt(document.getElementById("lovexin12").style.top)+percent+"px";

lastScrollY=lastScrollY+percent; 
//alert(lastScrollY);
}
suspendcode12="<DIV id=\"lovexin12\" style='RIGHT:-5px;POSITION:absolute;TOP:250px;z-index:80'>";
var recontent='<table align="left" style="margin-right:10px;width:60px" border="0" cellpadding=0 cellspacing=0 height="32">' + 
'<tr>' + 
'<td style="padding:0;font-size:13px" height="32" ><table style="width:40px" border="0" cellspacing="0" cellpadding="0" height="1">' + 
'<tr>' + 
'<td style="padding:0;font-size:13px; background:none" height="20"><img src="QQimages/qq1.gif"  border="0" usemap="#MapMapMap"></td>' + 
'</tr>' + 
'<tr>' + 
'<td style="padding:0;font-size:13px;padding-left:1px" background="QQimages/qq2.gif" height="19">' + 
'<table style="width:80px"  border="0" align="center" cellpadding="0" cellspacing="0" height="1">' + 
'<tr>' + 
'<td style="padding:0;background:#FFFFFF;font-size:13px" height="3"></td>' + 
'</tr>' + 
'<tr>' + 
'<td style="padding:0;background:#FFFFFF;font-size:13px" height="35">' + 
'<table  border="0" align="left" cellpadding="0" cellspacing="0" style="width:80px">' + 
'<!--begin-->' + 
'<tr>' + 
'<td style="padding: 0 0 3px 0;" align="right" width="20"><img src="QQimages/qq4_2.gif"></td>' + 
'<td style="background-color: bgcolor; background-repeat: repeat; background-attachment: scroll; padding: 0; background-position: 0%" height="24" align="left">' + 
'&nbsp;<a style="text-decoration:none;" href="tencent://message/?uin=57510459&Site=www.lw328.cn&Menu=yes"><span style="text-decoration:none;font-family:宋体;font-size:12;color:#000000;text-align:left">客服咨询</span>' + 
'</td>' + 
'</tr>' + 
'<tr>' + 
'<td style="padding: 0 0 3px 0;" align="right" width="20"><img src="QQimages/qq4.gif"></td>' + 
'<td style="background-color: bgcolor; background-repeat: repeat; background-attachment: scroll; padding: 0; background-position: 0%" height="24" align="left">' + 
'&nbsp;<a style="text-decoration:none;" href="tencent://message/?uin=32038541&Site=www.lw328.cn&Menu=yes"><span style="text-decoration:none;font-family:宋体;font-size:12;color:#000000;text-align:left">技术支持</span>' + 
'</td>' + 
'</tr>' + 
'<tr>' + 
'<td style="padding: 0 0 3px 0;" align="right" width="20"><img src="QQimages/qq4.gif"></td>' + 
'<td style="background-color: bgcolor; background-repeat: repeat; background-attachment: scroll; padding: 0; background-position: 0%" height="24" align="left">' + 
'&nbsp;<a style="text-decoration:none;" href="tencent://message/?uin=417628438&Site=www.lw328.cn&Menu=yes"><span style="text-decoration:none;font-family:宋体;font-size:12;color:#000000;text-align:left">技术支持</span>' + 
'</td>' + 
'</tr>' + 
'<tr>' + 
'<td style="padding: 0 0 3px 0;" align="right" width="20"><img src="QQimages/qq4_1.gif"></td>' + 
'<td style="background-color: bgcolor; background-repeat: repeat; background-attachment: scroll; padding: 0; background-position: 0%" height="24" align="left">' + 
'&nbsp;<a style="text-decoration:none;" href="tencent://message/?uin=57510459&Site=www.lw328.cn&Menu=yes" target="blank"><span style="text-decoration:none;font-family:宋体;font-size:12;color:#000000;text-align:left">站长在线</span>' + 
'</td>' + 
'</tr>' + 
'<!--end-->' + 
'</table></td>' + 
'</tr>' + 
'</table></td>' + 
'</tr>' + 
'<tr>' + 
'<td style="padding:0;font-size:13px" height="1"><img src="QQimages/qq5.gif"></td>' + 
'</tr>' + 
'</table>' + 
'</td>' + 
'</tr>' + 
'</table>' + 
'<map name="MapMapMap" onclick="far_close()" style="cursor:handle">' + 
'<area shape="rect" coords="71,8,82,30" href="#">' + 
'</map>';

document.write(suspendcode12); 
document.write(recontent); 
document.write("</div>"); 
window.setInterval("heartBeat()",1);

function far_close()
{
	document.getElementById("lovexin12").innerHTML="";
}

function setfrme()
{
	var tr=document.getElementById("lovexin12");
	var twidth=tr.clientWidth;
	var theight=tr.clientHeight;
	var fr=document.getElementById("frame55la");
	fr.width=twidth-1;
	fr.height=theight-30;
}
//setfrme()
