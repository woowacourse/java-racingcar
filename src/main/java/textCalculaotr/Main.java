package textCalculaotr;

import textCalculaotr.input.UserInput;
import textCalculaotr.input.UserInputCheck;

public class Main {
    public static void main(String[] args) {
        TextCalculator tc = new TextCalculator();

        String userInput = UserInput.inputText();
        String[] inputText = UserInputCheck.splitByBlank(userInput);
        int result = tc.execute(inputText);
        System.out.println(result);
    }
}
