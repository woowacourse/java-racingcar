package view.Printer;

public interface Printer {
    void printLine(String message);

    void printLine(String format, String... args);

    void printEmptyLine();
}
