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
     * Calculo da derivada da funcao fornecida.
     * @param x O valor de x.
     * @return O f'(x).
     */
    public double funcaoDerivada(double x){
        return 5 * Math.pow(x, 4) - (10 * Math.pow(x, 2)/3) + (5 / 21);
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

    /**
     * Encontra as raizes da funcao.
     * @return Um vetor contendo todas as raizes, no intervalo fornecido.
     */
    public double[] raizes(String metodo){
        this.encontraLim();
        double[] raizes = new double[2];

        // Verificacao pra impedir que o programa continue, sem ter encontrado os limites menores
        if(! this.getLim().isEmpty()){
            int i = 0;

            // Iterador para a lista contendo os limites
            for(String limites: this.getLim()){
                int j = limites.indexOf(",");

                double inic = Double.parseDouble(limites.substring(0, j));
                double fim = Double.parseDouble(limites.substring(j+1));

                switch(metodo){
                    case "B":
                        Bisseccao b = new Bisseccao();

                        raizes[i] = b.encontraRaiz(inic, fim);
                        break;

                    case "PF":
                        PosicaoFalsa p = new PosicaoFalsa();

                        raizes[i] = p.encontraRaiz(inic, fim);
                        break;

                    case "N":
                        Newton n = new Newton();

                        raizes[i] = n.encontraRaiz(inic, fim);
                        break;

                    case "S":
                        Secante s = new Secante();

                        raizes[i] = s.encontraRaiz(inic, fim);
                        break;
                }

                i++;
            }
        }

        return raizes;
    }
}
