package br.com.fag;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Gerenciador {
  List<Aposta> apostasExcel = new ArrayList<>();

  public static void gerenciador() {
    try {
      FileInputStream arquivoXlsx = new FileInputStream(new File("planilha/src/main/resources/Mega-Sena.xlsx"));
      XSSFWorkbook workbook = new XSSFWorkbook(arquivoXlsx);
      XSSFSheet sheet = workbook.getSheetAt(0);
      Iterator<?> fileiras = sheet.rowIterator();

      while (fileiras.hasNext()) {
        XSSFRow linhas = (XSSFRow) fileiras.next();
        Aposta aposta = new Aposta();

        if (linhas.getRowNum() > 0) {
          Iterator<?> celulas = linhas.cellIterator();

          while (celulas.hasNext()) {
            XSSFCell celula = (XSSFCell) celulas.next();
            // System.out.println(celula.toString());

            switch (celula.getColumnIndex()) {
              case 0:
                aposta.setConcurso((int) Math.floor(Double.parseDouble(celula.toString())));
                break;
              case 1:
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String date = celula.toString();
                LocalDate localDate = LocalDate.parse(date, formatter);
                aposta.setData(localDate);
                break;
              case 2:
                aposta.getBolasTotal().add((int) Math.floor(Double.parseDouble(celula.toString())));
                break;
              case 3:
                aposta.getBolasTotal().add((int) Math.floor(Double.parseDouble(celula.toString())));
                break;
              case 4:
                aposta.getBolasTotal().add((int) Math.floor(Double.parseDouble(celula.toString())));
                break;
              case 5:
                aposta.getBolasTotal().add((int) Math.floor(Double.parseDouble(celula.toString())));
                break;
              case 6:
                aposta.getBolasTotal().add((int) Math.floor(Double.parseDouble(celula.toString())));
                break;
              case 7:
                aposta.getBolasTotal().add((int) Math.floor(Double.parseDouble(celula.toString())));
                break;
              case 8:
                aposta.getGanhadoreSeisAcertos().add((int) Math.floor(Double.parseDouble(celula.toString())));
                break;
              case 9:
                aposta.setCidade(celula.toString());
                break;
              case 10:
                break;
              case 11:
                break;
              case 12:
                break;
            }
          }

        }
        Estrutura.quantasVezesCadaNumeroFoiSorteado(aposta);
        Estrutura.quantosConcursosNaoHouveApostadorSeisDezenas(aposta);
        // System.out.println(aposta.getBolasTotal());
      }

    }

    catch (Exception e) {
      System.out.println("Erro: " + e.getMessage());
    }

  }
}
