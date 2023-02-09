package validation.impl;

import dto.InputValidationRequest;
import validation.InputValidationChain;

public class InputValidateSuccessChain implements InputValidationChain {

    @Override
    public void setNext(final InputValidationChain next) {}

    @Override
    public boolean validate(final InputValidationRequest request) {
        return true;
    }
}
