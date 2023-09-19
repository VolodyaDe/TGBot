package userData;

import java.util.ArrayList;

public class User implements IUser
{
    private final ArrayList<Memo> m_MemoList = new ArrayList<>();

    public void addMemo(Memo reminder)
    {
        m_MemoList.add(reminder);
    }

    public void removeMemo(Memo reminder)
    {
        m_MemoList.remove(reminder);
    }

    public boolean isMemoExists()
    {
        return m_MemoList.size() != 0;
    }
}
