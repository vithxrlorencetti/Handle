package Model;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {

    private long idFuncionario;
    private String nomeFuncionario;
    private String numIdentidadeFuncionario;
    private String telefoneFuncionario;
    private Double salarioFuncionario;
    private List<Venda> vendasFuncionario = new ArrayList<Venda>();


    public Funcionario() {
    }

    public Funcionario(String nomeFuncionario, String numIdentidadeFuncionario, String telefoneFuncionario, Double salarioFuncionario, List<Venda> vendasFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
        this.numIdentidadeFuncionario = numIdentidadeFuncionario;
        this.telefoneFuncionario = telefoneFuncionario;
        this.salarioFuncionario = salarioFuncionario;
        this.vendasFuncionario = vendasFuncionario;
    }

    public Funcionario(String nomeFuncionario, String numIdentidadeFuncionario, String telefoneFuncionario, Double salarioFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
        this.numIdentidadeFuncionario = numIdentidadeFuncionario;
        this.telefoneFuncionario = telefoneFuncionario;
        this.salarioFuncionario = salarioFuncionario;
    }

    public long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getNumIdentidadeFuncionario() {
        return numIdentidadeFuncionario;
    }

    public void setNumIdentidadeFuncionario(String numIdentidadeFuncionario) {
        this.numIdentidadeFuncionario = numIdentidadeFuncionario;
    }

    public String getTelefoneFuncionario() {
        return telefoneFuncionario;
    }

    public void setTelefoneFuncionario(String telefoneFuncionario) {
        this.telefoneFuncionario = telefoneFuncionario;
    }

    public Double getSalarioFuncionario() {
        return salarioFuncionario;
    }

    public void setSalarioFuncionario(Double salarioFuncionario) {
        this.salarioFuncionario = salarioFuncionario;
    }

    public List<Venda> getVendasFuncionario() {
        return vendasFuncionario;
    }

    public void setVendasFuncionario(List<Venda> vendasFuncionario) {
        this.vendasFuncionario = vendasFuncionario;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "idFuncionario=" + idFuncionario +
                ", nomeFuncionario='" + nomeFuncionario + '\'' +
                ", numIdentidadeFuncionario='" + numIdentidadeFuncionario + '\'' +
                ", telefoneFuncionario='" + telefoneFuncionario + '\'' +
                ", salarioFuncionario=" + salarioFuncionario +
                ", vendasFuncionario=" + vendasFuncionario +
                '}';
    }
}
