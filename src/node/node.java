package node;


public class node<T> {
     private T value;
     private node<T> next=null;
     private node<T> back=null;
     private long index = 0;
     
// --Commented out by Inspection START (06/12/2017 09:52 AM):
//     public long getIndex() {
//		return index;
//	}
// --Commented out by Inspection STOP (06/12/2017 09:52 AM)

	public void setIndex(long index) {
		this.index = index;
	}

	public node(){
		this.value = null;
    	 
     }
     
     public node(T value) {
    	 this.value = value;
     }
     
 	@Override
 	public String toString() {
 		// TODO Auto-generated method stub
 		return super.toString();
 	}
 	
 	@Override
 	public boolean equals(Object arg0) {
 		// TODO Auto-generated method stub
 		return super.equals(arg0);
 	}
 	
 	
 	
     
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public node<T> getNext() {
		return next;
	}
	public void setNext(node<T> next) {
		this.next = next;
	}
	public node<T> getBack() {
		return back;
	}
	public void setBack(node<T> back) {
		this.back = back;
	}
   
}
