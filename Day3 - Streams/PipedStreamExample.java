import java.io.*;

@SuppressWarnings("override")

class WriterThread extends Thread {
    @SuppressWarnings("FieldMayBeFinal")
    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    public void run() {
        try {
            String message = "Hello from Writer Thread!";
            pos.write(message.getBytes());
            pos.close();
        } catch (IOException e) {
            System.out.println("Writer Error: " + e.getMessage());
        }
    }
}

class ReaderThread extends Thread {
    @SuppressWarnings("FieldMayBeFinal")
    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @SuppressWarnings("override")
    public void run() {
        try {
            byte[] buffer = new byte[1024];
            int bytesRead = pis.read(buffer);
            String receivedMessage = new String(buffer, 0, bytesRead);
            System.out.println("Reader received: " + receivedMessage);
            pis.close();
        } catch (IOException e) {
            System.out.println("Reader Error: " + e.getMessage());
        }
    }
}

public class PipedStreamExample {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            WriterThread writer = new WriterThread(pos);
            ReaderThread reader = new ReaderThread(pis);

            writer.start();
            reader.start();
        } catch (IOException e) {
            System.out.println("Pipe Error: " + e.getMessage());
        }
    }
}
