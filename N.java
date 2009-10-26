// Example 25
// A *simplified* generic node class for use with the Stack1 class 
// and other uses as desired


public class N {
  
    // constructors
    
    public N() {}


    public N(Object o, N link) {
        data = o;
        next = link;
    }


    // selectors


    public Object getData() {
        return data;
    }


    public void setData(Object o) {
        data = o;
    }


    public N getNext() {
        return next;
    }


    public void setNext(N link) {
        next = link;
    }


    // instance variables


    private Object data;
    private N next;

}  // N class 