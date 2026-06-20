import java.util.*;

class Flowers{

	private int flowerId, price, rating;
	private String flowerName, type;
	
	
	public Flowers(int flowerId, String flowerName, int price, int rating, String type)
        {
	this.flowerId=flowerId;
	this.flowerName=flowerName;
	this.price=price;
	this.rating=rating;
	this.type=type;
        }
	public int getflowerId()
	{
		return flowerId;
	}
	public String getflowerName()
        {
		return flowerName;
        }
	public int getprice()
        {
		return price;
        }
	public int getrating()
	{
		return rating;
	}
	public String gettype()
	{
		return type;
	}
	
	public void setflowerId(int id)
	{
		this.flowerId=id;
	}
	public void setflowerName(String name)
	{
		 this.flowerName=name;
	}
	public void setprice(int price)
	{
		this.price=price;
	}
	public void setrating(int rating)
	{
		this.rating=rating;
	}
	public void settype(String type)
	{
		this.type=type;
	}
	
	public String toString(){
	return "{Flower: Flower id:"+flowerId+",Flower Name:"+flowerName+",Price:"+price+",Rating:"+rating+",Type:"+type+"}";
	}

}



public class Prog19{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of flowers:");
		int n=sc.nextInt();
		Flowers[] f=new Flowers[n];
		for(int i=1;i<=n;i++)
		{
	System.out.println("Enter the id for flower"+i);
	int id=sc.nextInt();
	sc.nextLine();
	System.out.println("Enter the name of the flower "+i);
	String name=sc.nextLine();
        System.out.println("Enter the price for the flower"+i);
	int price=sc.nextInt();
	System.out.println("Enter the rating for the flower "+i);
        int rating=sc.nextInt();
	System.out.println("Enter the type of flower "+i);	
	String type=sc.next();
	f[i-1]=new Flowers(id, name, price,rating, type);
	
		}
	sc.nextLine();
	System.out.println("Enter the type to find:");
	String findtype=sc.nextLine();
	Flowers result=findMinPriceByType(f,findtype);
	if(result != null)
	{
		System.out.println(result.getflowerId());

	}
	else
	{
	        System.out.println("There is no flower with given type");

	}
	
	


	
}

public static Flowers findMinPriceByType(Flowers[] f, String type)
{
	Flowers result=null;
	for(int i=0;i<f.length;i++)
	{
		if(f[i].gettype().equals(type) && f[i].getrating() > 3)
		{
			if(result == null || f[i].getprice() < result.getprice())
			{
				result=f[i];
			}
		
		}
	}
	return result;




}
}