package racingcar.view.reader;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleReader implements Reader {

    private final Scanner scanner;

    public ConsoleReader(InputStream in) {
        this.scanner = new Scanner(in);
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }

}
