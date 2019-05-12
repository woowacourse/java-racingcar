package racing.utils;

public class Helper {
    private static final int GO_FORWARD_CRITERIA = 4;
    public static final String COMMA = ",";

    public static boolean moveOrNot(int randomNum) {
        return randomNum >= GO_FORWARD_CRITERIA;
    }

    public static int getRandomNumber() {
        return (int) (Math.random() * 10);
    }
}
