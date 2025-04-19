import java.io.*;
import java.util.*;

public class StudentManagementSystem {
    private List<Student> students;
    private final String FILE_NAME = "students.txt";

    public StudentManagementSystem() {
        students = new ArrayList<>();
        loadStudents();
    }

    public void addStudent(Student student) {
        if (getStudentByRoll(student.getRollNumber()) != null) {
            System.out.println("❌ Student with this roll number already exists.");
            return;
        }
        students.add(student);
        saveStudents();
        System.out.println("✅ Student added successfully!");
    }

    public void removeStudent(String rollNumber) {
        Student student = getStudentByRoll(rollNumber);
        if (student != null) {
            students.remove(student);
            saveStudents();
            System.out.println("✅ Student removed.");
        } else {
            System.out.println("❌ Student not found.");
        }
    }

    public void searchStudent(String rollNumber) {
        Student student = getStudentByRoll(rollNumber);
        if (student != null) {
            System.out.println("🔍 Student Found:");
            System.out.println("Name: " + student.getName());
            System.out.println("Roll Number: " + student.getRollNumber());
            System.out.println("Grade: " + student.getGrade());
        } else {
            System.out.println("❌ Student not found.");
        }
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        System.out.println("\n📋 Student List:");
        for (Student s : students) {
            System.out.println(s.getRollNumber() + " | " + s.getName() + " | " + s.getGrade());
        }
    }

    public void editStudent(String rollNumber, String newName, String newGrade) {
        Student student = getStudentByRoll(rollNumber);
        if (student != null) {
            student.setName(newName);
            student.setGrade(newGrade);
            saveStudents();
            System.out.println("✅ Student info updated.");
        } else {
            System.out.println("❌ Student not found.");
        }
    }

    private Student getStudentByRoll(String rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber().equalsIgnoreCase(rollNumber)) {
                return s;
            }
        }
        return null;
    }

    private void loadStudents() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                students.add(Student.fromString(data));
            }
        } catch (IOException e) {
            System.out.println("Error loading students.");
        }
    }

    private void saveStudents() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                writer.println(s.toString());
            }
        } catch (IOException e) {
            System.out.println("Error saving students.");
        }
    }
}
