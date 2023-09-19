package userData;

public interface IMemoManager
{
    void isUserExists(Long userId);

    void addMemoToUser(Long userId, Memo reminder);

    void removeMemoFromUser(Long userId, Memo reminder);
}
