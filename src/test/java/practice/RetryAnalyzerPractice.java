package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractice {
	@Test(retryAnalyzer = RetryAnalyserImplementation.class)
	public void analyser()
	{
		Assert.fail();
		System.out.println("hi");
	}

}
