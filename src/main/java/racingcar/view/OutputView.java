package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Race;

import java.util.List;

public class OutputView {
    public static void printRounds(int numberOfTrials, Race race) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < numberOfTrials; i++) {
            for (int j = 0; j < race.getNumberOfCars(); j++) {
                printLane(race.startRound());
            }
            System.out.println();
        }
    }

    public static void printLane(Car car) {
        System.out.println(car + " : " + car.drawTrail());
    }

    public static void printWinners(List<Car> winners) {
        String winnerList = winners.toString();
        System.out.println(
                winnerList.substring(1, winnerList.length() - 1)
                + differentiateIGa(winnerList.charAt(winnerList.length() - 2))
                + " 최종 우승했습니다."
        );
    }

    /*
    앞 글자에 따라 조사 이, 가 구분
    */
    private static String differentiateIGa(final char letter) {
        final char[] CONVERSION_TABLE = ("영일이삼사오육칠팔구:;<=>?@"
                + "이비씨디이프쥐치이이이엘엠엔오피큐알쓰티유이유스이지"
                + "[원]^_`이비씨디이프쥐치이이이엘엠엔오피큐알쓰티유이유스이지"
        ).toCharArray();
        if (48 <= letter && letter <= 122) {
            return ((CONVERSION_TABLE[letter - 48] - 0xAC00) % 28 == 0) ? "가" : "이";
        }
        return ((letter - 0xAC00) % 28 == 0) ? "가" : "이";
    }
}