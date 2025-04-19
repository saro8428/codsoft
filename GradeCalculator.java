import java.util.Scanner;
class GradeCalculator {

    // Method to input marks
    public static double[] inputMarks(int subjectCount, Scanner scanner) {
        double[] marks = new double[subjectCount];
        for (int i = 0; i < subjectCount; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextDouble();
        }
        return marks;
    }

    // Method to calculate total
    public static double calculateTotal(double[] marks) {
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return total;
    }

    // Method to calculate grade
    public static String getGrade(double percentage) {
        if (percentage >= 90) return "A+";
        else if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 50) return "D";
        else return "F";
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int subjectCount = scanner.nextInt();

        double[] marks = inputMarks(subjectCount, scanner);
        double total = calculateTotal(marks);
        double percentage = total / subjectCount;

        String grade = getGrade(percentage);

        // Display result
        System.out.println("\n--- Result Summary ---");
        System.out.printf("Total Marks: %.2f / %.2f\n", total, subjectCount * 100.0);
        System.out.printf("Average Percentage: %.2f%%\n", percentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
