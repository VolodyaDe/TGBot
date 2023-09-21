package userData;

import java.util.HashMap;

public class UserMemoManager implements MemoManager
{
    private final HashMap<Long, SimpleUser> m_UserList = new HashMap<>();

    public void isUserExists(Long userId)
    {
        if (!m_UserList.containsKey(userId))
            m_UserList.put(userId, new SimpleUser());
    }

    public void addMemoToUser(Long userId, UserMemo reminder)
    {
        m_UserList.get(userId).addMemo(reminder);
    }

    public void removeMemoFromUser(Long userId, UserMemo reminder)
    {
        m_UserList.get(userId).removeMemo(reminder);
    }
}
