package programa;

import edu.princeton.cs.algs4.Draw;

import java.awt.*;

public class Grafico {
    private Draw desenho = new Draw();

    public Grafico(){
        this.desenho.setCanvasSize(1000, 1000);
        this.desenho.setXscale(-2, 35);
        this.desenho.setYscale(-2, 0.5);
        this.desenho.setPenColor(Color.BLACK);

        // Horizontal
        this.desenho.line(0, -0.4, 0, -1.02);
        this.desenho.text(-0.9, -1, "-1");

        this.desenho.line(-0.2, -0.9, 30, -0.9);
        this.desenho.text(-0.9, -0.905, "-0.9");

        this.desenho.line(-0.2, -0.8, 30, -0.8);
        this.desenho.text(-0.9, -0.805, "-0.8");

        this.desenho.line(-0.2, -0.7, 30, -0.7);
        this.desenho.text(-0.9, -0.705, "-0.7");

        this.desenho.line(-0.2, -0.6, 30, -0.6);
        this.desenho.text(-0.9, -0.605, "-0.6");

        this.desenho.line(-0.2, -0.5, 30, -0.5);
        this.desenho.text(-0.9, -0.505, "-0.5");

        this.desenho.line(-0.2, -0.4, 30, -0.4);
        this.desenho.text(-0.9, -0.405, "-0.4");

        // Vertical
        this.desenho.line(-0.2, -1, 30, -1);
        this.desenho.text(0, -1.06, "0");

        this.desenho.line(5, -1, 5, -1.02);
        this.desenho.text(5, -1.06, "5");

        this.desenho.line(10, -1, 10, -1.02);
        this.desenho.text(10, -1.06, "10");

        this.desenho.line(15, -1, 15, -1.02);
        this.desenho.text(15, -1.06, "15");

        this.desenho.line(20, -1, 20, -1.02);
        this.desenho.text(20, -1.06, "20");

        this.desenho.line(25, -1, 25, -1.02);
        this.desenho.text(25, -1.06, "25");

        this.desenho.line(30, -1, 30, -1.02);
        this.desenho.text(30, -1.06, "30");
    }

    public void desenhaGrafico(double x, double y){
        this.desenho.filledRectangle(x, y, 0.25, 0.016);
    }
}
