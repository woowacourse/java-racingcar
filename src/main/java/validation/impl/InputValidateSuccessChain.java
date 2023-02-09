package validation.impl;

import dto.InputValidationRequest;
import validation.InputValidationChain;

public class InputValidateSuccessChain implements InputValidationChain {

    @Override
    public void setNext(InputValidationChain next) {}

    @Override
    public boolean validate(InputValidationRequest request) {
        return true;
    }
}
