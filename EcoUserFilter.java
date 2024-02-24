package Users;

public class EcoUserFilter implements UserFilter {
    int maxConsumption;

    public EcoUserFilter(int maxConsumption) {
        this.maxConsumption = maxConsumption;
    }

    public User[] filter(User[] users) {
        User[] ecologicUsers = new User[users.length];
        for (int i = 0, x = 0; i < ecologicUsers.length; i++) {
            if (users[i].isEcologic(maxConsumption)) {
                ecologicUsers[x] = users[i];
                x++;
            }
        }
        return ecologicUsers;
    }
}
