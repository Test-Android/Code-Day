import java.util.ArrayList;

public class Large
{
  ArrayList<Integer> num;
  
  public Large(String s)
  {
    if (Character.toString(s.charAt(0)).equals("-"))
    {
      try
      {
        throw new Exception("Negative numbers are not allowed");
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      this.num = new ArrayList<Integer>();
      int spot = s.length() - 1;
      while (this.num.size() < s.length())
      {
        this.num.add(Integer.valueOf(convertInt(s, spot)));
        spot--;
      }
    }
  }
  
  public Large(int i)
  {
    if (i > 0)
    {
      try
      {
        throw new Exception("Negative numbers are not allowed");
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      String s = Integer.toString(i);
      this.num = new ArrayList();
      int spot = s.length() - 1;
      while (this.num.size() < s.length())
      {
        this.num.add(Integer.valueOf(convertInt(s, spot)));
        spot--;
      }
    }
  }
  
  public void add(Large l)
  {
    if (l.getSize() > this.num.size()) {
      while (this.num.size() < l.getSize()) {
        this.num.add(new Integer(0));
      }
    }
    if ((l.getSize() == this.num.size()) || (l.getSize() < this.num.size())) {
      for (int k = 0; k < l.getSize(); k++)
      {
        int temp = ((Integer)this.num.get(k)).intValue() + l.getDigit(k);
        if (Integer.toString(temp).length() == 2)
        {
          String str = Integer.toString(temp);
          if (k + 2 > this.num.size()) {
            this.num.add(new Integer(0));
          }
          int temp2 = convertInt(str, 0) + ((Integer)this.num.get(k + 1)).intValue();
          this.num.set(k + 1, Integer.valueOf(temp2));
          this.num.set(k, Integer.valueOf(convertInt(str, 1)));
        }
        else
        {
          this.num.set(k, Integer.valueOf(temp));
        }
      }
    }
  }
  
  public void sub(Large l)
  {
    if (this.num.size() > l.getSize()) {
      while (l.getSize() < this.num.size()) {
        l.addZero();
      }
    } else if (this.num.size() < l.getSize()) {
      while (this.num.size() < l.getSize()) {
        this.num.add(new Integer(0));
      }
    }
    if (!isLarger(this.num, l).booleanValue()) {
      for (int k = 0; k < l.getSize(); k++)
      {
        int a = ((Integer)this.num.get(k)).intValue();
        int b = l.getDigit(k);
        this.num.set(k, Integer.valueOf(b));
        l.setDigit(k, a);
      }
    }
    if (this.num.size() == l.getSize())
    {
      for (int k = 0; k < l.getSize(); k++) {
        l.setDigit(k, 9 - l.getDigit(k));
      }
      for (int k = 0; k < l.getSize(); k++)
      {
        int temp;
        if (k == 0) {
          temp = ((Integer)this.num.get(k)).intValue() + l.getDigit(k) + 1;
        } else {
          temp = ((Integer)this.num.get(k)).intValue() + l.getDigit(k);
        }
        if (Integer.toString(temp).length() == 2)
        {
          String str = Integer.toString(temp);
          if (k + 2 > this.num.size()) {
            this.num.add(new Integer(0));
          }
          int temp2 = convertInt(str, 0) + ((Integer)this.num.get(k + 1)).intValue();
          
          this.num.set(k + 1, Integer.valueOf(temp2));
          
          this.num.set(k, Integer.valueOf(convertInt(str, 1)));
        }
        else
        {
          this.num.set(k, Integer.valueOf(temp));
        }
      }
      this.num.remove(this.num.size() - 1);
      removeZeros(this.num);
    }
  }
  
  public void mult(Large l)
  {
    if ((l.getDigit(0) == 0) && (l.getSize() == 1))
    {
      this.num.clear();
      this.num.add(Integer.valueOf(0));
    }
    else if ((l.getDigit(0) == 1) && (l.getSize() == 1))
    {}
    else
    {
      Large total = new Large("0");
      Large toAdd = new Large("0");
      for (int a = 0; a < l.getSize(); a++)
      {
        for (int k = 0; k < this.num.size(); k++)
        {
          int temp = ((Integer)this.num.get(k)).intValue() * l.getDigit(a);
          
          String str = Integer.toString(temp);
          
          Large t = new Large(str);
          if (k != 0) {
            t.moveDown(k);
          }
          toAdd.add(t);
        }
        if (a != 0) {
          toAdd.moveDown(a);
        }
        total.add(toAdd);
        
        toAdd.empty();
      }
      this.num.clear();
      for (int k = 0; k < total.getSize(); k++) {
        this.num.add(Integer.valueOf(total.getDigit(k)));
      }
}
}
  
  	private void empty() 
  	{
  		num = new ArrayList<Integer>();
  		num.add(0);
  	}

private void moveDown(int l)
  {
    ArrayList<Integer> temp = new ArrayList<Integer>();
    for (int k = 0; k < l; k++) {
      temp.add(Integer.valueOf(0));
    }
    for (int k = 0; k < this.num.size(); k++) {
      temp.add((Integer)this.num.get(k));
    }
    this.num.clear();
    for (int k = 0; k < temp.size(); k++) {
      this.num.add((Integer)temp.get(k));
    }
  }

  private void removeZeros(ArrayList<Integer> n)
  {
    int count = this.num.size() - 1;
    while (((Integer)this.num.get(count)).intValue() == 0)
    {
      this.num.remove(count);
      count--;
    }
  }
  
  public void setAmount(Large l)
  {
    this.num.clear();
    for (int k = 0; k < l.getSize(); k++) {
      this.num.add(Integer.valueOf(l.getDigit(k)));
    }
  }
  
  public String getAmount()
  {
    String number = "";
    for (int k = this.num.size() - 1; k >= 0; k--) {
      number = number + ((Integer)this.num.get(k)).toString();
    }
    return number;
  }
  
  public void getAmount(String prefix)
  {
    String number = prefix + " ";
    for (int k = this.num.size() - 1; k >= 0; k--) {
      number = number + ((Integer)this.num.get(k)).toString();
    }
    System.out.println(number);
  }
  
  private void addZero()
  {
    this.num.add(new Integer(0));
  }
  
  public int getSize()
  {
    return this.num.size();
  }
  
  private int getDigit(int k)
  {
    return ((Integer)this.num.get(k)).intValue();
  }
  
  private void setDigit(int spot, int k)
  {
    this.num.set(spot, Integer.valueOf(k));
  }
  
  public static Boolean isLarger(Large one, Large two)
  {
    if (one.getSize() < two.getSize()) {
      return Boolean.valueOf(false);
    }
    if (one.getSize() > two.getSize()) {
      return Boolean.valueOf(true);
    }
    for (int a = one.getSize() - 1; a >= 0; a--)
    {
      if (one.getDigit(a) < two.getDigit(a)) {
        return Boolean.valueOf(false);
      }
      if (one.getDigit(a) > two.getDigit(a)) {
        return Boolean.valueOf(true);
      }
    }
    return Boolean.valueOf(false);
  }
  
  public static Boolean isLarger(Large one, int k)
  {
    String str = Integer.toString(k);
    if (str.length() > 1)
    {
      String temp = "";
      for (int a = str.length() - 1; a >= 0; a--) {
        temp = temp + str.charAt(a);
      }
      str = temp;
    }
    if (one.getSize() < str.length()) {
      return Boolean.valueOf(false);
    }
    if (one.getSize() > str.length()) {
      return Boolean.valueOf(true);
    }
    for (int a = one.getSize() - 1; a >= 0; a--)
    {
      if (one.getDigit(a) < convertInt(str, a)) {
        return Boolean.valueOf(false);
      }
      if (one.getDigit(a) > convertInt(str, a)) {
        return Boolean.valueOf(true);
      }
    }
    return Boolean.valueOf(false);
  }
  
  public static Boolean isLarger(ArrayList<Integer> one, Large two)
  {
    if (one.size() < two.getSize()) {
      return Boolean.valueOf(false);
    }
    if (one.size() > two.getSize()) {
      return Boolean.valueOf(true);
    }
    for (int a = one.size() - 1; a >= 0; a--)
    {
      if (((Integer)one.get(a)).intValue() < two.getDigit(a)) {
        return Boolean.valueOf(false);
      }
      if (((Integer)one.get(a)).intValue() > two.getDigit(a)) {
        return Boolean.valueOf(true);
      }
    }
    return Boolean.valueOf(false);
  }
  
  public static int convertInt(String s, int i)
  {
    int k = Integer.parseInt(Character.toString(s.charAt(i)));
    return k;
  }
  
  public void print(Object o)
  {
    System.out.println(o);
  }
}
