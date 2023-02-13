# 2단계 리팩터링 구현
## 핵심 비지니스 로직 -> 도메인 객체로 이동
- [x] `OutputView`에서 `Car`객체(모델)를 사용하는 메서드들 수정
- [x] RacingGame에서 `Car`객체(모델)를 사용하여 출력하는 로직 구현

## 테스트 가능한 부분과 힘든 부분 분리
- [x] CarManager객체에서 Car.move 메서드를 호출할때
CarMovement라는 자동차 움직임을 담당하는 객체를 입력으로 넣는데, 
CarManager에서는 CarMovement에 랜덤값을 넣고, 테스트할 때는 
지정된 숫자를 넣는 방식으로 구현

## 1단계 피드백 반영
- [x] 접근제한자 위치 수정(static <-> private)
- [x] 미입력된 접근제한자 추가
- [x] forEach에 로직을 추가해서 생긴 위협성 for-loop로 변경
- [x] return에 불필요한 로직 제거