package service;

import java.util.ArrayList;
import java.util.Arrays;

import model.Course;
import model.CourseGradeType;
import model.Degree;
import model.Faculty;
import model.Grade;
import model.Person;
import model.Professor;
import model.Student;


public class VeA_IS {

	
	//private static ArrayList<Student> allStudentsList = new ArrayList<>();
	//private static ArrayList<Professor> allProfessorList = new ArrayList<>();
	
	private static ArrayList<Person> allPersons = new ArrayList<>();
	private static ArrayList<Course> allCourseList = new ArrayList<>();
	private static ArrayList<Grade> allGradesList = new ArrayList<>();
	
	public static void main(String[] args) {
		Student st1 = new Student();
		Student st2 = new Student("Jānis", "Bērziņš", Faculty.ITF, "121200-12345");
		Student st3 = new Student("Līga", "Jaukā", Faculty.ITF, "121400-12345");
		allPersons.addAll(Arrays.asList(st1, st2, st3));
		
		Professor pr1 = new Professor();
		Professor pr2 = new Professor("Karina", "Šķirmante", "121000-12345", Degree.master);
		Professor pr3 = new Professor("Gaļina", "Hiļķeviča", "121290-12345", Degree.phd);
		allPersons.addAll(Arrays.asList(pr1, pr2, pr3));
		
		System.out.println("----------------------------------------------");
		for(Person temp : allPersons) {
			System.out.println(temp.toString());
		}
		System.out.println("----------------------------------------------");
		
		
		
		
		
		
		
		
		Course c1 = new Course();
		Course c2 = new Course("Programmēšana tīmeklī JAVA", 4, CourseGradeType.EXAM, pr2);		
		Course c3 = new Course("Diferencialvienādojumi", 2, CourseGradeType.EXAM, pr3);
		Course c4 = new Course("Datu Struktūras un pamatalgoritmi", 2, CourseGradeType.EXAM, pr2);

		allCourseList.addAll(Arrays.asList(c1, c2, c3, c4));
		for(Course temp: allCourseList)
		{
			System.out.println(temp);
		}
		
		Grade gr1 = new Grade();
		Grade gr2 = new Grade(10, st2, c2);
		Grade gr3 = new Grade(10, st3, c2);
		Grade gr4  = new Grade(5, st2, c3);

		allGradesList.addAll(Arrays.asList(gr1, gr2, gr3, gr4));
		for(Grade temp: allGradesList)
		{
			System.out.println(temp);
		}
		
		System.out.println("-----------------------------------------");
		for(Person temp : allPersons) {
			if(temp instanceof Student)
			{
				Student tempStudent = (Student)temp;
				System.out.println(temp.getName() + ": " + calculateAVGGrade(tempStudent));
			}
		}
		
		System.out.println("-----------------------------------------");
		for(Course temp : allCourseList) {
			System.out.println(temp.getTitle() + ": " + calculateAVGGradeInCourse(temp));
		}
		
		System.out.println("-----------------------------------------");
		for(Person temp : allPersons) {
			if(temp instanceof Student)
			{
				System.out.println(temp.getName() + ": " + calculateWeightedAVGGrade((Student)temp));
			}
		}
		
		System.out.println("-----------------------------------------");
		for(Person temp : allPersons) {
			if(temp instanceof Professor) {
			System.out.println(temp.getSurname() + ": " + calculateCourseCount((Professor)temp));
			}
		}
		
		System.out.println("-----------------------------------------");
		ArrayList<Student> onlyStudents = new ArrayList<>();
		for(Person temp : allPersons) {
			if(temp instanceof Student)
			{
				System.out.println(temp);
				onlyStudents.add((Student)temp);
			}
		}
		
		ArrayList<Student> sortedAllStudentList = sortStudents(onlyStudents);
		System.out.println("-----------------------------------------");
		for(Student temp : sortedAllStudentList) {
			System.out.println(temp);
		}
		
		
	}
	
	private static float calculateAVGGrade(Student student)
	{
		if(student != null) {
			float gradesSum = 0;
			int gradesCounter = 0;
			
			for(Grade temp : allGradesList ) {
				if(temp.getStudent().equals(student)) {
					gradesSum += temp.getValue();
					gradesCounter++;
				}
			}
			//           int/ int -> int 
			//           float/int -> float
			//           int/float -> float
			return gradesSum/gradesCounter;

		}
		else
		{
			return 0;
		}
	}

	
	private static float calculateAVGGradeInCourse(Course course)
	{
		if(course != null) {
			float gradesSum = 0;
			int gradesCounter = 0;
			
			for(Grade temp : allGradesList ) {
				if(temp.getCourse().equals(course)) {
					gradesSum += temp.getValue();
					gradesCounter++;
				}
			}
			return gradesSum/gradesCounter;

		}
		else
		{
			return 0;
		}
	}
	
	private static float calculateWeightedAVGGrade(Student student) {
		if(student != null) {
			float gradesSum = 0;
			int creditPointsCounter = 0;
			for(Grade temp : allGradesList ) {
				if(temp.getStudent().equals(student)) {
					gradesSum += (temp.getValue()*temp.getCourse().getCreditPoints());
					creditPointsCounter += temp.getCourse().getCreditPoints();
				}
			}
			return gradesSum/creditPointsCounter;
		}
		else
		{
			return 0.0f;
		}
	}
	
	private static int calculateCourseCount(Professor professor) //String name, String surname
	{
		if(professor!=null) {
			int courseCounter = 0;
			
			for(Course temp : allCourseList) {
				if(temp.getProfessor().equals(professor)) {
					courseCounter++;
				}
			}
			return courseCounter;
		}
		else
		{
			return 0;
		}
	}
	
	private static ArrayList<Student> sortStudents(ArrayList<Student> allStudentsList){
		ArrayList<Student> sortedStudents = new ArrayList<>();
		
		for(Student temp : allStudentsList) {
			sortedStudents.add(temp);
		}
		
		for(int i = 0; i < sortedStudents.size();i++) {
			for(int j = 0; j < sortedStudents.size();j++) {
				float student1AVGGrade = calculateAVGGrade(sortedStudents.get(i));
				float student2AVGGrade = calculateAVGGrade(sortedStudents.get(j));
				
				if(student1AVGGrade > student2AVGGrade) {
					Student temp = sortedStudents.get(i);
					sortedStudents.set(i, sortedStudents.get(j));
					sortedStudents.set(j, temp);
				}
			}
		}
		
		
		
		return sortedStudents;
		
	}
	
	
}