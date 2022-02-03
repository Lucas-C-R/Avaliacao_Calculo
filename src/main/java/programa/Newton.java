package programa;

public class Newton {
    Dados d = new Dados();

    /**
     * Encontra a raiz da funcao, usando o metodo de Newton.
     * @param inic Inicio do intervalo.
     * @param fim Fim do intervalo.
     * @return A raiz da funcao.
     */
    public double encontraRaiz(double inic, double fim){
        double x0 = (inic + fim)/2;
        double x1 = x0 - (d.funcao(x0)/d.funcaoDerivada(x0));
        Grafico grafico = new Grafico();

        // Se |f(x0)| for menor que 10^-10, a raiz sera igual ao 'x0'
        if(Math.abs(d.funcao(x0)) < d.getPRECIS()){
            grafico.desenhaGrafico(1, x0, "Metodo de Newton");

            return x0;
        } else{

            // Se |f(x1)| ou |x1 - x0| for menor que 10^-10, a raiz sera igual a 'x1'
            for(int k = 1; Math.abs(d.funcao(x1)) >= d.getPRECIS() && Math.abs(x1 - x0) >= d.getPRECIS(); k++){
                x0 = x1;

                if(k < 30){
                    grafico.desenhaGrafico(k, x1, "Metodo de Newton");
                }

                x1 = x0 - (d.funcao(x0)/d.funcaoDerivada(x0));
            }

            return x1;
        }
    }
}
