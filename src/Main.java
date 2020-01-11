import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isProgramContinuing = true;
        Scanner scanner = new Scanner(System.in);
        University university = new University();

        System.out.print("Please enter the name of university: ");
        university.setNameOfUniversity(scanner.nextLine());
        System.out.print("Please enter the number of faculties in university: ");
        university.initializeFaculties(CheckForWrongInput.checkForWrongInput("faculties"));
        System.out.println();


//        while (isProgramContinuing) {
//            int action;
//            System.out.println("What you want to do");
//            System.out.println("1:Get the average point of a student");
//            System.out.println("2:Get the average point for concrete subject in concrete group");
//            System.out.println("3:Get the average point for concrete subject in concrete faculty");
//            System.out.println("4:Get the average point for concrete subject in university");
//            System.out.println("5:Stop the program");
//            try {
//                action = Integer.parseInt(scanner.nextLine());
//            } catch (NumberFormatException е) {
//                System.out.println("Write a right number: ");
//                continue;
//            }
//
//
//            switch (action){
//                case 1:
//                    university.getAveragePointOfStudent("a",1,"a");
//                    break;
//                case 2:
//                    university.getAverageOfConcreteSubjectOfConcreteGroup("sub",3,"s");
//                    break;
//                case 3:
//                    university.getAveragePointOfSubjectForFaculty("asd","asd");
//                    break;
//                case 4:
//                    university.getAveragePointOfSubjectForUniversity("math");
//                    break;
//                case 5:
//                    isProgramContinuing = false;
//                    break;
//
//            }
//
//        }



    }
}
