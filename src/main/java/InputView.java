import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public String[] inputCarName() {
        String inputName = scanner.nextLine();
        return inputName.split(",");
    }

}
