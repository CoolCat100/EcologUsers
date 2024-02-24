package Users;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class EcoUserWriter implements UserWriter {
    String path;

    public EcoUserWriter(String path) {
        this.path = path;
    }

    public void write(User[] ecoUsers) throws IOException {
        Path directory = Path.of(path).getParent();
        Path fileNew = Files.createFile(Path.of(directory + "\\\\datanew.csv"));
        FileWriter fileWriter = new FileWriter(String.valueOf(fileNew));
        BufferedWriter writer = new BufferedWriter(fileWriter);
        for (User ecologicUser : ecoUsers) {
            if (ecologicUser != null) {
                writer.write(ecologicUser.toString() + "\n");
            }
        }
        writer.flush();
        writer.close();
    }
}

