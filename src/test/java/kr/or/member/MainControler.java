package kr.or.member;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

public class MainControler {

	private static final String TIME_SERVER = "pool.ntp.org";

	public static void main(String[] args) throws IOException {
		System.out.println("클래스형 변수-사용자정의 자료형");
		//MemberVO 클래스를 실행하기 위해 new 연산자 사용
		MemberVO m1 = new MemberVO();
		// setter 메서드를 이용해 해당 인스턴스 변수에 값을 넣는다.
		m1.setName("김리윤");
		m1.setAge(45);
		m1.setPhoneNum("000-0000-0000");
		// 마찬가지로 다른 MemberVO객체(instance)를 생성해서 값을 넣는다.
		MemberVO m2 = new MemberVO();
		MemberVO m3 = new MemberVO();
		m2.setName("김리윤");
		m2.setAge(100);
		m2.setPhoneNum("111-1111-1111");
		m3.setName("김리윤");
		m3.setAge(3);
		m3.setPhoneNum("222-2222-2222");
		
		//크기가 3인 MemberVO클래스를 배열객체로 선언
		MemberVO[] members = new MemberVO[3];
		//MemberVO[]배열클래스 참조index에 m1,m2,m3를 넣는다.
		members[0] = m1;
		members[1] = m2;
		members[2] = m3;
		//출력: MemberService 클래스를 사용
		MemberService ms = new MemberService();
		ms.printMembers(members);
		
		// MainControl 클래스에 아래 내용 추가하 후 에러 상황 처리하기를 이용해서 외부 라이브러리 사용방법 확인 -->
		System.out.println("-서버타임 출력하기-");
		NTPUDPClient timeClient = new NTPUDPClient();
		timeClient.setDefaultTimeout(1000);
		try {
			timeClient.open();
		} catch (SocketException e) {
			System.out.println("open메서드 실행 오류");
			e.printStackTrace();
		}
		InetAddress address = InetAddress.getByName(TIME_SERVER);
	    TimeInfo timeInfo = timeClient.getTime(address);
	    //서버로부터 시간 가져오는 코드
	    long returnTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();
	    Date date = new Date(returnTime);
	    LocalDateTime localDateTime = 
	            date.toInstant()
	            .atZone(ZoneId.systemDefault())
	            .toLocalDateTime();//date to LocalDateTime
	    
	    System.out.println("Server 시간: " + localDateTime);//서버 시간!
	    System.out.println("로컬 PC 시간: " + LocalDateTime.now());

	}

}
//그냥 일반 클래스 하나 생성할 때 public class 클래스이름 { }
//String =====> 문자열
//필드 = 변수, 변수표기
//phoneNum같이 단어를 합쳐 만든 변수는 두번째단어 첫번째글자에 대문자를 사용해서 낙타 등 같다. 그래서 camel 표기법이라고 한다.
//printMember(name, age, phoneNum); <===== 이러한 형태를 메서드의 매개변수로 값을 전달한다고 한다.
//매개변수 = 파라미터
//자바를 쓰는 모든 프로그램에서 대괄호 []가 들어있으면 무조건 배열형
//같은 이름의 매서드인데 파라미터(매개변수)를 다르게 만든 매서드를 오버로딩이라고 함. 이름은같아도, 로딩하는게 다름.
//간단하게 오버로드란, 같은 이름인데 매개변수가 다른 것.
//배열은 값을 참조할 때 주소(index)를 사용하는데, 그게 0번 주소부터 시작한다. 그래서 cnt=0부터 시작하는거임
//ValueObject 클래스형 자료형
//get set 메서드를 한번에 만드는 방법: 마우스오른쪽클릭-->Source--->Grenerate getters and setters
//public void에서 void(0)는 실행 메서드이긴한데, 돌려받는값이 없음.반환값이 없음 void = return false

