package kr.or.test;

class MemberVO {
	private String name; // 통상적으로 보안때문에 private을 써서 만든다.
	private int age;
	private String phoneNum;
	
	@Override
	public String toString() {
		return "MemberVO클래스 [이름은=" + name + ", 나이는=" + age + ", 전화번호는=" + phoneNum + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}	
}

public class Step2 {
	
	public static void main(String[] args) { 
		System.out.println("-----------------------------");
		System.out.println("클래스를 사용한 사용자정의 자료형 소스");
		//클래스형 변수: 사용자 정의 자료형 사용하기(아래)
		//MemberVO 클래스를 사용하기 위해 new연산자를 이용해 객체(instance) 생성
		MemberVO m1 =new MemberVO();
		m1.setName("홍길동");
		m1.setAge(45);
		m1.setPhoneNum("000-0000-0000");
		// 마찬가지로 다른 MemberVo객체(instance)를 생성해서 값을 ↓
		MemberVO m2 = new MemberVO();
		m2.setName("성춘향");
		m2.setAge(100);
		m2.setPhoneNum("111-1111-1111");
		MemberVO m3 = new MemberVO();
		m3.setName("각시탈");
		m3.setAge(3);
		m3.setPhoneNum("333-3333-3333"); 
		/*System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m3.toString());*/
		
		// 크기가 3인 MemberVO클래스를 배열객체로 선언
		MemberVO[] members = new MemberVO[3];
		//MemberVO배열클래스 참조index에 각각의 실행클래스(m1,m2,m3)의 자료를 넣어준다.
		members[0] = m1;
		members[1] = m2;
		members[2] = m3;
		//출력: MemberService 클래스를 사용
		MemberService ms = new MemberService(); 
		ms.printMembers(members);
  	}	
}
class MemberService {
	//액션 - 서비스 클래스 - 출력용 매서드 작성
	//매개변수로 클래스배열을 받아서 출력하는 형태로 작성
	public void printMembers(MemberVO[] members) {
		//향상된 for(loop)문 사용
		//배열 members에 들어있는 값을 처음부터 끝까지 차례대로 하나씩 꺼내서 MemberVO로 선언된 변수 m에 담아서 출력
		for(MemberVO m : members) {
			System.out.println("이름은 " + m.getName() + " 입니다.");
			System.out.println("나이는 " + m.getAge() + " 세 입니다.");
			System.out.println("전화번호는 " + m.getPhoneNum() + "입니다.");
	}
}
}