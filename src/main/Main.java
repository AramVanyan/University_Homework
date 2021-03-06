package main;

import java.util.Scanner;
import services.*;

public class Main {
    public static void main(String[] args) {
        String nameOfFaculty;
        int numberOfGroup;
        String nameOfSubject;
        String nameOfStudent;
        boolean isProgramContinuing = true;
        Scanner scanner = new Scanner(System.in);
        University university = new University();


        System.out.print("Please enter the name of university: ");
        university.setNameOfUniversity(scanner.nextLine());
        System.out.print("Please enter the number of faculties in university: ");
        UniversityService.initializeFaculties(InputController.checkForWrongInput("faculties"),
                                                                                  university);
        System.out.println();


        while (isProgramContinuing) {
            int action;
            System.out.println("What you want to do");
            System.out.println("1:Get the average point of a student");
            System.out.println("2:Get the average point for concrete subject in concrete group");
            System.out.println("3:Get the average point for concrete subject in concrete faculty");
            System.out.println("4:Get the average point for concrete subject in university");
            System.out.println("5:Stop the program");
            System.out.println();
            try {
                action = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException exception) {
                System.out.println("Please write a number: ");
                continue;
            }
            System.out.println();

            switch (action){
                case 1:
                    System.out.println("Enter the name of faculty: ");
                    nameOfFaculty = scanner.nextLine();
                    if(!InputController.checkForFacultyExistence(university.getFaculties(),nameOfFaculty)) {
                        System.out.println("There is no faculty with name " + nameOfFaculty);
                        break;
                    }
                    System.out.println("Enter the number of group: ");
                    numberOfGroup = InputController.checkForWrongInput();
                    if(!InputController.checkForGroupExistence(numberOfGroup,nameOfFaculty,
                                                                  university.getFaculties())) {
                        System.out.println("There is no number " + numberOfGroup + " group in faculty "
                                            + nameOfFaculty);
                        break;
                    }
                    System.out.println("Enter the name of student: ");
                    nameOfStudent = scanner.nextLine();
                    if(!InputController.checkForStudentExistence(nameOfStudent,numberOfGroup,university.getFaculties(),
                                                                 nameOfFaculty)) {
                        System.out.println("There is no student with name " + nameOfStudent + " in group "
                                            + numberOfGroup + " in faculty " + nameOfFaculty);
                        break;
                    }
                    System.out.println("average point of student is ");
                    System.out.println(UniversityService.getAveragePointOfStudent(nameOfFaculty,numberOfGroup,
                                                                                   nameOfStudent,
                                                                                   university.getFaculties()));
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Enter the name of faculty: ");
                    nameOfFaculty = scanner.nextLine();
                    if(!InputController.checkForFacultyExistence(university.getFaculties(),nameOfFaculty)) {
                        System.out.println("There is no faculty with name " + nameOfFaculty);
                        break;
                    }
                    System.out.println("Enter the number of group: ");
                    numberOfGroup = InputController.checkForWrongInput();
                    if(!InputController.checkForGroupExistence(numberOfGroup,nameOfFaculty,
                            university.getFaculties())) {
                        System.out.println("There is no number " + numberOfGroup + "group in faculty" + nameOfFaculty);
                    }
                    System.out.println("Enter the name of subject: ");
                    nameOfSubject = scanner.nextLine();
                    if(!InputController.checkForSubjectExistence(nameOfSubject,numberOfGroup,university.getFaculties(),
                                                                nameOfFaculty)) {
                        System.out.println("There is no subject with name " + nameOfSubject);
                        break;
                    }
                    System.out.print("average point of subject in group is ");
                    System.out.println(UniversityService.getAverageOfConcreteSubjectOfConcreteGroup(nameOfSubject,
                                                                                                     numberOfGroup,
                                                                                                     nameOfFaculty,
                                                                                                     university
                                                                                                     .getFaculties()));
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Enter the name of faculty: ");
                    nameOfFaculty = scanner.nextLine();
                    if(!InputController.checkForFacultyExistence(university.getFaculties(),nameOfFaculty)) {
                        System.out.println("There is no faculty with name " + nameOfFaculty);
                        break;
                    }
                    System.out.println("Enter the name of subject: ");
                    nameOfSubject = scanner.nextLine();
                    if(!InputController.checkForSubjectExistence(nameOfSubject,university.getFaculties(),
                                                                    nameOfFaculty)) {
                        System.out.println("There is no subject with name " + nameOfSubject);
                        break;
                    }
                    System.out.print("average point of subject in faculty is ");
                    System.out.println(UniversityService.getAveragePointOfSubjectForFaculty(nameOfSubject,nameOfFaculty,
                                                                                            university.getFaculties()));
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Enter the name of subject: ");
                    nameOfSubject = scanner.nextLine();
                    if(!InputController.checkForSubjectExistence(nameOfSubject,university.getFaculties())) {
                        System.out.println("There is no subject with name " + nameOfSubject);
                        break;
                    }
                    System.out.print("average point of subject in university is ");
                    System.out.println(UniversityService.getAveragePointOfSubjectForUniversity(nameOfSubject,
                                                                                            university.getFaculties()));
                    System.out.println();
                    break;
                case 5:
                    isProgramContinuing = false;
                    System.out.println("Bye " + university.getNameOfUniversity());
                    System.out.println("Program is stopped");
                    break;
                default:
                    System.out.println("Please write a correct number");
            }
        }
    }
}
