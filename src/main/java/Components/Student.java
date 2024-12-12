package Components;

import static Singleton.LogManager.studentList;


public class Student {
    // static variable with starting int 1
    private int id = 1;
    String name;
    String grade;
    String printFormat = "| %-2s | %-21s | %-5s |%n";
    // First Student-Constructor, used when reading from .txt to memory,  that initialize Id, Name and Grade for every student created
    public Student(int id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
    //constructor overloading, Student that's used when creating a new student.
    public Student(String name, String grade) {
        // Students Id, gathered via method: getLastSavedUniqueId
        this.id = getLastSavedUniqueId();
        this.name = name;
        this.grade = grade;
        System.out.printf("\n" + printFormat, "ID", "NAME", "GRADE");
        System.out.println("--------------------------------------");
        System.out.printf(printFormat, this.id, this.name, this.grade);
        System.out.println("--------------------------------------");
        System.out.println("Student added. Save before shutting down to keep student in system.");
    }
    // Method to read how many students there is in memory and adds 1
    public static int getLastSavedUniqueId() {
        return studentList.size() + 1;
    }
    public String getName() {
        return name;
    }
    public String getGrade() {
        return grade;
    }
    public int getId() {
        return id;
    }
}
