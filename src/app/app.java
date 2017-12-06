package app;

import queue.Queue;

public class app {

	public static void main(String[] args) {
		Queue<String> names = new Queue<>(6);
		
		try{
		    names.enQueue("Arturo");
			names.enQueue("Gaby");
			names.enQueue("Ana");
			names.enQueue("Andrik");
			names.enQueue("Joselo");
			names.enQueue("Melquiades");
			names.deQueue();
			names.enQueue("Roberto");

			for(String string: names) System.out.println(string);
            System.out.println("Encontrado: "+names.search("Andrik").getValue());
			names.deQueue();
			names.deQueue();
			names.deQueue();
			names.deQueue();
			names.deQueue();

//			names.clear();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
