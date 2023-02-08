package validation.impl;

import dto.InputValidationRequest;
import exception.ErrorCode;
import type.ValidationType;
import validation.InputValidationChain;

public class EmptyValueValidationChain implements InputValidationChain {

    private InputValidationChain next;

    @Override
    public void setNext(InputValidationChain next) {
        this.next = next;
    }

    @Override
    public boolean validate(InputValidationRequest request) {
        if (!request.getValidationTypes().contains(ValidationType.EMPTY_VALUE)) {
            return next.validate(request);
        }
        if (request.getTarget().isBlank()) {
            throw new IllegalArgumentException(ErrorCode.CAR_NAMES_EMPTY.getMessage());
        }
        return next.validate(request);
    }
}
