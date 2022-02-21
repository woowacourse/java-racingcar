# 문자열 덧셈 계산기
## 기능 요구사항
- 쉼표(,) 또는 콜론(:)을 구분자로 분리한다.
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다.
    - "//"과 "\n" 사이의 커스텀 구분자 추출
        - (예시 : “//;\n1;2;3” => `;`가 커스텀 구분자)
    - 문자열을 구분자 기준으로 분리
- 분리된 문자열 합하여 반환한다.
    - 빈 문자열 or null 입력시 0 반환
    - 숫자 하나 입력시 해당 숫자 반환
    - 숫자 두개 컴마(,) 구분자 입력시 합 반환
- 숫자 이외의 값 or 음수 전달하는 경우 `RuntimeException` throw

## 리팩토링 기능 요구사항
Main
- 자동차 이름 출력 뷰 call한다.

- 자동차 이름을 입력 받는 InputView call한다.
- 입력 받은 자동차 이름을 split하여 CarController에 생성 메세지을 보낸다.

- 시도할 횟수 입력 뷰를 call한다.
- 실행 결과 뷰를 호출하고, 그 결과 출력을 요청하는 메시지를 CarController에게 보낸다.

CarController
- 자동차 생성
	- 자동차 이름(잘려서 받음)을 받아서, List<CarDto>로 변환하여 CarService에 전달한다.
- 자동차 이동
	- 전달 받은 시도 횟수 만큼 CarService에서 자동차들을 움직이게 하는 메소드를 호출한다.
- 자동차 점수판
	- CarService에게 현재까지의 Score결과를 요청한다.

CarService
- 자동차 생성
	- 자동차를 생성하여 CarRepository에 저장한다.
- 자동차 이동
	- Random값 리스트를 자동차 갯수 만큼 생성하여 carRepository에서 자동차를 움직여준다.
	- 이동한 자동차를 ScoreRepository에 저장한다. (Score를 만들어서 저장한다.)
- 자동차 점수판
	- ScoreRepository를 읽어온 후, DTO로 변환해서 반환한다.


CarRepository
- 자동차 생성
	- 전달 받은 CarDto를 List<Car>에 저장한다.