package racingcar.domain;

public class Lap {
    private final int lap;

    public Lap(String inputLap) {
        int numberLap = validateNumberLap(inputLap);
        this.lap = validatePositiveLap(numberLap);
    }

    private int validateNumberLap(String inputLap) {
        try{
            return Integer.parseInt(inputLap);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자가 아닌 입력입니다.");
        }
    }

    private int validatePositiveLap(int numberLap) {
        if(numberLap < 1){
            throw new IllegalArgumentException("1 미만의 입력입니다.");
        }
        return numberLap;
    }

    public int getLap() {
        return lap;
    }
}
