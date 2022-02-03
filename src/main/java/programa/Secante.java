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

        // Se |f(x0)| for menor que 10^-10, entao a raiz sera igual a 'x0'
        if(Math.abs(d.funcao(x0)) < d.getPRECIS()){
            grafico.desenhaGrafico(1, x0, "Metodo da Secante");

            return x0;
        } else{

            // Se |f(x1)| ou |x1 - x0| for menor que 10^-10, a raiz sera igual a 'x1'
            for(int k = 1; Math.abs(d.funcao(x1)) >= d.getPRECIS() && Math.abs(x1 - x0) >= d.getPRECIS(); k++){

                // x2 = x1 - (f(x1)/(f(x1) - f(x0)) * (x1 - x0))
                double x2 = x1 - (((d.funcao(x1))/(d.funcao(x1) - d.funcao(x0))) * (x1 - x0));

                // Se |f(x2)| ou |x2 - x1| for menor que 10^-10, a raiz sera igual a 'x2'
                if(Math.abs(d.funcao(x2)) < d.getPRECIS() || Math.abs(x2 - x1) < d.getPRECIS()){
                    if(k < 30){
                        grafico.desenhaGrafico(1, x2, "Metodo da Secante");

                        return x2;
                    }
                } else{
                    x0 = x1;
                    x1 = x2;

                    if(k < 30){
                        grafico.desenhaGrafico(1, x1, "Metodo da Secante");
                    }
                }
            }

            return x1;
        }
    }
}