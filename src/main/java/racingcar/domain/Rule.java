package racingcar.domain;

import java.util.Random;

public class Rule {
    private final static int RANDOM_NUMBER_OFFSET = 10;
    private final static int MOVE_OFFSET = 4;

    public static boolean isPossibleMove(int num) { //테스트 코드를 위한 코드
        return num > MOVE_OFFSET;
    }

    public static int generateRandomNumber() {
        return new Random().nextInt(RANDOM_NUMBER_OFFSET);
    }
}
