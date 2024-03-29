
// Uma classe para representar um ponto 2D
class Point {
   int x, y;

   Point() {
      x = y = 0;
   }

   Point(int x0, int y0) {
      x = x0;
      y = y0;
   }

   public String toString() {
      return "(" + x + "," + y + ")";
   }
}

class Rectangle {

  Point p1, p2; //inf esq, sup dir

  Rectangle(int x1, int y1, int x2, int y2) {
    p1 = new Point(x1, y1);
    p2 = new Point(x2, y2);
  }

  Rectangle(Point p3, Point p4) {
    p1 = p3;
    p2 = p4;
  }

  public int area() {
    int len = (p2.x) - (p1.x);
    int wid = (p2.y) - (p1.y);
    int area = len * wid;
    return area;
  }

  public int perimeter() {
    int len = (p2.x) - (p1.x);
    int wid = (p2.y) - (p1.y);
    int per = (len*2) + (wid*2);
    return per;
  }


  public boolean pointInside(Point p) {
    if (p.x <= p2.x && p.x >= p1.x &&
        p.y <= p2.y && p.y >= p1.y)
        return true;
    return false;
  }

  public boolean rectangleInside(Rectangle r) {
    if (p1.x <= r.p1.x && p1.y <= r.p1.y &&
        p2.x >= r.p2.x && p2.y >= r.p2.y)
        return true;
    return false;
  }

}

// Classe principal com a função main
public class TestRectangle {
   public static void main (String[] args){
     Point a = new Point(1,1);
     Point b = new Point(2,2);
     Point c = new Point(3,4);
     Point d = new Point(8,2);

     Rectangle amarelo  = new Rectangle(a, c);
     Rectangle laranja  = new Rectangle(2, 3, 9, 6);
     Rectangle verde    = new Rectangle(3, 4, 4, 5);
     Rectangle azul     = new Rectangle(5, 1, 6, 5);
     Rectangle vermelho = new Rectangle(7, 3, 9, 5);

     System.out.println("Perimetro do retangulo amarelo = " + amarelo.perimeter()); // 10
     System.out.println("Perimetro do retangulo laranja = " + laranja.perimeter()); // 20

     System.out.println("Area do retangulo amarelo = " + amarelo.area()); // 6
     System.out.println("Area do retangulo laranja = " + laranja.area()); // 21

     System.out.println("Ponto B dentro rectangulo amarelo? " + amarelo.pointInside(b)); // true
     System.out.println("Ponto D dentro rectangulo amarelo? " + amarelo.pointInside(d)); // false

     System.out.println("Retangulo verde dentro do laranja? " + laranja.rectangleInside(verde));       // true
     System.out.println("Retangulo azul dentro do laranja? " + laranja.rectangleInside(azul));         // false
     System.out.println("Retangulo vermelho dentro do laranja? " + laranja.rectangleInside(vermelho)); // true
   }
}
