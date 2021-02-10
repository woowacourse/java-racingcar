package racingcar.utils;

import org.junit.jupiter.api.Test;

class InputValidationTest {

    @Test
    public void 정상_입력_시() {
        String[] validInput = {"pobi", "brown"};
        InputValidation.validateCars(validInput);   // 정상 처리 시 예외가 발생하지 않음
    }


}