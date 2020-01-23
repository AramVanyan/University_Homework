package main;

import java.util.Scanner;

class University {
    private String nameOfUniversity;
    private Faculty[] faculties;
    private Scanner scanner = new Scanner(System.in);

    Faculty[] getFaculties() {
        return faculties;
    }

    String getNameOfUniversity() {
        return nameOfUniversity;
    }

    void setNameOfUniversity(String nameOfUniversity) {
        this.nameOfUniversity = nameOfUniversity;
    }

    void initializeFaculties(int numberOfFaculties) {
        faculties = new Faculty[numberOfFaculties];
        for (int i = 0; i < numberOfFaculties ; i++) {
            System.out.println("Please enter the name of faculty " + (i + 1) + ": ");
            faculties[i] = new Faculty();
            faculties[i].setNameOfFaculty(scanner.next());
            System.out.print("Please enter the number of groups in faculty " + faculties[i].getNameOfFaculty() + ": ");
            faculties[i].initializeGroups(InputController.checkForWrongInput("groups"));
        }
    }

    double getAveragePointOfStudent(String nameOfFaculty, int numberOfGroup, String nameOfStudent){
        int indexOfNecessaryFaculty = 0;

        for (int i = 0; i < faculties.length; i++) {
            if (faculties[i].getNameOfFaculty().equals(nameOfFaculty)) {
                indexOfNecessaryFaculty = i;
                break;
            }
        }
        return faculties[indexOfNecessaryFaculty].getAveragePointOfStudent(numberOfGroup,nameOfStudent);
    }

    double getAverageOfConcreteSubjectOfConcreteGroup(String nameOfSubject,int numberOfGroup,
                                                             String nameOfFaculty){
        int indexOfNecessaryFaculty = 0;

        for (int i = 0; i < faculties.length; i++) {
            if(faculties[i].getNameOfFaculty().equals(nameOfFaculty)){
                indexOfNecessaryFaculty = i;
                break;
            }
        }
        return faculties[indexOfNecessaryFaculty].getAverageOfConcreteSubjectOfConcreteGroup(numberOfGroup,
                                                                                             nameOfSubject);
    }

     double getAveragePointOfSubjectForFaculty(String nameOfSubject,String nameOfFaculty) {
        int indexOfNecessaryFaculty = 0;

        for (int i = 0; i < faculties.length; i++) {
            if(faculties[i].getNameOfFaculty().equals(nameOfFaculty)){
                indexOfNecessaryFaculty = i;
                break;
            }
        }
        return faculties[indexOfNecessaryFaculty].getAveragePointOfSubjectForFaculty(nameOfSubject);
    }

    double getAveragePointOfSubjectForUniversity(String nameOfSubject) {
        int numberOfFacultiesTeachingSubject;
        double averagePointOfSubjectForUniversity = 0;

        for (int i = 0; i < faculties.length; i++) {
            averagePointOfSubjectForUniversity += faculties[i].getAveragePointOfSubjectForFaculty(nameOfSubject);
        }
        numberOfFacultiesTeachingSubject = checkForNumberOfFacultiesTeachingSubject(nameOfSubject);
        if (checkForNumberOfFacultiesTeachingSubject(nameOfSubject) == 0) {
            return 0;
        }
        return averagePointOfSubjectForUniversity/numberOfFacultiesTeachingSubject;
    }

    private int checkForNumberOfFacultiesTeachingSubject(String nameOfSubject) {
        int numberOfFacultiesTeachingSubject = 0;

        for (int i = 0; i < faculties.length; i++) {
            if (faculties[i].checkForNumberOfGroupsTeachingSubject(nameOfSubject) > 0) {
                numberOfFacultiesTeachingSubject++;
            }
        }
        return numberOfFacultiesTeachingSubject;
    }
}
