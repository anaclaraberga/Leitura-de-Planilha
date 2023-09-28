package br.com.fag;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import lombok.Cleanup;

public class GerenciadorGanhadores {
  
  public List<Ganhadores> criar() throws IOException{

    //lendo os ganhadores
    @Cleanup FileInputStream file = new FileInputStream("src\\main\\resources\\Mega-Sena.xlsx");

    //lendo a aba
    Workbook workbook = new HSSFWorkbook(file);

    Sheet sheet = workbook.getSheetAt(0);

    List<Row> rows = (List<Row>) toList(sheet.iterator());

    return null;
  }
  
  public List<?> toList(Iterator<?> iterator) {
    return IteratorUtils.toList(iterator);
  }
}
