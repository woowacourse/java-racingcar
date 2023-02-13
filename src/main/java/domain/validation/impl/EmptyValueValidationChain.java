package domain.validation.impl;

import domain.dto.InputValidationRequest;
import domain.exception.ErrorCode;
import domain.type.ValidationType;
import domain.validation.InputValidationChain;

public class EmptyValueValidationChain implements InputValidationChain {

    private InputValidationChain next;

    @Override
    public void setNext(final InputValidationChain next) {
        this.next = next;
    }

    @Override
    public boolean validate(final InputValidationRequest request) {
        if (!request.getValidationTypes().contains(ValidationType.EMPTY_VALUE)) {
            return next.validate(request);
        }
        if (request.getTarget().isBlank()) {
            throw new IllegalArgumentException(ErrorCode.CAR_NAMES_EMPTY.getMessage());
        }
        return next.validate(request);
    }
}
