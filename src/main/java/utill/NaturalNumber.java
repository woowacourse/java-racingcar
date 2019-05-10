package utill;

public class NaturalNumber {
    int number;

    NaturalNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("자연수가 아닙니다.");
        }

        this.number = number;
    }

    int toIndex() {
        return number - 1;
    }
}
