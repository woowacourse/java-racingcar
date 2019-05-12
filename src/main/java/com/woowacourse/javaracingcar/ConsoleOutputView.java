package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.domain.CarDto;
import com.woowacourse.javaracingcar.domain.PlayingCars;
import com.woowacourse.javaracingcar.domain.WinnerGroup;
import com.woowacourse.javaracingcar.interfaces.OutputView;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printResultTitle() {
        System.out.println("실행 결과");
    }

    @Override
    public void printResult(PlayingCars cars) {
        for (CarDto c : cars.retrieveAllCars()) {
            System.out.println(carToString(c));
        }

        System.out.println();
    }

    public String carToString(CarDto car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName()).append(" : ");
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append('-');
        }

        return sb.toString();
    }

    @Override
    public void printWinners(WinnerGroup winners) {
        String str = RacingcarUtil.joinCarNames(winners.getWinners());
        System.out.println(str + "가 최종 우승했습니다.");
    }
}
