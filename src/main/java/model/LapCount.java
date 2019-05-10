package model;

public class LapCount {
    static final String REGEX_IS_NATURAL_NUMBER = "^([1-9])([0-9])*$";
    private int lapCount;

    public LapCount(String lapCount) {
        this.lapCount = parseNaturalNumber(lapCount);
    }

    private int parseNaturalNumber(String lapCount) {
        if (lapCount.matches(REGEX_IS_NATURAL_NUMBER)) {
            throw new IllegalArgumentException("시도 횟수는 자연수입니다.");
        }

        try {
            return Integer.parseInt(lapCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수가 정수 범위롤 초과힙니다.");
        }
    }

    public int getLapCount() {
        return lapCount;
    }
}
