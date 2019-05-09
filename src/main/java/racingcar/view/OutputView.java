package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    public static void printRounds(List<String> names, List<Integer> positions) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < positions.size();) {
            for (int j = 0; j < names.size(); i++, j++) {
                System.out.println(names.get(j) + " : " + drawTrail(positions.get(i)));
            }
            System.out.println();
        }
    }

    private static String drawTrail(int length) {
        StringBuffer trail = new StringBuffer();

        for (int i = 0; i < length; i++) {
            trail.append("-");
        }
        return trail.toString();
    }

    public static void printWinners(List<Car> winners) {
        String winnerList = winners.toString();
        System.out.println(
                winnerList.substring(1, winnerList.length() - 1)
                + IOValidation.differentiateIGa(winnerList.charAt(winnerList.length() - 2))
                + " 최종 우승했습니다."
        );

    }
}