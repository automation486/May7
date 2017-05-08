package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;

	public ExcelDataProvider() throws IOException {
		try {
			wb = new XSSFWorkbook(new FileInputStream(new File(
					"./TestCases/AvactisData.xlsx")));
		} catch (FileNotFoundException e) {

			System.out.println("Unable to Load Excel Sheet" + e.getMessage());
		}
	}

	public String getData(String sheetname, int row, int column) {
		String data = wb.getSheet(sheetname).getRow(row).getCell(column)
				.getStringCellValue();
		return data;
	}

	public String getData(int sheetindex, int row, int column) {
		String data = wb.getSheetAt(sheetindex).getRow(row).getCell(column)
				.getStringCellValue();
		return data;
	}

	public int rowCount(String sheetname) {
		int numofrows = wb.getSheet(sheetname).getLastRowNum();
		return numofrows;
	}

	public int rowCount(int sheetindex) {
		return wb.getSheetAt(sheetindex).getLastRowNum();
	}
	

}
