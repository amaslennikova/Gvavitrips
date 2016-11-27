import java.util.Scanner;

public class UserInteraction {

    Scanner scanner = new Scanner(System.in);

    public int getMenuInput() {
        System.out.println("Hello! Lets start a game. How many players will play? Press '0', '1' or '2'.");
        Integer input = 0;
        for(int i=0; i<10; i++) {
            input = scanner.nextInt();
            if (input == 0 || input == 1 || input == 2) {
                break;
            }
            System.out.println("Your input is incorrect. Please enter '0', '1' or '2'.");
        }
        return input;
    }
}
