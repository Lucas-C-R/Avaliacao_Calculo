package programa;

public class PosicaoFalsa {
    Dados d = new Dados();

    /**
     * Encontra a raiz da funcao, usando o metodo da Posicao Falsa.
     * @param inic Inicio do intervalo.
     * @param fim Fim do intervalo.
     * @return A raiz da funcao.
     */
    public double encontraRaiz(double inic, double fim){
        double a = inic;
        double b = fim;
        double fa = d.funcao(a);
        double fb = d.funcao(b);
        double x = 0;
        Grafico grafico = new Grafico();

        // Se |f(a)| ou |f(b)| for menor que 10^-10, entao x sera igual a 'a'
        if(Math.abs(fa) >= d.getPRECIS() && Math.abs(fb) >= d.getPRECIS()){

            // Enquanto b-a for maior que 10^-10, essa parte continuara sendo executada
            for(int k = 1; b - a >= d.getPRECIS(); k++){
                x = ((a * fb) - (b * fa))/(fb - fa);

                double fx = d.funcao(x);

                // Se |f(x)| for menor que 10^-10, entao a raiz sera igual ao 'x' atual
                if(Math.abs(fx) < d.getPRECIS()){
                    if(k < 30){
                        grafico.desenhaGrafico(k, x, "Metodo da Posicao Falsa");
                    }

                    break;
                }

                // Se f(x)*f(a) for maior que 0, entao 'a' ira assumir o valor de 'x', caso contrario, sera 'b'
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
}