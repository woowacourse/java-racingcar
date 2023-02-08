package validation.impl;

import dto.InputValidationRequest;
import exception.ErrorCode;
import type.ValidationType;
import validation.InputValidationChain;

public class NumberRangeValidationChain implements InputValidationChain {

    private InputValidationChain next;

    @Override
    public void setNext(InputValidationChain next) {
        this.next = next;
    }

    @Override
    public boolean validate(InputValidationRequest request) {
        if (!request.getValidationTypes().contains(ValidationType.NUMBER_RANGE)) {
            return next.validate(request);
        }
        try {
            Integer.parseInt(request.getTarget());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorCode.NUMBER_OUT_OF_RANGE.getMessage());
        }
        return next.validate(request);
    }
}
