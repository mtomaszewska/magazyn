package pl.mt.magazyn.reports;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

@Component
public class FileWriter {

    public void writeToFile(File file, List<? extends ReportElement> elements) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        for (ReportElement element : elements) {
            bw.write(element.report());
            bw.newLine();
        }
        bw.close();
    }
}
