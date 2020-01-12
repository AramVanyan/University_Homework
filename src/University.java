import java.util.Scanner;

public class University {
    private String nameOfUniversity;
    private Faculty[] faculties;
    private Scanner scanner = new Scanner(System.in);

    public Faculty[] getFaculties() {
        return faculties;
    }

    public void setNameOfUniversity(String nameOfUniversity) {
        this.nameOfUniversity = nameOfUniversity;
    }

    public void initializeFaculties(int numberOfFaculties) {
        faculties = new Faculty[numberOfFaculties];
        for (int i = 0; i < numberOfFaculties ; i++) {
            System.out.println("Please enter the name of faculty " + (i + 1) + ": ");
            faculties[i] = new Faculty();
            faculties[i].setNameOfFaculty(scanner.next());
            System.out.print("Please enter the number of groups in faculty " + faculties[i].getNameOfFaculty() + ": ");
            faculties[i].initializeGroups(CheckForWrongInput.checkForWrongInput("groups"));
        }
    }

    public double getAveragePointOfStudent(String nameOfFaculty,int numberOfGroup,String nameOfStudent){
        int indexOfNecessaryFaculty = 0;

        for (int i = 0; i < faculties.length; i++) {
            if (faculties[i].getNameOfFaculty().equals(nameOfFaculty)) {
                indexOfNecessaryFaculty = i;
                break;
            }
        }
        return faculties[indexOfNecessaryFaculty].getAveragePointOfStudent(numberOfGroup,nameOfStudent);
    }

    public double getAverageOfConcreteSubjectOfConcreteGroup(String nameOfSubject,int numberOfGroup,
                                                             String nameOfFaculty){
        int indexOfNecessaryFaculty = 0;

        for (int i = 0; i < faculties.length; i++) {
            if(faculties[i].getNameOfFaculty().equals(nameOfFaculty)){
                indexOfNecessaryFaculty = i;
                break;
            }
        }
        return faculties[indexOfNecessaryFaculty].getAverageOfConcreteSubjectOfConcreteGroup(numberOfGroup,
                                                                                             nameOfSubject);
    }

    public double getAveragePointOfSubjectForFaculty(String nameOfSubject,String nameOfFaculty) {
        int indexOfNecessaryFaculty = 0;

        for (int i = 0; i < faculties.length; i++) {
            if(faculties[i].getNameOfFaculty().equals(nameOfFaculty)){
                indexOfNecessaryFaculty = i;
                break;
            }
        }
        return faculties[indexOfNecessaryFaculty].getAveragePointOfSubjectForFaculty(nameOfSubject);
    }

    public double getAveragePointOfSubjectForUniversity(String nameOfSubject) {
        int numberOfFacultiesTeachingSubject;
        double averagePointOfSubjectForUniversity = 0;

        for (int i = 0; i < faculties.length; i++) {
            averagePointOfSubjectForUniversity += faculties[i].getAveragePointOfSubjectForFaculty(nameOfSubject);
        }
        numberOfFacultiesTeachingSubject = checkForNumberOfFacultiesTeachingSubject(nameOfSubject);
        return averagePointOfSubjectForUniversity/numberOfFacultiesTeachingSubject;
    }

    public int checkForNumberOfFacultiesTeachingSubject(String nameOfSubject) {
        int numberOfFacultiesTeachingSubject = 0;

        for (int i = 0; i < faculties.length; i++) {
            if (faculties[i].checkForNumberOfGroupsTeachingSubject(nameOfSubject) > 0) {
                numberOfFacultiesTeachingSubject++;
            }
        }
        return numberOfFacultiesTeachingSubject;
    }
}
