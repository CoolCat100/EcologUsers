package EcologUsers;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class DataWriter {
    public static void writeData(String path, Data data, String heading) throws IOException {
        Path directory = Path.of(path).getParent();
        Path fileNew = Files.createFile(Path.of(directory + "\\\\datanew.csv"));
        OutputStream output = Files.newOutputStream(fileNew);
        output.write(heading.getBytes());
        output.write(System.getProperty("line.separator").getBytes());
        for (int i = 0; i < data.getData().size(); i++) {
            output.write(data.getData().get(i).getBytes());
            output.write(System.getProperty("line.separator").getBytes());
        }
        output.close();
    }
}
