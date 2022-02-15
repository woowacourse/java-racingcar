package racingcar;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class ConsoleTest {

    protected PrintStream stdout;
    protected ByteArrayOutputStream outputStream;

    @BeforeEach
    protected void changeOutput() {
        stdout = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    protected void printOutput() {
        System.setOut(stdout);
        System.out.println(outputStream.toString());
    }

    protected void changeInput(String str) {
        System.setIn(new ByteArrayInputStream(str.getBytes()));
    }

}
