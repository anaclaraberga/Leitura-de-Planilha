package br.com.fag;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Rateio {
  private Integer numeroDeDezenas;
  private Integer quantidadeDeGanhadores;
  private Long valorRateio;

  public Rateio() {
  }
}
