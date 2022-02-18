package racingcar.domain.movement;

public class RandomNumberOverThanFour implements Movement {
    private static final int NUMBER_POSSIBLE_TO_MOVE = 4;
    private static final int MAX_RANDOM_NUMBER_BOUNDARY = 10;

    private final NumberGenerator numberGenerator;

    public RandomNumberOverThanFour(final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public int getMovementValue() {
        final int randomNumber = numberGenerator.generate(MAX_RANDOM_NUMBER_BOUNDARY);
        if (randomNumber >= NUMBER_POSSIBLE_TO_MOVE) {
            return 1;
        }
        return 0;
    }
}
