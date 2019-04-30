/**
 * 
 */
//用来对输入信息是否有空缺进行检测
function logincheckform()//登录界面进行检测
{
	if(document.login.xinxi.value=="")
	{
	alert("提示：\n\n请输入账号");
	document.login.xinxi.focus();
	return false;
	}
	if(document.login.mima.value=="")
	{
	alert("提示：\n\n请输入密码");
	document.login.mima.focus();
	return false;
	}
}

function registrationcheckform()//对注册界面进行检测
{
	if(document.userlogin.xinxi[0].value=="")
	{
	alert("提示：\n\n请输入企业名称");
	document.userlogin.xinxi[0].focus();
	return false;
	}
	if(document.userlogin.xinxi[1].value=="")
	{
	alert("提示：\n\n请输入法人代表");
	document.userlogin.xinxi[1].focus();
	return false;
	}
	if(document.userlogin.xinxi[2].value=="")
	{
	alert("提示：\n\n请输入组织机构代码");
	document.userlogin.xinxi[2].focus();
	return false;
	}
	if(document.userlogin.xinxi[3].value=="")
	{
	alert("提示：\n\n请输入企业地址");
	document.userlogin.xinxi[3].focus();
	return false;
	}
	if(document.userlogin.xinxi[4].value=="")
	{
	alert("提示：\n\n请输入工商税务登记号");
	document.userlogin.xinxi[4].focus();
	return false;
	}
	if(document.userlogin.xinxi[5].value=="")
	{
	alert("提示：\n\n请输入企业性质");
	document.userlogin.xinxi[5].focus();
	return false;
	}
	if(document.userlogin.xinxi[6].value=="")
	{
	alert("提示：\n\n请输入注册资本");
	document.userlogin.xinxi[6].focus();
	return false;
	}
	if(document.userlogin.xinxi[7].value=="")
	{
	alert("提示：\n\n请输入联系人姓名");
	document.userlogin.xinxi[7].focus();
	return false;
	}
	if(document.userlogin.xinxi[8].value=="")
	{
	alert("提示：\n\n请输入联系人电话");
	document.userlogin.xinxi[8].focus();
	return false;
	}
	if(document.userlogin.xinxi[9].value=="")
	{
	alert("提示：\n\n请输入联系人e-mail");
	document.userlogin.xinxi[9].focus();
	return false;
	}
	if(document.userlogin.mima[0].value=="")
	{
	alert("提示：\n\n请输入密码");
	document.userlogin.mima[0].focus();
	return false;
	}
	if(document.userlogin.mima[1].value=="")
	{
	alert("提示：\n\n请再次输入密码");
	document.userlogin.mima[1].focus();
	return false;
	}
	if(document.userlogin.mima[0].value!=document.userlogin.mima[1].value)
	{
	alert("提示：\n\n你两次输入的密码不一致\n\n请重新输入");
	document.userlogin.mima[1].focus();
	return false;
    } 
	if(document.userlogin.con.checked)
	{
	}
	else
	{
	alert("提示：\n\n请阅读合同并勾选同意按钮");
	//document.userlogin.con.focus();
	return false;
	}
}

function productcheckform()//产品界面进行检测
{
	if(document.productlogin.xinxi[0].value=="")
	{
	alert("提示：\n\n请输入产品名称");
	document.productlogin.xinxi[0].focus();
	return false;
	}
	if(document.productlogin.xinxi[1].value=="")
	{
	alert("提示：\n\n请输入规格型号");
	document.productlogin.xinxi[1].focus();
	return false;
	}
	if(document.productlogin.xinxi[2].value=="")
	{
	alert("提示：\n\n请输入生产商名称");
	document.productlogin.xinxi[2].focus();
	return false;
	}
	if(document.productlogin.xinxi[3].value=="")
	{
	alert("提示：\n\n请输入所有者名称");
	document.productlogin.xinxi[3].focus();
	return false;
	}
	if(document.productlogin.xinxi[4].value=="")
	{
	alert("提示：\n\n请输入物流包装单位");
	document.productlogin.xinxi[4].focus();
	return false;
	}
	if(document.productlogin.xinxi[5].value=="")
	{
	alert("提示：\n\n请输入包装单位所含个数");
	document.productlogin.xinxi[5].focus();
	return false;
	}
	if(document.productlogin.xinxi[6].value=="")
	{
	alert("提示：\n\n请输入生产日期");
	document.productlogin.xinxi[6].focus();
	return false;
	}
	if(document.productlogin.xinxi[7].value=="")
	{
	alert("提示：\n\n请输入保质期");
	document.productlogin.xinxi[7].focus();
	return false;
	}
	if(document.productlogin.xinxi[8].value=="")
	{
	alert("提示：\n\n请输入生产批次");
	document.productlogin.xinxi[8].focus();
	return false;
	}
}