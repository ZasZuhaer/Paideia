import java.util.*;
public class CourseMng {
    Vector<Course> available_courses = new Vector<Course>(); 
    PaideiaDB teacher_courses = new PaideiaDB("teacher_courses");
    public CourseMng(){
        teacher_courses.getAvailableCoursesTo(available_courses);
        for(int i = 0; i<available_courses.size(); i++){
            System.out.println(available_courses.get(i).title);
        }
    }
    public static void main(String [] args){
        new CourseMng();
    }
}
