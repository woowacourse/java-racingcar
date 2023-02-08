package validation;

import dto.InputValidationRequest;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import type.ValidationType;
import validation.impl.EmptyValueValidationChain;

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
        Assertions.assertThatThrownBy(() -> validator.validate(request))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
