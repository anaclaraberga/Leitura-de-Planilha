package br.com.fag;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{
        //instanciando GerenciadorApostas
        GerenciadorApostas apostasExcel = new GerenciadorApostas();

        List<Aposta> apostas = apostasExcel.criar();

        apostasExcel.imprimir(apostas);

        System.out.println("hello");

    }
}