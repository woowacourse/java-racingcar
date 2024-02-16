package domain;

public class Count {
    private int count;

    public Count(int count) {
        validateCount(count);
        this.count = count;
    }

    private void validateCount(int count) {
        if (count <= 0 || count > 100) {
            throw new IllegalArgumentException("회수의 범위는 1 이상 100 이하 입니다.");
        }
    }

    public boolean isRemain() {
        return count > 0;
    }

    public void down() {
        count--;
    }
}
