function fucCheckLength(strTemp)
{
 var i,sum;
 sum=0;
 for(i=0;i<strTemp.length;i++)
 {
  if ((strTemp.charCodeAt(i)>=0) && (strTemp.charCodeAt(i)<=255))
   sum=sum+1;
  else
   sum=sum+2;
 }
 return sum;
}


function CheckEmail(strEmail)
{
	var myReg = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+[a-zA-Z0-9_-]{2,3}$/; 
	
	if(myReg.test(strEmail))
	{
		return true;
	}
	else
	{
		return false;
	}
}

function checkEmpty(obj,msg){   
   if(obj.value=="")
{
   alert(msg);
   obj.focus();
   return false;}
   else
{
   return true;}
}

function checkclick(msg,url){if(confirm(msg))window.location.href=url;}

function CheckAll(form,formname)  {
  for (var i=0;i<form.elements.length;i++)    {
    var e = form.elements[i];
    if (e.name ==formname){
	e.checked = form.chkall.checked;
	}
   }
  }

function send_request(ObjName,url,method,executesub) {
	eval(ObjName + " = false");									//��ʼ��ʼ��XMLHttpRequest����
	if(window.XMLHttpRequest) { 								//Mozilla �����
		eval(ObjName + "= new XMLHttpRequest()");
		if (eval(ObjName+".overrideMimeType")) {				//����MiME���
			eval(ObjName+".overrideMimeType('text/xml')");
		}
	}
	else if (window.ActiveXObject) { 							// IE�����
		try {
			eval(ObjName+" = new ActiveXObject(\"Msxml2.XMLHTTP\")");
		} catch (e) {
			try {
				eval(ObjName+" = new ActiveXObject(\"Microsoft.XMLHTTP\")");
			} catch (e) {}
		}
	}
	if (!eval(ObjName)) { 										// �쳣����������ʵ��ʧ��
		window.alert("���ܴ���XMLHttpRequest����ʵ��.");
		return false;
	}
	eval(ObjName+".onreadystatechange = function(){" + executesub + "}");	// ȷ����������ķ�ʽ��URL�Լ��Ƿ�ͬ��ִ���¶δ���
	eval(ObjName+".open(method, url, true)");
	eval(ObjName+".send(null)");
}