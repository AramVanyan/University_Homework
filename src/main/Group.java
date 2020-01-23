package main;

public class Group {
    private int numberOfGroup;
    private Student[] students;

    public Student[] getStudents() {
        return students;
    }

    public int getNumberOfGroup() {
        return numberOfGroup;
    }

    public void setNumberOfGroup(int numberOfGroup) {
        this.numberOfGroup = numberOfGroup;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
}
