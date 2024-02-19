package domain.moveStrategy;

import domain.numbergenerator.NumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GeneratedNumberMoveStrategyTest {

    @ParameterizedTest(name = "{0}이 생성되면 자동차는 이동할 수 없다.")
    @ValueSource(ints = {0, 1, 2, 3})
    void CarCantMoveTest(int generatedValue){
        GeneratedNumberMoveStrategy moveStrategy = new GeneratedNumberMoveStrategy(
                new ConstNumberGenerator(generatedValue));
        Assertions.assertFalse(moveStrategy.canGo());
    }

    @ParameterizedTest(name = "{0}이 생성되면 자동차는 이동할 수 있다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void CarMoveTest(int generatedValue){
        GeneratedNumberMoveStrategy moveStrategy = new GeneratedNumberMoveStrategy(
                new ConstNumberGenerator(generatedValue));
        Assertions.assertTrue(moveStrategy.canGo());
    }
}

class ConstNumberGenerator implements NumberGenerator {
    private final int generatedValue;

    ConstNumberGenerator(int generatedValue) {
        this.generatedValue = generatedValue;
    }

    @Override
    public int generate() {
        return generatedValue;
    }
}