public class Course{
	private int courseId;
	private String courseName;
	private String courseAdmin;
	private int quiz;
	private int handson;

	public Course (int courseId, String courseName, String courseAdmin, int quiz, int handson)
	{
		this.courseId=courseId;
		this.courseName=courseName;
		this.courseAdmin=courseAdmin;
		this.quiz=quiz;
		this.handson=handson;
	}
	public int getcourseId()
	{
		return courseId;
	}
	public String getcourseName()
	{
		return courseName;
	}
	public String getcourseAdmin()
	{
		return courseAdmin;
	}
	public int getquiz()
	{
		return quiz;
	}
        public int gethandson()
	{
		return handson;
	}

	public void setcourseId(int id)
	{
		courseId=id;
	}
	public void setcourseName(String name)
	{
		courseName=name;
	}
	public void setcourseAdmin(String admin)
	{
		courseAdmin=admin;
	}
	public void setquiz(int q)
	{
		quiz=q;
	}
	public void sethandson(int h)
	{
		handson=h;
	}

        public String toString() {
            return "Course{" +
            "courseId=" + courseId +
            ", courseName='" + courseName + '\'' +
            ", courseAdmin='" + courseAdmin + '\'' +
            ", quiz=" + quiz +
            ", handson=" + handson +
            '}';
}


}
