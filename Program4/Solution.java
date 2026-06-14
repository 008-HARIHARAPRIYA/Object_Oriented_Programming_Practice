import java.util.*;

class College{

	private int id;
	private String name;
	private int contactNo;
	private String address;
	private int pincode;

	public College(int id,String name, int contactNo, String address, int pincode)
        {
	this.id=id;
	this.name=name;
	this.contactNo=contactNo;
	this.address=address;
	this.pincode=pincode;
        }
	public int getid()
	{
		return id;
	}
	public String getname()
        {
		return name;
        }
	public int getcontactNo()
        {
		return contactNo;
        }
	public String getaddress()
	{
		return address;
	}
	public int getpincode()
	{
		return pincode;
	}
	
	public void setid(int id)
	{
		this.id=id;
	}
	public void setname(String name)
	{
		 this.name=name;
	}
	public void setcontactNo(int num)
	{
		contactNo=num;
	}
	public void setaddress(String add)
	{
		address=add;
	}
	public void setpincode(int pin)
	{
		pincode=pin;
	}
	public String toString(){
	return "{College: Id:"+id+",Name:"+name+",Contact no:"+contactNo+",Address:"+address+",Pincode"+pincode+"}";
	}

}




public class Solution{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of Colleges:");
		int n=sc.nextInt();
		College[] c=new College[n];
		for(int i=1;i<=n;i++)
		{
	System.out.println("Enter the id for college"+i);
	int id=sc.nextInt();
	sc.nextLine();
	System.out.println("Enter the name of the college"+i);
	String name=sc.nextLine();
        System.out.println("Enter the contact no of the college"+i);
	int contact=sc.nextInt();
	sc.nextLine();
	System.out.println("Enter the address of the college"+i);
        String  address=sc.nextLine();
	System.out.println("Enter the pincode of college"+i);	
	int pincode=sc.nextInt();

	
	c[i-1]=new College(id, name, contact, address, pincode);
	
		}
sc.nextLine();
System.out.println("Enter the address to find:");
String findaddress=sc.nextLine();

College result=findCollegeWithMaximumPincode(c);
if(result != null)
{
System.out.println("id-"+result.getid());
System.out.println("name-"+result.getname());
System.out.println("contactNo-"+result.getcontactNo());
System.out.println("address-"+result.getaddress());
System.out.println("pincode-"+result.getpincode());





}
else{
System.out.println("No college found with mentioned attribute");
}

System.out.println();
College ans=searchCollegeByAddress(c,findaddress);

if(ans != null)
{
System.out.println("id-"+ans.getid());
System.out.println("name-"+ans.getname());
System.out.println("contactNo-"+ans.getcontactNo());
System.out.println("address-"+ans.getaddress());
System.out.println("pincode-"+ans.getpincode());
}
else{
System.out.println("No college found with mentioned attribute");
}

	
}
public static College searchCollegeByAddress(College[] c, String address)
{
College result=null;
for(int i=0;i<c.length;i++)
{
	if(c[i].getaddress().equals(address))
	{
		result=c[i];
	}
}
return result;
}
public static College findCollegeWithMaximumPincode(College[] c)
{
College ans=null;
int max=Integer.MIN_VALUE;
for(int i=0;i<c.length;i++)
{
if(c[i].getpincode() >= max)
{
  max=c[i].getpincode();
  ans=c[i];
}
}
if(max != Integer.MIN_VALUE)
{
return ans;
}
else{
return null;
}


}



}