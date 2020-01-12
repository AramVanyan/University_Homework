import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Group {
    private int numberOfGroup;
    private int numberOfStudents;
    private Student[] students;
    Scanner scanner = new Scanner(System.in);

    public int getNumberOfGroup() {
        return numberOfGroup;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public void setNumberOfGroup(int numberOfGroup) {
        this.numberOfGroup = numberOfGroup;
    }

    public void initializeStudents(int numberOfStudents) {
        int mark,numberOfSubjects;
        String subject,name;
        students = new Student[numberOfStudents];

        for (int i = 0; i < numberOfStudents ; i++) {
            System.out.print("Please enter the name of a student: ");
            name = scanner.nextLine();
            System.out.print("Please enter the number of subjects: ");
            numberOfSubjects = CheckForWrongInput.checkForWrongInput("subjects");
            System.out.print("Please enter the name of a subject: ");
            subject = scanner.nextLine();
            System.out.print("Please enter the mark of a subject: ");
            mark = CheckForWrongInput.checkForWrongInput("marks");
            students[i] = new Student.StudentBuilder(name,subject,mark).build();
            if(numberOfSubjects > 1) {
                students[i].initializeSubjects(numberOfSubjects);
            }
        }
    }

    public double getAveragePointOfStudent(String nameOfStudent){
        int indexOfNecessaryStudent = 0;

        for (int i = 0; i < students.length; i++) {
            if(students[i].getName().equals(nameOfStudent)) {
                indexOfNecessaryStudent = i;
            }
        }
        return students[indexOfNecessaryStudent].getAveragePointOfStudent();
    }

    public double getAverageOfConcreteSubject(String nameOfSubject) {
        double averagePointOfSubject = 0;

        for (int i = 0; i < students.length ; i++) {
            if(students[i].isLearning(nameOfSubject)){
                averagePointOfSubject += students[i].getMarkOfSubject(nameOfSubject);
            }
        }

        return averagePointOfSubject/students.length;
    }

    public boolean checkForStudentsLearningSubject(String nameOfSubject) {
        boolean learningSubject = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].isLearning(nameOfSubject)) {
                learningSubject = true;
                break;
            }
        }

        return learningSubject;
    }
}
