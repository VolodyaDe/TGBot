package userData;

public interface IUser
{
    void addMemo(Memo reminder);

    void removeMemo(Memo reminder);

    boolean isMemoExists();
}
