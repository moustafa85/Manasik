package Pages.utils;

import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class TestUtils {
	
	public int col_num;

	
	public static Object[][] ReadFromExcel(String sheetName, String FileName ) throws IOException {
		
		File file = new File(FileName);
		FileInputStream fls=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fls);
		XSSFSheet sheet1=wb.getSheet(sheetName);
		Row row1 = sheet1.getRow(0);
		//System.out.println("row -- "+row1.getRowNum());
		//XSSFRow row1 = sheet1.getRow(0);
		
		int RowNum = sheet1.getPhysicalNumberOfRows();
		int ColNum = row1.getLastCellNum();
		
		Object Data[][] = new Object[RowNum-1][ColNum];
		
		for(int i=0; i<RowNum-1; i++)
		{
			XSSFRow row = sheet1.getRow(i+1);		
			for(int k=0; k<ColNum; k++)
			{
				if(row==null)
					Data[i][k]="";
				else {
						XSSFCell cell = row.getCell(k);
						if(cell==null)
							Data[i][k]="";
						else
							{
								String value=new DataFormatter().formatCellValue(cell);
								Data[i][k] = value;
								System.out.println(Data[i][k]);
							}
					}
			}
			System.out.println("--------");
		}
		return Data;
	}
	
	
	
	
	@Test
	public void WriteInExcel(String status, int DR, String sheetName, String ColName, String FileName) throws IOException
	{
		File file = new File(FileName);
		FileInputStream fls=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fls);
		XSSFSheet sheet1=wb.getSheet(sheetName);
		XSSFRow row = sheet1.getRow(0);
		
		int sheetIndex = wb.getSheetIndex(sheetName);
		DataFormatter formatter = new DataFormatter();
		if(sheetIndex==-1)
		{
			System.out.println("No such sheet in file exists");
		} 
		else 
		{
			col_num = -1;
			for(int i=0; i<=row.getLastCellNum(); i++)
			{
				XSSFCell cols = row.getCell(i);
				String colsval= formatter.formatCellValue(cols);
				if(colsval.trim().equalsIgnoreCase(ColName.trim()))
				{
					col_num=i;
					break;
				}
			}
			row=sheet1.getRow(DR);
			try
			{
				XSSFCell cell = sheet1.getRow(DR).getCell(col_num);
				if(cell==null)
				{
					cell=row.createCell(col_num);
				}
				cell.setCellValue(status);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		FileOutputStream fls2=new FileOutputStream(file);
		wb.write(fls2);
		fls2.close();
		if(col_num==-1) {
			System.out.println("Column you are searching for does not exist");
		}
		
	}
	
	public void ExcelWrite(String status,int rownum, int colnum, String sheetName, String FileName) throws IOException
	{
		File file = new File(FileName);
		FileInputStream fls = new FileInputStream(file);
    	XSSFWorkbook wb=new XSSFWorkbook(fls);
    	XSSFSheet sheet=wb.getSheet(sheetName);
    	XSSFRow row = sheet.getRow(rownum);
    	
		row.createCell(colnum).setCellValue(status);
		
		FileOutputStream fout=new FileOutputStream(file);
		
		wb.write(fout);
		fout.close();
	}


	public static Object[][] dataSupplier(String sheetName, String FileName ) throws IOException {
		String key = "";
		String value= "";
		File file = new File(FileName);
		FileInputStream fis = null;
		XSSFWorkbook wb;
		XSSFSheet sheet = null;
		try{

			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int lastRowNum = sheet.getLastRowNum() ;
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		Object[][] obj = new Object[lastRowNum][1];

		for (int i = 0; i < lastRowNum; i++) {
			Map<String, String> datamap = new HashMap<>();
			for (int j = 0; j < lastCellNum; j++) {
				key = new DataFormatter().formatCellValue(sheet.getRow(0).getCell(j));
				value =  new DataFormatter().formatCellValue(sheet.getRow(i+1).getCell(j));
				datamap.put(key,value);
			}
			obj[i][0] = datamap;

		}
		return  obj;
	}



}
