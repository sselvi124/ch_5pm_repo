package practice;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementation implements IRetryAnalyzer{

	int count=0;
	int retryCount =3;
	public boolean retry(ITestResult result) {
		while(count<retryCount) { // o<=3t 1<=3 2<=3 3<=3t 4<=3f
			count++;  // 0++ 1++ 2++ 3++ 
		//	return true;
		}
		
		return false;
	} 
	
	
}
	
/*	public boolean retry(ITestResult result) {
		
		//0<3  1<3  2<3  3<3
		while(count<retryCount)
		{
			count++; // 1 2 3
			return true;  //retry  //retry   //retry
		}
		
		return false;  //stop
	} */
	
	


