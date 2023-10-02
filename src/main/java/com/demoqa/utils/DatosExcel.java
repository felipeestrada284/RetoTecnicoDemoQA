
package com.demoqa.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DatosExcel {

    private XSSFWorkbook libro;
    private FileInputStream file;
    private FileOutputStream fileWrite;

    public String leerDatoExcel(String hoja, String ruta, int rowValue, int cellValue) throws IOException {
        String valor;

        file = new FileInputStream(new File(ruta));
        libro = new XSSFWorkbook(file);
        Sheet sheet = libro.getSheet(hoja);
        Row row = sheet.getRow(rowValue);
        Cell cell  = row.getCell(cellValue);
        valor = cell.getStringCellValue();
        libro.close();
        file.close();
        return valor;
    }

   public String escribirDatoExcel (String hoja, String ruta, int rowValue, int cellValue, String resultText) throws IOException {
        String valor;
        file = new FileInputStream(new File(ruta));
        libro = new XSSFWorkbook(file);
        Sheet sheet = libro.getSheet(hoja);
        Row row = sheet.getRow(rowValue);
        Cell cell  = row.getCell(cellValue);
        valor = cell.getStringCellValue();
        Cell firstCell = row.getCell(cellValue-1);
        System.out.println("First cell value is:" + firstCell.getStringCellValue());
        Cell nextCell = row.createCell(cellValue);
        nextCell.setCellValue(resultText);
        System.out.println("Next cell value:" + nextCell.getStringCellValue());
        fileWrite = new FileOutputStream(new File(ruta));
        libro.write(fileWrite);
        libro.close();
        file.close();
        fileWrite.close();
        return valor;
    }
}
