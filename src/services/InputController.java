package services;

import custom_exceptions.*;
import main.Faculty;
import java.util.Scanner;

public class InputController {
    private static Scanner scanner = new Scanner(System.in);
    private static int input;

    public static int checkForWrongInput(String nameOfSpecificGroup){
        while(true){
            try {
                input = Integer.parseInt(scanner.nextLine());
                    if (input <= 0 && !(nameOfSpecificGroup.equals("marks"))) {
                        System.out.println("Number of " + nameOfSpecificGroup + " must be greater than 0");
                        System.out.print("Try again: ");
                        continue;
                    }
                    return input;
            } catch (NumberFormatException e) {
                System.out.print("Please enter a number: ");
            }
        }
    }

    public static int checkForCorrectMarksInput() {
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input < 0 || input > 10) {
                    System.out.println("mark should be in range of 0-10: ");
                }
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number: ");
            }
        }
    }

    public static int checkForWrongInput() {
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.out.print("Please enter a number: ");
            }
        }
    }

    public static boolean checkForFacultyExistence(Faculty[] faculties, String nameOfFaculty) {
        if (faculties == null) {
            return false;
        }
        for (int i = 0; i < faculties.length; i++) {
            if (faculties[i].getNameOfFaculty().equals(nameOfFaculty)) {
                return true;
            }
        }
        throw new NoFacultyException("NoFacultyException");
    }

    public static boolean checkForGroupExistence(int numberOfGroup, String nameOfFaculty,
                                          Faculty[] faculties) {
        if (faculties == null) {
            return false;
        }
        for (int i = 0; i < faculties.length; i++) {
            if (faculties[i].getNameOfFaculty().equals(nameOfFaculty)) {
                for (int j = 0; j < faculties[i].getGroups().length; j++) {
                    if (faculties[i].getGroups()[j].getNumberOfGroup() == numberOfGroup) {
                        return true;
                    }
                }
            }
        }
        throw new NoGroupException("NoGroupException");
    }

    public static boolean checkForStudentExistence(String nameOfStudent, int numberOfGroup, Faculty[] faculties,
                                            String nameOfFaculty) {
        if (faculties == null) {
            return false;
        }
        for (int i = 0; i < faculties.length; i++) {
            if (faculties[i].getNameOfFaculty().equals(nameOfFaculty)) {
                for (int j = 0; j < faculties[i].getGroups().length; j++) {
                    if(faculties[i].getGroups()[j].getNumberOfGroup() == numberOfGroup) {
                        for (int k = 0; k < faculties[i].getGroups()[j].getStudents().length; k++) {
                            if (faculties[i].getGroups()[j].getStudents()[k].getName().equals(nameOfStudent)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        throw new NoStudentException("NoStudentException");
    }

    public static boolean checkForSubjectExistence(String nameOfSubject, int numberOfGroup, Faculty[] faculties,
                                            String nameOfFaculty) {
        if (faculties == null) {
            return false;
        }
        for (int i = 0; i < faculties.length; i++) {
            if (faculties[i].getNameOfFaculty().equals(nameOfFaculty)) {
                for (int j = 0; j < faculties[i].getGroups().length; j++) {
                    if(faculties[i].getGroups()[j].getNumberOfGroup() == numberOfGroup) {
                        for (int k = 0; k < faculties[i].getGroups()[j].getStudents().length; k++) {
                                for (int l = 0; l < faculties[i].getGroups()[j].getStudents()[k].getSubjects().length;
                                     l++) {
                                    if(faculties[i].getGroups()[j].getStudents()[k].getSubjects()[l]
                                            .equals(nameOfSubject)) {
                                        return true;
                                    }
                                }
                        }
                    }
                }
            }
        }
        throw new NoSubjectException("NoSubjectException");
    }

    public static boolean checkForSubjectExistence(String nameOfSubject, Faculty[] faculties,
                                            String nameOfFaculty) {
        if (faculties == null) {
            return false;
        }
        for (int i = 0; i < faculties.length; i++) {
            if (faculties[i].getNameOfFaculty().equals(nameOfFaculty)) {
                for (int j = 0; j < faculties[i].getGroups().length; j++) {
                        for (int k = 0; k < faculties[i].getGroups()[j].getStudents().length; k++) {
                            for (int l = 0; l < faculties[i].getGroups()[j].getStudents()[k].getSubjects().length;
                                 l++) {
                                if(faculties[i].getGroups()[j].getStudents()[k].getSubjects()[l]
                                        .equals(nameOfSubject)) {
                                    return true;
                                }
                            }
                        }
                }
            }
        }
        throw new NoSubjectException("NoSubjectException");
    }

    public static boolean checkForSubjectExistence(String nameOfSubject, Faculty[] faculties) {
        if (faculties == null) {
            return false;
        }
        for (int i = 0; i < faculties.length; i++) {
                for (int j = 0; j < faculties[i].getGroups().length; j++) {
                    for (int k = 0; k < faculties[i].getGroups()[j].getStudents().length; k++) {
                        for (int l = 0; l < faculties[i].getGroups()[j].getStudents()[k].getSubjects().length;
                             l++) {
                            if(faculties[i].getGroups()[j].getStudents()[k].getSubjects()[l]
                                    .equals(nameOfSubject)) {
                                return true;
                            }
                        }
                    }
                }
        }
        throw new NoSubjectException("NoSubjectException");
    }
}
