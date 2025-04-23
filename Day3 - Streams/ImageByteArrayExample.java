import java.io.*;
import java.util.Arrays;

public class ImageByteArrayExample {
    public static void main(String[] args) {
        String inputImagePath = "input.jpg";
        String outputImagePath = "output.jpg";

        byte[] imageBytes = null;

        try (FileInputStream fis = new FileInputStream(inputImagePath);
                ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            imageBytes = baos.toByteArray();
            System.out.println("Image converted to byte array successfully.");
        } catch (IOException e) {
            System.out.println("Error reading the image file: " + e.getMessage());
        }

        if (imageBytes != null) {
            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                    FileOutputStream fos = new FileOutputStream(outputImagePath)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = bais.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
                System.out.println("Byte array written back to image successfully.");
            } catch (IOException e) {
                System.out.println("Error writing the image file: " + e.getMessage());
            }
        }

        boolean isIdentical = compareFiles(inputImagePath, outputImagePath);
        if (isIdentical) {
            System.out.println("Success: Both images are identical.");
        } else {
            System.out.println("Failure: Images are not identical.");
        }
    }

    private static boolean compareFiles(String file1, String file2) {
        try (FileInputStream fis1 = new FileInputStream(file1);
                FileInputStream fis2 = new FileInputStream(file2)) {
            byte[] file1Bytes = fis1.readAllBytes();
            byte[] file2Bytes = fis2.readAllBytes();
            return Arrays.equals(file1Bytes, file2Bytes);
        } catch (IOException e) {
            System.out.println("Error comparing files: " + e.getMessage());
            return false;
        }
    }
}
