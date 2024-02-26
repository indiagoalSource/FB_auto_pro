package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;



public class Utility {
	
	// Repeated code / common code
	// 2 method for Excel sheet data, Take screenShot method
	
	//	WebDriver driver ;
	
	public static void captureScreenshot(WebDriver driver, String testID) throws IOException {
		
		//e.g 		 -> Test-testID-DateAndTime.png
		//image name -> Test-T1017-24-02-2024-01-22-44.png
		
		String date = new SimpleDateFormat("dd-MM-YY-hh-mm-ss-SS").format(Calendar.getInstance().getTime());
		File scr1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("test-output/FailtestScreenshots/Test-"+testID+"-"+date+".png");
		FileHandler.copy(scr1, dest);
		
	}
	
	
	// Test class input -> SheetName, Row No, Cell No.
	public static String getExcelData(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
		
		FileInputStream file = new FileInputStream("src/main/resources/Data/testDataForSelenium.xlsx");
		Workbook book = WorkbookFactory.create(file);
		//return book.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		
		
		try {
			
			return book.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		}
		catch(IllegalStateException e){
			
			double value =  book.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getNumericCellValue();
			
			//convert double to string 
			String data = String.valueOf(value) ;
			return data ;
			
		}
		
	}
	
}
