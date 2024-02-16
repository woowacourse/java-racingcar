# 📌 핵심 기능: 랜덤한 자동차 게임의 우승자를 가린다.

# 📝기능 구현 목록

- [x] 자동차 이름을 입력받는다.
- [x] 자동차 게임 횟수를 입력받는다.
- [x] 자동차를 게임 횟수만큼 움직인다.
    - [x] 랜덤 숫자에 따라 이동여부를 결정한다.
    - [x] 이동 여부에 따라 자동차가 전진 혹은 정지한다.
- [x] 이동된 거리를 바탕으로 우승자를 구한다.
- [x] 우승자를 출력한다.

# 자체 추가한 기능 요구사항

- [x] 예외가 발생하면 재입력을 받는다.
- [x] 자동차는 2~50대 사이로 게임을 실행할 수 있다.
- [x] 시도할 횟수는 100회까지 허용한다.
- [x] 자동차 이름은 ","을 포함할 수 없다.
- [x] 공백은 허용하지 않는다.
- [x] "," 사이의 공백은 허용한다.

# ⚠️ 예외 처리

- [x] 자동차 이름들 입력 형식의 유효성 검증
  - [x] 공백이 아닌지
  - [x] ","가 2번이상 연속으로 들어가지 않는지
    - [x] 맨 앞, 뒤에 ","가 있지 않은지


- [x] 시도 횟수 입력 형식의 유효성 검증
    - [x] 공백이 아닌지
    - [x] 수인지
    - [x] 1 이상의 수인지

-[x] 자동차 이름의 유효성 검증
    - [x] 자동차 이름 길이가 1에서 5 사이인지

-[x] 시도 횟수의 유효성 검증
    - [x] 1이상 100이하인지

# 🛠 리팩토링 목록

- [x] 원시값 포장 확인
- [x] 일급 컬렉션 필요 부분 확인
- [x] 숫자 리터럴 상수화
- [x] 컨트롤러 메소드 네이밍 정리 및 분리 개선
- [x] 부생성자가 있는 경우 부생성자가 합당한지,
- [x] 부생성자가 있는 경우 생성자의 접근제어자가 private인지
- [x] 객체 생성이 불필요한 경우 private 생성자가 있는지
- [x] 각 클래스의 책임 범위 위반한 것 없는지 점검하기
    - [x] public 메소드가 클래스에 많다면
- [x] 메서드 길이가 15 넘어가지 않는지 확인
- [x] 각 클래스 점검하기
    - [x] 불필요한 public 접근제어자
    - [x] 메소드 순서
- [x] 이해를 위한 코드 전반의 공백 추가
- [ ] 단위 테스트 모두 됐는지 확인
  - [x] cars.move -> 반복문, 호출 정도만 필요하므로 테스트 필요 적음
  - [x] getGameResult.getGameResult
  - [x] RandomNumberGenerator.generate -> 자바 자체 메서드 이용한 것으로 테스트 필요 적음
  - [x] Winner.getWinners
- [ ] 테스트 코드 리팩토링
 
# 🧐 추가 반영할 부분

2. extracting 사용법
3. 해당 함수가 실행되었는지, 몇회 실행되었는지 확인하는 테스트 메서드
4. dto를 컨트롤러에서 만들어서 뷰로 보내도 되는지, dto 생성의 위치가 컨트롤러여도 되는지.
5. 입력을 받아서 입력 받은 DTO를 컨트롤러에 객체를 생성해서 넘겨주느냐, 아니면 각 객체에서 DTO를 자체적으로 변환하느냐 (CarNameRequst를 Cars로 변환하려는 시도)
6. 재입력 처리의 책임이 컨트롤러가 맞을지, 예외를 처리하는 클래스가 있어야할지.
7. 가능한 class를 record로 바꿨을 때 부작용이 있을지??
8. 함수가 호출 되는지 확인하는 테스트 추가 필요(Car Move)
- [x] 랜덤이동여부 생성에서 랜덤 숫자를 임의 주입해서 생성할 수 있게 하는 방법

 