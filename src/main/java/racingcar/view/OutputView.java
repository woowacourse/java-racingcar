package racingcar.view;

import java.util.List;
import static racingcar.view.UserMessage.*;

public class OutputView {

    public static void displayMessage(String message){
        System.out.println(message);
    }
    public void printResultHeaderPrompt() {
        displayMessage(RESULT_HEADER_PROMPT);
    }

    public static void parseLine(){
        System.out.print(System.lineSeparator());
    }

    public void printResult(String name, int position) {
        displayMessage(name + " : " + CAR_POSITION_PROGRESS_BAR.repeat(position));
    }

    public void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + RESULT_SUFFIX_PROMPT);
    }
}
