package br.com.fag;

import java.util.Map;

public class Estrutura {
    public static void quantasVezesCadaNumeroFoiSorteado(Aposta aposta) {
    Integer i = 0;
    Map<Integer, Integer> map = Resultado.quantasVezesCadaNumeroFoiSorteado;
    for (i = 0; i <= 60; i++) {
      if (aposta.getBolasTotal().contains(i)) {
        if (map.containsKey(i)) {
          map.put(i, map.get(i) + 1);
        } else {
          map.put(i, 1);
        }
      }
    }
    }

    public static void quantosConcursosNaoHouveApostadorSeisDezenas(Aposta aposta) {
        Integer zero = 0;
        if (aposta.getGanhadoreSeisAcertos().contains(zero)) {
            Resultado.totalSeisAcertos++;
        }
    }

    public static void menorValorQuatroDezenas(Aposta aposta) {

    }
    public static void imprimir() {
        System.out.println("Quantas vezes cada número foi sorteado =" + Resultado.quantasVezesCadaNumeroFoiSorteado);
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("Quantos concursos não houve apostador que acertou as 6 dezenas =" + Resultado.totalSeisAcertos);
    }
    
}
