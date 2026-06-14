import java.util.*;

class Footwear{

	private int footwearId;
	private String footwearName;
	private String footwearType;
	private int price;

	public Footwear(int footwearId,String footwearName, String footwearType, int price)
        {
	this.footwearId=footwearId;
	this.footwearName=footwearName;
	this.footwearType=footwearType;
	this.price=price;
        }
	public int getfootwearId()
	{
		return footwearId;
	}
	public String getfootwearName()
        {
		return footwearName;
        }
	public String getfootwearType()
        {
		return footwearType;
        }
	public int getprice()
	{
		return price;
	}
	public void setfootwearId(int id)
	{
		footwearId=id;
	}
	public void setfootwearName(String name)
	{
		 footwearName=name;
	}
	public void setfootwearType(String type)
	{
		footwearType=type;
	}
	public void setprice(int p)
	{
		price=p;
	}
	public String toString(){
	return "{Footwear: Id:"+footwearId+",Name"+footwearName+",Type:"+footwearType+",Price:"+price+"}";
	}

}
public class FootwearProgram{
	public static void main(String[] args)
	{
Scanner sc=new Scanner(System.in);
System.out.println("Enter the number of Footwears:");
int n=sc.nextInt();
Footwear[] fw=new Footwear[n];
for(int i=1;i<=n;i++)
{
	System.out.println("Enter the id for footwear"+i);
	int id=sc.nextInt();
	sc.nextLine();
	System.out.println("Enter the name of the footwear"+i);
	String name=sc.nextLine();
        System.out.println("Enter the type of the footwear"+i);
	String type=sc.nextLine();
	System.out.println("Enter the price of the footwear"+i);
	int price=sc.nextInt();
	sc.nextLine();
	fw[i-1]=new Footwear(id, name, type, price);
}
System.out.println("Enter the type:");
String findtype=sc.nextLine();
System.out.println("Enter the brand:");

String findbrand=sc.nextLine();

int count=getCountByType(fw, findtype);
if(count != 0)
{
System.out.println(count);
}
else{
System.out.println("Footwear not available");
}
Footwear ans=getSecondHighestPriceByBrand(fw, findbrand);
if(ans != null){
System.out.println(ans.getfootwearId());
System.out.println(ans.getfootwearName());
System.out.println(ans.getprice());

}
else{
System.out.println("Brand not available");
}
}
public static int getCountByType(Footwear[] fw, String type)
{
type=type.toLowerCase();
int count=0;
	for(int i=0;i<fw.length;i++)
{
	if(fw[i].getfootwearType().toLowerCase().equals(type))
	{
	count++;
}
}

return count;
}

public static Footwear getSecondHighestPriceByBrand(Footwear[]  fw, String name)
{
	name=name.toLowerCase();
	int count=0;
	for(int i=0;i<fw.length;i++)
	{
		if(fw[i].getfootwearName().toLowerCase().equals(name))
		{
			count++;
		}
	}
	Footwear[] result=new Footwear[count];
	int index=0;
	for(int i=0;i<fw.length;i++)
	{
		if(fw[i].getfootwearName().toLowerCase().equals(name))
		{
			result[index]=fw[i];
			index++;
		}
	}
	if(result.length == 0 || result.length == 1)
	{
		return  null;
	}
	for(int i=0;i<result.length-1;i++)
	{
		for(int j=i+1;j<result.length;j++)
		{
			if(result[i].getprice() > result[j].getprice()){
			Footwear temp=result[i];
			result[i]=result[j];
			result[j]=temp;
}
		}
	}

	return result[result.length-2];
}

}