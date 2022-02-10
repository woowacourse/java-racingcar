package calculator;

public class StringAddCalculator {

    public int run(String givenString) {
        if (checkNull(givenString)) {
            return 0;
        }
        String[] splitString = split(givenString);
        return sumStringArray(splitString);
    }


    private boolean checkNull(String givenString) {
        if (givenString == null || givenString.isEmpty()) {
            return true;
        }
        return false;
    }

    private String[] split(String givenString) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(givenString);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return givenString.split("[,:]");
    }

    private int sumStringArray(String[] splitString) {
        int result = 0;
        for (int i = 0; i < splitString.length; i++) {
            result += Integer.parseInt(splitString[i]);
        }
        return result;
    }
}
