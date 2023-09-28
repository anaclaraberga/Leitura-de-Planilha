package br.com.fag;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import lombok.Cleanup;

public class GerenciadorApostas {
  
  public List<Aposta> criar() throws IOException{

    List <Aposta> apostasExcel = new ArrayList<>();

    //LEITURA DOS GANHADORES
    @Cleanup FileInputStream file = new FileInputStream("src\\main\\resources\\Mega-Sena.xlsx");

    //LEITURA DAS ABAS
    Workbook workbook = new HSSFWorkbook(file);

    Sheet sheet = workbook.getSheetAt(0);

    List<Row> fileiras = (List<Row>) toList(sheet.iterator());

    fileiras.forEach(row ->{

      //CONFIGURANDO VARIÁVEIS NAS CÉLULAS DO EXCEL
      List<Cell> celulas = (List<Cell>) toList(row.cellIterator());

      Aposta aposta = Aposta.builder()
              .build();
      apostasExcel.add(aposta);
    });

    return apostasExcel;
  }
  
  public List<?> toList(Iterator<?> iterator) {
    return IteratorUtils.toList(iterator);
  }
}
