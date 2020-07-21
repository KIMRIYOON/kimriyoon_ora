package kr.or.test;
// 대문자로 시작했다는 건 클래스를 의미함. String=문자열
// 클래스 안에는 매서드 등이 내장되어있음. 클래스+. 하면 안의 매서드나 변수를 보고 선택할 수 있음
// String name = "123"l //문자열형 char var3 = 'a'; //단일문자형
// System.out.println 출력할때 쯤. System대문자로시작하므로 클래스.
// 형이 다른 변수를 출력할때는 + 로 합해준다. ex) System.out.println(num_name + "님 안녕하세요. 자바 !")

// if문 사용법
// int score = 85; {   <-----스코어를 90으로 설정해 둔 상태에서↓
// ! = not(조건값 반대) 이라는 의미. ex) if(!(score>90)) 만약 scrore가 90보다 크지 않으면이라는 의미 ↓
// result(값) = "가"; 라고쓰고나서 System.out.println으로 출력해보면  값이 85보다 작으니까 가 라고 나온다.
// 여기에 else(그렇지않으면) { result = "나"; } 라고 반대일 경우의 값을 설정해둘수도있다.
// 이것을 삼항조건 축약문으로 만들면 //result = (!(score>90))?"가":"나"; 라고 쓸 수도 있다. 위의if문이랑 똑같은 결과가 나옴.

// &&(앤드기호) = and랑 똑같은 말 ||(파이프라인) = or랑 똑같은 말

// boolean변수 쓰는 방법 ↓↓↓ boolean변수는 true(1) 아니면 false(0)로 결과값이 나옴.
// int x = 10; , int y= 5; ===> int변수로 x와 y값을 설정해놓고
// boolean result1,result2,result3; ===> boolean변수를 지정하고
// result1 = (x>7)&&(y<=5); ===> result1,2,3의 조건을 지정해준 다음 (비교구문)
// result2 = (x<7)&&(y<=5);
// result3 = (x<7)||(y<=5);
// System.out.println("1번:" + result1) ===> 이런식으로 값을 출력하면, 조건에 따라 true인지 false인지 출력해줌

// 1부터 100까지 합을 구하기
// 먼저 변수지정
// int sum = 0; =====> sum이라는 이름의 int(정수)형태의 변수는 값이 0이다.
// for(int cnt=1;cnt<=100;cnt++) {
//     sum - sum + cnt;} =====> sum은 누적변수, cnt는 증가변수
// System.out.println("1부터 100까지의 합은" + sum + "입니다.") ===>로 출력해보면

// [대괄호]{중괄호}(소괄호)
// 반복문은 어떤 작업(코드들)이 반복적으로 실행되도록 할 때 사용되며, 반복문의 종류로는 for문, while문, do-while문이 있다.
// for문, while문은 서로 변환이 가능하기 때문에 반복문을 작성할 때 어느 쪽을 선택해도 좋지만, ↓
// for문은 반복 횟수를 알고 있을 때 주로 사용하고 while문은 조건에 따라 반복할 때 주로 사용합니다.

// println할때 ln는 = new line이라는 뜻. 새로운 줄을 만들어라. 그냥 print는 줄바꿈이 없다.
// nextInt() <==== 키보드로 입력받은 숫자. 키보드로 입력 할 아무 숫자

// run = false; =====> while문을 빠져나가는 명령
// break; =====> switch문을 빠져나가는 명령

// 상속문 예시(extend)
// Tire라는 클래스가 하나 있고, SnowTire라는 클래스를 하나 만들고싶은데, Tire라는 클래스를 상속받고싶을경우
// class SnowTire extends Tire { } 라는 형태를 사용함.
// 





