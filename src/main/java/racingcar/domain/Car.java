package racingcar.domain;

public class Car {

    private static final int MOVE_CONDITION = 4;
    private static final int LIMIT_NAME_LEN = 5;

    private final String name;
    private int position = 0;

    private Car(String name) {
        this.name = name;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car createByName(String name) {
        checkValidName(name);
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public static void checkValidName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name can't be null");
        }

        if (!isValidLength(name)) {
            throw new IllegalArgumentException("Invalid name length exception");
        }
    }

    private static boolean isValidLength(String name) {
        return name.trim().length() <= LIMIT_NAME_LEN && name.trim().length() > 0;
    }

    public boolean isInWinnerPosition(int winnerPosition) {
        return winnerPosition == this.position;
    }

    public void tryMove(int moveNum) {
        if (moveNum >= MOVE_CONDITION) {
            movePosition();
        }
    }

    private void movePosition() {
        position++;
    }

    private String getPositionBar() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public String getPositionStatus() {
        return name + " : " + getPositionBar();
    }

    public int greaterPosition(int winnerPosition) {
        return Math.max(this.position, winnerPosition);
    }
}
