package userData;

import java.util.HashMap;

public class MemoManager implements IMemoManager
{
    private final HashMap<Long, User> m_UserList = new HashMap<>();

    public void isUserExists(Long userId)
    {
        if (!m_UserList.containsKey(userId))
            m_UserList.put(userId, new User());
    }

    public void addMemoToUser(Long userId, Memo reminder)
    {
        m_UserList.get(userId).addMemo(reminder);
    }

    public void removeMemoFromUser(Long userId, Memo reminder)
    {
        m_UserList.get(userId).removeMemo(reminder);
    }
}
