package model;

import java.time.LocalDateTime;

public class Student {
    private LocalDateTime creationDate;
    private String name;
    private String eftername;
    private int age;
    private double grade;
    private String studentID;

    public Student(String name, String eftername, int age, double grade, String studentID) {
        this.name = name;
        this.eftername = eftername;
        this.age = age > 0 ? age : 0; // Walidacja
        this.grade = (grade >= 0.0 && grade <= 100.0) ? grade : 0.0; // Walidacja
        
        if (studentID == null || studentID.trim().isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be null or empty.");
        }
        this.studentID = studentID;
        this.creationDate = LocalDateTime.now();
    }

    // Gettery i settery
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEfterName() { return eftername; }
    public void setEfterName(String eftername) { this.eftername = eftername; }

    public int getAge() { return age; }
    public void setAge(int age) { if (age > 0) this.age = age; }

    public double getGrade() { return grade; }
    public void setGrade(double grade) { if (grade >= 0.0 && grade <= 100.0) this.grade = grade; }

    public String getStudentID() { return studentID; }
    public void setStudentID(String studentID) { this.studentID = studentID; }

    public void displayInfo() {
        System.out.println(", Added on: " + creationDate + ", Student ID: " + studentID + ", Name: " + name + ", Efterame: " + eftername + ", Age: " + age + ", Grade: " + grade);
    }
}
