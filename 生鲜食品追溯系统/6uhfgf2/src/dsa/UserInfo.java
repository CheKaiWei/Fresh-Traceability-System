package dsa;

public class UserInfo {
	private int  ID;//产品ID
	private String Product_name;//产品名称
	private String Specification_model;//规格型号
	private String Manufacturer_name;//生产商名称
	private String Owner_name;//所有者名称
	private String Date_of_manufacture;//生产日期
	private String Quality_guarantee_period;//保质期
	private String Production_batch;//生产批次
//Javabean——封装调用product数据表内的数据
	//获取product数据表数据
	public void setID(int xinxi0)
	{
		ID=xinxi0;		
	}
	public  void setProduct_name(String xinxi0)
	{
		Product_name=xinxi0;
	}
	public  void setSpecification_model(String xinxi0)
	{
		Specification_model=xinxi0;
	}
	public  void setManufacturer_name(String xinxi0)
	{
		Manufacturer_name=xinxi0;
	}
	public  void setOwner_name(String xinxi0)
	{
		Owner_name=xinxi0;
	}
	public  void setDate_of_manufacture(String xinxi0)
	{
		Date_of_manufacture=xinxi0;
	}
	public  void setQuality_guarantee_period(String xinxi0)
	{
		Quality_guarantee_period=xinxi0;
	}
	public  void setProduction_batch(String xinxi0)
	{
		Production_batch=xinxi0;
	}
	
	
	
	//展示product数据表的数据
	public  int getID()
	{
		return ID;
	}
	public  String getProduct_name()
	{
		return Product_name;
	}
	public  String getSpecification_model()
	{
		return Specification_model;
	}
	public  String getManufacturer_name()
	{
		return Manufacturer_name;
	}
	public  String getOwner_name()
	{
		return Owner_name;
	}
	public  String getDate_of_manufacture()
	{
		return Date_of_manufacture;
	}
	public  String getQuality_guarantee_period()
	{
		return Quality_guarantee_period;
	}
	public  String getProduction_batch()
	{
		return Production_batch;
	}	
}
