package racingcar.domain.rule;

import java.util.Random;

public class RandomMoveCondition implements MoveCondition<Integer> {
    private static final Random random = new Random();

    @Override
    public Integer generate(int bound) {
        int randomNumber = random.nextInt(bound + 1);

        return randomNumber;
    }
}