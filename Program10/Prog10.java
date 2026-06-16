import java.util.*;

class Employee{

	private int employeeId;
	private String name, branch;
	private double rating;
	private boolean companyTransport;

	
	public Employee(int employeeId, String name, String branch, double rating, boolean companyTransport)
        {
	this.employeeId=employeeId;
	this.name=name;
	this.branch=branch;
	this.rating=rating;
	this.companyTransport=companyTransport;
        }
	public int getemployeeId()
	{
		return employeeId;
	}
	public String getname()
        {
		return name;
        }
	public String getbranch()
        {
		return branch;
        }
	public double getrating()
	{
		return rating;
	}
	public boolean getcompanyTransport()
	{
		return companyTransport;
	}
	
	public void setemployeeId(int id)
	{
		this.employeeId=id;
	}
	public void setname(String name)
	{
		 this.name=name;
	}
	public void setbranch(String branch)
	{
		this.branch=branch;
	}
	public void setrating(double rate)
	{
		this.rating=rate;
	}
	public void setcompanyTransport(boolean ct)
	{
		this.companyTransport=ct;
	}
	public String toString(){
	return "{Employee: EmployeeId:"+employeeId+",Name:"+name+",Branch:"+branch+",Rating:"+rating+",Company Transport:"+companyTransport+"}";
	}

}



public class Prog10{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of Employees:");
		int n=sc.nextInt();
		Employee[] e=new Employee[n];
		for(int i=1;i<=n;i++)
		{
	System.out.println("Enter the id for Employee"+i);
	int id=sc.nextInt();
	sc.nextLine();
	System.out.println("Enter the name of the Employee "+i);
	String name=sc.nextLine();
        System.out.println("Enter the branch of the Employee "+i);
	String branch=sc.nextLine();
	System.out.println("Enter the rating of the Employee "+i);
        double rate=sc.nextDouble();
	System.out.println("Is the Employee uses company transport "+i);	
	boolean companyTransport=sc.nextBoolean();
	e[i-1]=new Employee(id, name, branch, rate, companyTransport);
	
		}
sc.nextLine();
System.out.println("Enter thr branch to find:");
String findbranch=sc.nextLine();
int result1=findCountOfEmployeesUsingCompTransport(e, findbranch);
if(result1 == 0)
{
	System.out.println("No such Employees");
}
else{
	System.out.println(result1);
}

Employee result2=findEmployeeWithSecondHighestRating(e);
if(result2 == null)
{
  System.out.println("All Employees using company transport");
}
else{
System.out.println(result2.getemployeeId());
System.out.println(result2.getname());


}

}
public static Employee findEmployeeWithSecondHighestRating(Employee[] e)
{
        
	int count=0;
	for(int i=0;i<e.length;i++)
	{
		if(e[i].getcompanyTransport() == false)
		{
			count++;
		}
		
	}
	if(count < 2)
	{
		return null;
	}
	Employee[] result=new Employee[count];
        Employee fhigh=null;
	Employee shigh=null;
	int index=0;
	for(int i=0;i<e.length;i++)
	{
		if(e[i].getcompanyTransport() == false)
		{
			if(fhigh == null || e[i].getrating() > fhigh.getrating())
			{
				shigh=fhigh;
				fhigh=e[i];
			}
			else if(shigh == null || e[i].getrating() > shigh.getrating())
			{
				shigh=e[i];
			}
			
		}
	}
	return shigh;
	
	
}
public static int findCountOfEmployeesUsingCompTransport(Employee e[], String branch)
{
	int count=0;
	for(int i=0;i<e.length;i++)
	{
		if(e[i].getbranch().equalsIgnoreCase(branch) && e[i].getcompanyTransport() == true)
		{
			count++;
		
		}
	}
        return count;
}




}