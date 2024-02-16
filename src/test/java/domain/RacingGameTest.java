package domain;

class RacingGameTest {
//    @Test
//    @DisplayName("전진 경우의 게임 실행 결과를 구한다.")
//    void getGameResultMove() {
//        // given
//        MovementGenerator movementGenerator = () -> Movement.MOVE;
//        RacingGame racingGame = RacingGame.of(
//                Count.from(2),
//                Cars.from(List.of(Car.of("pobi", 2), Car.of("kirby", 3))),
//                movementGenerator);
//
//        // when
//        TurnsStatus gameResult = racingGame.getGameResult();
//
//        // then
//        assertThat(gameResult.getGameResult()).contains(
//                        TurnStatus.from(Cars.from(List.of(Car.of("pobi", 3), Car.of("kirby", 4)))),
//                        TurnStatus.from(Cars.from(List.of(Car.of("pobi", 4), Car.of("kirby", 5)))));
//    }
//
//    @Test
//    @DisplayName("전진하지 않는 경우의 게임 실행 결과를 구한다.")
//    void getGameResultStay() {
//        // given
//        MovementGenerator movementGenerator = () -> Movement.STAY;
//        RacingGame racingGame = RacingGame.of(
//                Count.from(2),
//                Cars.from(List.of(Car.of("pobi", 2), Car.of("kirby", 3))),
//                movementGenerator);
//
//        // when
//        TurnsStatus gameResult = racingGame.getGameResult();
//
//        // then
//        assertThat(gameResult.getGameResult()).contains(
//                        TurnStatus.from(Cars.from(List.of(Car.of("pobi", 2), Car.of("kirby", 3)))),
//                        TurnStatus.from(Cars.from(List.of(Car.of("pobi", 2), Car.of("kirby", 3)))));
//    }
}