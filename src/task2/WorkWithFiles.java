package task2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorkWithFiles {
    private String dirPath;
    private List<String> filesPaths = new ArrayList<>();
    private int countValidFiles;
    private int countInValidFiles;

    public WorkWithFiles(String dirPath) {
        this.dirPath = dirPath;
    }

    public String getDirPath() {
        return dirPath;
    }

    private void addFilesPathsToList() throws IOException, EmptyDirectoryException {
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Path.of(dirPath));
        for (Path filePath : directoryStream) {
            filesPaths.add(filePath.toString());
        }
        if (filesPaths.isEmpty()) {
            throw new EmptyDirectoryException();
        }
    }

    public void analyseFiles(int count, Information information) throws IOException, EmptyDirectoryException, WrongFilesFormatException {
        addFilesPathsToList();
        countValidFiles = 0;
        countInValidFiles = 0;
        for (int i = 0; i < filesPaths.size(); i++) {
            String name = findTxtFileName(filesPaths.get(i));
            if (name.equals("")) {
                countInValidFiles++;
                continue;
            }
            String text = Files.readString(Path.of(filesPaths.get(i)));
            Document document = findInfoInText(text);
            information.addInfo(name, document);
            countValidFiles++;
            if (countValidFiles == count) {
                break;
            }
        }
        if (countValidFiles == 0) {
            throw new WrongFilesFormatException();
        } else showInfoAboutProcessedFiles();
    }

    private String findTxtFileName(String pathOfFile) {
        String name = "";
        if (pathOfFile.endsWith(".txt")) {
            Pattern fileNamePattern = Pattern.compile("\\w+\\.txt");
            Matcher fileNameMatcher = fileNamePattern.matcher(pathOfFile);
            fileNameMatcher.find();
            name = pathOfFile.substring(fileNameMatcher.start(), fileNameMatcher.end() - 4);
        }
        return name;
    }

    private Document findInfoInText(String text) throws IOException {
        Document document = new Document();
        Pattern phoneNumberPattern = Pattern.compile("\\+\\(\\d{2}\\)\\d{7}");
        Pattern emailPattern = Pattern.compile("([A-Za-z0-9]+\\p{Punct}*[A-Za-z0-9]*)@([a-z]{3,10})\\.[a-z]{2,5}");
        Pattern documentNumberPattern = Pattern.compile("(\\d{4}-[A-Za-zА-Яа-я]{3}-){2}(\\d[A-Za-zА-Яа-я]){2}");
        Matcher phoneNumberMatcher = phoneNumberPattern.matcher(text);
        Matcher emailMatcher = emailPattern.matcher(text);
        Matcher documentNumberMatcher = documentNumberPattern.matcher(text);
        while (phoneNumberMatcher.find()) {
            document.addToList(text.substring(phoneNumberMatcher.start(), phoneNumberMatcher.end()));
        }
        while (emailMatcher.find()) {
            document.addToList(text.substring(emailMatcher.start(), emailMatcher.end()));
        }
        while (documentNumberMatcher.find()) {
            document.addToList(text.substring(documentNumberMatcher.start(), documentNumberMatcher.end()));
        }
        return document;
    }

    private void showInfoAboutProcessedFiles() {
        System.out.println("Total count of processed files is " + (countValidFiles + countInValidFiles) + ";\n" +
                "There are " + countValidFiles + " valid files and " + countInValidFiles + " invalid files.");
    }

}
