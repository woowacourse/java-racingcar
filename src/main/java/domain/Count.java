package domain;

public class Count {
    private final int count;
    private int remain;

    public Count(int count) {
        validateCount(count);
        this.count = count;
        this.remain = count;
    }

    private void validateCount(int count) {
        if (count <= 0 || count > 100) {
            throw new IllegalArgumentException("회수의 범위는 1 이상 100 이하 입니다.");
        }
    }

    public int getCount() {
        return count;
    }

    public boolean hasRemain() {
        return remain > 0;
    }

    public void down() {
        remain--;
    }
}
