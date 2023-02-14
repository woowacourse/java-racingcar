package racingcar.view.outputview;

import racingcar.exception.*;

public class KoreanOutputView extends OutputView {
    private static final String NOT_EXIST_CARS_ERROR_MESSAGE = "[ERROR] 게임에 참여한 자동차가 없습니다.";
    private static final String DUPLICATE_CAR_NAMES_ERROR_MESSAGE = "[ERROR] 중복된 차 이름이 존재합니다.";
    private static final String EXCEED_CAR_NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 자동차 이름은 다섯 글자 이하여야 합니다.";
    private static final String HAS_BLANK_CAR_NAME_ERROR_MESSAGE = "[ERROR] 비어있는 자동차 이름이 존재합니다.";
    private static final String INVALID_CAR_NAME_FORMAT_ERROR_MESSAGE = "[ERROR] 자동차 이름은 문자와 숫자만 가능합니다.";
    private static final String INVALID_RANGE_TRIAL_TIMES_ERROR_MESSAGE = "[ERROR] 시도 횟수는 1 이상 100 이하여야 합니다.";
    private static final String INVALID_TRIAL_TIMES_FORMAT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자만 입력 가능합니다.";

    @Override
    void initialCarsErrorMessage() {
        super.insertErrorMessage(NotExistCarsException.getErrorNumber(), NOT_EXIST_CARS_ERROR_MESSAGE);
        super.insertErrorMessage(DuplicateCarNamesException.getErrorNumber(), DUPLICATE_CAR_NAMES_ERROR_MESSAGE);
    }

    @Override
    void initialCarErrorMessage() {
        super.insertErrorMessage(ExceedCarNameLengthException.getErrorNumber(), EXCEED_CAR_NAME_LENGTH_ERROR_MESSAGE);
        super.insertErrorMessage(HasBlankCarNameException.getErrorNumber(), HAS_BLANK_CAR_NAME_ERROR_MESSAGE);
        super.insertErrorMessage(InvalidCarNameFormatException.getErrorNumber(), INVALID_CAR_NAME_FORMAT_ERROR_MESSAGE);
    }

    @Override
    void initialTrackErrorMessage() {
        super.insertErrorMessage(InvalidRangeTrialTimesException.getErrorNumber(), INVALID_RANGE_TRIAL_TIMES_ERROR_MESSAGE);
        super.insertErrorMessage(InvalidTrialTimesFormatException.getErrorNumber(), INVALID_TRIAL_TIMES_FORMAT_ERROR_MESSAGE);
    }
}
