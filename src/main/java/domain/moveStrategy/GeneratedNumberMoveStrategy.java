package domain.moveStrategy;

import domain.numbergenerator.NumberGenerator;

public class GeneratedNumberMoveStrategy implements MoveStrategy {
    public static final int MOVE_THRESHOLD = 4;

    private final NumberGenerator numberGenerator;

    public GeneratedNumberMoveStrategy(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public boolean canGo() {
        return numberGenerator.generate() >= MOVE_THRESHOLD;
    }
}
