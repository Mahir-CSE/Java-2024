import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GradeSheet {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input section number and teacher's name
        System.out.print("Enter Section Number: ");
        String sectionNumber = scanner.nextLine();

        System.out.print("Enter Teacher's Name: ");
        String teacherName = scanner.nextLine();

        // Input number of students
        System.out.print("Enter the total number of students: ");
        int totalStudents = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        // StringBuilder to store output for spreadsheet
        StringBuilder output = new StringBuilder();
        output.append("ID,Name,Attendance,Quiz1,Quiz2,Overall Quiz,Assignment1,Assignment2,Overall Assignment,Mid,Final,Total,Grade\n");

        // Loop for each student
        for (int i = 1; i <= totalStudents; i++) {
            System.out.println("Enter details for student " + i + ":");

            // Input student information
            System.out.print("Enter ID: ");
            String id = scanner.nextLine();

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            // Input attendance with validation
            int attendance = inputAttendance(scanner);

            // Input quiz marks with validation
            double quiz1 = inputQuizMarks(scanner, 1);
            double quiz2 = inputQuizMarks(scanner, 2);

            // Calculate best quiz marks
            double overallQuiz = calculateBestQuiz(quiz1, quiz2);

            // Input assignment marks with validation
            double assignment1 = inputAssignmentMarks(scanner, 1);
            double assignment2 = inputAssignmentMarks(scanner, 2);

            // Calculate overall assignment marks
            double overallAssignment = calculateAssignmentMarks(assignment1, assignment2);

            // Input midterm marks with validation
            double mid = inputMidMarks(scanner);

            // Input final marks with validation
            double finalMarks = inputFinalMarks(scanner);

            // Calculate total marks
            double totalMarks = attendance + overallQuiz + overallAssignment + mid + finalMarks;

            // Output student details
            System.out.println("ID: " + id + ", Name: " + name);
            System.out.println("Attendance: " + attendance + ", Quiz 1: " + (quiz1 < 0 || quiz1 > 20 ? "X" : quiz1) + ", Quiz 2: " + (quiz2 < 0 || quiz2 > 20 ? "X" : quiz2) + ", Overall Quiz: " + overallQuiz);
            System.out.println("Assignment 1: " + (assignment1 < 0 || assignment1 > 10 ? "X" : assignment1) + ", Assignment 2: " + (assignment2 < 0 || assignment2 > 10 ? "X" : assignment2) + ", Overall Assignment: " + overallAssignment);
            System.out.println("Mid: " + mid + ", Final: " + finalMarks + ", Total Marks: " + totalMarks);

            // Calculate and output grade
            System.out.print("Grade: ");
            grade(totalMarks); // Calling grade function

            // Append student info to output for spreadsheet
            output.append(id).append(",")
                    .append(name).append(",")
                    .append(attendance).append(",")
                    .append(quiz1 < 0 || quiz1 > 20 ? "X" : quiz1).append(",")
                    .append(quiz2 < 0 || quiz2 > 20 ? "X" : quiz2).append(",")
                    .append(overallQuiz).append(",")
                    .append(assignment1 < 0 || assignment1 > 10 ? "X" : assignment1).append(",")
                    .append(assignment2 < 0 || assignment2 > 10 ? "X" : assignment2).append(",")
                    .append(overallAssignment).append(",")
                    .append(mid).append(",")
                    .append(finalMarks).append(",")
                    .append(totalMarks).append(",")
                    .append(getGradeAsString(totalMarks)) // Get grade string for CSV
                    .append("\n");

            scanner.nextLine(); // Consume the newline
        }

        // Save the output to a CSV file
        saveToSpreadsheet(output.toString(), sectionNumber, teacherName);
        scanner.close();
    }

    // Function to input attendance marks with validation
    public static int inputAttendance(Scanner scanner) {
        int attendance;
        while (true) {
            System.out.print("Enter Attendance (1 to 5): ");
            attendance = scanner.nextInt();
            if (attendance >= 1 && attendance <= 5) {
                break;
            } else {
                System.out.println("Invalid input. Please enter attendance between 1 and 5.");
            }
        }
        return attendance;
    }

    // Function to input quiz marks with validation
    public static double inputQuizMarks(Scanner scanner, int quizNumber) {
        double marks;
        while (true) {
            System.out.print("Enter Quiz " + quizNumber + " marks (out of 20): ");
            marks = scanner.nextDouble();
            if (marks >= 0 && marks <= 20) {
                break;
            } else {
                System.out.println("Invalid input. Please enter marks between 0 and 20.");
            }
        }
        return marks;
    }

    // Function to input assignment marks with validation
    public static double inputAssignmentMarks(Scanner scanner, int assignmentNumber) {
        double marks;
        while (true) {
            System.out.print("Enter Assignment " + assignmentNumber + " marks (out of 10): ");
            marks = scanner.nextDouble();
            if (marks >= 0 && marks <= 10) {
                break;
            } else {
                System.out.println("Invalid input. Please enter marks between 0 and 10.");
            }
        }
        return marks;
    }

    // Function to input midterm marks with validation
    public static double inputMidMarks(Scanner scanner) {
        double mid;
        while (true) {
            System.out.print("Enter Midterm marks (out of 20): ");
            mid = scanner.nextDouble();
            if (mid >= 0 && mid <= 20) {
                break;
            } else {
                System.out.println("Invalid input. Please enter marks between 0 and 20.");
                return 0.0;
            }
        }
        return mid;
    }

    // Function to input final marks with validation
    public static double inputFinalMarks(Scanner scanner) {
        double finalMarks;
        while (true) {
            System.out.print("Enter Final marks (out of 30): ");
            finalMarks = scanner.nextDouble();
            if (finalMarks >= 0 && finalMarks <= 30) {
                break;
            } else {
                System.out.println("Invalid input. Please enter marks between 0 and 30.");
                return 0.0;
            }
        }
        return finalMarks;
    }

    // Function to calculate best quiz marks
    public static double calculateBestQuiz(double quiz1, double quiz2) {
        return Math.max(quiz1, quiz2);
    }

    // Function to calculate overall assignment marks and convert to 25
    public static double calculateAssignmentMarks(double assignment1, double assignment2) {
        double sum = assignment1 + assignment2;
        return (sum / 20) * 25; // Convert to out of 25
    }

    // Function to determine and print the grade based on total marks
    public static void grade(double totalMarks) {
        if (totalMarks >= 97 && totalMarks <= 100) {
            System.out.println("A+ (4.0) Exceptional");
        } else if (totalMarks >= 90 && totalMarks < 97) {
            System.out.println("A (4.0) Excellent");
        } else if (totalMarks >= 85 && totalMarks < 90) {
            System.out.println("A- (3.7)");
        } else if (totalMarks >= 80 && totalMarks < 85) {
            System.out.println("B+ (3.3)");
        } else if (totalMarks >= 75 && totalMarks < 80) {
            System.out.println("B (3.0) Good");
        } else if (totalMarks >= 70 && totalMarks < 75) {
            System.out.println("B- (2.7)");
        } else if (totalMarks >= 65 && totalMarks < 70) {
            System.out.println("C+ (2.3)");
        } else if (totalMarks >= 60 && totalMarks < 65) {
            System.out.println("C (2.0) Fair");
        } else if (totalMarks >= 57 && totalMarks < 60) {
            System.out.println("C- (1.7)");
        } else if (totalMarks >= 55 && totalMarks < 57) {
            System.out.println("D+ (1.3)");
        } else if (totalMarks >= 52 && totalMarks < 55) {
            System.out.println("D (1.0) Poor");
        } else if (totalMarks >= 50 && totalMarks < 52) {
            System.out.println("D- (0.7)");
        } else {
            System.out.println("F (0.0) Failure");
        }
    }

    // Function to get the grade string for saving in CSV
    public static String getGradeAsString(double totalMarks) {
        if (totalMarks >= 97 && totalMarks <= 100) {
            return "A+ (4.0) Exceptional";
        } else if (totalMarks >= 90 && totalMarks < 97) {
            return "A (4.0) Excellent";
        } else if (totalMarks >= 85 && totalMarks < 90) {
            return "A- (3.7)";
        } else if (totalMarks >= 80 && totalMarks < 85) {
            return "B+ (3.3)";
        } else if (totalMarks >= 75 && totalMarks < 80) {
            return "B (3.0) Good";
        } else if (totalMarks >= 70 && totalMarks < 75) {
            return "B- (2.7)";
        } else if (totalMarks >= 65 && totalMarks < 70) {
            return "C+ (2.3)";
        } else if (totalMarks >= 60 && totalMarks < 65) {
            return "C (2.0) Fair";
        } else if (totalMarks >= 57 && totalMarks < 60) {
            return "C- (1.7)";
        } else if (totalMarks >= 55 && totalMarks < 57) {
            return "D+ (1.3)";
        } else if (totalMarks >= 52 && totalMarks < 55) {
            return "D (1.0) Poor";
        } else if (totalMarks >= 50 && totalMarks < 52) {
            return "D- (0.7)";
        } else {
            return "F (0.0) Failure";
        }
    }

    // Function to save the output to a CSV file
    public static void saveToSpreadsheet(String data, String sectionNumber, String teacherName) {
        String fileName = "Grades_" + sectionNumber + "_" + teacherName.replaceAll(" ", "_") + ".csv";
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(data); // Write the student data
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file.");
            e.printStackTrace();
        }
    }
}
