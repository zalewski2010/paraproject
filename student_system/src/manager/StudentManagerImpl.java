package manager;

import model.Student;
import java.sql.*;
import java.util.ArrayList;

public class StudentManagerImpl implements StudentManager {
    private Connection connection;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("SQLite JDBC Driver loaded.");
        } catch (ClassNotFoundException e) {
            System.err.println("SQLite JDBC Driver not found.");
            e.printStackTrace();
        }
    }

    public StudentManagerImpl() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:src/database/students.db");
    
            if (connection != null) {
                System.out.println("Connection to SQLite has been established.");
            } else {
                System.err.println("Connection is null!");
            }
    
            Statement statement = connection.createStatement();
            String createTableSQL = "CREATE TABLE IF NOT EXISTS students (" +
                                    "name TEXT, " +
                                    "eftername TEXT, " +
                                    "age INTEGER, " +
                                    "grade REAL, " +
                                    "studentID TEXT PRIMARY KEY)";
            statement.execute(createTableSQL);
            System.out.println("Table 'students' ensured.");
        } catch (SQLException e) {
            System.err.println("SQLException occurred in constructor: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void addStudent(Student student) {
        String sql = "INSERT INTO students (name, eftername, age, grade, studentID) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getEfterName());
            pstmt.setInt(3, student.getAge());
            pstmt.setDouble(4, student.getGrade());
            pstmt.setString(5, student.getStudentID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeStudent(String studentID) {
        String sql = "DELETE FROM students WHERE studentID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, studentID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudent(String studentID, Student updatedStudent) {
        String sql = "UPDATE students SET name = ?, eftername = ?, age = ?, grade = ? WHERE studentID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, updatedStudent.getName());
            pstmt.setString(2, updatedStudent.getEfterName());
            pstmt.setInt(3, updatedStudent.getAge());
            pstmt.setDouble(4, updatedStudent.getGrade());
            pstmt.setString(5, studentID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Student> displayAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("Fetching students from the database...");
            while (rs.next()) {
                Student student = new Student(
                    rs.getString("name"),
                    rs.getString("eftername"),
                    rs.getInt("age"),
                    rs.getDouble("grade"),
                    rs.getString("studentID")
                );
                students.add(student);
                System.out.println("Fetched: " + student.getStudentID() + " - " + student.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("SQL Error: " + e.getMessage());
        }
        return students;
    }

    @Override
public double calculateAverageGrade() {
    String sql = "SELECT AVG(grade) AS averageGrade FROM students";
    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        if (rs.next()) {
            double average = rs.getDouble("averageGrade");
            if (rs.wasNull()) {  // Jeśli zapytanie zwraca NULL
                System.out.println("No grades found in the database.");
                return 0.0;
            }
            System.out.println("Calculated Average Grade: " + average);
            return average;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.err.println("SQL Error while calculating average grade: " + e.getMessage());
    }
    System.out.println("Returning 0.0 due to an error or no data.");
    return 0.0;
}
}

