package view.Printer;

public class ConsolePrinter implements Printer {
    @Override
    public void printLine(String message) {
        System.out.println(message);
    }

    @Override
    public void printLine(String format, String... args) {
        System.out.printf(format, args);
        printEmptyLine();
    }

    @Override
    public void printEmptyLine() {
        System.out.println();
    }
}
