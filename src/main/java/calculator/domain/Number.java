package calculator.domain;

public class Number {
    private final int number;

    public Number(String number) {
        if(number.isBlank()) {
            throw new RuntimeException("빈 값이 포함되어 있습니다.");
        }
        this.number = parseNumber(number);
        if (this.number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다!");
        }
    }

    private int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 이외의 값은 입력할 수 없습니다!");
        }
    }

    public int getNumber() {
        return this.number;
    }

}
