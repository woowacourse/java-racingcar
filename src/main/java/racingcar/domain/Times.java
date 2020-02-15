package racingcar.domain;

public class Times {
    public static final int MINIMUM = 1;
    private int times;

    public Times(String times) {
        int parsed = Integer.parseInt(times);
        if (parsed < MINIMUM) {
            throw new IllegalArgumentException("올바르지 않은 시간 형식입니다.");
        }
        this.times = parsed;
    }

    public void reduce() {
        times--;
    }

    public boolean isDone() {
        return times == 0;
    }
}
