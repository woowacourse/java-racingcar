package view;

public class ConsoleOutput implements Output {
    @Override
    public void print(String message) {
        System.out.print(message);
    }

    @Override
    public void println(String message) {
        System.out.println(message);
    }

    @Override
    public void println() {
        System.out.println();
    }
}
