package programa;

public class Principal {
    public void menu(){
        System.out.println("Escolha uma das opcoes abaixo: \n");
        System.out.println("1 - ");
    }

    public static void main(String[] args) {
        Bisseccao b = new Bisseccao();
        double[] raizes = b.raizes();

    }
}
