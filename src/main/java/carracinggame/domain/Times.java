package carracinggame.domain;

public class Times {

    final String REGEX = "^[0-9]+$";

    private int times;
    private int theNumberOfTimes = 0;

    public Times(String input) throws IllegalArgumentException{
        isRightTimes(input);
        this.times = Integer.parseInt(input);
    }

    private void isRightTimes(String input) throws IllegalArgumentException {
        if (!input.matches(REGEX)) {
            throw new IllegalArgumentException();
        }

    }

    public boolean isEnd() {
        theNumberOfTimes++;
        return times < theNumberOfTimes;
    }

    public int getTimes() {
        return this.times;
    }
}