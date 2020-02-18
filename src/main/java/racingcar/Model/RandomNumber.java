package racingcar.Model;

/**
 * 클래스 이름 : RandomNumber.java
 *
 * @author 작은곰
 * @version 1.0.1
 * <p>
 * 날짜 : 2020.02.16 일요일
 */

public class RandomNumber {
    public static final int RANDOM_UPPER_LIMIT = 9;
    public static final int RANDOM_LOWER_LIMIT = 1;

    public static int randomNumberCreate() {
        return (int) (Math.random() * RANDOM_UPPER_LIMIT) + RANDOM_LOWER_LIMIT;
    }
}
