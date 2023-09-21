package userData;

public interface User
{
    void addMemo(UserMemo reminder);

    void removeMemo(UserMemo reminder);

    boolean isMemoExists();
}
