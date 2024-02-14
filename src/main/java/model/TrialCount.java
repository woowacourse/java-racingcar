package model;

public class TrialCount {
    private int number;

    public TrialCount(int number) {
        validatePositive(number);
        this.number = number;
    }

    private void validatePositive(int number) {
        if(number <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public void reduce() {
        number--;
    }


    public boolean isRest() {
        return number > 0;
    }

}
