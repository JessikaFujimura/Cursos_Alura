package br.com.alura.rh.service;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;

public class PromocaoService {

    public void promover(Funcionario funcionario, boolean metaBatida){
        Cargo cargoAtual = funcionario.getCargo();
        if(Cargo.GERENTE == funcionario.getCargo()){
            throw new ValidacaoException("Gerentes não podem ser promovidos!");
        }
        if (metaBatida){
            Cargo novoCargo = cargoAtual.getProximoCargo();
            funcionario.promover(novoCargo);
        }
    }
}
