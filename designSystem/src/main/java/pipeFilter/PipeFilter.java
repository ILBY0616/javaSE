package pipeFilter;

import java.io.*;

public class PipeFilter {
    public static void main(String[] args) {
        Sender s = new Sender();
        Receiver r = new Receiver();
        PipedOutputStream out = s.getOut();
        PipedInputStream in = r.getIn();

        try {
            in.connect(out);
            s.start();
            r.start();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

