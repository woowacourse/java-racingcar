package calculator;

public class StringAddCalculator {

    public int run(String givenString) {
        if (checkNull(givenString)) {
            return 0;
        }
        return 100;
    }


    private boolean checkNull(String givenString) {
        if (givenString == null || givenString.isEmpty()) {
            return true;
        }
        return false;
    }
}
