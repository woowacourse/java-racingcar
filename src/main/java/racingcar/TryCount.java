package racingcar;

public class TryCount {
    private int count = 0;

    public TryCount(int count) throws IllegalArgumentException {
        if (count <= 0)
            throw new IllegalArgumentException("0이상의 자연수만 입력할 수 있습니다.\n다시 입력해주세요.");

        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
