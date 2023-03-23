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
