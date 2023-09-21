package userData;

import java.util.Date;

public class UserMemo implements Memo
{
    private final String m_sMemoText;
    private final Date m_dtMemoDate;

    public UserMemo(String sMemoText, Date dtMemoDate)
    {
        m_sMemoText = sMemoText;
        m_dtMemoDate = dtMemoDate;
    }

    public String getMemoText()
    {
        return m_sMemoText;
    }

    public boolean dateCompare(Date date)
    {
        return m_dtMemoDate.compareTo(date) <= 0;
    }
}
