package racingcar;

public class Car {

    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() < MINIMUM_NAME_LENGTH || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 최소 한글자, 최대 다섯글자까지 가능해요.");
        }
    }

    public void move(int movingCondition) {
        if (movingCondition >= 4) {
            position++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }

        return name + " : " + sb.toString();
    }

    public int findWinnerPosition(int position) {
        return Math.max(this.position, position);

    }

    public boolean isWinner(int winnerPosition) {
        return winnerPosition == position;
    }

    public String getName() {
        return name;
    }
}
