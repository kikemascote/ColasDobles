package queue;

public class QueueFullException extends Exception {
	public QueueFullException(){}
	public QueueFullException(String Causa){
		super(Causa);
	}
	public QueueFullException(Throwable Causa){
		super(Causa);
	}
}
