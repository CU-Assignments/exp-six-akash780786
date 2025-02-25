import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public void display() {
        System.out.println(name + " | Age: " + age + " | Salary: $" + salary);
    }
}

public class EmployeeSorting {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, 70000),
            new Employee("Bob", 25, 50000),
            new Employee("Charlie", 35, 80000)
        );

        // Sorting by name
        employees.sort(Comparator.comparing(emp -> emp.name));
        System.out.println("Sorted by Name:");
        employees.forEach(Employee::display);

        // Sorting by age
        employees.sort(Comparator.comparingInt(emp -> emp.age));
        System.out.println("\nSorted by Age:");
        employees.forEach(Employee::display);

        // Sorting by salary
        employees.sort(Comparator.comparingDouble(emp -> emp.salary));
        System.out.println("\nSorted by Salary:");
        employees.forEach(Employee::display);
    }
}
