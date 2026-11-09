import java.io.*;
import java.nio.file.*;
import java.util.concurrent.*;

public class ResultProcessor {

    public static void main(String[] args) {

        ExecutorService executor =
                Executors.newFixedThreadPool(4);

        File folder = new File("scores");

        File[] files = folder.listFiles();

        if (files == null) {
            System.out.println("Scores folder not found");
            executor.shutdown();
            return;
        }

        int success = 0;
        int failure = 0;

        for (File file : files) {

            Future<String> result = executor.submit(() -> {

                String data = Files.readString(file.toPath());

                int marks = Integer.parseInt(data.trim());

                return file.getName() + " : " + marks;
            });

            try {
                System.out.println(result.get());
                success++;

            } catch (Exception e) {
                System.out.println("Failed: " + file.getName());
                failure++;
            }
        }

        executor.shutdown();

        System.out.println("Successful files: " + success);
        System.out.println("Failed files: " + failure);
    }
}