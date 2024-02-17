package domain;

public class MoveStrategy {

    private final static int MIN_MOVABLE_DIGIT = 4;

    public static boolean isMove(int target) {
        return MIN_MOVABLE_DIGIT <= target;
    }
}
