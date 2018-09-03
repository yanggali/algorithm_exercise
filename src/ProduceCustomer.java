import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class ProduceCustomer {
    static class Producer implements Runnable {
        //用final类型指向同一个引用
        private final BlockingDeque queue;

        public Producer(BlockingDeque queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("生产"+i);
                    queue.put(i);
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    static class Customer implements Runnable{
        private final BlockingDeque queue;

        public Customer(BlockingDeque queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true){
                try {
                    System.out.println("消费"+queue.take());
                    Thread.sleep(2000);
                }
                catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        BlockingDeque queue = new LinkedBlockingDeque(5);
        Producer p = new Producer(queue);
        Customer c = new Customer(queue);

        Thread a = new Thread(p);
        Thread b = new Thread(c);

        a.start();
        b.start();
    }

}
