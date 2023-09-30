package br.com.fag;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
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

public class GerenciadorApostas {
  
  public List<Aposta> criar() throws IOException{

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
              .data(celulas.get(0).getDateCellValue())
              .concurso((int) celulas.get(1).getNumericCellValue())
              .bola1((int) celulas.get(2).getNumericCellValue())
              .bola2((int) celulas.get(3).getNumericCellValue())
              .bola3((int) celulas.get(4).getNumericCellValue())
              .bola4((int) celulas.get(5).getNumericCellValue())
              .bola5((int) celulas.get(6).getNumericCellValue())
              .bola6((int) celulas.get(7).getNumericCellValue())
              .ganhadoreSeisAcertos((int) celulas.get(8).getNumericCellValue())
              .cidade(celulas.get(9).getStringCellValue())
              .rateioSeisAcertos(new BigDecimal(celulas.get(10).getNumericCellValue()))
              .ganhadoreCincoAcertos((int) celulas.get(11).getNumericCellValue())
              .rateioCincoAcertos(new BigDecimal(celulas.get(12).getNumericCellValue()))
              .ganhadoreQuatroAcertos((int) celulas.get(13).getNumericCellValue())
              .rateioQuatroAcertos(new BigDecimal(celulas.get(14).getNumericCellValue()))
              .acumuladosSeisAcertos(new BigDecimal(celulas.get(15).getNumericCellValue()))
              .arrecadacaoTotal(new BigDecimal(celulas.get(16).getNumericCellValue()))
              .estimativaPremio(new BigDecimal(celulas.get(17).getNumericCellValue()))
              .acumuladoSorteio(new BigDecimal(celulas.get(18).getNumericCellValue()))
              .observacao(celulas.get(19).getStringCellValue())
              .build();
      apostasExcel.add(aposta);
    });

    return apostasExcel;
  }
  
  public List<?> toList(Iterator<?> iterator) {
    return IteratorUtils.toList(iterator);
  }
  
  public void imprimir(List<Aposta> apostas) {
    apostas.forEach(System.out::println);
  }
}
