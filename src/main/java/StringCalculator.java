import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringCalculator {
    public int add(String numberExpression) {
        int result = 0;
        if (numberExpression.isEmpty()) {
            return result;
        }

        String[] splittedWordsWithComma = numberExpression.split(",");
        List<String> notSplittedWordsWithComma = new ArrayList<>();
        for (String spllitedWordWithComma : splittedWordsWithComma) {
            if (isInteger(spllitedWordWithComma)) {
                result += Integer.parseInt(spllitedWordWithComma);
                continue;
            }
            notSplittedWordsWithComma.add(spllitedWordWithComma);
        }

        for (String notSpllitedWordWithComma : notSplittedWordsWithComma) {
            String[] splittedWordsWithCollon = notSpllitedWordWithComma.split(":");
            for (String splittedWordWithColon : splittedWordsWithCollon) {
                if (isInteger(splittedWordWithColon)) {
                    result += Integer.parseInt(splittedWordWithColon);
                }
            }
        }


        return result;
    }

    private boolean isInteger(String splittedWord) {
        return splittedWord.length() == 1;
    }
}
