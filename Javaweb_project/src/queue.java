public class queue {
    String s[] = new String[10000];
    int l = 0;
    int r = 0;
    public queue(){

    }
    public void push(String id)
    {
        s[r++] = id;
    }
    public boolean empty()
    {
        return l == r;
    }
    public String pop()
    {
        return s[l++];
    }
    public int size()
    {
        return r - l;
    }
    public int find(String id)
    {
        for(int i = l; i < r; i++)
            if(s[i].equals(id))
                return i - l + 1;
        return -1;
    }
}
