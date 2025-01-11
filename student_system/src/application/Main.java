package application;

import gui.StudentManagementSystem;

public class Main {
    public static void main(String[] args) {
        // Uruchamia GUI
        javax.swing.SwingUtilities.invokeLater(() -> {
            new StudentManagementSystem().createAndShowGUI();
        });
    }
}
