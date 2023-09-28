package br.com.fag;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Aposta {
  private int concurso;
  private Date data;
  private int bola1;
  private int bola2;
  private int bola3;
  private int bola4;
  private int bola5;
  private int bola6;
  private double ganhadoreSeisAcertos;
  private double ganhadoreCincoAcertos;
  private double ganhadoreQuatroAcertos;
  private double rateioSeisAcertos;
  private double rateioCincoAcertos;
  private double rateioQuatroAcertos;
  private String cidade;
  private double acumuladosSeisAcertos;
  private BigDecimal arrecadacaoTotal;
  private double estimativaPremio;
  private double acumuladoSorteio;
  private String observacao;

}
