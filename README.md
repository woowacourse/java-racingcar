## 기능 구현 목록

### 입력 처리
- [x] 각 자동차에 이름을 부여할 수 있다.
- [x] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.

### 입력 검증
- [x] 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- [x] 이름은 5자 이하만 가능하다.
- [x] 이동 횟수에 대해 정수인지 검증한다.
- [x] 이동 횟수에 대해 음수가 아닌지 검증한다.
- [x] 올바르지 않은 형태로 입력될 경우 해당 부분부터 다시 입력받는다.

### 핵심 도메인
- [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [x] 전진하는 조건은 0에서 9 사이에서 random 값을 구한다.
- [x] random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- [x] 우승자는 한 명 이상일 수 있다.

### 출력 처리
- [x] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [x] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.