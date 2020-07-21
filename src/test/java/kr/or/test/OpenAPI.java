package kr.or.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class OpenAPI {
	
	//외부연계 매서드
	public static void serviceApi() {
		BufferedReader br = null; //HRD넷에서 전송받은 데이터를 일시저장하는 저수지와 같은 역할
		String urlstr = "http://www.hrd.go.kr/hrdp/api/apipo/APIPO0101T.do?srchTraEndDt=20201231&pageSize=10&srchTraArea1=44&srchTraStDt=20200501&sortCol=TR_STT_DT&authKey=bsTluRJAbUl7HvbBPSohmMavdk9X50dq&sort=DESC&returnType=XML&outType=1&pageNum=1&srchTraPattern=N1&srchPart=-99&apiRequstPageUrlAdres=/jsp/HRDP/HRDPO00/HRDPOA60/HRDPOA60_1.jsp&apiRequstIp=58.74.90.6";
		//인증키부분은 노출되지 않도록 한글로 바꿔서 놓는것이 좋다. 
		//URL이 너무 길 경우 한눈에 보기 쉽도록 "주소"+"주소"+"주소" 형식으로 잘라놓아도 된다.
		try {
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"euc-kr"));
			String result = "";
			String line;
			while((line=br.readLine()) != null) {
				result = result + line + "\n";
				//1부터 100까지 더하는 로직과 같다
			}
			//System.out.println(result);
			String result_xmlUtils = XmlUtils.formatXml(result);
			System.out.println(result_xmlUtils);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			//콘솔화면에 현재 PC시간을 표시해준다.
			Calendar cal = Calendar.getInstance();
			System.out.println(cal.getTime());
	}
	public static void main(String[] args) {
		//실행간격 지정(5초)
		int sleepSec = 5;
		//주기적인 작업을 위한 코딩 exec 실행가능한 클래스만듬
		final ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
		exec.scheduleAtFixedRate(new Runnable() {
			public void run() {
				serviceApi();
			}
		}, 0, sleepSec, TimeUnit.SECONDS);
		
		//serviceApi();

	}

}
