package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InputDataValues {

	private static String ValidUsername;
	private static String InvalidUsername;
	private static String Password;
	private static String SortingMethod;
	private static String firstname;
	private static String Lastname;
	private static String postalcode;

	public void data() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/ExcelInput.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet worksheet = workbook.getSheet("Input");
		XSSFRow row = worksheet.getRow(1);

		ValidUsername = row.getCell(0).toString();
		InvalidUsername = row.getCell(1).toString();
		Password = row.getCell(2).toString();
		SortingMethod = row.getCell(3).toString();
		firstname = row.getCell(4).toString();
		Lastname = row.getCell(5).toString();
		postalcode = row.getCell(6).toString();
		
		workbook.close();
	}

	public String getValidUsername() {
		return ValidUsername;
	}

	public String getInvalidUsername() {
		return InvalidUsername;
	}

	public String getPassword() {
		return Password;
	}

	public String getSortingMethod() {
		return SortingMethod;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public String getPostalcode() {
		return postalcode;
	}

	
}