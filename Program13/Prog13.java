import java.util.*;

class AutonomousCar{

	private int carId,  noOfTestsConducted, noOfTestsPassed;
	private String brand, environment;
	private String Grade;
	
	public AutonomousCar(int carId, String brand, int noOfTestsConducted,int noOfTestsPassed,String environment)
        {
	this.carId=carId;
	this.brand=brand;
	this.noOfTestsConducted=noOfTestsConducted;
	this.noOfTestsPassed=noOfTestsPassed;
	this.environment=environment;
	this.Grade=null;
        }
	public int getcarId()
	{
		return carId;
	}
	public String getbrand()
        {
		return brand;
        }
	public int getnoOfTestsConducted()
        {
		return noOfTestsConducted;
        }
	public int getnoOfTestsPassed()
	{
		return noOfTestsPassed;
	}
	public String getenvironment()
	{
		return environment;
	}
	
	public void setcarId(int id)
	{
		this.carId=id;
	}
	public void setbrand(String brand)
	{
		 this.brand=brand;
	}
	public void setnoOfTestsConducted(int tests)
	{
		this.noOfTestsConducted=tests;
	}
	public void setnoOfTestsPassed(int passed)
	{
		noOfTestsPassed=passed;
	}
	public void setenvironment(String environ)
	{
		this.environment=environ;
	}
	public void setGrade(String g)
	{
		this.Grade=g;
	}
	public String getGrade()
	{
		return Grade;
	}
	public String toString(){
	return "{Autonomous Car: Carid:"+carId+",Brand:"+brand+",No.of.Tests conducted:"+noOfTestsConducted+",No.of.Tests passed:"+noOfTestsPassed+",Environment:"+environment+"}";
	}

}



public class Prog13{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of Cars:");
		int n=sc.nextInt();
		AutonomousCar[] c=new AutonomousCar[n];
		for(int i=1;i<=n;i++)
		{
	System.out.println("Enter the id for car"+i);
	int id=sc.nextInt();
	sc.nextLine();
	System.out.println("Enter the brand of the car "+i);
	String brand=sc.nextLine();
        System.out.println("Enter the no of tests conducted for the car "+i);
	int conducted=sc.nextInt();
	System.out.println("Enter the no of tests passed for the car "+i);
        int passed=sc.nextInt();
	System.out.println("Enter the environment of car "+i);	
	String environment=sc.next();
	c[i-1]=new AutonomousCar(id, brand, conducted, passed, environment);
	
		}
	sc.nextLine();
	System.out.println("Enter the environment to search:");
	String findenviron=sc.nextLine();
        System.out.println("Enter the brand to search:");
	String findbrand=sc.nextLine();

	
	int result=findTestPassedByEnv(c,findenviron);
	if(result == 0)
	{
		System.out.println("There are no tests passed in this particular environment");
	}
	else{
		System.out.println(result);
	}

	AutonomousCar result2=updateCarGrade(c,findbrand);
	if(result2 == null)
	{
		System.out.println("No Car is available with the specified brand");
	}
	else{
	
		System.out.println(result2.getbrand()+"::"+result2.getGrade());
		
	}

}

public static int findTestPassedByEnv(AutonomousCar[] c, String environment)
{
	int sum=0;
	for(int i=0;i<c.length;i++)
	{
		if(c[i].getenvironment().equals(environment))
		{
			sum+=c[i].getnoOfTestsPassed();
		}
	}
	return  sum;
}
public static AutonomousCar updateCarGrade(AutonomousCar[] c, String brand)
{
	
        AutonomousCar result=null;
	
	for(int i=0;i<c.length;i++)
	{
		if(c[i].getbrand().equals(brand))
		{
			int rating=(c[i].getnoOfTestsPassed() * 100)/c[i].getnoOfTestsConducted();
			if(rating >= 80)
			{
				c[i].setGrade("A1");
			}
			else
			{
				c[i].setGrade("B2");
				
			}
			return c[i];
			
		}
	}
return result;
}
}