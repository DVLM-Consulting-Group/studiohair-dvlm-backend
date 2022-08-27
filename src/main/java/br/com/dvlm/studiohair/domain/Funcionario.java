package br.com.dvlm.studiohair.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Funcionario extends Pessoa implements Serializable {

    @OneToMany(mappedBy = "funcionario") // foi mapeado pelo funcionario

    private List<Agendamento> lista = new ArrayList<>();

    public Funcionario() {
        super();
    }

    public Funcionario(Integer id, String nome, String cpf, String telefone, String email) {
        super(id, nome, cpf, telefone, email);
    }

    public List<Agendamento> getLista() {
        return lista;
    }

    public void setLista(List<Agendamento> lista) {
        this.lista = lista;
    }
}