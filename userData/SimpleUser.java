package userData;

import java.util.ArrayList;

public class SimpleUser implements User
{
    private final ArrayList<UserMemo> m_MemoList = new ArrayList<>();

    public void addMemo(UserMemo reminder)
    {
        m_MemoList.add(reminder);
    }

    public void removeMemo(UserMemo reminder)
    {
        m_MemoList.remove(reminder);
    }

    public boolean isMemoExists()
    {
        return m_MemoList.size() != 0;
    }
}
