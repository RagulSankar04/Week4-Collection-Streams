import java.util.*;

// --- Abstract JobRole Base Class ---
abstract class JobRole {
    private String candidateName;
    private int experienceYears;

    public JobRole(String candidateName, int experienceYears) {
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public abstract void evaluateResume();
}

// --- Specific Job Roles ---
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String name, int exp) {
        super(name, exp);
    }

    @Override
    public void evaluateResume() {
        System.out.println("Screening Software Engineer: " + getCandidateName() +
                " | Experience: " + getExperienceYears() + " years");
    }
}

class DataScientist extends JobRole {
    public DataScientist(String name, int exp) {
        super(name, exp);
    }

    @Override
    public void evaluateResume() {
        System.out.println("Screening Data Scientist: " + getCandidateName() +
                " | Experience: " + getExperienceYears() + " years");
    }
}

class ProductManager extends JobRole {
    public ProductManager(String name, int exp) {
        super(name, exp);
    }

    @Override
    public void evaluateResume() {
        System.out.println("Screening Product Manager: " + getCandidateName() +
                " | Experience: " + getExperienceYears() + " years");
    }
}

// --- Generic Resume Class ---
class Resume<T extends JobRole> {
    private T jobApplicant;

    public Resume(T jobApplicant) {
        this.jobApplicant = jobApplicant;
    }

    public void processResume() {
        jobApplicant.evaluateResume();
    }

    public T getJobApplicant() {
        return jobApplicant;
    }
}

// --- Resume Screening Utility ---
class ResumeScreeningSystem {
    public static void screenAllResumes(List<? extends Resume<? extends JobRole>> resumes) {
        for (Resume<? extends JobRole> resume : resumes) {
            resume.processResume();
        }
    }
}

// --- Main Class for Demo ---
public class ResumeScreeningDemo {
    public static void main(String[] args) {
        // Sample Resumes
        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer("Alice", 3));
        Resume<DataScientist> dsResume = new Resume<>(new DataScientist("Bob", 5));
        Resume<ProductManager> pmResume = new Resume<>(new ProductManager("Charlie", 7));

        List<Resume<? extends JobRole>> resumePool = new ArrayList<>();
        resumePool.add(seResume);
        resumePool.add(dsResume);
        resumePool.add(pmResume);

        System.out.println("---- AI-Driven Resume Screening ----");
        ResumeScreeningSystem.screenAllResumes(resumePool);
    }
}
