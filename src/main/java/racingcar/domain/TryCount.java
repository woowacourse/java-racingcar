package racingcar.domain;

import java.util.Objects;

public class TryCount {
    private int count;

    public TryCount(String stringCount) throws IllegalArgumentException {
        validTryNumberException(stringCount);

        this.count = Integer.parseInt(stringCount);
    }

    private void validTryNumberException(String stringCount) throws IllegalArgumentException {
        if (!isNumeric(stringCount)) {
            throw new IllegalArgumentException("문자열을 입력할 수 없습니다.\n 다시 입력해 주세요.");
        }
        if (Integer.parseInt(stringCount) <= 0) {
            throw new IllegalArgumentException("0이상의 자연수만 입력할 수 있습니다.\n다시 입력해주세요.");
        }
    }

    public static boolean isNumeric(String str) { //문자열이 숫자인지 아닌지 판단하는 메소드
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TryCount tryCount = (TryCount) o;
        return count == tryCount.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
