package programa;

import java.util.Scanner;

public class Principal {
    public boolean menu(boolean continua){
        System.out.println("Escolha uma das opcoes abaixo: \n");
        System.out.println("1 - Metodo da Bisseccao.");
        System.out.println("2 - Metodo da Posicao Falsa.");
        System.out.println("3 - Metodo de Newton.");
        System.out.println("4 - Metodo da Secante.");
        System.out.println("5 - Encerrar o programa.");

        Scanner entrada = new Scanner(System.in);
        String op = entrada.next();

        double[] raizes = new double[2];
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
        }

        if(raizes.length == 0){
            System.out.println("\nNao existem raizes neste intervalo.");
        } else{
            System.out.println("\nAs raizes da funcao sao:");
            System.out.print("                                                   ");
            System.out.println(raizes[0] + " e " + raizes[1]);
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
