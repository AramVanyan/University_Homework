import java.util.Scanner;

public class CheckForWrongInput {
    public static int checkForWrongInput(String nameOfSpecificGroup){
        int input;
        Scanner scanner = new Scanner(System.in);
        while(true){
            try {
                input = Integer.parseInt(scanner.nextLine());
                if(nameOfSpecificGroup.equals("marks") && (input<0 || input>10)){
                    System.out.println("mark should be in range og 1-10: ");
                } else {
                    if (input <= 0 && !(nameOfSpecificGroup.equals("marks"))) {
                        System.out.println("Number of " + nameOfSpecificGroup + " must be greater than 0");
                        System.out.print("Try again: ");
                        continue;
                    }
                    return input;
                }
            } catch (NumberFormatException e){
                System.out.print("Please enter a number: ");
            }
        }
    }
}
