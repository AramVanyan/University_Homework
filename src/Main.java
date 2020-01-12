import java.util.Scanner;

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
        university.initializeFaculties(CheckForWrongInput.checkForWrongInput("faculties"));
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
                System.out.println("Write a right number: ");
                continue;
            }
            System.out.println();

            switch (action){
                case 1:
                    System.out.println("Enter the name of faculty: ");
                    nameOfFaculty = scanner.nextLine();
                    System.out.println("Enter the number of group: ");
                    numberOfGroup = CheckForWrongInput.checkForWrongInput();
                    System.out.println("Enter the name of student: ");
                    nameOfStudent = scanner.nextLine();
                    System.out.println("average point of student is ");
                    System.out.println(university.getAveragePointOfStudent(nameOfFaculty,numberOfGroup,
                                       nameOfStudent));
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Enter the name of faculty: ");
                    nameOfFaculty = scanner.nextLine();
                    System.out.print("Enter the number of group: ");
                    numberOfGroup = CheckForWrongInput.checkForWrongInput();
                    System.out.print("Enter the name of subject: ");
                    nameOfSubject = scanner.nextLine();
                    System.out.print("average point of subject in group is ");
                    System.out.println(university.getAverageOfConcreteSubjectOfConcreteGroup(nameOfSubject,
                                       numberOfGroup,nameOfFaculty));
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter the name of faculty: ");
                    nameOfFaculty = scanner.nextLine();
                    System.out.print("Enter the name of subject: ");
                    nameOfSubject = scanner.nextLine();
                    System.out.print("average point of subject in faculty is ");
                    System.out.println(university.getAveragePointOfSubjectForFaculty(nameOfSubject,nameOfFaculty));
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Enter the name of subject: ");
                    nameOfSubject = scanner.nextLine();
                    System.out.print("average point of subject in university is ");
                    System.out.println(university.getAveragePointOfSubjectForUniversity(nameOfSubject));
                    System.out.println();
                    break;
                case 5:
                    isProgramContinuing = false;
                    System.out.println("Program is stopped");
                    break;
            }
        }
    }
}
