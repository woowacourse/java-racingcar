package calculator;

import calculator.model.Calculator;
import calculator.model.ExtractedInformation;
import calculator.model.OperatorMap;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CalculatorTest {
    @Test
        void 덧셈_테스트() {
        String test = "2 + 3";
        ExtractedInformation extractedInfo = new ExtractedInformation(test);
        OperatorMap functionMap = new OperatorMap();
        Calculator calculator = new Calculator(extractedInfo);

        assertThat(calculator.calculate()).isEqualTo(5);
    }

    @Test
    void 뺄셈_테스트() {
        String test = "2 - 3";
        ExtractedInformation extractedInfo = new ExtractedInformation(test);
        OperatorMap functionMap = new OperatorMap();
        Calculator calculator = new Calculator(extractedInfo);

        assertThat(calculator.calculate()).isEqualTo(-1);
    }


    @Test
    void 나눗셈_테스트() {
        String test = "4 / 2";
        ExtractedInformation extractedInfo = new ExtractedInformation(test);
        OperatorMap functionMap = new OperatorMap();
        Calculator calculator = new Calculator(extractedInfo);

        assertThat(calculator.calculate()).isEqualTo(2);
    }

    @Test
    void 곱셈_테스트() {
        String test = "2 * 3";
        ExtractedInformation extractedInfo = new ExtractedInformation(test);
        OperatorMap functionMap = new OperatorMap();
        Calculator calculator = new Calculator(extractedInfo);

        assertThat(calculator.calculate()).isEqualTo(6);
    }

}

