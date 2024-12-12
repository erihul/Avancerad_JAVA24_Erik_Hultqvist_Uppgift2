package Singleton;

import Components.Student;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class LogManager {
    // Static variable to hold the single instance of the class
    private static LogManager instance;
    // List to hold Students
    public static LinkedList<Student> studentList;
    // Format for Student table
    String printFormat = "| %-2s | %-21s | %-5s |%n";
    // Private constructor to prevent instantiation
    private LogManager()  {
       // studentMemoryList = new LinkedList<>();
        studentList = new LinkedList<>();
       try {
           readFromFile();
       } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       }
        // While loop containing Main menu (Student Manager System
        boolean running = true;
        while (running) {
            Scanner menuScanner = new Scanner(System.in);
            System.out.println("\n" + " - Student Manager System -");
            System.out.println("1. Add Student");
            System.out.println("2. Save to File");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Show Students");
            System.out.println("5. Exit");
        try {
                int menuChoice = menuScanner.nextInt();
                switch (menuChoice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        saveToFile();
                        break;
                    case 3:
                        searchStudentById();
                        break;
                    case 4:
                        showStudents();
                        break;
                    case 5:
                        System.out.println("Thank you for using the Student Manager System");
                        running = false;
                }
            } catch (Exception e) {
                System.out.println("Invalid option");
            }
        }
    }
    // Public method to get the instance of the class
    public static LogManager getInstance() {
        if(instance == null) {
            instance = new LogManager();
        }
        return instance;
    }
    // Method for saving student to memory
    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        String nameOfStudent;
        // While loop to check if user gives both first & last name
        while (true){
            System.out.print("Student name: ");
            nameOfStudent = scanner.nextLine().trim();
            // Split user input i two parts, and space is separator.
            String[] nameParts = nameOfStudent.split(" ");
            // It needs to be at least two parts
            if (nameParts.length >= 2) {
                break; // Exit the loop when the name is valid
            } else {
                System.out.println("Please enter both a first name and a last name.");
            }
        }
        // Then ask user for students grade and a question if everything looks OK
        System.out.print("Student grade: ");
        String gradeOfStudent = scanner.nextLine();
        System.out.println(nameOfStudent + " " + gradeOfStudent);
        System.out.print("Is this correct? (Y/N)");
        String answer = scanner.nextLine();
        // If OK, save student to list that holds students waiting to be saved to file
        if(answer.equalsIgnoreCase("Y")) {
            Student student = new Student(nameOfStudent, gradeOfStudent);
            studentList.add(student);
            showStudents();
        } else {
            System.out.println("Please try again");
        }
    }
    // Method to search students by their ID-number
    public void searchStudentById() {
        if (studentList.isEmpty()) {
            System.out.println("Students saved to memory is empty");
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Student ID: ");
            String studentID = scanner.nextLine();
            for(Student student : studentList) {
                // Check if id written matches a students ID in memory, and display it
                if(studentID.equals(String.valueOf(student.getId()))) {
                    System.out.println(" - Student gathered by ID -");
                    System.out.printf(printFormat, "ID", "NAME", "GRADE");
                    System.out.println("--------------------------------------");
                    System.out.printf(printFormat, student.getId(), student.getName(), student.getGrade());
                    //System.out.println(student.getUniqueId() + " " + student.getName() + " " + student.getGrade() + "\n");
                }
            }
        }
    }
    // Saves students from Memory(studentList) to file
    public void saveToFile() {
        // Check if there is any students in list
        if (studentList.isEmpty()) {
            System.out.println("StudentList is empty");
        } else {

            try{
            FileWriter writer = new FileWriter("./src/main/java/StudentFiles/StudentData.txt", false);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            for (Student student : studentList) {
                bufferWriter.write(student.getId() + " " + student.getName() + " " + student.getGrade() + "\n");
            }
                bufferWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    // Method that prints List
    public void showStudents() {
            System.out.println(" - Studentlist -");
            System.out.printf(printFormat, "ID", "NAME", "GRADE");
            System.out.println("--------------------------------------");
        for (Student student : studentList) {
            System.out.printf(printFormat, student.getId(), student.getName(), student.getGrade());
        }
    }

    // Adds Students saved to file to a List
    public void readFromFile() throws FileNotFoundException {
        FileReader reader = new FileReader("./src/main/java/StudentFiles/StudentData.txt");
        try(BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            // Reads from file and divides the text into int and Strings.
            while ((line = bufferedReader.readLine()) != null){
                String[] studentData = line.split(" ");
                studentList.add(new Student(Integer.parseInt(studentData[0]),studentData[1] + " " + studentData[2], studentData[3]));
            }
            // runs Method showStudent to display
            showStudents();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}