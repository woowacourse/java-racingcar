package validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import dto.InputValidationRequest;
import java.util.List;
import org.junit.jupiter.api.Test;
import type.ValidationType;
import validation.impl.EmptyValueValidationChain;
import validation.impl.PositiveNumberValidationChain;

public class InputValidationTest {

    private InputValidationChain validator;

    @Test
    public void emptyValueValidationTest() {
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
    public void positiveNumberValidationTest() {
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
}
