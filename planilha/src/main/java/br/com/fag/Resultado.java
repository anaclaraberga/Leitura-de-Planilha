package br.com.fag;

import java.util.HashMap;
import java.util.Map;

public class Resultado {
  public static Map<Integer, Integer> quantasVezesCadaNumeroFoiSorteado = new HashMap<>();
  public static Integer totalSeisAcertos = 0;
  public static Long menorValorQuatroDezenas = 1000000000L;
  public static Long menorValorCincoDezenas = 1000000000L;
  public static Long menorValorSeisDezenas = 1000000000L;
  public static Long maiorValorQuatroDezenas = 0L;
  public static Long maiorValorCincoDezenas = 0L;
  public static Long maiorValorSeisDezenas = 0L;
}
