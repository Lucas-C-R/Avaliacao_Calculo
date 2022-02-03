package programa;

public class Secante {
    Dados d = new Dados();

    /**
     * Encontra a raiz da funcao, usando o metodo da Secante.
     * @param inic Inicio do intervalo.
     * @param fim Fim do intervalo.
     * @return A raiz da funcao.
     */
    public double encontraRaiz(double inic, double fim){
        double x0 = inic;
        double x1 = fim;
        Grafico grafico = new Grafico();

        // Se |f(x0)| for menor que 10^-10, entao a raiz sera igual ao x0
        if(Math.abs(d.funcao(x0)) < d.getPRECIS()){
            return x0;
        } else{

            // Se |x1 - x0| for menor que 10^-10, encerra a operacao
            for(int k = 1; Math.abs(x1 - x0) >= d.getPRECIS(); k++){
                double x2 = x1 - ((d.funcao(x1)/(d.funcao(x1) - d.funcao(x0))) * (x1 - x0));

                x0 = x1;
                x1 = x2;

                // Se f(x1) for menor que 10^-10, encerra a operacao
                if(d.funcao(x1) < d.getPRECIS()){
                    if(k < 30){
                        grafico.desenhaGrafico(k, x1, "Metodo da Secante");
                    }

                    break;
                }

                if(k < 30){
                    grafico.desenhaGrafico(k, x1, "Metodo da Secante");
                }
            }

            return x1;
        }
    }
}
