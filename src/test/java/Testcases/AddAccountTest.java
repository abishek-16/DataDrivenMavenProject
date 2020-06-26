package Testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Baseclass.testbase;
import Utilities.TestUtil;

public class AddAccountTest extends testbase {
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
public void addAccountTest(Hashtable<String,String> data) throws InterruptedException {

		
		if(!(TestUtil.isTestRunnable("addAccountTest", excel))){
			
			throw new SkipException("Skipping the test "+"addAccountTest".toUpperCase()+ "as the Run mode is NO");
		}
		
		
		click("openaccount_CSS");
		select("customer_CSS", data.get("customer"));
		select("currency_CSS", data.get("currency"));
		click("process_CSS");
		Thread.sleep(2000);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();

	}

}

