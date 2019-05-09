package domain;

public class Car {
    private static final int MOVE_CONDITION = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    /* 테스트용 생성자 */
    Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    void move(int randomNumber) {
        if (isMove(randomNumber)) {
            position++;
        }
    }

    static boolean isMove(int randomNumber) {
        return randomNumber >= MOVE_CONDITION;
    }

    int getMaxPosition(int pos) {
        return Math.max(pos, position);
    }

    boolean compareToPosition(int maxPosition) {
        return maxPosition == position;
    }

    public String appendCarName(String carNames) {
        return carNames + (name + ", ");
    }

    private String getPositionString() {
        StringBuilder str = new StringBuilder();

        for (int i = 1; i <= position; i++) {
            str.append("-");
        }

        return str.toString();
    }

    @Override
    public String toString() {
        return name + " : " + getPositionString();
    }
}
