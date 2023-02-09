## 🧐 미션 목표
+ 기능 구현 완료
+ SRP(Single Responsibility Principle) 원칙 준수
+ MVC 패턴 적용

## 📚 기능 목록
- [x] 사용자의 입력을 받는다.
  - [x] 자동차 이름을 입력받는다. InputView#requestCarName()
  - [x] 시도 횟수를 입력받는다. InputView#requestTryCount()
- [x] 사용자 입력을 검증한다.
  - [x] 자동차 이름을 검증한다.
    - 쉼표 구분 CommaSeparator#sliceNameByComma()
    - 5글자 이하 Name#validateName()
  - [x] 시도 횟수 검증한다. TryCount
    - 정수 입력
    - 0 제외
- [x] 랜덤값 생성한다. RandomGenerator#getRandomInteger
  - 0 ~ 9 사이 정수
- [x] 자동차 전진한다. RacingCar#Move
- [x] 레이싱 게임을 주관한다. RacingCars#moveAll()
- [ ] 실행 결과 출력
- [ ] 최종 우승자 출력