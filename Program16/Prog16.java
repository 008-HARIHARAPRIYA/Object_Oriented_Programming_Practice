import java.util.*;

class NavalVessel{

	private int vesselId, noOfVoyagesPlanned, noOfVoyagesCompleted;
	private String vesselName, purpose, Classification;
	
	
	public NavalVessel(int vesselId, String vesselName, int noOfVoyagesPlanned, int noOfVoyagesCompleted, String purpose)
        {
	this.vesselId = vesselId;
	this.vesselName=vesselName;
	this.noOfVoyagesPlanned=noOfVoyagesPlanned;
	this.noOfVoyagesCompleted=noOfVoyagesCompleted;
	this.purpose=purpose;
	this.Classification=null;
        }
	public int getvesselId()
	{
		return vesselId;
	}
	public String getvesselName()
        {
		return vesselName;
        }
	public int getnoOfVoyagesPlanned()
        {
		return noOfVoyagesPlanned;
        }
	public int getnoOfVoyagesCompleted()
	{
		return noOfVoyagesCompleted;
	}
	public String getpurpose()
	{
		return purpose;
	}
	
	public void setvesselId(int id)
	{
		this.vesselId=id;
	}
	public void setvesselName(String name)
	{
		 this.vesselName=name;
	}
	public void setnoOfVoyagesPlanned(int voyage)
	{
		this.noOfVoyagesPlanned=voyage;
	}
	public void setnoOfVoyagesCompleted(int complete)
	{
		noOfVoyagesCompleted=complete;
	}
	public void setpurpose(String p)
	{
		this.purpose=p;
	}
	public void setClassification(String classi)
	{
		this.Classification=classi;
	}
	public String getClassification()
	{
		return Classification;
	}
	public String toString(){
	return "{Naval Vessel: vessel id:"+vesselId+",Vessel Name:"+vesselName+",No.of.voyages planned:"+noOfVoyagesPlanned+",No.of. Voyages completed:"+noOfVoyagesCompleted+",Purpose:"+purpose+"}";
	}

}



public class Prog16{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of vessels:");
		int n=sc.nextInt();
		NavalVessel[] v=new NavalVessel[n];
		for(int i=1;i<=n;i++)
		{
	System.out.println("Enter the id for vessel"+i);
	int id=sc.nextInt();
	sc.nextLine();
	System.out.println("Enter the name of the vessel "+i);
	String name=sc.nextLine();
        System.out.println("Enter the no of voyages planned for the vessel "+i);
	int planned=sc.nextInt();
	System.out.println("Enter the no of voyages completed for the vessel "+i);
        int completed=sc.nextInt();
	System.out.println("Enter the purpose of vessel "+i);	
	String purpose=sc.next();
	v[i-1]=new NavalVessel(id, name, planned, completed, purpose);
	
		}
	
	System.out.println("Enter the percentage:");
	int per=sc.nextInt();
	sc.nextLine();
	System.out.println("Enter the purpose to find:");
	String pur=sc.nextLine();
	int result1=findAvgVoyagesByPct(v, per);
	System.out.println(result1);
	NavalVessel result2=findVesselByGrade(v, pur);
	if(result2 == null)
	{
		System.out.println("No Naval Vessel is available with the specified purpose");
	}
	else
	{
		System.out.println(result2.getvesselName()+"%"+result2.getClassification());
	}


	
}
public static int findAvgVoyagesByPct(NavalVessel[] v, int per)
{
	int sum=0, count=0;
	
	for(int i=0;i<v.length;i++)
	{
		int percentage=(v[i].getnoOfVoyagesCompleted() * 100)/v[i].getnoOfVoyagesPlanned();
		if(percentage >= per)
		{
			count++;
			sum+=v[i].getnoOfVoyagesCompleted();
			
		}
	}
	if(count == 0)
	{
		return 0;
	}
	int avg=sum/count;
	return avg;
	
}
public static NavalVessel findVesselByGrade(NavalVessel v[], String purpose)
{
	
	NavalVessel res=null;
	for(int i=0;i<v.length;i++)
	{
			if(v[i].getpurpose().equals(purpose))
			{
		
			int percent=(v[i].getnoOfVoyagesCompleted() * 100)/v[i].getnoOfVoyagesPlanned();
			if(percent == 100)
			{
				v[i].setClassification("Star");

			}
			else if(percent >= 80 && percent <= 90)
			{
				v[i].setClassification("Leader");
			}
			else if(percent >= 55 && percent <= 79)
			{
				v[i].setClassification("Inspirer");
			}
			else
			{
				v[i].setClassification("Striver");
			}
                        return v[i];
			
			}

         
		
	}
return null;

	
}


}