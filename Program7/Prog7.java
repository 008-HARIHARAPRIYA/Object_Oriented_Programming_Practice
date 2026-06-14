import java.util.*;

class Sim{

	private int simId;
	private String customerName, circle;
	private double balance, ratePerSecond;
	
	public Sim(int simId, String customerName, double balance, double ratePerSecond, String circle)
        {
	this.simId=simId;
	this.customerName=customerName;
	this.balance=balance;
	this.ratePerSecond=ratePerSecond;
	this.circle=circle;
        }
	public int getsimId()
	{
		return simId;
	}
	public String getcustomerName()
        {
		return customerName;
        }
	public double getbalance()
        {
		return balance;
        }
	public double getratePerSecond()
	{
		return ratePerSecond;
	}
	public String getcircle()
	{
		return circle;
	}
	
	public void setsimId(int id)
	{
		this.simId=id;
	}
	public void setname(String name)
	{
		 this.customerName=name;
	}
	public void setbalance(double num)
	{
		balance=num;
	}
	public void setrate(double rate)
	{
		ratePerSecond=rate;
	}
	public void setcircle(String circle)
	{
		this.circle=circle;
	}
	public String toString(){
	return "{Sim: SimId:"+simId+",Customername:"+customerName+",Balance:"+balance+",Rate per second:"+ratePerSecond+",Circle:"+circle+"}";
	}

}



public class Prog7{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of Colleges:");
		int n=sc.nextInt();
		Sim[] s=new Sim[n];
		for(int i=1;i<=n;i++)
		{
	System.out.println("Enter the id for sim"+i);
	int id=sc.nextInt();
	sc.nextLine();
	System.out.println("Enter the customer name of the sim "+i);
	String name=sc.nextLine();
        System.out.println("Enter the balance of the sim "+i);
	double bal=sc.nextDouble();
	System.out.println("Enter the rate per second of the sim "+i);
        double rate=sc.nextDouble();
	System.out.println("Enter the circle of sim "+i);	
	String circle=sc.next();
	s[i-1]=new Sim(id, name,bal,rate,circle);
	
		}
sc.nextLine();
System.out.println("Enter the cicle1:");
String circle1=sc.next();
System.out.println("Enter the cicle2:");
String circle2=sc.next();
Sim[] ans=transferCustomerCircle(s, circle1, circle2);
if(ans == null)
{
System.out.println("null");
}
else{
for(int i=0;i<ans.length;i++)
{
System.out.println(ans[i].getsimId()+" "+ans[i].getcustomerName()+" "+ans[i].getcircle()+" "+ans[i].getratePerSecond());
}
}

}
public static Sim[] transferCustomerCircle(Sim[] s, String circle1,String circle2)
{
 int count=0;
 for(int i=0;i<s.length;i++)
{
if(s[i].getcircle().equals(circle1))
{
count++;
}
}
if(count == 0)
{
return null;
}
Sim[] result=new Sim[count];

int index=0;
for(int i=0;i<s.length;i++)
{
if(s[i].getcircle().equals(circle1))
{

s[i].setcircle(circle2);
result[index]=s[i];
index++;


}
}
for(int i=0;i<result.length-1;i++)
{
for(int j=i+1;j<result.length;j++)
{

if(result[i].getratePerSecond() < result[j].getratePerSecond())
{
  Sim temp=result[i];
  result[i]=result[j];
  result[j]=temp;
}
}
}
return result;



}



}