# [레벨1] 자동차 경주 미션

## 구현할 기능

- [x] 경주할 자동차들의 이름을 사용자로부터 입력받는다.

  - [ ] 자동차 이름은 쉼표(,)를 기준으로 구분하여 받는다.
  - [ ] 자동차명으로 빈문자열 혹은 공백만 입력되면 예외가 발생한다.
  - 자동차명이 1대만 입력되어도 예외가 발생하지 않는다.
  - [ ] 자동차 이름이 5글자를 넘어가면 예외가 발생한다.
  
- [ ] 사용자로부터 전체 라운드 횟수로 양의 정수를 입력받는다.
  
  - [ ] 횟수로 정수 이외의 값이 입력되면 예외가 발생한다.
  - [ ] 횟수로 0이 입력되면 예외가 발생한다.
  - [ ] 횟수로 음수가 입력되면 예외가 발생한다.

- [ ] 각 라운드마다 각 자동차는 전진 혹은 정지한다.

  - [ ] 각 자동차는 0~9 사이의 숫자를 임의로 생성하고, 4 이상이면 전진한다.
  - [ ] 각 라운드 종료시, 모든 자동차의 현재 위치를 출력한다.

- [ ] 전체 라운드 종료 후 누가 우승자를 출력한다.

  - [ ] 우승자는 가장 멀리 전진한 자동차가 된다.
  - [ ] 우승자는 한 명 이상일 수 있다.
