package application.racingGame;

public class RacingInformationValidator {

    public static final int ZERO = 0;

    public static int validateRacingLab(String input) {
        int racingLab = checkRacingLabValue(input);
        return racingLab;
    }

    public static int checkRacingLabValue(String input) {
        int racingLab;
        try {
            racingLab = Integer.parseInt(input);
            checkNegativeNumber(racingLab);
        } catch(Exception e){
            throw new IllegalArgumentException("양의 숫자를 다시 입력하십시오.\n 잘못된 값을 입력했으므로 다시 시작합니다.");
        }
        return racingLab;
    }

    public static void checkNegativeNumber(int racingLab) {
        if(isNegativeNumber(racingLab)) {
            throw new IllegalArgumentException("0 이상의 수를 입력하십시오.");
        }
    }

    private static boolean isNegativeNumber(int racingLab) {
        return racingLab < ZERO;
    }

}
