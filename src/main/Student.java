package main;

public class Student {
    private String name;
    private int numberOfMarks;
    private int numberOfSubjects;
    private int[] marks;
    private String[] subjects;

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfMarks() {
        return numberOfMarks;
    }

    public void setNumberOfMarks(int numberOfMarks) {
        this.numberOfMarks = numberOfMarks;
    }

    public int getNumberOfSubjects() {
        return numberOfSubjects;
    }

    public void setNumberOfSubjects(int numberOfSubjects) {
        this.numberOfSubjects = numberOfSubjects;
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
            return new Student(this);
        }

        @Override
        public String toString() {
            return "StudentBuilder{" +
                    "name='" + name + '\'' +
                    ", numberOfMandatorySubjects=" + numberOfMandatorySubjects +
                    ", minimalNumberOfMarks=" + minimalNumberOfMarks +
                    ", mandatorySubject='" + mandatorySubject + '\'' +
                    ", markOfMandatorySubject=" + markOfMandatorySubject +
                    '}';
        }
    }
}

