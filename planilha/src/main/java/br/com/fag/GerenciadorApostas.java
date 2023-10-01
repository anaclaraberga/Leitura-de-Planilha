package br.com.fag;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GerenciadorApostas {
  
  List<Aposta> criar() throws IOException {
    File file = new File("planilha/src/main/resources/Mega-Sena.xlsx");

    FileInputStream arquivoXlsx = new FileInputStream(file);

    XSSFWorkbook workbook = new XSSFWorkbook(arquivoXlsx);
    XSSFSheet sheet = workbook.getSheetAt(0);

    List <Aposta> apostasExcel = new ArrayList<>();

    return null;
  }


}
