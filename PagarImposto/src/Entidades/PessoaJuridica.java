package Entidades;

public class PessoaJuridica extends PagadorDeImpostos{
    
    private int numeroDeEmpregados;

    public PessoaJuridica(String nome, Double rendaAnual, int numeroDeEmpregados) {
        super(nome, rendaAnual);
        this.numeroDeEmpregados = numeroDeEmpregados;
    }

    public int getNumeroDeEmpregados() {
        return numeroDeEmpregados;
    }

    public void setNumeroDeEmpregados(int numeroDeEmpregados) {
        this.numeroDeEmpregados = numeroDeEmpregados;
    }

    @Override
    public double imposto() {
        if (getNumeroDeEmpregados() > 10){
            return getRendaAnual() * 0.14;
        }else{
            return getRendaAnual() * 0.16;
        }
    }

    
}
