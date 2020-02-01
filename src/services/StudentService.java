package services;

import main.Student;

import java.util.Scanner;

public class StudentService {
    private static Scanner scanner = new Scanner(System.in);

    public static int getMarkOfSubject(String subject,Student student) {
        int indexOfMarkInCorrespondingArray = -1;

        for (int i = 0; i < student.getSubjects().length; i++) {
            if (student.getSubjects()[i].equals(subject)) {
                indexOfMarkInCorrespondingArray = i;
            }
        }

        return student.getMarks()[indexOfMarkInCorrespondingArray];
    }

    public static void addMark(int mark,Student student) {
        int previousLengthOfArray = student.getNumberOfMarks();
        student.setNumberOfMarks(student.getNumberOfMarks() + 1);
        int[] temp = new int[student.getNumberOfMarks()];

        for (int i = 0; i < previousLengthOfArray ; i++) {
            temp[i] = student.getMarks()[i];
        }
        temp[student.getNumberOfMarks()-1] = mark;
        student.setMarks(temp);
    }

    public static void addSubject(String subject,Student student) {
        int previousLengthOfArray = student.getNumberOfSubjects();
        student.setNumberOfSubjects(student.getNumberOfSubjects() + 1);
        String[] temp = new String[student.getNumberOfSubjects()];

        for (int i = 0; i < previousLengthOfArray ; i++) {
            temp[i] = student.getSubjects()[i];
        }
        temp[student.getNumberOfSubjects()-1] = subject;
        student.setSubjects(temp);
    }

    public static void initializeSubjects(int numberOfSubjects, Student student) {
        for (int i = 1; i < numberOfSubjects ; i++) {
            System.out.print("Please enter the name of a subject: ");
            addSubject(scanner.nextLine(),student);
            System.out.print("Please enter the mark of a subject: ");
            addMark(InputController.checkForCorrectMarksInput(),student);
        }
    }

    public static double getAveragePointOfStudent(Student student) {
        double sumOfMarks = 0 ;
        for (int i = 0; i < student.getMarks().length ; i++) {
            sumOfMarks += student.getMarks()[i];
        }
        return sumOfMarks/student.getMarks().length;

    }

    public static boolean isLearning(String nameOfSubject,Student student) {
        boolean learns = false;

        for (int i = 0; i < student.getSubjects().length; i++) {
            if (student.getSubjects()[i].equals(nameOfSubject)) {
                learns = true;
                break;
            }
        }
        return learns;
    }
}
