package dsa;

public class UserInfo {
	private int  ID;//��ƷID
	private String Product_name;//��Ʒ����
	private String Specification_model;//����ͺ�
	private String Manufacturer_name;//����������
	private String Owner_name;//����������
	private String Date_of_manufacture;//��������
	private String Quality_guarantee_period;//������
	private String Production_batch;//��������
//Javabean������װ����product���ݱ��ڵ�����
	//��ȡproduct���ݱ�����
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
	
	
	
	//չʾproduct���ݱ������
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
