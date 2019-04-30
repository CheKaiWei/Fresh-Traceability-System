package dsa;

public class ComReJavaBean {
private String Company_name;//企业名称
private String Legal_representative;//法人代表
private String Company_code;//组织机构代码
private String Company_address;//企业地址
private String Tax_number;//工商税务登记号
private String Company_nature;//企业性质
private String Registered_capital;//注册资本
private String Contact_name;//联系人姓名
private String Contact_number;//联系人电话
private String Contact_email;//联系人email地址
private String password;//密码

//Javabean——封装调用数据表内的数据
	//获取product数据表数据
public void setCompany_name(String xinxi0)
{
	Company_name=xinxi0;		
}
public void setLegal_representative(String xinxi0)
{
	Legal_representative=xinxi0;		
}
public void setCompany_code(String xinxi0)
{
	Company_code=xinxi0;		
}
public void setCompany_address(String xinxi0)
{
	Company_address=xinxi0;		
}
public void setTax_number(String xinxi0)
{
	Tax_number=xinxi0;		
}
public void setCompany_nature(String xinxi0)
{
	Company_nature=xinxi0;		
}
public void setRegistered_capital(String xinxi0)
{
	Registered_capital=xinxi0;		
}
public void setContact_name(String xinxi0)
{
	Contact_name=xinxi0;		
}
public void setContact_number(String xinxi0)
{
	Contact_number=xinxi0;		
}
public void setContact_email(String xinxi0)
{
	Contact_email=xinxi0;		
}
public void setpassword(String xinxi0)
{
	password=xinxi0;		
}

//展示ComRegistratio数据表的数据
	public  String getCompany_name()
	{
		return Company_name;
	}
	public  String getLegal_representative()
	{
		return Legal_representative;
	}
	public  String getCompany_code()
	{
		return Company_code;
	}
	public  String getCompany_address()
	{
		return Company_address;
	}
	public  String getTax_number()
	{
		return Tax_number;
	}
	public  String getCompany_nature()
	{
		return Company_nature;
	}
	public  String getRegistered_capital()
	{
		return Registered_capital;
	}
	public  String getContact_name()
	{
		return Contact_name;
	}
	public  String getContact_number()
	{
		return Contact_number;
	}
	public  String getContact_email()
	{
		return Contact_email;
	}
	public  String getpassword()
	{
		return password;
	}
	
}
