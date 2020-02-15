//package racingcar.domain;
//
//import racingcar.domain.car.Car;
//import racingcar.domain.car.Cars;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class Winners {
//    private static final String AND = ", ";
//
//    public Car findCarAtMaxLocation(Cars cars) {
//        return Collections.max(cars);
//    }
//
//    private List<Car> findWinners(List<Car> cars, Car carAtMaxLocation) {
//        Car carAtMaxLocation = findCarAtMaxLocation(cars);
//        List<Car> winners = cars.getCars().stream()
//                .filter(car -> car.isAtSameLocation(carAtMaxLocation))
//                .collect(Collectors.toList());
//        return winners;
//    }
//
//    public String getWinnersName() {
//        List<String> winnerNames = winners.stream()
//                .map(Car::toString)
//                .collect(Collectors.toList());
//
//        return String.join(AND, winnerNames);
//    }
//}