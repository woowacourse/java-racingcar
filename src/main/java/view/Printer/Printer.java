package view.Printer;

public class Printer {
    public void printLine(String message) {
        System.out.println(message);
    }

    public void printLine(String format, String... args) {
        System.out.printf(format, args);
        printEmptyLine();
    }

    public void printEmptyLine() {
        System.out.println();
    }
}
