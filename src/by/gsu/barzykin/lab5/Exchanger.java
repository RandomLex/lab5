package by.gsu.barzykin.lab5;

public class Exchanger {
    private String message;
    private int count;

    public Exchanger(String message, int count) {
        this.message = message;
        this.count = count;
    }

    public synchronized void send(Exchanger ex)  {
        while (count-- > 0) {
            try {
                Thread.sleep(1000);
                message = message + " -> " + Thread.currentThread().getName();
                System.out.println(message);
                ex.notifyAll();
                wait(1);
            } catch (InterruptedException e) {
                //do nothing
            }
        }
    }
}
