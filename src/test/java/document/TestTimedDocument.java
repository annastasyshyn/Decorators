package document;

import ua.edu.ucu.apps.document.TimedDocument;
import ua.edu.ucu.apps.document.MockedDocument;
import ua.edu.ucu.apps.document.Document;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class TestTimedDocument {

    @Test
    void TestTimed() {
        MockedDocument mocked = new MockedDocument();
        Document doc = new TimedDocument(mocked);
        Assertions.assertEquals(doc.parse(""), "Parse");
    }

    @Test
    void TestTimeMeasure() {
        MockedDocument mocked = new MockedDocument();
        Document doc = new TimedDocument(mocked);
        long start = System.currentTimeMillis();
        doc.parse("");
        long end = System.currentTimeMillis();
        Assertions.assertTrue(end - start > 1000);
    }
}
