package racingcar.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public abstract class IOTest {

    private ByteArrayOutputStream outputStreamCaptor;
    private PrintStream standardOut;

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @BeforeEach
    void setUp() {
        standardOut = System.out;
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    protected void printResult() {
        System.setOut(standardOut);
        System.out.println(getOutput());
    }

    protected String getOutput() {
        return outputStreamCaptor.toString();
    }
}
