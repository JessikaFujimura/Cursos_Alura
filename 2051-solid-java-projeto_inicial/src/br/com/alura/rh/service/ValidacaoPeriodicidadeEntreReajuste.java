package br.com.alura.rh.service;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoPeriodicidadeEntreReajuste implements ValidacaoReajuste{

    public void validar(Funcionario funcionario, BigDecimal aumento){
        LocalDate ultimoReajuste = funcionario.getDataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();
        long mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(ultimoReajuste, dataAtual);
        if(mesesDesdeUltimoReajuste <6){
            throw new ValidacaoException("Intervalo entre reajustes deve ser de no mínimo 6 meses");
        }
    }
}
