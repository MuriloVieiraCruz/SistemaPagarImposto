package Entidades;

public class PessoaFisica extends PagadorDeImpostos{
    
    private Double gastosComSaude;

    public PessoaFisica(String nome, Double rendaAnual, Double gastosComSaude) {
        super(nome, rendaAnual);
        this.gastosComSaude = gastosComSaude;
    }

    public Double getGastosComSaude() {
        return gastosComSaude;
    }

    public void setGastosComSaude(Double gastosComSaude) {
        this.gastosComSaude = gastosComSaude;
    }

    @Override
    public double imposto() {
        double impostoBasico;
            if(getRendaAnual() < 20000.00){
                impostoBasico = getRendaAnual() * 0.15;
            }else{
                impostoBasico = getRendaAnual() * 0.25;
            }

            impostoBasico -= getGastosComSaude() * 0.5;
        return impostoBasico;
    }

    
}
