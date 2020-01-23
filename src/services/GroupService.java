package services;

import main.*;
import java.util.Scanner;

public class GroupService {
    private static Scanner scanner = new Scanner(System.in);


    public static void initializeStudents(int numberOfStudents, Group group) {
        int mark,numberOfSubjects;
        String subject,name;
        Student[] students = new Student[numberOfStudents];

        for (int i = 0; i < numberOfStudents ; i++) {
            System.out.print("Please enter the name of a student: ");
            name = scanner.nextLine();
            System.out.print("Please enter the number of subjects: ");
            numberOfSubjects = InputController.checkForWrongInput("subjects");
            System.out.print("Please enter the name of a subject: ");
            subject = scanner.nextLine();
            System.out.print("Please enter the mark of a subject: ");
            mark = InputController.checkForWrongInput("marks");
            students[i] = new Student.StudentBuilder(name,subject,mark).build();
            if(numberOfSubjects > 1) {
                StudentService.initializeSubjects(numberOfSubjects,students[i]);
            }
        }
        group.setStudents(students);

    }

    public static double getAveragePointOfStudent(String nameOfStudent,Student[] students) {
        int indexOfNecessaryStudent = 0;

        for (int i = 0; i < students.length; i++) {
            if (students[i].getName().equals(nameOfStudent)) {
                indexOfNecessaryStudent = i;
            }
        }
        return StudentService.getAveragePointOfStudent(students[indexOfNecessaryStudent]);
    }

    public static double getAverageOfConcreteSubject(String nameOfSubject,Student[] students) {
        double averagePointOfSubject = 0;
        int numberOfStudentsLearningSubject = 0;

        for (int i = 0; i < students.length ; i++) {
            if (StudentService.isLearning(nameOfSubject,students[i])) {
                averagePointOfSubject += StudentService.getMarkOfSubject(nameOfSubject,students[i]);
                numberOfStudentsLearningSubject++;
            }
        }
        if (numberOfStudentsLearningSubject == 0) {
            return 0;
        }
        return averagePointOfSubject/numberOfStudentsLearningSubject;
    }

    public static boolean checkForStudentsLearningSubject(String nameOfSubject,Student[] students) {
        boolean islearningSubject = false;

        for (int i = 0; i < students.length; i++) {
            if (StudentService.isLearning(nameOfSubject,students[i])) {
                islearningSubject = true;
                break;
            }
        }
        return islearningSubject;
    }
}
