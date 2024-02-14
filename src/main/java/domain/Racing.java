package domain;

public class Racing {
    private static Integer generateRandomNumber() {
        return (int) (Math.random() * 10);
    }

    public static boolean isMoveForward() {
        int number = generateRandomNumber();
        return number > 3;
    }
}
