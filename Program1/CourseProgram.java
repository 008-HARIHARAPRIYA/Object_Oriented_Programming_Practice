import java.util.*;
public class CourseProgram{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of courses:");
		int courses=sc.nextInt();
                List<Course> myclass=new ArrayList<>();
	        for(int i=1;i<=courses;i++)
		{
			System.out.println("Enter the courseId for course"+i);
			int courseid=sc.nextInt();
			System.out.println("Enter the coursename for course"+i);
			String coursename=sc.next();
			System.out.println("Enter the course admin for course"+i);
			String courseadmin=sc.next();
			System.out.println("Enter the number of quizzes for course"+i);
			int quiz=sc.nextInt();
			System.out.println("Enter the number of handson for course"+i);
			int handson=sc.nextInt();
			myclass.add(new Course(courseid, coursename, courseadmin, quiz, handson));			
		}

                System.out.println(myclass);
		//String inp="Santha";
		//System.out.println(findAvgOfQuizByAdmin(myclass, inp));
		  List<Course> ans=sortCourseByHandsOn(myclass, 4);
		  System.out.println(ans);

		
	}
	public static double findAvgOfQuizByAdmin(List<Course> courses, String adminname)
	{
		double avg=0;
		int sum=0;
		int count=0;
		for(int i=0;i<courses.size();i++)
	        {
			if(((courses.get(i)).getcourseAdmin()).equals(adminname)){
				count++;
				sum+=(courses.get(i)).getquiz();
                        }
			
		}
		if(count == 0)
		{
			return 0;
		}
		avg=sum/count;
		return avg;


	}
	public static List<Course> sortCourseByHandsOn(List<Course> courses, int handson)
	{
		List<Course> result=new ArrayList<>();
		for(int i=0;i<courses.size();i++)
		{
			if(((courses.get(i)).gethandson())<handson)
			{
				result.add(courses.get(i));
				
			}
		}
		Collections.sort(result, new Comparator<Course>()
		{
			public int compare(Course c1, Course c2)
			{
				return c1.gethandson() - c2.gethandson();
			}
		});
		if(result.size() == 0)
		{
			return null;
		}
		return result;
	}

	
}

