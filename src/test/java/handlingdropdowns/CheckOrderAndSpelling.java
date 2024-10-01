package handlingdropdowns;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckOrderAndSpelling {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/Book1.xlsx");
		List<String> expectedDayList = new ArrayList<String>();
		List<String> expectedMonthList = new ArrayList<String>();
		List<String> expectedYearList = new ArrayList<String>();
		List<String> actualDayList = new ArrayList<String>();
		List<String> actualMonthList = new ArrayList<String>();
		List<String> actualYearList = new ArrayList<String>();
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		int lastRowIndexNum = sheet.getLastRowNum();
		// System.out.println(lastRowIndexNum);
		int firstRowIndexNum = sheet.getFirstRowNum();
		// System.out.println(firstRowIndexNum);
		for (int i = firstRowIndexNum; i <= lastRowIndexNum; i++) {
			int actualCellCount = sheet.getRow(i).getLastCellNum();
			// System.out.println(actualCellCount);31,12,119
			int firstCellIndexNumInEachRow = sheet.getRow(i).getFirstCellNum();
			// System.out.println(firstCellIndexNumInEachRow); 0,0,0
			for (int j = firstCellIndexNumInEachRow; j < actualCellCount; j++) {
				CellType cellType = sheet.getRow(i).getCell(j).getCellType();
				// System.out.println(cellType);
				if (String.valueOf(cellType).equals("NUMERIC")) {
					long numData = (long) sheet.getRow(i).getCell(j).getNumericCellValue();
					// System.out.println(numData);
					if (actualCellCount <= 31) {
						expectedDayList.add(String.valueOf(numData));
					} else
						expectedYearList.add(String.valueOf(numData));
				} else if (String.valueOf(cellType).equals("STRING")) {
					String stringData = sheet.getRow(i).getCell(j).getStringCellValue();
					// System.out.println(stringData);
					expectedMonthList.add(stringData);
				}
			}

		}
		workbook.close();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/signup");
		List<WebElement> allDropDowns = driver.findElements(By.tagName("select"));
		for (WebElement dropdown : allDropDowns) {

			if (dropdown.isDisplayed()) {
				String dropdownName = dropdown.getAttribute("title");
				Select dropdownSelect = new Select(dropdown);
				List<WebElement> allOptions = dropdownSelect.getOptions();
				for (WebElement option : allOptions) {

					if (dropdownName.equals("Day")) {
						actualDayList.add(option.getText());
					} else if (dropdownName.equals("Month")) {
						actualMonthList.add(option.getText());
					} else if (dropdownName.equals("Year")) {
						actualYearList.add(option.getText());
					}
				}
			}
		}
		if (actualDayList.equals(expectedDayList)) {
			System.out.println(actualDayList);
			System.out.println(expectedDayList);
			System.out.println("The Order and Spelling of Day Dropdown Is found correct");
		} else {
			System.out.println(actualDayList);
			System.out.println(expectedDayList);
			System.out.println("The Order and Spelling of Day Dropdown Is found incorrect");
		}
		if (actualMonthList.equals(expectedMonthList)) {
			System.out.println(actualMonthList);
			System.out.println(expectedMonthList);
			System.out.println("The Order and Spelling of Month Dropdown Is found correct");
		} else {
			System.out.println(actualMonthList);
			System.out.println(expectedMonthList);
			System.out.println("The Order and Spelling of Month Dropdown Is found incorrect");
		}
		if (actualYearList.equals(expectedYearList)) {
			System.out.println(actualYearList);
			System.out.println(expectedYearList);
			System.out.println("The Order and Spelling of Year Dropdown Is found correct");
		} else {
			System.out.println(actualMonthList);
			System.out.println(expectedMonthList);
			System.out.println("The Order and Spelling of Year Dropdown Is found incorrect");
		}

		driver.manage().window().minimize();
		driver.quit();

	}

}
