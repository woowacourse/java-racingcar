public class InputException {
    public void checkCarNameLength(String carName) throws IllegalArgumentException {
        if (carName.length() > 5 || carName.length() < 1) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름의 길이가 1이상 4자 이하여야 합니다.");
        }
    }
}
