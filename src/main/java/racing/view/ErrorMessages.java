package racing.view;

public enum ErrorMessages {
    IDENTIFIER_NAME("이름은 쉼표를 기준으로 구분합니다."),
    CAR_NAME("레이서의 이름은 5자 이하여야 합니다."),
    CAR_BLANK_NAME("레이서의 이름은 적어도 하나의 공백이 아닌 문자가 있어야 합니다."),
    NAME_NULL("유효한 레이서 이름이 없습니다."),
    INVALID_REPEAT_NUMBER("횟수는 1 이상이어야 합니다."),
    NOT_NUMBER("반복 횟수는 숫자만 가능합니다.");

    private String message;
    private ErrorMessages(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
