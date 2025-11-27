import java.util.HashMap;

public class CourseService{
    HashMap<String, Student> students = new HashMap<>();
    HashMap<String, Course> courses = new HashMap<>();


    public CourseService(){
        students.put( "120120", new Student( "Santiago", "120120" ) );
        students.put( "884545", new Student( "Kate", "884545" ) );
        students.put( "458787", new Student( "Alejandra", "458787" ) );
        students.put( "135464", new Student( "Maria", "135464" ) );
        students.put( "778979", new Student( "Peter", "778979" ) );

        courses.put( "math_01", new Course( "Mathematics 1", "math_01", 8 ) );
        courses.put( "biol_01", new Course( "Biology 1", "biol_01", 8 ) );
        courses.put( "phys_01", new Course( "Physics 1", "phys_01", 8 ) );
        courses.put( "art_01", new Course( "Arts 1", "art_01", 8 ) );
        courses.put( "chem_01", new Course( "Chemistry 1", "chem_01", 8 ) );
        courses.put( "sport_01", new Course( "Sports 1", "sport_01", 8 ) );
    }//constructor

    public void enrollStudent(String studentId, String courseId){
        Course course = courses.get(courseId);
        Student student = students.get(studentId);
        if ((student!=null) && (course!=null))  {
            student.enroll(course);
        }//!=null
    }//enrollStudent

    public void unEnrollStudent1(String studentId, String courseId){
        
        Course course = courses.get(courseId);
        Student student = students.get(studentId);

        if(student != null && course != null){
            student.enroll(course);     
        }//!=null
        
    }//enrollStudent
    
    public void unEnrollStudent(String studentId, String courseId){
        // Obtener el estudiante del HashMap
        Student student = students.get(studentId);
        
        // Obtener el curso del HashMap
        Course course = courses.get(courseId);
        
        // Si ambos existen, des-inscribir al estudiante del curso
        if(student != null && course != null){
            student.unEnroll(course);
        }
    }

    public void displayCourseInformation(String courseId){
        // Obtener el curso del HashMap
        Course course = courses.get(courseId);
        
        // Si el curso existe, mostrar su información
        if(course != null){
            System.out.println("Course Information:");
            System.out.println("Name: " + course.name);
            System.out.println("ID: " + course.id);
            System.out.println("Credits: " + course.credits);
        } else {
            System.out.println("Course not found with ID: " + courseId);
        }
    }//displayCourseInformation

    public void displayStudentInformation(String studentId){
        // Obtener el estudiante del HashMap
        Student student = students.get(studentId);
        
        // Si el estudiante existe, mostrar su información
        if(student != null){
            System.out.println("Student Information:");
            System.out.println("Name: " + student.getName());
            System.out.println("ID: " + student.getId());
            System.out.println("Enrolled Courses: " + student.totalEnrolledCourses());
            
            // Mostrar la lista de cursos inscritos
            System.out.println("Courses:");
            for(Course course : student.getEnrolledCourses()){
                System.out.println("  - " + course.name + " (" + course.id + ")");
            }
        } else {
            System.out.println("Student not found with ID: " + studentId);
        }
    }// displayStudentInformation
        
    // DESAFÍO ADICIONAL DEL EJERCICIO
    public void totalCredits(String studentId){
        Student student = students.get(studentId);
        
        if(student != null){
            int totalCredits = 0;
            
            for(Course course : student.getEnrolledCourses()){
                totalCredits += course.credits;
            }
            
            System.out.println("Total credits for " + student.getName() + ": " + totalCredits);
        } else {
            System.out.println("Student not found with ID: " + studentId);
        }
    }
}
