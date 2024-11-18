package ua.edu.ucu.apps.document;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import java.io.File;

public class SmartDocument implements Document {
    public String parse(String filePath) {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("/Users/anya/Documents/OOP/labs/Decorators/src/main/resources/");
        tesseract.setLanguage("eng");
        try {
            return tesseract.doOCR(new File(filePath));
        } catch (TesseractException e) {
            e.printStackTrace();
            return "";
        }
    }
}