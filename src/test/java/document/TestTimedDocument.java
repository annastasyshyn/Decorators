package document;

import ua.edu.ucu.apps.document.TimedDocument;
import ua.edu.ucu.apps.document.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class TestTimedDocument {
    private Document doc;

    @BeforeEach
    void setUp() {
        doc = new TimedDocument(new Document() {
            @Override
            public String parse(String path) {
                return "";
            }
        });
    }

    @Test
    void testParse() {
        String result = doc.parse("src/test/resources/image_test.jpg");
        Assertions.assertEquals("", result);
    }
    
}
