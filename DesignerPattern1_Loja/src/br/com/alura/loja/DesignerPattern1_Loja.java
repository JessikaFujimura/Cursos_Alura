package br.com.alura.loja;

import br.com.alura.loja.desconto.CalculadoraDeDescontos;
import br.com.alura.loja.imposto.CalculadoraDeImpostos;
import br.com.alura.loja.imposto.ISS;
import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class DesignerPattern1_Loja {
    public static void main(String[] args) {
    testeCalculadoraDescontos();
    }

    public static void testeCalculadoraImpostos(){
        Orcamento orcamento = new Orcamento(new BigDecimal("100"), 1);
        CalculadoraDeImpostos calculadoraDeImpostos = new CalculadoraDeImpostos();
        System.out.println(calculadoraDeImpostos.calcular(orcamento, new ISS()));
    }

    public static void testeCalculadoraDescontos(){
        Orcamento primeiro = new Orcamento(new BigDecimal("200"), 6);
        Orcamento segundo = new Orcamento(new BigDecimal("1000"), 1);

        CalculadoraDeDescontos calculadoraDeDescontos = new CalculadoraDeDescontos();
        System.out.println(calculadoraDeDescontos.calcular(primeiro));
        System.out.println(calculadoraDeDescontos.calcular(segundo));

    }

}
