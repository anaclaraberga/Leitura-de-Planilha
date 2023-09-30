package br.com.fag;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import lombok.Cleanup;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Teste {
  
  public static void main(String[] args) throws IOException{

    List <Aposta> apostasExcel = new ArrayList<>();

    //LEITURA DOS GANHADORES
    @Cleanup FileInputStream file = new FileInputStream("C:\\Users\\ana4e\\OneDrive\\Documentos\\Github\\leitura-de-planilha\\planilha\\src\\main\\resources\\Mega-Sena.xlsx");

    //LEITURA DAS ABAS
    Workbook workbook = new XSSFWorkbook(file);

    Sheet sheet = workbook.getSheetAt(0);

    List<Row> fileiras = (List<Row>) toList(sheet.iterator());

    fileiras.remove(0);

    fileiras.forEach(fileira ->{

      //CONFIGURANDO VARIÁVEIS NAS CÉLULAS DO EXCEL
      List<Cell> celulas = (List<Cell>) toList(fileira.cellIterator());

      Aposta aposta = Aposta.builder()
              .concurso((int) celulas.get(1).getNumericCellValue())
              .build();
      apostasExcel.add(aposta);
    });
  }
  
  public static List<?> toList(Iterator<?> iterator) {
    return IteratorUtils.toList(iterator);
  }
  
  public void imprimir(List<Aposta> apostas) {
    apostas.forEach(System.out::println);
  }
}
