// E-S-P

import java.util.NoSuchElementException;

public class DLLDeque<T> implements Deque<T> {
    
    private DLLNode<T> _first , _last;
    private int _size;

    /*---------------------------------------
      precond: 
      postcond: constructs a DLLDeque
      ---------------------------------------*/    
    public DLLDeque() {
	_first = null;
	_last = null;
	_size = 0;
    }
    
    /*---------------------------------------
      precond: DLLDeque is created
      postcond: adds DLLNode to front of DLLDeque
      ---------------------------------------*/
    public void addFirst(T value) {
	DLLNode<T> newNode = new DLLNode<T>(value , null , null); 
	if (isEmpty()) {
	    _first = newNode;
	    _last = newNode;
	}
	else {
	    newNode.setNext(_first);
	    _first.setPrev(newNode);
	    _first = newNode;
	}
	_size++;
    }//end addFirst()
    
    /*---------------------------------------
      precond: DLLDeque is created
      postcond: removes first element in DLLDeque
      if DLLDeque is empty, throw exception
      ---------------------------------------*/
    public T removeFirst(){
    	if (!isEmpty()){
	    T ret = _first.getCargo();
	    _first = _first.getNext();
	    _size--;
	    return ret;
    	}
	else {
	    throw new NoSuchElementException( "Deque is empty!" );
	}
	
    }//end removeFirst()
    
    /*---------------------------------------
      precond: DLLDeque is created
      postcond: Returns first element in DLLDeque
      if DLLDeque is empty, throw exception
      ---------------------------------------*/
    public T getFirst(){
    	if (isEmpty()){
	    throw new NoSuchElementException( "Deque is empty!" );
    	}
    	return _first.getCargo();
    }//end getFirst()

    /*---------------------------------------
      precond: DLLDeque is created
      postcond: adds DLLNode to end of DLLDeque
      ---------------------------------------*/
    public void addLast(T value) {
	DLLNode<T> newNode = new DLLNode<T>(value , null , null);
	if (isEmpty()) {
	    _first = newNode;
	    _last = newNode;
	}
	else {
	    newNode.setPrev(_last);
	    _last.setNext(newNode);
	    _last = newNode;
	}
	_size++;
    }//end addLast()
	
    /*---------------------------------------
      precond: DLLDeque is created
      postcond: removes last element in DLLDeque
      if DLLDeque is empty, throw exception
      ---------------------------------------*/
    public T removeLast(){
    	if (!isEmpty()){
	    T ret = _last.getCargo();
	    _last = _last.getPrev();
	    _size--;
	    return ret;
    	}
	else {
	    throw new NoSuchElementException( "Deque is empty!" );
	}
    }//end removeLast()
	
    /*---------------------------------------
      precond: DLLDeque is created
      postcond: Returns Last element in DLLDeque
      if DLLDeque is empty, throw exception
      ---------------------------------------*/
    public T getLast(){
    	if (isEmpty()){
	    throw new NoSuchElementException( "Deque is empty!" );
    	}
    	return _last.getCargo();
    }//end getLast()


    //--v------------H E L P E R-----M E T H O D S------------v--

    // Checks if DLLDeque is empty
    public boolean isEmpty(){
    	return _size == 0;
    }//end isEmpty()

    // print each node, separated by spaces
    public String toString() { 
	String foo = "";
	DLLNode<T> tmp = _first;
	int counter = _size;
	while ( counter > 0 ) {
	    foo += tmp.getCargo() + " ";
	    tmp = tmp.getNext();
	    counter --;
	}
	return foo;
    }//end toString()

    //--^------------H E L P E R-----M E T H O D S------------^--

    //main method for testing
    public static void main(String[] args) {
	DLLDeque<String> deeznuts = new DLLDeque<String>();
	
	deeznuts.addLast("banana");
	deeznuts.addLast("pear");
	deeznuts.addLast("cherry");
	deeznuts.addLast("lychee");
	System.out.println("DLLDeque: " + deeznuts);
		
		
		
	System.out.println("removed: " + deeznuts.removeLast()); // lychee
	System.out.println("DLLDeque: " + deeznuts);
	System.out.println("removed: " + deeznuts.removeLast()); // cherry
	System.out.println("DLLDeque: " + deeznuts);
	System.out.println("removed: " + deeznuts.removeLast()); // pear
	System.out.println("DLLDeque: " + deeznuts);
	System.out.println("removed: " + deeznuts.removeLast()); // banana
	System.out.println("DLLDeque: " + deeznuts);
	System.out.println("removed: " + deeznuts.removeLast()); // null
	System.out.println("DLLDeque: " + deeznuts);
	/*--------------------- test remove ------------------------
	  ----------------------------------------------------------*/

	//test get
	//System.out.println("getFirst: " + deeznuts.getLast()); //lychee

    }//end main method
       
}//end DLLDeque