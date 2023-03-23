
class BooleanArrayIntSet implements IntSet {
  private boolean isElem[];
  private int size;
  public int maxSize;

  BooleanArrayIntSet(int maxSize) {
    this.maxSize = maxSize+1;
    isElem = new boolean[this.maxSize];
    size = 0;
  }

  public boolean contains(int x) {
    if (isElem[x] == true)
      return true;
    else
      return false;
  }

  public boolean add(int x) {
    if (isElem[x] == false) {
      isElem[x] = true;
      size++;
      return true;
    }
    return false;
  }

  public boolean remove(int x) {
    if (isElem[x] == true) {
      size--;
      isElem[x] = false;
      return true;
    }
    return false;
  }

  public int size() {
    return size;
  }

  public void clear() {
    for (int i=0; i<maxSize; i++)
      isElem[i] = false;
    size = 0;
  }

  public boolean equals(IntSet s) {
    if (this.size == s.size()) {
      for (int i=0; i<maxSize; i++) {
        if (!(s.contains(i) == contains(i)))
          return false;
      }
      return true;
    }
    return false;
  }

  public IntSet intersection(IntSet s) {
    IntSet tmp = new BooleanArrayIntSet(maxSize-1);
    for(int i=0; i<maxSize; i++)
      if(s.contains(i) && contains(i))
        tmp.add(i);
    return tmp;
  }


  @Override
  public String toString() {
     String res = "{";
     int count=0;
     for (int i=0; i<maxSize && count<size; i++) {
        if (isElem[i] == true) {
          res += i; count++;
          if(count<size)
            res += ",";
        }
     }
     res += "}";
     return res;
  }
}
