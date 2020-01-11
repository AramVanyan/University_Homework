import java.util.Scanner;

public class University {
    private String nameOfUniversity;
    private Faculty[] faculties;
    private Scanner scanner = new Scanner(System.in);


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
            faculties[i].initializeGroups(scanner.nextInt());
        }
    }

    public double getAveragePointOfStudent(String nameOfFaculty,int numberOfGroup,String nameOfStudent){
        int indexOfNecessaryFaculty = 0;

        for (int i = 0; i < faculties.length; i++) {
            if(faculties[i].getNameOfFaculty().equals(nameOfFaculty)){
                indexOfNecessaryFaculty = i;
                break;
            }
        }
        return faculties[indexOfNecessaryFaculty].getAveragePointOfStudent(numberOfGroup,nameOfStudent);
    }

    public double getAverageOfConcreteSubjectOfConcreteGroup(String nameOfSubject,int numberOfGroup,String nameOfFaculty){
        int indexOfNecessaryFaculty = 0;

        for (int i = 0; i < faculties.length; i++) {
            if(faculties[i].getNameOfFaculty().equals(nameOfFaculty)){
                indexOfNecessaryFaculty = i;
                break;
            }
        }
        return faculties[indexOfNecessaryFaculty].getAverageOfConcreteSubjectOfConcreteGroup(numberOfGroup,nameOfSubject);
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
        double averagePointOfSubjectForUniversity = 0;

        for (int i = 0; i < faculties.length; i++) {
            averagePointOfSubjectForUniversity += faculties[i].getAveragePointOfSubjectForFaculty(nameOfSubject);
        }
        return averagePointOfSubjectForUniversity/faculties.length;
    }

//    public int checkForNumberOfFacultiesTeachingSubject(String nameOfSubject) {
//        for (int i = 0; i < faculties.length; i++) {
//
//        }
//
//        return 0;
//    }
}
