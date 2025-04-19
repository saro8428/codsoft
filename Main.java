import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();
        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Enter a valid number: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll Number: ");
                    String roll = scanner.nextLine().trim();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine().trim();
                    System.out.print("Enter Grade: ");
                    String grade = scanner.nextLine().trim();

                    if (roll.isEmpty() || name.isEmpty() || grade.isEmpty()) {
                        System.out.println("❌ All fields are required.");
                    } else {
                        sms.addStudent(new Student(name, roll, grade));
                    }
                    break;
                case 2:
                    System.out.print("Enter Roll Number to edit: ");
                    String editRoll = scanner.nextLine().trim();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine().trim();
                    System.out.print("Enter new grade: ");
                    String newGrade = scanner.nextLine().trim();
                    sms.editStudent(editRoll, newName, newGrade);
                    break;
                case 3:
                    System.out.print("Enter Roll Number to remove: ");
                    String removeRoll = scanner.nextLine().trim();
                    sms.removeStudent(removeRoll);
                    break;
                case 4:
                    System.out.print("Enter Roll Number to search: ");
                    String searchRoll = scanner.nextLine().trim();
                    sms.searchStudent(searchRoll);
                    break;
                case 5:
                    sms.displayAllStudents();
                    break;
                case 6:
                    System.out.println("👋 Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("❗ Invalid choice. Try again.");
            }

        } while (choice != 6);

        scanner.close();
    }
}
