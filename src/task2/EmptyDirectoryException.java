package task2;

public class EmptyDirectoryException extends Exception {
    @Override
    public String getMessage() {
        return "The directory is empty!";
    }

    @Override
    public String toString() {
        return "EmptyDirectoryException: " + getMessage();
    }
}
