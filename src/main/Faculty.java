package main;

public class Faculty {
    private String nameOfFaculty;
    private int numberOfGroups;
    private Group[] groups;

    public String getNameOfFaculty() {
        return nameOfFaculty;
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setNameOfFaculty(String nameOfFaculty) {
        this.nameOfFaculty = nameOfFaculty;
    }

    public void initializeGroups(int numberOfGroups) {
        this.numberOfGroups = numberOfGroups;
        groups = new Group[this.numberOfGroups];
        for (int i = 0; i < this.numberOfGroups; i++) {
            groups[i] = new Group();
            groups[i].setNumberOfGroup(i + 1);
        }
        for (int i = 0; i < numberOfGroups; i++) {
            System.out.print("Please enter the number of students in group " + (i + 1) + ": ");
            groups[i].initializeStudents(CheckForWrongInput.checkForWrongInput("groups"));
        }
    }

    public double getAveragePointOfStudent(int numberOfGroup,String nameOfStudent) {
        return groups[numberOfGroup-1].getAveragePointOfStudent(nameOfStudent);
    }

    public double getAverageOfConcreteSubjectOfConcreteGroup(int numberOfGroup,String nameOfSubject) {
        return groups[numberOfGroup-1].getAverageOfConcreteSubject(nameOfSubject);
    }

    public double getAveragePointOfSubjectForFaculty(String nameOfSubject) {
        double averagePointOfSubjectForFaculty = 0;

        for (int i = 0; i < numberOfGroups; i++) {
            averagePointOfSubjectForFaculty += groups[i].getAverageOfConcreteSubject(nameOfSubject);
        }
        if (checkForNumberOfGroupsTeachingSubject(nameOfSubject) == 0) return 0;

        return averagePointOfSubjectForFaculty/checkForNumberOfGroupsTeachingSubject(nameOfSubject);
    }

    public int checkForNumberOfGroupsTeachingSubject(String nameOfSubject) {
        int numberOfGroupsTeachingSubject = 0;

        for (int i = 0; i < numberOfGroups; i++) {
            if (groups[i].checkForStudentsLearningSubject(nameOfSubject)) {
                numberOfGroupsTeachingSubject++;
            }
        }
        return numberOfGroupsTeachingSubject;
    }
}
