import java.io.IOException;

class ExamException extends Exception {
    ExamException(String message) {
        super(message);
    }
}

class SubmissionStorageException extends Exception {
    SubmissionStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class StorageDemo {

    static void saveSubmission(String fileName)
            throws ExamException, SubmissionStorageException {

        try {
            if (fileName.equals("answer02.pdf")) {
                throw new IOException("Disk quota exceeded");
            }

            System.out.println(fileName + " saved successfully");

        } catch (IOException e) {
            throw new SubmissionStorageException(
                "Could not store " + fileName, e);
        }
    }

    public static void main(String[] args) {

        try {
            saveSubmission("answer01.pdf");
            saveSubmission("answer02.pdf");

        } catch (SubmissionStorageException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Cause: " + e.getCause().getMessage());

        } catch (ExamException e) {
            System.out.println(e.getMessage());
        }
    }
}