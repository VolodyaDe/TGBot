package userData;

public interface MemoManager
{
    void isUserExists(Long userId);

    void addMemoToUser(Long userId, UserMemo reminder);

    void removeMemoFromUser(Long userId, UserMemo reminder);
}
