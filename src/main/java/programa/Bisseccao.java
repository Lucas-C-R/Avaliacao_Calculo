package programa;


import java.util.LinkedList;

public class Bisseccao {

    // Inicio do intervalo
    private final double INIC = -1;

    // Fim do intervalo
    private final double FIM = -0.4;

    // Precisao exigida
    private final double PRECIS = Math.pow(10, -10);

    // Uma lista contendo intervalos menores (dentro do intervalo dado), onde as raizes se encontram
    private LinkedList<String> lim = new LinkedList<>();

    /**
     * Calculo da funcao fornecida.
     * @param x O valor de x.
     * @return O f(x).
     */
    private double funcao(double x){
        return Math.pow(x, 5) - (10 * Math.pow(x, 3)/9) + (5 * x/21);
    }

    /**
     * Separa o intervalo fornecido em intervalos menores, contendo cada um, uma raiz.
     */
    private void encontraLim(){
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

    /**
     * Encontra a raiz da funcao.
     * @param inic Inicio do intervalo.
     * @param fim Fim do intervalo.
     * @return A raiz da funcao.
     */
    private double encontraRaiz(double inic, double fim){
        double a = inic;
        double b = fim;
        double fa = this.funcao(a);
        double x = 1;
        Grafico grafico = new Grafico();

        // Enquanto b-a for maior que a precisa exigida, essa parte continuara sendo executada
        for(int i = 1; b - a >= this.PRECIS; i++){
            x = (a + b)/2;

            double fx = this.funcao(x);

            // Se f(x)*f(a) for maior que 0, entao 'a' ira assumir o valor de 'x', caso contrario, sera 'b'
            if(fx * fa > 0){
                a = x;
            } else{
                b = x;
            }

            if(i < 30){
                grafico.desenhaGrafico(i, x);
            }
        }

        return x;
    }

    /**
     * Encontra as raizes da funcao, usando o metodo da Bisseccao.
     * @return Um vetor contendo todas as raizes, no intervalo fornecido.
     */
    public double[] raizes(){
        this.encontraLim();
        double[] raizes = new double[2];

        // Verificacao pra impedir que o programa continue, sem ter encontrado os limites menores
        if(! this.lim.isEmpty()){
            int i = 0;

            // Iterador para a lista contendo os limites
            for(String limites: this.lim){
                int j = limites.indexOf(",");

                double inic = Double.parseDouble(limites.substring(0, j));
                double fim = Double.parseDouble(limites.substring(j+1));

                raizes[i] = (this.encontraRaiz(inic, fim));

                i++;
            }
        }

        return raizes;
    }
}
