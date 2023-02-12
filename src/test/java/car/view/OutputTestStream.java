package car.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public abstract class OutputTestStream {
    private PrintStream printStream;
    private OutputStream outputStream;

    @BeforeEach
    protected final void init(){
        printStream = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    protected final void printOutput(){
        System.setOut(printStream);
        System.out.println(output());
    }
    protected final String output(){
        return outputStream.toString();
    }
}
