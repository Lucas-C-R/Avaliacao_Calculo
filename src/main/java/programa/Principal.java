package programa;

import java.util.Scanner;

public class Principal {
    public boolean menu(boolean continua){
        System.out.println("Escolha uma das opcoes abaixo: \n");
        System.out.println("1 - Metodo da Bisseccao.");
        System.out.println("2 - Metodo da Posicao Falsa.");
        System.out.println("3 - Metodo de Newton.");
        System.out.println("4 - Metodo da secante.");
        System.out.println("5 - Encerrar o programa.");

        Scanner entrada = new Scanner(System.in);
        String op = entrada.next();

        double[] raizes;

        switch(op){
            case "1":
                Bisseccao b = new Bisseccao();
                 raizes = b.raizes();

                System.out.println("\nAs raizes da funcao sao:");
                System.out.print("                                                   ");
                System.out.println(raizes[0] + " e " + raizes[1]);
                break;

            case "2":
                PosicaoFalsa p = new PosicaoFalsa();
                raizes = p.raizes();

                System.out.println("\nAs raizes da funcao sao:");
                System.out.print("                                                   ");
                System.out.println(raizes[0] + " e " + raizes[1]);
                break;
        }

        return continua;
    }

    public static void main(String[] args) {
        Principal p = new Principal();
        boolean continua = true;

        while(continua){
            p.menu(continua);
        }
    }
}
