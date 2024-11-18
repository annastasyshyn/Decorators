package ua.edu.ucu.apps;

import ua.edu.ucu.apps.document.Document;
import ua.edu.ucu.apps.document.CachedDocument;
import ua.edu.ucu.apps.document.SmartDocument;
import ua.edu.ucu.apps.document.TimedDocument;

public class Main {
    public static void main(String[] args) {
        Document doc = new TimedDocument(new SmartDocument());
        System.out.println(doc.parse("image_test.jpg"));
        System.out.println(new SmartDocument().parse("image_test.jpg"));
        Document document = new TimedDocument(new SmartDocument());
        System.out.println(document.parse("image_test.jpg"));
    }
}
