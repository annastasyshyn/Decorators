package ua.edu.ucu.apps.document;

public class DocumentDecorator implements Document {
    protected Document document;

    public DocumentDecorator(Document document) {
        this.document = document;
    }

    @Override
    public String parse(String path) {
        return document.parse(path);
    }
    
}
