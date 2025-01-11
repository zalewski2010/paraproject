package gui;

import manager.StudentManagerImpl;
import model.Student;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentManagementSystem {
    private StudentManagerImpl manager = new StudentManagerImpl();

    public static void main(String[] args) {
        new StudentManagementSystem().createAndShowGUI();
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 10, 10)); // 6 wierszy, 2 kolumny, odstępy między komponentami(10,10)

        JLabel lblID = new JLabel("Student ID:");
        JTextField txtID = new JTextField(15);

        JLabel lblName = new JLabel("Name:");
        JTextField txtName = new JTextField();

        JLabel lblEfterName = new JLabel("Eftername:");
        JTextField txtEfterName = new JTextField();

        JLabel lblAge = new JLabel("Age:");
        JTextField txtAge = new JTextField();

        JLabel lblGrade = new JLabel("Grade:");
        JTextField txtGrade = new JTextField();

        JButton btnAdd = new JButton("Add Student");
        JTextArea outputArea = new JTextArea();

        JButton btnRemove = new JButton("Remove Student");
        JButton btnUpdate = new JButton("Update Student");
        JButton btnDisplayAll = new JButton("Display All Students");
        JButton btnCalculateAverage = new JButton("Calculate Average");

        btnAdd.addActionListener(e -> {
            try {
                String id = txtID.getText();
                String name = txtName.getText();
                String eftername = txtEfterName.getText();
                int age = Integer.parseInt(txtAge.getText());
                double grade = Double.parseDouble(txtGrade.getText());
        
                // Debugowanie danych wejściowych
                System.out.println("Adding Student: " + id + ", " + name + ", " + eftername + ", " + age + ", " + grade);
        
                manager.addStudent(new Student(name, eftername, age, grade, id));
                outputArea.setText("Student added successfully!");
            } catch (NumberFormatException ex) {
                outputArea.setText("Invalid input: Age must be an integer, Grade must be a number.");
                ex.printStackTrace();
            } catch (Exception ex) {
                outputArea.setText("An error occurred while adding the student.");
                ex.printStackTrace();
            }
        });

        // remove student
        btnRemove.addActionListener(e -> {
            String id = txtID.getText().trim();
            if (!id.isEmpty()) {
                manager.removeStudent(id);
                outputArea.setText("Student with ID " + id + " removed successfully.");
            } else {
                outputArea.setText("Please enter a valid Student ID to remove.");
            }
        });

        //update student
        btnUpdate.addActionListener(e -> {
            try {
                String id = txtID.getText().trim();
                String name = txtName.getText().trim();
                String eftername = txtEfterName.getText().trim();
                int age = Integer.parseInt(txtAge.getText().trim());
                double grade = Double.parseDouble(txtGrade.getText().trim());

                manager.updateStudent(id, new Student(name, eftername, age, grade, id));
                outputArea.setText("Student with ID " + id + " updated successfully.");
            } catch (NumberFormatException ex) {
                outputArea.setText("Invalid input: Age must be an integer, Grade must be a number.");
            } catch (Exception ex) {
                outputArea.setText("An error occurred: " + ex.getMessage());
                ex.printStackTrace();
            }
        });

        //display all students
        btnDisplayAll.addActionListener(e -> {
            ArrayList<Student> students = manager.displayAllStudents();
            StringBuilder result = new StringBuilder("All Students:\n");
            for (Student student : students) {
                result.append("ID: ").append(student.getStudentID()).append(", ")
                      .append("Name: ").append(student.getName()).append(" ")
                      .append(student.getEfterName()).append(", ")
                      .append("Age: ").append(student.getAge()).append(", ")
                      .append("Grade: ").append(student.getGrade()).append("\n");
            }
            if (students.isEmpty()) {
                result.append("No students found in the database.");
            }
            outputArea.setText(result.toString());
        });


        panel.add(lblID);
        panel.add(txtID);
        panel.add(lblName);
        panel.add(txtName);
        panel.add(lblEfterName);
        panel.add(txtEfterName);
        panel.add(lblAge);
        panel.add(txtAge);
        panel.add(lblGrade);
        panel.add(txtGrade);
        panel.add(btnAdd);
        panel.add(btnRemove);
        panel.add(btnUpdate);
        panel.add(btnDisplayAll);
        panel.add(btnCalculateAverage);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(new JScrollPane(outputArea), BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}