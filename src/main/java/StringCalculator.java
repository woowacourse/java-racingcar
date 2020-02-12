import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private int result = 0;
    public int add(String numberExpression) {
        if (numberExpression.isEmpty()) {
            return result;
        }

        String[] splittedWordsWithComma = numberExpression.split(",");
        List<String> notSplittedWordsWithComma = new ArrayList<>();
        for (String spllitedWordWithComma : splittedWordsWithComma) {
            boolean isAdded = addNumber(spllitedWordWithComma);
            if (isAdded) {
                continue;
            }
            notSplittedWordsWithComma.add(spllitedWordWithComma);
        }

        for (String notSpllitedWordWithComma : notSplittedWordsWithComma) {
            String[] splittedWordsWithCollon = notSpllitedWordWithComma.split(":");
            for (String splittedWordWithColon : splittedWordsWithCollon) {
                addNumber(splittedWordWithColon);
            }
        }


        return result;
    }

    private boolean addNumber(String splittedWord) {
        if (isInteger(splittedWord)) {
            result += Integer.parseInt(splittedWord);
            return true;
        }
        return false;
    }

    private boolean isInteger(String splittedWord) {
        return splittedWord.length() == 1;
    }
}
