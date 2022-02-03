package programa;

public class Bisseccao {
    Dados d = new Dados();

    /**
     * Encontra a raiz da funcao, usando o metodo da Bisseccao.
     * @param inic Inicio do intervalo.
     * @param fim Fim do intervalo.
     * @return A raiz da funcao.
     */
    public double encontraRaiz(double inic, double fim){
        double a = inic;
        double b = fim;
        double fa = d.funcao(a);
        double x = (a + b)/2;
        Grafico grafico = new Grafico();

        // Enquanto b-a for maior que 10^-10, essa parte continuara sendo executada
        for(int k = 1; b - a >= d.getPRECIS(); k++){
            x = (a + b)/2;

            double fx = d.funcao(x);

            // Se f(x)*f(a) for maior que 0, entao 'a' ira assumir o valor de 'x', caso contrario, sera 'b'
            if(fx * fa > 0){
                a = x;
            } else{
                b = x;
            }

            if(k < 30){
                grafico.desenhaGrafico(k, x, "Metodo da Bisseccao");
            }
        }

        return x;
    }
}
