package domain.validation.impl;

import domain.dto.InputValidationRequest;
import domain.exception.ErrorCode;
import domain.type.ValidationType;
import domain.validation.InputValidationChain;

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
