package programa;

public class PosicaoFalsa {
    Dados d = new Dados();

    /**
     * Encontra a raiz da funcao, usando o metodo da Posicao Falsa.
     * @param inic Inicio do intervalo.
     * @param fim Fim do intervalo.
     * @return A raiz da funcao.
     */
    public double encontraRaiz(double inic, double fim) {
        double a = inic;
        double b = fim;
        Grafico grafico = new Grafico();

        // Se |f(a)| ou |f(b)| for menor que 10^-10, a raiz sera igual a 'a'
        if(Math.abs(d.funcao(a)) < d.getPRECIS() || Math.abs((d.funcao(b))) < d.getPRECIS()){
            grafico.desenhaGrafico(1, a, "Metodo da Posicao Falsa");
            return a;
        } else{

            // Se (b - a) for menor que 10^-10, entao a raiz sera igual a (a + b) / 2
            for(int k = 1; b - a >= d.getPRECIS(); k++){
                double x = ((a * d.funcao(b)) - (b * d.funcao(a)))/(d.funcao(b) - d.funcao(a));

                // Se |f(x)| for menor que 10^-10, entao a raiz sera igual ao 'x' atual
                if(Math.abs(d.funcao(x)) < d.getPRECIS()){
                    if(k < 30){
                        grafico.desenhaGrafico(k, x, "Metodo da Posicao Falsa");
                    }

                    return x;
                }

                // Se f(a) * f(x) for maior que 0, entao 'a' ira assumir o valor de 'x', caso contrario, sera 'b'
                if(d.funcao(a) * d.funcao(x) > 0){
                    a = x;
                } else {
                    b = x;
                }

                if(k < 30){
                    grafico.desenhaGrafico(k, (a + b) / 2, "Metodo da Posicao Falsa");
                }
            }

            return (a + b) / 2;
        }
    }
}