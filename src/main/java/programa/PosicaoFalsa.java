package programa;

public class PosicaoFalsa {
    Dados d = new Dados();

    /**
     * Encontra a raiz da funcao, usando o metodo da Posicao Falsa.
     * @param inic Inicio do intervalo.
     * @param fim Fim do intervalo.
     * @return A raiz da funcao.
     */
    private double encontraRaiz(double inic, double fim){
        double a = inic;
        double b = fim;
        double fa = d.funcao(a);
        double fb = d.funcao(b);
        double x = 0;
        Grafico grafico = new Grafico();

        if(Math.abs(fa) > d.getPRECIS() && Math.abs(fb) > d.getPRECIS()){
            for(int k = 1; b - a >= d.getPRECIS(); k++){
                x = ((a * fb) - (b * fa))/(fb - fa);

                double fx = d.funcao(x);

                if(Math.abs(fx) < d.getPRECIS()){
                    break;
                }

                if(fa * fx > 0){
                    a = x;
                } else {
                    b = x;
                }

                if(k < 30){
                    grafico.desenhaGrafico(k, x, "Metodo da Posicao Falsa");
                }
            }
        } else{
            x = a;
        }

        return x;
    }

    /**
     * Encontra as raizes da funcao.
     * @return Um vetor contendo todas as raizes, no intervalo fornecido.
     */
    public double[] raizes(){
        d.encontraLim();
        double[] raizes = new double[2];

        // Verificacao pra impedir que o programa continue, sem ter encontrado os limites menores
        if(! d.getLim().isEmpty()){
            int i = 0;

            // Iterador para a lista contendo os limites
            for(String limites: d.getLim()){
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