package racinggame.domain.data;

import racinggame.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Input 클래스는 InputView와 RacingGame 사이에서 입력값의 검증, 전달을 맡는 클래스이다.
 * 데이터의 검증과 예외처리, InputView 메서드 호출 등을 포함한다.
 * 또한, 입력되는 두 값(이름 목록, 횟수)을 감싸 변조를 방지하는 역할을 담당한다.
 */
public class Input {
    private String names;
    private int repeat;

    private static final String LENGTH_ERROR_MESSAGE = "이름의 길이는 1자 이상, 5자 이하만 가능합니다.";
    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "횟수는 정수만 가능합니다.";
    private static final String NOT_POSITIVE_ERROR_MESSAGE = "횟수는 1이상의 정수만 가능합니다.";
    private static final String SPLIT_DELIMITER = ",";


    public Input() {
        this(InputView.inputName(), InputView.inputRepeat());
    }

    /**
     * 생성자 메서드의 파라미터로 이름목록과 횟수가 전달될 경우,
     * 이를 Input 인스턴스의 필드값으로 옮겨 저장한다.
     * 이후 데이터에 대한 예외처리를 수행하여,
     * 만약 올바르지 않은 값임이 확인된다면 예외를 발생시킨다.
     *
     * @param inputName   이름의 목록을 저장하는 String 값이다.
     * @param inputRepeat 횟수를 저장하는 String 값이다.
     */
    public Input(String inputName, String inputRepeat) {
        this.names = inputName;
        validateNames();

        this.repeat = validateRepeat(inputRepeat);
    }

    /**
     * splitInputByComma 는 입력받은 문자열을 SPLIT_DELIMITER를 기준으로 잘라
     * 이를 String을 저장하는 List로 변환하여 반환한다.
     *
     * @return 문자열 형태의 이름을 담은 List를 반환한다.
     */
    public List<String> splitInputByComma() {
        String[] splitName = names.split(SPLIT_DELIMITER);
        return Arrays.asList(splitName);
    }

    public boolean isLoopDone(int repeat) {
        return repeat < this.repeat;
    }

    /**
     * validateNameLength 는 이름에 대한 예외처리 사항을 확인하고, 문제 시 예외를 발생시킨다.
     * 이름의 길이가 1글자 미만이거나, 혹은 5글자 초과이거나, 혹은 문자열이 비어있을 경우 예외처리된다.
     *
     * @param name 검증을 위해 전달되는, 이름을 담은 String 인스턴스이다.
     */
    private static void validateNameLength(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    /**
     * validateNames 는 이름의 목록 데이터를 분석하여, 목록 자체가 비어있거나 null인 경우 예외를 발생시킨다.
     * 또한, 각각의 이름 데이터에 문제가 있는지 validateNameLength를 호출하여 검사한다.
     */
    private void validateNames() {
        List<String> splitName = splitInputByComma();
        if (Objects.isNull(names)) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
        for (String name : splitName) {
            validateNameLength(name);
        }
    }

    /**
     * validateRepeat 는 반복횟수 값에 대한 예외처리 사항을 확인하여 문제 시 예외를 발생시킨다.
     * Input의 필드에 있는 repeat 값이 정수값이 아니어서 parseInt가 불가한 경우가 이에 해당한다.
     */
    private int validateRepeat(String inputRepeat) {
        try {
            int repeat = Integer.parseInt(inputRepeat);
            validateRepeatPositive(repeat);
            return repeat;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    /**
     * validateRepeatPositive 는 반복횟수 값에 대한 예외처리 사항을 확인하여 문제 시 예외를 발생시킨다.
     * 만약 반복 횟수가 0이나 음수일 경우, 이는 비정상적인 값으로 판단되어 메서드에서 예외를 발생시킨다.
     */
    private void validateRepeatPositive(int inputRepeat) {
        if (inputRepeat <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_ERROR_MESSAGE);
        }
    }
}