package racing.input;

import java.io.BufferedReader;
import java.io.IOException;

public class RacingMaxTurnInputManager {

    public static int getMaxTurnFromConsole(BufferedReader br) throws IOException {
        String input = br.readLine();
        return getMaxTurn(input.strip());
    }

    static int getMaxTurn(String input) {
        int parsedNumber;
        try {
            parsedNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException("총 이동 횟수는 1 이상 100이하의 정수만 가능합니다.");
        }
        if (parsedNumber < 1 || parsedNumber > 100) {
            throw new RuntimeException("총 이동 횟수는 1 이상 100이하의 정수만 가능합니다.");
        }
        return parsedNumber;
    }
}
