package programa;

import java.util.LinkedList;

public class Dados {
    // Inicio do intervalo
    private final double INIC = -1;

    public double getINIC() {
        return INIC;
    }

    // Fim do intervalo
    private final double FIM = -0.4;

    public double getFIM() {
        return FIM;
    }

    // Precisao exigida
    private final double PRECIS = Math.pow(10, -10);

    public double getPRECIS() {
        return PRECIS;
    }

    // Uma lista contendo intervalos menores (dentro do intervalo dado), onde as raizes se encontram
    private LinkedList<String> lim = new LinkedList<>();

    public LinkedList<String> getLim() {
        return lim;
    }

    /**
     * Calculo da funcao fornecida.
     * @param x O valor de x.
     * @return O f(x).
     */
    public double funcao(double x){
        return Math.pow(x, 5) - (10 * Math.pow(x, 3)/9) + (5 * x/21);
    }

    /**
     * Separa o intervalo fornecido em intervalos menores, contendo cada um, uma raiz.
     */
    public void encontraLim(){
        double posAnt = this.INIC;
        double posAtual;
        double fAnt = funcao(posAnt);
        double fAtual;

        // Enquanto o programa nao chegar no limite do intervalo, ele vai continuar efetuando essa parte
        while(posAnt < this.FIM){
            posAtual = posAnt + 0.1;

            fAtual = funcao(posAtual);

            // Verifica se houve a inversao do sinal da funcao.
            if(fAnt < 0 && fAtual > 0 || fAnt > 0 && fAtual < 0){
                this.lim.add(posAnt + "," + posAtual);
            }

            posAnt = posAtual;
            fAnt = fAtual;
        }
    }
}
