package ua.edu.ucu.apps.document;

public class TimedDocument extends DocumentDecorator{
    public TimedDocument(Document document) {
        super(document);
    }

    @Override
    public String parse(String path) {
        long start = System.currentTimeMillis();
        String result = document.parse(path);
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + "ms");
        return result;
    }
}
