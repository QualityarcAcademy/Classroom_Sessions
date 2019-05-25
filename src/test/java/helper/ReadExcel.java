package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] readExcelData(String fileName) {

		//Crete the file object

		String [][] data = null;
		File file = new File("./Data/"+fileName+".xlsx");
		try {
			FileInputStream fis = new FileInputStream(file);

			//Workbook object
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);

			//Get the last row and column
			int lastRowNum = sheet.getLastRowNum();
			short lastColNum = sheet.getRow(0).getLastCellNum();
			System.out.println("The row is: "+lastRowNum +"The last col: "+lastColNum);
			data = new String[lastRowNum][lastColNum];

			//Get the values from the table
			for(int i=1; i<=lastRowNum; i++) {
				XSSFRow row = sheet.getRow(i);

				for(int j=0; j<lastColNum; j++) {
					XSSFCell cell = row.getCell(j);
					String val = cell.getStringCellValue();
					data[i-1][j] = val;
				}

			}
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(Arrays.deepToString(data));
		return data;

	}

}
