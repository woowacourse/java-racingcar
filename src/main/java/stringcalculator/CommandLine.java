package stringcalculator;

public class CommandLine {

    private static final String DOUBLE_BLANK = "  ";
    private static final String SINGLE_BLANK = " ";
    private String[] command;

    public CommandLine(String inputText) {
        inputText = removeUnnecessaryBlank(inputText);
        this.command = splitByBlank(inputText);
    }

    private String[] splitByBlank(String inputText) {
        return inputText.split(SINGLE_BLANK);
    }

    private String removeUnnecessaryBlank(String inputText) {
        while(inputText.contains(DOUBLE_BLANK)) {
            inputText = inputText.replace(DOUBLE_BLANK, SINGLE_BLANK);
        }

        return inputText;
    }

    public boolean checkCommandLength(String[] command) {
        return command.length >= 3;
    }

    public String[] getCommand() {
        return command;
    }
}
