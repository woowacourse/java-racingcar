package domain.moveStrategy;

import domain.numbergenerator.NumberGenerator;

public class NumberMoveStrategy implements MoveStrategy {
    private final NumberGenerator numberGenerator;

    public NumberMoveStrategy(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public boolean canGo() {
        return numberGenerator.generate() > 4;
    }
}
