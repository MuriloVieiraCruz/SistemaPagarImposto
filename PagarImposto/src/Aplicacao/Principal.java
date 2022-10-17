package Aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entidades.PagadorDeImpostos;
import Entidades.PessoaFisica;
import Entidades.PessoaJuridica;

public class Principal {

    public static void main (String[] args){

        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        System.out.println("Informe o número de cobrantes:");
        int numeroCobrantes = scan.nextInt();

        List<PagadorDeImpostos> lista = new ArrayList<PagadorDeImpostos>();

        for (int i = 1; i <= numeroCobrantes ; i++) {
            System.out.println("Pagador número # " + i + "data:");
            System.out.println("Você é uma pessoa física ou jurídica (f/j) ?");
            char tipo = scan.next().charAt(0);
            System.out.println("Nome: ");
            String nome = scan.next();
            System.out.println("Renda anual: ");
            Double rendaAnual = scan.nextDouble();

            if(tipo == 'f') {
                System.out.println("Alguma dispesa médica: ");
                Double dispesaMedica = scan.nextDouble();
                PessoaFisica perfil = new PessoaFisica(nome, rendaAnual, dispesaMedica);
                lista.add(perfil);
            }else{
                System.out.println("Numero de empregados:");
                int numeroDeEmpregados = scan.nextInt();
                PessoaJuridica perfil = new PessoaJuridica(nome, rendaAnual, numeroDeEmpregados);
                lista.add(perfil);
            }

        }

        System.out.println();
        System.out.println("Impostos pagos:");

        for (PagadorDeImpostos pg : lista) {
            System.out.println(pg.getNome() + "/ R$ " + String.format("%.2f", pg.imposto()));
        }

        double somar = 0;

        for (PagadorDeImpostos pdg : lista) {
            somar += pdg.imposto();
        }

        System.out.println(somar);


        scan.close();
    }
}