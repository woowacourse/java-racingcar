package calculator;

public class StringAddCalculator {

    public int run(String givenString) {
        if (checkNull(givenString)) {
            return 0;
        }
        return Integer.parseInt(givenString);
    }


    private boolean checkNull(String givenString) {
        if (givenString == null || givenString.isEmpty()) {
            return true;
        }
        return false;
    }

    
}
