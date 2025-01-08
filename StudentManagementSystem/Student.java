import java.util.Scanner;
import java.util.ArrayList;

class Student {

    ArrayList<String> studentList = new ArrayList<>(); // Use consistent variable name

    // Method to add a student
    void addStudent(Scanner Sc) {
        System.out.println("Enter Name of the Student:");
        String Input = Sc.nextLine();
        studentList.add(Input);  // Add student name to ArrayList
        System.out.println(Input + " is Added!");
    }

    // Method to view all students
    void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No Students Added Yet.");
        } else {
            System.out.println("List of Students:");
            for (String name : studentList) {
                System.out.println(name);
            }
        }
    }

    // Method to search for a student
    void searchStudent(Scanner Sc) {
        System.out.println("Enter the Name of the Student to Find:");
        String searchName = Sc.nextLine();
        if (studentList.contains(searchName)) {
            System.out.println(searchName + " is Found!");
        } else {
            System.out.println("Student Not Found.");
        }
    }

    public static void main(String[] args) {
        Student student = new Student(); // Create an instance of Student
        Scanner Sc = new Scanner(System.in); // Create a Scanner object
        int choice = 0;

        // Menu-driven loop
        while (choice != 4) {
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search For Student");
            System.out.println("4. Exit");
            System.out.println("Enter your Choice:");
            choice = Sc.nextInt();
            Sc.nextLine(); // Consume the newline character

            // Handle user choices
            if (choice == 1) {
                student.addStudent(Sc); // Call addStudent method
            } else if (choice == 2) {
                student.viewStudents(); // Call viewStudents method
            } else if (choice == 3) {
                student.searchStudent(Sc); // Call searchStudent method
            } else if (choice == 4) {
                System.out.println("Exiting the program.");
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }

        Sc.close(); // Close the Scanner
    }
}
