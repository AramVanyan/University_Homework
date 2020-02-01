package main;

import java.util.Arrays;

public class University {
    private String nameOfUniversity;
    private Faculty[] faculties;

    public void setFaculties(Faculty[] faculties) {
        this.faculties = faculties;
    }

    public Faculty[] getFaculties() {
        return faculties;
    }

    public String getNameOfUniversity() {
        return nameOfUniversity;
    }

    public void setNameOfUniversity(String nameOfUniversity) {
        this.nameOfUniversity = nameOfUniversity;
    }

    @Override
    public String toString() {
        return "University{" +
                "nameOfUniversity='" + nameOfUniversity + '\'' +
                ", faculties=" + Arrays.toString(faculties) +
                '}';
    }
}
