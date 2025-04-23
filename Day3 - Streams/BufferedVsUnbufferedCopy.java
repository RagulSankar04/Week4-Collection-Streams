import java.io.*;

public class BufferedVsUnbufferedCopy {
    public static void main(String[] args) {
        String sourceFile = "largefile.txt";
        String destFileUnbuffered = "unbuffered_copy.txt";
        String destFileBuffered = "buffered_copy.txt";

        long unbufferedTime = copyFileUnbuffered(sourceFile, destFileUnbuffered);
        System.out.println("Time taken with unbuffered streams: " + unbufferedTime + " nanoseconds");

        long bufferedTime = copyFileBuffered(sourceFile, destFileBuffered);
        System.out.println("Time taken with buffered streams: " + bufferedTime + " nanoseconds");

        System.out.println("\nPerformance Comparison:");
        if (bufferedTime < unbufferedTime) {
            System.out.println("Buffered streams are faster by " + (unbufferedTime - bufferedTime) + " nanoseconds.");
        } else {
            System.out.println("Unbuffered streams are faster.");
        }
    }

    private static long copyFileUnbuffered(String source, String dest) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
                FileOutputStream fos = new FileOutputStream(dest)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error during unbuffered copy: " + e.getMessage());
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long copyFileBuffered(String source, String dest) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error during buffered copy: " + e.getMessage());
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
