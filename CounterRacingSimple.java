
public class CounterRacingSimple {
	public static void main(String[] args) {
		
		// 1)для нового объекта приложения не создается переменная 
		//   потому что он создается как анонимный объект /работа с объектом
				new CounterRacingSimple().doCounter();
				
			}
			
			private int count = 0;
			
			private synchronized void increment() {
				count++;
			}
			
			private void doCounter() {
		        // 2)создали объект класса Thread, в аргументе создали поток выполнения. 
				//   Чтобы реализовать Runnable, должен быть объявлен метод run ()
				Thread t1 = new Thread(new Runnable() {
					
					@Override
					public void run() {
		                // 3)цикл for() повторится 1 000 000 раз
						for(int i = 0; i < 1_000_000; i++) {
							increment();
						}
		                System.out.println("t1: " + count);
						
					}
				});

				Thread t2 = new Thread(new Runnable() {
					
					@Override
					public void run() {
						for(int i = 0; i < 1_000_000; i++) {
							increment();
						}
		                System.out.println("t2: " + count);
						
					}
				});
				Thread t3 = new Thread(new Runnable() {
					
					@Override
					public void run() {
						for(int i = 0; i < 1_000_000; i++) {
							increment();
						}
		                System.out.println("t3: " + count);
						
					}
				});
				// 4) потому что они параллельные потоки
				t1.start();
				t2.start();
				t3.start();
		//5) асинхронное поведение
	}
	
	
}
