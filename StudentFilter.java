import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentFilter {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 82),
            new Student("Bob", 68),
            new Student("Charlie", 90),
            new Student("David", 74),
            new Student("Eve", 88)
        );

        // Filter students with marks > 75, sort by marks, and display names
        List<String> topStudents = students.stream()
                .filter(s -> s.marks > 75) // Filtering
                .sorted(Comparator.comparingDouble(s -> -s.marks)) // Sorting in descending order
                .map(s -> s.name) // Extracting names
                .collect(Collectors.toList());

        System.out.println("Students scoring above 75% (sorted by marks): " + topStudents);
    }
}
