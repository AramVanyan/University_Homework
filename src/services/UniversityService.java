package services;

import main.Faculty;
import main.University;
import java.util.Scanner;

public class UniversityService {
    private static Scanner scanner = new Scanner(System.in);

    public static void initializeFaculties(int numberOfFaculties, University university) {
        university.setFaculties(new Faculty[numberOfFaculties]);
        Faculty[] faculties = university.getFaculties();
        for (int i = 0; i < numberOfFaculties ; i++) {
            System.out.println("Please enter the name of faculty " + (i + 1) + ": ");
            faculties[i] = new Faculty();
            faculties[i].setNameOfFaculty(scanner.next());
            System.out.print("Please enter the number of groups in faculty " + faculties[i].getNameOfFaculty() + ": ");
            FacultyService.initializeGroups(InputController.checkForWrongInput("groups"),faculties[i]);
        }
    }

    public static double getAveragePointOfStudent(String nameOfFaculty, int numberOfGroup, String nameOfStudent,Faculty[] faculties){
        int indexOfNecessaryFaculty = 0;

        for (int i = 0; i < faculties.length; i++) {
            if (faculties[i].getNameOfFaculty().equals(nameOfFaculty)) {
                indexOfNecessaryFaculty = i;
                break;
            }
        }
        return FacultyService.getAveragePointOfStudent(numberOfGroup,nameOfStudent,faculties[indexOfNecessaryFaculty].getGroups());
    }

    public static double getAverageOfConcreteSubjectOfConcreteGroup(String nameOfSubject,int numberOfGroup,
                                                      String nameOfFaculty,Faculty[] faculties){
        int indexOfNecessaryFaculty = 0;

        for (int i = 0; i < faculties.length; i++) {
            if(faculties[i].getNameOfFaculty().equals(nameOfFaculty)){
                indexOfNecessaryFaculty = i;
                break;
            }
        }
        return FacultyService.getAverageOfConcreteSubjectOfConcreteGroup(numberOfGroup,nameOfSubject,faculties[indexOfNecessaryFaculty].getGroups());
    }

    public static double getAveragePointOfSubjectForFaculty(String nameOfSubject,String nameOfFaculty,Faculty[] faculties) {
        int indexOfNecessaryFaculty = 0;

        for (int i = 0; i < faculties.length; i++) {
            if(faculties[i].getNameOfFaculty().equals(nameOfFaculty)){
                indexOfNecessaryFaculty = i;
                break;
            }
        }
        return FacultyService.getAveragePointOfSubjectForFaculty(nameOfSubject,faculties[indexOfNecessaryFaculty].getGroups());
    }

    public static double getAveragePointOfSubjectForUniversity(String nameOfSubject,Faculty[] faculties) {
        int numberOfFacultiesTeachingSubject;
        double averagePointOfSubjectForUniversity = 0;

        for (int i = 0; i < faculties.length; i++) {
            averagePointOfSubjectForUniversity += FacultyService.getAveragePointOfSubjectForFaculty(nameOfSubject,
                                                                                            faculties[i].getGroups());
        }
        numberOfFacultiesTeachingSubject = checkForNumberOfFacultiesTeachingSubject(nameOfSubject,faculties);
        if (checkForNumberOfFacultiesTeachingSubject(nameOfSubject,faculties) == 0) {
            return 0;
        }
        return averagePointOfSubjectForUniversity/numberOfFacultiesTeachingSubject;
    }

    public static int checkForNumberOfFacultiesTeachingSubject(String nameOfSubject,Faculty[] faculties) {
        int numberOfFacultiesTeachingSubject = 0;

        for (int i = 0; i < faculties.length; i++) {
            if (FacultyService.checkForNumberOfGroupsTeachingSubject(nameOfSubject,faculties[i].getGroups()) > 0) {
                numberOfFacultiesTeachingSubject++;
            }
        }
        return numberOfFacultiesTeachingSubject;
    }

}
