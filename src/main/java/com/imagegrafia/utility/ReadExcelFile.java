package com.imagegrafia.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.imagegrafia.model.Product;
import com.imagegrafia.model.ProductExcel;

public class ReadExcelFile {
	/*public static void main(String[] args) {
		try {
			FileInputStream file = new FileInputStream(new File("C:\\Users\\ashish\\Downloads\\grocery_item.xlsx"));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			int i = 3;
			while (i < 100) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				List<String> lists =new ArrayList<>();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
//						System.out.print(cell.getNumericCellValue() + " N ");
						lists.add(String.valueOf(cell.getNumericCellValue()));
						break;
					case Cell.CELL_TYPE_STRING:
//						System.out.print(cell.getStringCellValue() + " S ");
						lists.add(cell.getStringCellValue());
						break;
					default:
						lists.add("0");
					break;
					}

				}
				
				setProduct(lists);
				
				i++;
				System.out.println("");
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	public static void setProduct(List<String> list) {
		ProductExcel p =new ProductExcel();
		p.setSno(list.get(0));
		p.setItemCode(list.get(1));
		p.setBarCode(list.get(2));
		p.setItemName(list.get(3));
		p.setRate(list.get(4));
		p.setWithGstRate(list.get(5));
		p.setMrp(list.get(6));
		p.setMargin(list.get(7));
		p.setBrandName(list.get(8));
		p.setDepartment(list.get(9));
		p.setMainCategory(list.get(10));
		p.setSubCategory(list.get(11));
		p.setCategory(list.get(12));
		System.out.println(p);
	}
}