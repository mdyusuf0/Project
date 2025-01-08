import java.util.Scanner;
import java.util.ArrayList;

class StudentDetails {
    private String name;
    private int age;
    private String grade;
    private String enrolmentNumber;

    // Constructor to initialize student details
    public StudentDetails(String name, String enrolmentNumber, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.enrolmentNumber = enrolmentNumber;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getRoll() {
        return enrolmentNumber;
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }
}

class Student {
    ArrayList<StudentDetails> studentList = new ArrayList<>(); // Student list

    // Method to add a student
    void addStudent(Scanner sc) {
        System.out.println("Enter Name of the Student:");
        String name = sc.nextLine();
        System.out.println("Enter Enrolment Number of the Student:");
        String enrolmentNumber = sc.nextLine();
        System.out.println("Enter Age of the Student:");
        int age = sc.nextInt();
        sc.nextLine(); // Consume newline character
        System.out.println("Enter Grade of the Student:");
        String grade = sc.nextLine();

        StudentDetails student = new StudentDetails(name, enrolmentNumber, age, grade);
        studentList.add(student); // Add object to ArrayList
        System.out.println(name + " has been added!");
    }

    // Method to view all students
    void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No Students Added Yet.");
        } else {
            System.out.println("List of Students:");
            for (StudentDetails student : studentList) {
                printStudentDetails(student);
            }
        }
    }

    // Method to search for a student
    void searchStudent(Scanner sc) {
        if (studentList.isEmpty()) {
            System.out.println("No Students Added Yet.");
            return;
        }
        System.out.println("Search By:");
        System.out.println("1. Name");
        System.out.println("2. Enrollment Number");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline character

        boolean found = false;

        switch (choice) {
            case 1:
                System.out.println("Enter Name of Student:");
                String searchName = sc.nextLine();
                for (StudentDetails student : studentList) {
                    if (student.getName().equalsIgnoreCase(searchName)) {
                        printStudentDetails(student);
                        found = true;
                    }
                }
                break;

            case 2:
                System.out.println("Enter the Enrollment Number of the Student:");
                String searchEnroll = sc.nextLine();
                for (StudentDetails student : studentList) {
                    if (student.getRoll().equalsIgnoreCase(searchEnroll)) {
                        printStudentDetails(student);
                        found = true;
                    }
                }
                break;

            default:
                System.out.println("Invalid choice.");
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    // Method to print student details
    void printStudentDetails(StudentDetails student) {
        System.out.println("Name: " + student.getName());
        System.out.println("Enrollment Number: " + student.getRoll());
        System.out.println("Age: " + student.getAge());
        System.out.println("Grade: " + student.getGrade());
        System.out.println("------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student(); // Create an instance of Student
        Scanner sc = new Scanner(System.in); // Create a Scanner object
        int choice = 0;

        // Menu-driven loop
        while (choice != 4) {
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search For Student");
            System.out.println("4. Exit");
            System.out.print("Enter your Choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            // Handle user choices
            switch (choice) {
                case 1:
                    student.addStudent(sc);
                    break;
                case 2:
                    student.viewStudents();
                    break;
                case 3:
                    student.searchStudent(sc);
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        sc.close(); // Close the Scanner
    }
}
