# java-racingcar
## 기능 요구사항 
- 자동차
  - [x] 이름, 위치 가짐 
    - [x] 이름 5자 초과 or 빈 문자열 예외
  -  [x] 0~9 사이의 random 값을 받아 4 이상일 경우 전진, 3 이하이면 정지
- 자동차 경주 
  - [x] n 대의 자동차 생성
    - [x] 쉼표 기준 구분, 공백 제거
  - [ ] 진행 회수만큼 게임 진행
    - [ ] random 값 생성
    - [ ] n 대의 자동차 게임 진행
  - [ ] 우승자 목록 전달
- 입출력
  - 입력
    - [ ] 자동차 이름 쉼표 기준 구분하여 입력
    - [ ] 진행 회수 입력
  - 출력
    - [ ] 각 게임 결과 출력
    - [ ] 각 자동차 위치 받아 출력
    - [ ] 최종 우승자 출력

## 객체 설계
### Model
- Car
  - 이름, 위치 가짐
  - 전진 기능
- CarRepository
  - Car Collection 상태 관리
- RandNo
  - 0~9 정수 반환 

### Controller
- CarController
  - CarRepository 생성, 관리
  - 각 Car 게임 진행
- RacingController
  - InputView, ResultView 사이 데이터 전달
  - 이름, 진행 회수 CarController에 전달

### View
- InputView
  - 자동차 이름 입력
  - 진행 회수 입력
- ResultView
  - 각 게임 결과 출력
  - 최종 우승자 출력