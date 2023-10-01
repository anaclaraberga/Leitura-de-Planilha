package br.com.fag;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GerenciadorApostas {

  public static void main(String[] args) {
    try {
      FileInputStream arquivoXlsx = new FileInputStream(new File("planilha/src/main/resources/Mega-Sena.xlsx"));
      XSSFWorkbook workbook = new XSSFWorkbook(arquivoXlsx);
      XSSFSheet sheet = workbook.getSheetAt(0);
      List<Aposta> apostasExcel = new ArrayList<>();
      Iterator<?> fileiras = sheet.rowIterator();

      while (fileiras.hasNext()) {
        XSSFRow linhas = (XSSFRow) fileiras.next();

        if (linhas.getRowNum() > 0) {
          Iterator<?> celulas = linhas.cellIterator();
          
          while (celulas.hasNext()) {
            XSSFCell celula = (XSSFCell) celulas.next();
            System.out.println(celula.toString());
          }
        }
      }

    } catch (Exception e) {
      System.out.println("Erro: " + e.getMessage());
    }
  }

  public void imprimir(List<Aposta> apostas) {
    apostas.forEach(System.out::println);
  }

}
