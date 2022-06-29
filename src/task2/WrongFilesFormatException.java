package task2;

public class WrongFilesFormatException extends Exception {
    @Override
    public String getMessage() {
        return "All of files have wrong format!";
    }

    @Override
    public String toString() {
        return "WrongFilesFormatException: " + getMessage();
    }
}
