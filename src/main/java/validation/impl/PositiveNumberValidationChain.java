package validation.impl;

import dto.InputValidationRequest;
import exception.ErrorCode;
import type.ValidationType;
import validation.InputValidationChain;

public class PositiveNumberValidationChain implements InputValidationChain {

    private InputValidationChain next;

    @Override
    public void setNext(final InputValidationChain next) {
        this.next = next;
    }

    @Override
    public boolean validate(final InputValidationRequest request) {
        if (!request.getValidationTypes().contains(ValidationType.POSITIVE_NUMBER)) {
            return next.validate(request);
        }
        if (1 > Integer.parseInt(request.getTarget())) {
            throw new IllegalArgumentException(ErrorCode.NOT_POSITIVE_NUMBER.getMessage());
        }
        return next.validate(request);
    }
}
