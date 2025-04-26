import java.util.*;
import java.util.stream.Collectors;

public class EmployeeDataProcessing {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "Engineering", 90000),
                new Employee(2, "Bob", "Engineering", 85000),
                new Employee(3, "Carol", "HR", 75000),
                new Employee(4, "Dan", "Engineering", 81000),
                new Employee(5, "Eve", "Finance", 95000));

        List<Employee> filteredSorted = employees.stream()
                .filter(e -> e.getDepartment().equals("Engineering") && e.getSalary() > 80000)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());

        System.out.println("Filtered & Sorted Employees:");
        filteredSorted.forEach(e -> System.out.println(e.getName() + " - $" + e.getSalary()));

        Map<String, Double> avgSalaryPerDept = filteredSorted.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

        System.out.println("\nAverage Salary per Department:");
        avgSalaryPerDept.forEach((dept, avg) -> System.out.println(dept + " : $" + avg));
    }
}

@SuppressWarnings("FieldMayBeFinal")
class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}
