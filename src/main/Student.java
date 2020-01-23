package main;

import java.util.Scanner;

class Student {
    private String name;
    private int numberOfMarks;
    private int numberOfSubjects;
    private int[] marks;
    private String[] subjects;
    private Scanner scanner = new Scanner(System.in);

    String[] getSubjects() {
        return subjects;
    }

    String getName() {
        return name;
    }

    private Student(StudentBuilder studentBuilder) {
        this.name = studentBuilder.name;
        this.numberOfMarks = studentBuilder.minimalNumberOfMarks;
        this.numberOfSubjects = studentBuilder.numberOfMandatorySubjects;
        this.marks = new int[numberOfMarks];
        this.subjects = new String[numberOfSubjects];
        this.subjects[numberOfSubjects-1] = studentBuilder.mandatorySubject;
        this.marks[numberOfMarks-1] = studentBuilder.markOfMandatorySubject;
    }

    static class StudentBuilder {
        private String name;
        private int numberOfMandatorySubjects = 1;
        private int minimalNumberOfMarks = 1;
        private String mandatorySubject;
        private int markOfMandatorySubject;


        StudentBuilder(String name, String mandatorySubject, int markOfMandatorySubject) {
            this.name = name;
            this.mandatorySubject = mandatorySubject;
            this.markOfMandatorySubject = markOfMandatorySubject;
        }

        Student build() {
            return new Student(this);
        }
    }

    int getMarkOfSubject(String subject) {
        int indexOfMarkInCorrespondingArray = -1;

        for (int i = 0; i < numberOfSubjects; i++) {
            if (subjects[i].equals(subject)) {
                indexOfMarkInCorrespondingArray = i;
            }
        }

        return marks[indexOfMarkInCorrespondingArray];
    }

    private void addMark(int mark) {
        int previousLengthOfArray = this.numberOfMarks;
        int[] temp = new int[++this.numberOfMarks];

        for (int i = 0; i < previousLengthOfArray ; i++) {
            temp[i] = this.marks[i];
        }
        temp[numberOfMarks-1] = mark;
        this.marks = temp;
    }

    private void addSubject(String subject) {
        int previousLengthOfArray = this.numberOfSubjects;
        String[] temp = new String[++this.numberOfSubjects];

        for (int i = 0; i < previousLengthOfArray ; i++) {
            temp[i] = this.subjects[i];
        }
        temp[numberOfSubjects-1] = subject;
        this.subjects = temp;
    }

    void initializeSubjects(int numberOfSubjects) {
        for (int i = 1; i < numberOfSubjects ; i++) {
            System.out.print("Please enter the name of a subject: ");
            addSubject(scanner.nextLine());
            System.out.print("Please enter the mark of a subject: ");
            addMark(InputController.checkForWrongInput("marks"));
        }
    }

    double getAveragePointOfStudent() {
        double sumOfMarks = 0 ;
        for (int i = 0; i <marks.length ; i++) {
            sumOfMarks += marks[i];
        }
        return sumOfMarks/marks.length;

    }

    boolean isLearning(String nameOfSubject) {
        boolean learns = false;

        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i].equals(nameOfSubject)) {
                learns = true;
                break;
            }
        }
        return learns;
    }
}

