package Users;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public interface UserWriter {
    public void write(User[] ecoUsers) throws IOException;
}

