package br.com.fag;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import lombok.Cleanup;

public class GerenciadorGanhadores {
  
  public List<Ganhadores> criar() throws IOException{

    //lendo os ganhadores
    @Cleanup FileInputStream file = new FileInputStream("src\\main\\resources\\Mega-Sena.xlsx");

    Workbook workbook = new HSSFWorkbook(file);

    workbook.getSheetAt(0);

    return null;
  }
}
