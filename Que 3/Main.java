import java.lang.StringBuffer;

class AlphabetAppender implements Runnable {
    private StringBuffer buffer;
    private String alphabet;

    public AlphabetAppender(StringBuffer buffer, String alphabet) {
        this.buffer = buffer;
        this.alphabet = alphabet;
    }

    @Override
    public void run() {
        synchronized (buffer) {
            for (int i = 0; i < alphabet.length(); i++) {
                buffer.append(alphabet.charAt(i));
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();
        String alphabet1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabet2 = "abcdefghijklmnopqrstuvwxyz";

        Thread thread1 = new Thread(new AlphabetAppender(buffer, alphabet1));
        Thread thread2 = new Thread(new AlphabetAppender(buffer, alphabet2));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final string: " + buffer.toString());
    }
}
