package kr.or.test;

public class Step1 {

	public static void main(String[] args) {
		System.out.println("------------------------------");
		System.out.println("클래스를 사용하지 않는 내장변수 자료형 소스");
		// 필드=field=변수 <--다 같은 말
		String name;
		int age;
		String phoneNum;
		
		name = "홍길동";
		age = 45;
		phoneNum = "000-0000-0000";
		printMember(name, age, phoneNum);
		
		name = "성춘향";
		age = 100;
		phoneNum = "111-1111-1111";
		printMember(name, age, phoneNum);
		
		name = "각시탈";
		age = 3;
		phoneNum = "222-2222-2222";
		printMember(name, age, phoneNum);
				
		System.out.println("------------------------------");
		System.out.println("내장변수 배열자료형 소스");
	    // 필드=field=배열변수
		String[] names = {"홍길동","성춘향","각시탈"};
		System.out.println("현재 등록된 회원은" + names.length + " 명 입니다.");
		//위에서 name.다음에 length같은 매서드를 쓸 수 있는 이유는 String클래스 안에 있기 때문이다.
		int[] ages = {45,100,3};
		String[] phoneNums = null;
		phoneNums = new String[] {"000-0000-0000","111-1111-1111","222-2222-2222"};
		printMember(names, ages, phoneNums);
	}
    // 같은 이름의 매서드인데 파라미터(매개변수)를 다르게 만든 매서드를 오버로딩이라고 함. 이름은같아도, 로딩하는게 다름.
	private static void printMember(String[] names, int[] ages, String[] phoneNums) {
		for (int cnt=0; cnt<3; cnt++) {	// <===== 0부터 시작하는데, 3보다는 작게, 점점 늘어나게 라는 뜻.
			                            // <===== 그래서 cnt할때 0부터 시작하고 최대 3까지 카운트된다.
			// 배열은 값을 참조할 때 주소(index)를 사용하는데, 그게 0번 주소부터 시작한다.
			System.out.println("------------");
				System.out.println(cnt + "번째 참조한 이름은 " + names[cnt] + " 님 입니다.");
				System.out.println(cnt + "번째 참조한 나이는 " + ages[cnt] + " 살 입니다.");
				System.out.println(cnt + "번째 참조한 전화번호는 " + phoneNums[cnt] + " 입니다.");
		}	
	}

	private static void printMember(String name, int age, String phoneNum) {
		System.out.println("이름은 " + name + " 님 입니다.");
		System.out.println("나이는 " + age + " 살 입니다.");
		System.out.println("전화번호는 " + phoneNum + " 입니다.");
		
	}
}