import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private String name;
    private int numberOfMarks;
    private int numberOfSubjects;
    private int[] marks;
    private String[] subjects;
    Scanner scanner = new Scanner(System.in);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Student(StudentBuilder studentBuilder) {
//        this.numberOfMarks = studentBuilder.numberOfMandatoryMarks;
//        this.numberOfSubjects = studentBuilder.numberOfMandatorySubjects;
        this.name = studentBuilder.name;
        this.numberOfMarks = studentBuilder.minimalNumberOfMarks;
        this.numberOfSubjects = studentBuilder.numberOfMandatorySubjects;
        this.marks = new int[numberOfMarks];
        this.subjects = new String[numberOfSubjects];
        this.subjects[numberOfSubjects-1] = studentBuilder.mandatorySubject;
        this.marks[numberOfMarks-1] = studentBuilder.markOfMandatorySubject;
    }

    public static class StudentBuilder {
        private String name;
        private int numberOfMandatorySubjects = 1;
        private int minimalNumberOfMarks = 1;
        private String mandatorySubject;
        private int markOfMandatorySubject;


        public StudentBuilder(String name, String mandatorySubject, int markOfMandatorySubject) {
            this.name = name;
            this.mandatorySubject = mandatorySubject;
            this.markOfMandatorySubject = markOfMandatorySubject;
        }

        public Student build() {
            Student student = new Student(this);
            return student;
        }
    }

    public int getMarkOfSubject(String subject) {
        int indexOfMarkInCorrespondingArray = -1;

        for (int i = 0; i < numberOfSubjects; i++) {
            if (subjects[i].equals(subject)) {
                indexOfMarkInCorrespondingArray = i;
            }
        }

        return marks[indexOfMarkInCorrespondingArray];
    }

    public void addMark(int mark) {
        int previousLengthOfArray = this.numberOfMarks;
        int[] temp = new int[++this.numberOfMarks];

        for (int i = 0; i < previousLengthOfArray ; i++) {
            temp[i] = this.marks[i];
        }
        temp[numberOfMarks-1] = mark;
        this.marks = temp;
    }

    public void addSubject(String subject) {
        int previousLengthOfArray = this.numberOfSubjects;
        String[] temp = new String[++this.numberOfSubjects];

        for (int i = 0; i < previousLengthOfArray ; i++) {
            temp[i] = this.subjects[i];
        }
        temp[numberOfSubjects-1] = subject;
        this.subjects = temp;
    }

    public void initializeSubjects(int numberOfSubjects) {
        for (int i = 1; i < numberOfSubjects ; i++) {
            System.out.print("Please enter the name of a subject: ");
            addSubject(scanner.nextLine());
            System.out.print("Please enter the mark of a subject: ");
            addMark(CheckForWrongInput.checkForWrongInput("marks"));
        }
    }

    public double getAveragePointOfStudent(){
        double sumOfMarks = 0 ;
        for (int i = 0; i <marks.length ; i++) {
            sumOfMarks += marks[i];
        }
        return sumOfMarks/marks.length;

    }

    public boolean isLearning(String nameOfSubject) {
        boolean learns = false;

        for (int i = 0; i < subjects.length; i++) {
            if(subjects[i].equals(nameOfSubject)) {
                learns = true;
                break;
            }
        }
        return learns;
    }

}

