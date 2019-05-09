package domain;

import utils.OutputUtil;

public class Car {
    private static final int MOVE_CONDITION = 4;

    private String name;
    private int position;

    Car(String name) {
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

    void printPosition() {
        OutputUtil.printPosition(name, position);
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
}
