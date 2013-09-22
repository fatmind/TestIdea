package spring.inject.staticf;

public class DogUtil {

	private static DogTeacher teacher;


	public void teacher() {
		teacher.teacher();
	}
	
	
	public static void setTeacher(DogTeacher teacher) {
    	DogUtil.teacher = teacher;
    }

	
}
