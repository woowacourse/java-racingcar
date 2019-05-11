package stringcalculator;

public class Main {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        CommandLine command;

        do {
            String inputText = UserInput.inputText();
            command = new CommandLine(inputText);
        } while(!command.checkCommandLength(command.getCommand()));

        int result = cal.calculate(command.getCommand());

        UserOutput.printResult(result);
    }
}
