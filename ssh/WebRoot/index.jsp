<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tag/tour.tld" prefix="tour" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>校友录</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
	color: #000000;
}
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.t1 {
	border-right-width: 2px;
	border-right-style: solid;
	border-right-color: #999999;
}
.t2 {
	border-left-width: 2px;
	border-left-style: solid;
	border-left-color: #999999;
}
.t3 {
	border-bottom-width: 1px;
	border-bottom-style: dashed;
	border-bottom-color: #999999;
}
a:link {
	color: #000000;
	text-decoration: none;
}
a:visited {
	text-decoration: none;
	color: #000000;
}
a:hover {
	text-decoration: none;
}
a:active {
	text-decoration: none;
}
-->
</style>
</head>

<body>
<form name="myform" id="myf" action="" method="post">
<table width="1002" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <th width="34" class="t1" scope="row">&nbsp;</th>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <th scope="row"><img src="images/main02_02.jpg" width="937" height="52" /></th>
      </tr>
	   <tr>
        <th scope="row"><img src="images/main02_04.jpg" width="937" height="105" /></th>
      </tr>
	   <tr>
        <th scope="row"><img src="images/main02_05.jpg" width="937" height="110" /></th>
      </tr>
	   <tr>
        <th scope="row"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <th width="331" scope="row"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <th scope="row"><img src="images/main02_06.jpg" width="331" height="36" /></th>
              </tr>
              <tr>
                <th height="118" scope="row"><table width="100%" height="118" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <th width="30" scope="row">&nbsp;</th>
                    <td width="60" height="30" align="left">用户名：</td>
                    <td align="left"><input name="username" id="un" type="text" size="12" /></td>
                    <td width="30">&nbsp;</td>
                  </tr>
                  <tr>
                    <th scope="row">&nbsp;</th>
                    <td height="30" align="left">密 码：</td>
                    <td align="left"><input name="passwords" id="ps" type="password" size="12" /></td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <th height="30" scope="row">&nbsp;</th>
                    <td rowspan="2"><input type="image" src="images/dl.jpg" name="button" onclick="log();"/></td>
                    <td rowspan="2" align="left"><input type="image" src="images/zc.jpg" name="button" onclick="zc();"/></td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <th height="30" scope="row">&nbsp;</th>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <th scope="row">&nbsp;</th>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                  </tr>
                </table></th>
              </tr>
              <tr>
                <th scope="row"><img src="images/main02_10.jpg" width="331" height="27" /></th>
              </tr>
              <tr>
                <th height="221" align="left" valign="top" scope="row"><table width="100%" height="221" border="0" cellpadding="0" cellspacing="0">
                <c:forEach items="${clist}" var="cl">
                  <tr>
                    <th width="50" height="35" align="right" scope="row"><img src="images/t.jpg" width="15" height="7" /></th>
                    <td>&nbsp;${cl.classname}(<tour:number cid="${cl.id}"/>)</td>
                  </tr>
                 </c:forEach>
                  <!-- tr>
                    <th width="50" height="35" align="right" scope="row"><img src="images/t.jpg" width="15" height="7" /></th>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <th width="50" height="35" align="right" scope="row"><img src="images/t.jpg" width="15" height="7" /></th>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <th width="50" height="35" align="right" scope="row"><img src="images/t.jpg" width="15" height="7" /></th>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <th width="50" height="35" align="right" scope="row"><img src="images/t.jpg" width="15" height="7" /></th>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <th width="50" height="35" align="right" scope="row"><img src="images/t.jpg" width="15" height="7" /></th>
                    <td>&nbsp;</td>
                  </tr-->
                  
                  <tr>
                    <th scope="row">&nbsp;</th>
                    <td>&nbsp;</td>
                  </tr>
                </table></th>
              </tr>
              <tr>
                <th scope="row"><img src="images/main02_14.jpg" width="331" height="30" /></th>
              </tr>
              <tr>
                <th height="221" align="left" valign="top" scope="row"><table width="100%" height="221" border="0" cellpadding="0" cellspacing="0">
                <c:forEach items="${ilist}" var="il">
                  <tr>
                    <th width="50" height="35" align="right" scope="row"><img src="images/t.jpg" width="15" height="7" /></th>
                    <td>&nbsp;${il.name}</td>
                  </tr>
                  </c:forEach>
                  <!--tr>
                    <th width="50" height="35" align="right" scope="row"><img src="images/t.jpg" width="15" height="7" /></th>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <th width="50" height="35" align="right" scope="row"><img src="images/t.jpg" width="15" height="7" /></th>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <th width="50" height="35" align="right" scope="row"><img src="images/t.jpg" width="15" height="7" /></th>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <th width="50" height="35" align="right" scope="row"><img src="images/t.jpg" width="15" height="7" /></th>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <th width="50" height="35" align="right" scope="row"><img src="images/t.jpg" width="15" height="7" /></th>
                    <td>&nbsp;</td>
                  </tr-->
                  
                  <tr>
                    <th scope="row">&nbsp;</th>
                    <td>&nbsp;</td>
                  </tr>
                </table></th>
              </tr>
            </table></th>
            <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <th scope="row"><img src="images/main02_07.jpg" width="606" height="36" /></th>
              </tr>
              <tr>
                <th height="210" align="left" valign="top" scope="row"><table width="100%" height="210" border="0" cellpadding="0" cellspacing="0">
                <c:forEach items="${slist}" var="sl">
                  <tr>
                    <th width="30" height="33" align="right" class="t3" scope="row"><img src="images/d.jpg" width="8" height="7" /></th>
                    <td class="t3">&nbsp;<a href="home.html?ssh=form&id=${sl.id}" target="_blank">${sl.title}</td>
                  </tr>
                </c:forEach>
                  <!--tr>
                    <th height="33" align="right" class="t3" scope="row"><img src="images/d.jpg" width="8" height="7" /></th>
                    <td class="t3">&nbsp;</td>
                  </tr>
                  <tr>
                    <th height="33" align="right" class="t3" scope="row"><img src="images/d.jpg" width="8" height="7" /></th>
                    <td class="t3">&nbsp;</td>
                  </tr>
                  <tr>
                    <th height="33" align="right" class="t3" scope="row"><img src="images/d.jpg" width="8" height="7" /></th>
                    <td class="t3">&nbsp;</td>
                  </tr>
                  <tr>
                    <th height="33" align="right" class="t3" scope="row"><img src="images/d.jpg" width="8" height="7" /></th>
                    <td class="t3">&nbsp;</td>
                  </tr>
                  <tr>
                    <th height="33" align="right" class="t3" scope="row"><img src="images/d.jpg" width="8" height="7" /></th>
                    <td class="t3">&nbsp;</td>
                  </tr-->
                  <tr>
                    <th scope="row">&nbsp;</th>
                    <td>&nbsp;</td>
                  </tr>
                </table></th>
              </tr>
              <tr>
                <th scope="row"><img src="images/main02_12.jpg" width="606" height="25" /></th>
              </tr>
              <tr>
                <th height="210" align="left" valign="top" scope="row"><table width="100%" height="210" border="0" cellpadding="0" cellspacing="0">
                <c:forEach items="${nlist}" var="nl">
                  <tr>
                    <th width="30" height="33" align="right" class="t3" scope="row"><img src="images/d.jpg" width="8" height="7" /></th>
                    <td class="t3">&nbsp;<a href="home.html?ssh=news&id=${nl.id}" target="_blank">${nl.title}</a></td>
                  </tr>
                 </c:forEach>
                 
                  <!--tr>
                    <th height="33" align="right" class="t3" scope="row"><img src="images/d.jpg" width="8" height="7" /></th>
                    <td class="t3">&nbsp;</td>
                  </tr>
                  <tr>
                    <th height="33" align="right" class="t3" scope="row"><img src="images/d.jpg" width="8" height="7" /></th>
                    <td class="t3">&nbsp;</td>
                  </tr>
                  <tr>
                    <th height="33" align="right" class="t3" scope="row"><img src="images/d.jpg" width="8" height="7" /></th>
                    <td class="t3">&nbsp;</td>
                  </tr>
                  <tr>
                    <th height="33" align="right" class="t3" scope="row"><img src="images/d.jpg" width="8" height="7" /></th>
                    <td class="t3">&nbsp;</td>
                  </tr>
                  <tr>
                    <th height="33" align="right" class="t3" scope="row"><img src="images/d.jpg" width="8" height="7" /></th>
                    <td class="t3">&nbsp;</td>
                  </tr-->
                  <tr>
                    <th scope="row">&nbsp;</th>
                    <td>&nbsp;</td>
                  </tr>
                </table></th>
              </tr>
              <tr>
                <th scope="row"><img src="images/main02_16.jpg" width="606" height="24" /></th>
              </tr>
              <tr>
                <th height="160" align="left" valign="top" scope="row"><table width="100%" height="160" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <th width="165" rowspan="6" scope="row"><img src="images/main02_17.jpg" width="160" height="140" /></th>
                    <td height="30">
                    <table width="100%" height="30" border="0" cellpadding="0" cellspacing="0">
                    <c:forEach items="${hlist}" var="hl">
                      <tr>
                        <th width="30" class="t3" scope="row"><img src="images/d.jpg" width="8" height="26" /></th>
                        <td class="t3">&nbsp;<a href="home.html?ssh=news&id=${hl.id}" target="_blank">${hl.title}</a></td>
                      </tr>
                     </c:forEach>
                    </table>
                    </td>
                  </tr>
                  <!--tr>
                    <td height="30"><table width="100%" height="30" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <th width="30" class="t3" scope="row"><img src="images/d.jpg" width="8" height="7" /></th>
                        <td class="t3">&nbsp;asdfasdf</td>
                      </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="30"><table width="100%" height="30" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <th width="30" class="t3" scope="row"><img src="images/d.jpg" width="8" height="7" /></th>
                        <td class="t3">&nbsp;</td>
                      </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="30"><table width="100%" height="30" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <th width="30" class="t3" scope="row"><img src="images/d.jpg" width="8" height="7" /></th>
                        <td class="t3">&nbsp;</td>
                      </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="30"><table width="100%" height="30" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <th width="30" class="t3" scope="row"><img src="images/d.jpg" width="8" height="7" /></th>
                        <td class="t3">&nbsp;</td>
                      </tr>
                    </table></td>
                  </tr-->
                  <tr>
                    <td>&nbsp;</td>
                  </tr>
                </table>
                  </th>
              </tr>
            </table></td>
          </tr>
        </table></th>
      </tr>
	   <tr>
        <th scope="row"><img src="images/main02_19.jpg" width="937" height="36" /></th>
      </tr>
	  <tr>
        <th height="50" bgcolor="#F9FBF6" scope="row"><img src="images/h.jpg" width="310" height="16" /></th>
      </tr>
    </table></td>
    <td width="34" class="t2">&nbsp;</td>
  </tr>
</table>
</form>
<br />
<script type="text/javascript">
function log(){
	var un = document.getElementById("un").value;
	var ps = document.getElementById("ps").value;
	if(un == null || un== ""){
		alert("请输入用户名");
		return false;
	}else if(ps == null || ps == ""){
		alert("请输入密码");
		return false;
	}else {
		document.getElementById("myf").action="login.html";
	}
}
function zc(){
	document.getElementById("myf").action="zc.html?ssh=zhuce";
}
</script>
</body>
</html>
