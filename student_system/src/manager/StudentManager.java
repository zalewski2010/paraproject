package manager;

import model.Student;
import java.util.ArrayList;

//zarządza studentami
public interface StudentManager {
    void addStudent(Student student);
    void removeStudent(String studentID);
    void updateStudent(String studentID, Student updatedStudent);
    ArrayList<Student> displayAllStudents();
    double calculateAverageGrade();
}
