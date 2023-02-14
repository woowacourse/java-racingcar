package domain.validation.impl;

import domain.dto.InputValidationRequest;
import domain.exception.ErrorCode;
import domain.type.ValidationType;
import domain.validation.InputValidationChain;

public class NumberRangeValidationChain implements InputValidationChain {

    private InputValidationChain next;

    @Override
    public void setNext(final InputValidationChain next) {
        this.next = next;
    }

    @Override
    public boolean validate(final InputValidationRequest request) {
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
