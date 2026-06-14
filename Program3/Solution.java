import java.util.*;

class Student{

	private int rollNo;
	private String name;
	private String branch;
	private double score;
	private boolean dayScholar;

	public Student(int rollNo,String name, String branch, double score, boolean dayScholar)
        {
	this.rollNo=rollNo;
	this.name=name;
	this.branch=branch;
	this.score=score;
	this.dayScholar=dayScholar;
        }
	public int getrollNo()
	{
		return rollNo;
	}
	public String getname()
        {
		return name;
        }
	public String getbranch()
        {
		return branch;
        }
	public double getscore()
	{
		return score;
	}
	public boolean getdayScholar()
	{
		return dayScholar;
	}
	
	public void setrollNo(int no)
	{
		rollNo = no;
	}
	public void setname(String name)
	{
		 name=name;
	}
	public void setbranch(String b)
	{
		branch=branch;
	}
	public void setscore(int s)
	{
		score=s;
	}
	public void setdayScholar(boolean scholar)
	{
		dayScholar=scholar;
	}
	public String toString(){
	return "{Student: Rollno:"+rollNo+",Name:"+name+",Branch:"+branch+",Score:"+score+",Dayscholar:"+"}";
	}

}




public class Solution{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of Students:");
		int n=sc.nextInt();
		Student[] st=new Student[n];
		for(int i=1;i<=n;i++)
		{
	System.out.println("Enter the rollno for student"+i);
	int rollno=sc.nextInt();
	sc.nextLine();
	System.out.println("Enter the name of the student"+i);
	String name=sc.nextLine();
        System.out.println("Enter the branch of the student"+i);
	String branch=sc.nextLine();
	System.out.println("Enter the score of the student"+i);
        double score=sc.nextDouble();
	sc.nextLine();
	System.out.println("Dayscholar or not of student"+i);	
	boolean dayScholar=sc.nextBoolean();

	
	st[i-1]=new Student(rollno, name, branch, score, dayScholar);
	
		}
	int dayscholar=findCountOfDayscholarStudents(st);
	Student second=findStudentwithSecondHighestScore(st,dayscholar);

	System.out.println(dayscholar);
	System.out.println(second.getrollNo()+"#"+second.getname()+"#"+second.getscore());

}

public static int findCountOfDayscholarStudents(Student[] st)
{
	int count=0;
	for(int i=0;i<st.length;i++)
	{
	if(st[i].getscore() > 80 && st[i].getdayScholar() == true)
	{
		count++;
	}
	}
return count;
}

public static Student findStudentwithSecondHighestScore(Student[] st,int dayscholar)
{
  int l=st.length - dayscholar;
  if(l == 0)
{
return null;
}

Student[] result=new Student[l];
int index=0;
for(int i=0;i<st.length;i++)
{
	if(st[i].getdayScholar() != true)
	{
		result[index]=st[i];
		index++;

	}
}

for(int i=0;i<st.length-1;i++)
{
	for(int j=i+1;j<st.length;j++)
	{
		if(st[i].getscore() > st[j].getscore())
		{
			Student temp=st[i];
			st[i]=st[j];
			st[j]=temp;
		}
	}
}
return result[result.length-2];
  
}

}