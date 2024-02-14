package racing.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public String readNames(){
        return scanner.nextLine();
    }

    public int readTryCount(){
        return Integer.parseInt(scanner.nextLine());
    }
}
