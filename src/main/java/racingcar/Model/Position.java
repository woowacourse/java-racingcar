package racingcar.Model;

/**
 * 클래스 이름 : Position.java
 *
 * @author 작은곰
 * @version 1.0.1
 * <p>
 * 날짜 : 2020.02.16 일요일
 */

public class Position {
    private int position;
    private static final int INITIAL_POSITION = 0;

    public Position(int position) {
        this.position = position;
    }

    public Position() {
        this.position = INITIAL_POSITION;
    }

    public void go() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }
}
