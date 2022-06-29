package task2;

import java.util.HashMap;

public class Information {
    private HashMap<String, Document> info = new HashMap<>();

    public HashMap<String, Document> getInfo() {
        return info;
    }

    public void addInfo(String fileName, Document document) {
        info.put(fileName, document);
    }

    public void showInfo() {
        for (String name : info.keySet()) {
            Document document = info.get(name);
            System.out.println(name + " ---> " + document);
        }
    }
}
