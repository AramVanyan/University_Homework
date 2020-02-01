package main;

import java.util.Arrays;

public class Faculty {
    private String nameOfFaculty;
    private int numberOfGroups;
    private Group[] groups;

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    public String getNameOfFaculty() {
        return nameOfFaculty;
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setNumberOfGroups(int numberOfGroups) {
        this.numberOfGroups = numberOfGroups;
    }

    public void setNameOfFaculty(String nameOfFaculty) {
        this.nameOfFaculty = nameOfFaculty;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "nameOfFaculty='" + nameOfFaculty + '\'' +
                ", numberOfGroups=" + numberOfGroups +
                ", groups=" + Arrays.toString(groups) +
                '}';
    }
}
