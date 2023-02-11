package validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import dto.InputValidationRequest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import type.ValidationType;
import validation.impl.EmptyValueValidationChain;
import validation.impl.NumberRangeValidationChain;
import validation.impl.PositiveNumberValidationChain;

public class InputValidationTest {

    private InputValidationChain validator;

    @Test
    @DisplayName("빈 값이 들어오는 경우")
    void emptyValueValidationTest() {
        //given
        validator = new EmptyValueValidationChain();
        String target = "";

        //when
        //then
        assertValidationByType(ValidationType.EMPTY_VALUE, target);
    }

    @Test
    @DisplayName("양수가 들어오지 않는 경우")
    void positiveNumberValidationTest() {
        //given
        validator = new PositiveNumberValidationChain();
        String target = "0";

        //when
        //then
        assertValidationByType(ValidationType.POSITIVE_NUMBER, target);
    }

    @Test
    @DisplayName("int 범위를 넘어선 수가 들어온 경우")
    void numberRangeValidationTest() {
        //given
        validator = new NumberRangeValidationChain();
        String target = String.valueOf(Long.MAX_VALUE);

        //when
        //then
        assertValidationByType(ValidationType.NUMBER_RANGE, target);
    }

    private void assertValidationByType(ValidationType validationType, String target) {
        InputValidationRequest request = new InputValidationRequest(
            List.of(validationType), target);
        assertThatThrownBy(() -> validator.validate(request))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
