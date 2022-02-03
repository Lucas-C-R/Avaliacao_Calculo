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
        double fx1 = d.funcao(x1);

        Grafico grafico = new Grafico();
        grafico.desenhaGrafico(1, x1, "Metodo de Newton");

        // Se |f(x0)| for maior ou igual a 10^-10, encerra a operacao
        if(Math.abs(d.funcao(x0)) >= d.getPRECIS()){

            // Continua ate |f(x1)| ser menor que 10^-10
            for(int k = 2; Math.abs(fx1) >= d.getPRECIS(); k++){
                x1 = x0 - (d.funcao(x0)/d.funcaoDerivada(x0));

                fx1 = d.funcao(x1);

                // Caso |x1 - x0| for menor que 10^-10, encerra a operacao
                if(Math.abs(x1 - x0) < d.getPRECIS()){
                    if(k < 30){
                        grafico.desenhaGrafico(k, x1, "Metodo de Newton");
                    }

                    break;
                }

                x0 = x1;

                if(k < 30){
                    grafico.desenhaGrafico(k, x1, "Metodo de Newton");
                }
            }
        }

        return x1;
    }
}
