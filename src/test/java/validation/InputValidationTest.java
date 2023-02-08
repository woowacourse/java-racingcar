package validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import dto.InputValidationRequest;
import java.util.List;
import org.junit.jupiter.api.Test;
import type.ValidationType;
import validation.impl.EmptyValueValidationChain;
import validation.impl.NumberRangeValidationChain;
import validation.impl.PositiveNumberValidationChain;

public class InputValidationTest {

    private InputValidationChain validator;

    @Test
    void emptyValueValidationTest() {
        //given
        validator = new EmptyValueValidationChain();
        String target = "";
        InputValidationRequest request = new InputValidationRequest(
            List.of(ValidationType.EMPTY_VALUE), target);

        //when
        //then
        assertThatThrownBy(() -> validator.validate(request))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void positiveNumberValidationTest() {
        //given
        validator = new PositiveNumberValidationChain();
        String target = "0";
        InputValidationRequest request = new InputValidationRequest(
            List.of(ValidationType.POSITIVE_NUMBER), target);

        //when
        //then
        assertThatThrownBy(() -> validator.validate(request))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void numberRangeValidationTest() {
        //given
        validator = new NumberRangeValidationChain();
        String target = String.valueOf(Long.MAX_VALUE);
        InputValidationRequest request = new InputValidationRequest(
            List.of(ValidationType.NUMBER_RANGE), target);

        //when
        //then
        assertThatThrownBy(() -> validator.validate(request))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
