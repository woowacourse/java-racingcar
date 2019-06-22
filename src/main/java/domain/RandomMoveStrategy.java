package domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    public static RandomMoveStrategy DEFAULT = new RandomMoveStrategy();

    private static final Random RANDOM = new Random();

    @Override
    public boolean canMove() {
        int num = RANDOM.nextInt(RandomMoveCondition.NUM_TO + 1);

        return RandomMoveCondition.canMove(num);
    }

    static class RandomMoveCondition {
        // [NUM_START, NUM_END]
        public static final int NUM_FROM = 0;
        public static final int NUM_MOVE_FROM = 4;
        public static final int NUM_TO = 9;

        public static boolean canMove(int num) {
            checkNum(num);

            return NUM_MOVE_FROM <= num;
        }

        private static void checkNum(int num) {
            if (num < NUM_FROM || NUM_TO < num) {
                throw new IndexOutOfBoundsException(
                        String.format("num 은 [%d, %d] 범위 내의 정수이여야 합니다.", NUM_FROM, NUM_TO)
                );
            }
        }
    }
}
