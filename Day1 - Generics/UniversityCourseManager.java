import java.util.*;

// --- Abstract Base Class for Course Types ---
abstract class CourseType {
    private String courseName;
    private int credits;

    public CourseType(String courseName, int credits) {
        this.courseName = courseName;
        this.credits = credits;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public abstract void displayEvaluationMethod();
}

// --- Subclasses for Evaluation Types ---
class ExamCourse extends CourseType {
    public ExamCourse(String courseName, int credits) {
        super(courseName, credits);
    }

    @Override
    public void displayEvaluationMethod() {
        System.out.println(getCourseName() + " (Credits: " + getCredits() + ") - Evaluated via Final Exam");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName, int credits) {
        super(courseName, credits);
    }

    @Override
    public void displayEvaluationMethod() {
        System.out.println(getCourseName() + " (Credits: " + getCredits() + ") - Evaluated via Assignments");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName, int credits) {
        super(courseName, credits);
    }

    @Override
    public void displayEvaluationMethod() {
        System.out.println(getCourseName() + " (Credits: " + getCredits() + ") - Evaluated via Research Papers");
    }
}

// --- Generic Course Wrapper Class ---
class Course<T extends CourseType> {
    private T courseType;
    private String department;

    public Course(String department, T courseType) {
        this.department = department;
        this.courseType = courseType;
    }

    public T getCourseType() {
        return courseType;
    }

    public void displayCourseDetails() {
        System.out.print("Department: " + department + " - ");
        courseType.displayEvaluationMethod();
    }
}

// --- Utility to Display Any Course List ---
class UniversityUtils {
    public static void displayAllCourses(List<? extends Course<? extends CourseType>> courses) {
        for (Course<? extends CourseType> c : courses) {
            c.displayCourseDetails();
        }
    }
}

// --- Main Class to Demonstrate Everything ---
public class UniversityCourseManager {
    public static void main(String[] args) {
        List<Course<? extends CourseType>> courseCatalog = new ArrayList<>();

        Course<ExamCourse> math = new Course<>("Mathematics", new ExamCourse("Calculus", 4));
        Course<AssignmentCourse> cs = new Course<>("Computer Science", new AssignmentCourse("Web Development", 3));
        Course<ResearchCourse> physics = new Course<>("Physics", new ResearchCourse("Quantum Mechanics Research", 5));

        courseCatalog.add(math);
        courseCatalog.add(cs);
        courseCatalog.add(physics);

        System.out.println("---- University Course Catalog ----");
        UniversityUtils.displayAllCourses(courseCatalog);
    }
}
