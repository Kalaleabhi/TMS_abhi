package Practice;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import com.WebDriverUtils.ExcelUtility;

public class Dummy {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WebDriver driver=null;
		ExcelUtility eLib = new	ExcelUtility();
		HashMap<String, String> map = eLib.getMultipleDataFromExcel("EnquiryDetails", 0, 1, driver);
		for(Entry<String, String> s:map.entrySet())
		{
			if(s.getKey().contains("  "))
			{
				System.out.println("hi");
			}
			System.out.println(s.getKey());
			System.out.println(s.getValue());
		}
	}
}
