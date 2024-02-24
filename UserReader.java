package Users;

import java.io.IOException;

public interface UserReader {
    public User[] read() throws IOException;
}
