package domain;

import java.util.function.Predicate;

public class MoveStrategy implements Predicate<Integer> {
    public static final int MAX_NUM = 10; // [0, MAX_NUM)
    public static final int MOVE_START = 4;

    @Override
    public boolean test(Integer num) {
        return MOVE_START <= num;
    }
}
