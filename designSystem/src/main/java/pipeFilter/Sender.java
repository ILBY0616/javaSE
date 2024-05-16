package pipeFilter;

import java.io.PipedOutputStream;

public class Sender extends Thread {
    private final PipedOutputStream out = new PipedOutputStream();

    public PipedOutputStream getOut() {
        return out;
    }

    public void run() {
        String str = "Hello,receiver! I'm sender\n";
        try {
            out.write(str.getBytes());
            out.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
