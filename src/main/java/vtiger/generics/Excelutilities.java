package vtiger.generics;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.WorkbookFactory;



public class Excelutilities {
	public String readDataExcel(String sheetname, int rownumber, int cellno) throws Throwable {
		FileInputStream fis = new FileInputStream(IAutoconst.excelpath);
		return WorkbookFactory.create(fis)
				.getSheet(sheetname)
				.getRow(rownumber)
				.getCell(cellno)
				.getStringCellValue();

	}
	public String readDataExcel(String path, String sheetname, int rownumber, int cellno) throws Throwable {
		FileInputStream fis=new FileInputStream(IAutoconst.excelpath);
		return WorkbookFactory.create(fis)
				.getSheet(sheetname)
				.getRow(rownumber)
				.getCell(cellno)
				.getStringCellValue();

	}
}
