package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {
public static void main(String []args) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./src/test/resources/Student.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	Sheet sheet = workbook.getSheet("Sheet1");
	//getting String value
	System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());
	//getting Numeric cell value and converting it into integer type from double
	System.out.println((int)(sheet.getRow(1).getCell(1).getNumericCellValue()));
	System.out.println("get First RowNum "+sheet.getFirstRowNum());
	System.out.println(sheet.getLastRowNum()); 
	for (int i = 0; i < sheet.getLastRowNum(); i++) {
		for(int j=0; j<2;j++) {
			if(sheet.getRow(i).getCell(j).getCellType().toString()=="STRING") {
				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			}else 
			System.out.println(sheet.getRow(i).getCell(j).getNumericCellValue());
		}
		
	}
}
}
 