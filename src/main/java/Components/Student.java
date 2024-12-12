package Components;

import static Singleton.LogManager.studentList;


public class Student {
    // static variable with starting int 1
    private  int id = 1;
    String name;
    String grade;

    // Constructor that initialize UniqueID, Name and Grade for every student created
    public Student(int id, String name, String grade) /*throws IOException*/ {
        // Students unique ID, from int id
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
    public Student( String name, String grade) {
        // Students unique ID, from int id
        this.id = getLastSavedUniqueId();
        System.out.println(this.id +" is the new students id!!!");
        this.name = name;
        this.grade = grade;
    }
    public String getName() {
        return name;
    }
    public String getGrade() {
        return grade;
    }
    // Method to read what the last saved id is in file
    public static int getLastSavedUniqueId() {
        return studentList.size() + 1;
    }
    public int getId() {
        return id;
    }
}
