import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestGUI {

    private static int totalStudents = 0; // Track the number of students
    private static StringBuilder output = new StringBuilder(); // Store all outputs for saving to CSV
    private static String lastFileName = ""; // Track the last saved filename
    private static String lastSection = ""; // Track the last section number
    private static String lastTeacher = ""; // Track the last teacher name

    public static void main(String[] args) {
        JFrame frame = new JFrame("Prepare Gradesheet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(new GridLayout(0, 2));

        // Add input fields
        String[] sections = {"Select Section", "01", "02", "03", "04", "05"}; // Dropdown options
        JComboBox<String> sectionDropdown = new JComboBox<>(sections);
        JTextField teacherField = new JTextField();
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField attendanceField = new JTextField();
        JTextField quiz1Field = new JTextField();
        JTextField quiz2Field = new JTextField();
        JTextField assignment1Field = new JTextField();
        JTextField assignment2Field = new JTextField();
        JTextField midField = new JTextField();
        JTextField finalField = new JTextField();
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);

        frame.add(new JLabel("Section Number:"));
        frame.add(sectionDropdown);
        frame.add(new JLabel("Teacher's Name:"));
        frame.add(teacherField);
        frame.add(new JLabel("ID:"));
        frame.add(idField);
        frame.add(new JLabel("Name:"));
        frame.add(nameField);
        frame.add(new JLabel("Attendance (1-5):"));
        frame.add(attendanceField);
        frame.add(new JLabel("Quiz 1 Marks (0-20):"));
        frame.add(quiz1Field);
        frame.add(new JLabel("Quiz 2 Marks (0-20):"));
        frame.add(quiz2Field);
        frame.add(new JLabel("Assignment 1 Marks (0-10):"));
        frame.add(assignment1Field);
        frame.add(new JLabel("Assignment 2 Marks (0-10):"));
        frame.add(assignment2Field);
        frame.add(new JLabel("Midterm Marks (0-20):"));
        frame.add(midField);
        frame.add(new JLabel("Final Marks (0-30):"));
        frame.add(finalField);

        JButton submitButton = new JButton("Submit");
        JButton saveButton = new JButton("Save to CSV");
        frame.add(submitButton);
        frame.add(saveButton);
        frame.add(new JLabel("Output:"));
        frame.add(new JScrollPane(outputArea));

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Increment student count
                    totalStudents++;

                    // Collect and validate inputs
                    String sectionNumberInput = (String) sectionDropdown.getSelectedItem();
                    String teacherNameInput = teacherField.getText();
                    String id = idField.getText();
                    String name = nameField.getText();
                    int attendance = Integer.parseInt(attendanceField.getText());
                    double quiz1 = Double.parseDouble(quiz1Field.getText());
                    double quiz2 = Double.parseDouble(quiz2Field.getText());
                    double assignment1 = Double.parseDouble(assignment1Field.getText());
                    double assignment2 = Double.parseDouble(assignment2Field.getText());
                    double mid = Double.parseDouble(midField.getText());
                    double finalMarks = Double.parseDouble(finalField.getText());

                    // Validate inputs
                    if (attendance < 1 || attendance > 5 || quiz1 < 0 || quiz1 > 20 || quiz2 < 0 || quiz2 > 20 ||
                            assignment1 < 0 || assignment1 > 10 || assignment2 < 0 || assignment2 > 10 ||
                            mid < 0 || mid > 20 || finalMarks < 0 || finalMarks > 30) {
                        JOptionPane.showMessageDialog(frame, "Invalid input. Please check your values.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Calculate overall marks
                    double overallQuiz = Math.max(quiz1, quiz2);
                    double overallAssignment = (assignment1 + assignment2) / 20 * 25; // Convert to out of 25
                    double totalMarks = attendance + overallQuiz + overallAssignment + mid + finalMarks;

                    // Generate output
                    String grade = getGradeAsString(totalMarks);
                    String studentOutput = String.format("ID: %s, Name: %s, Attendance: %d, Quiz 1: %.1f, Quiz 2: %.1f, Overall Quiz: %.1f, Assignment 1: %.1f, Assignment 2: %.1f, Overall Assignment: %.1f, Mid: %.1f, Final: %.1f, Total Marks: %.1f, Grade: %s\n",
                            id, name, attendance, quiz1, quiz2, overallQuiz, assignment1, assignment2, overallAssignment, mid, finalMarks, totalMarks, grade);
                    outputArea.append(studentOutput);

                    // Store data in the output StringBuilder
                    output.append(String.format("%s,%s,%d,%.1f,%.1f,%.1f,%.1f,%.1f,%.1f,%.1f,%.1f,%.1f,%s\n",
                            id, name, attendance, quiz1, quiz2, overallQuiz, assignment1, assignment2, overallAssignment, mid, finalMarks, totalMarks, grade));

                    // Clear input fields for next entry
                    idField.setText("");
                    nameField.setText("");
                    attendanceField.setText("");
                    quiz1Field.setText("");
                    quiz2Field.setText("");
                    assignment1Field.setText("");
                    assignment2Field.setText("");
                    midField.setText("");
                    finalField.setText("");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid number format. Please check your input.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get section and teacher name
                String sectionNumberInput = (String) sectionDropdown.getSelectedItem();
                String teacherNameInput = teacherField.getText();
                String fileName = sectionNumberInput + "_" + teacherNameInput.replaceAll(" ", "_") + ".csv";

                // Check if file exists
                File file = new File(fileName);
                boolean fileExists = file.exists();

                // Save to CSV
                saveToSpreadsheet(output.toString(), fileName, fileExists);
                if (fileExists) {
                    JOptionPane.showMessageDialog(frame, "Data appended to " + fileName, "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "New file created: " + fileName, "Success", JOptionPane.INFORMATION_MESSAGE);
                }

                // Reset for new entries
                output.setLength(0); // Clear the output for new file
                totalStudents = 0; // Reset student count for new file
            }
        });

        frame.setVisible(true);
    }

    // Function to get the grade string based on total marks
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
    public static void saveToSpreadsheet(String data, String fileName, boolean fileExists) {
        boolean append = fileExists; // Check if the file exists
        try (FileWriter fileWriter = new FileWriter(fileName, append)) {
            // Write header only if creating a new file
            if (!fileExists) {
                fileWriter.write("ID,Name,Attendance,Quiz 1,Quiz 2,Overall Quiz,Assignment 1,Assignment 2,Overall Assignment,Mid,Final,Total Marks,Grade\n");
            }
            fileWriter.write(data); // Write the student data
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file.");
            e.printStackTrace();
        }
    }
}
