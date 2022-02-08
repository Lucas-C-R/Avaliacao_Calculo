package programa;

import java.util.Scanner;

public class Principal {
    public boolean menu(){
        System.out.println("Escolha uma das opcoes abaixo: \n");
        System.out.println("1 - Metodo da Bisseccao.");
        System.out.println("2 - Metodo da Posicao Falsa.");
        System.out.println("3 - Metodo de Newton.");
        System.out.println("4 - Metodo da Secante.");
        System.out.println("5 - Encerrar o programa.");

        Scanner entrada = new Scanner(System.in);
        String op = entrada.next();

        double[] raizes;
        Dados d = new Dados();

        switch(op){
            case "1":
                raizes = d.raizes("B");
                break;

            case "2":
                raizes = d.raizes("PF");
                break;

            case "3":
                raizes = d.raizes("N");
                break;

            case "4":
                raizes = d.raizes("S");
                break;

            case "5":
                return false;

            default:
                System.out.println("\nOpcao invalida!\n");
                return true;
        }

        System.out.println("\nAs raizes da funcao sao:");
        System.out.print("                                                   ");
        System.out.println(raizes[0] + " e " + raizes[1]);

        return true;
    }

    public static void main(String[] args) {
        Principal p = new Principal();

        while(p.menu()){}

        System.exit(0);
    }
}
