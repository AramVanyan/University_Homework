package main;

import java.util.Arrays;

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

    @Override
    public String toString() {
        return "Group{" +
                "numberOfGroup=" + numberOfGroup +
                ", students=" + Arrays.toString(students) +
                '}';
    }
}
