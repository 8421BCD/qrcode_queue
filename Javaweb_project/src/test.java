import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "test")
public class test extends HttpServlet {
    queue q;
    Clock clock;

    public void init() throws ServletException {
        q = new queue();
        q.push("abc");
        q.push("bcd");
        q.push("aaa");
        q.push("bbb");
        q.push("ccc");
        clock = new Clock(q);
        clock.start();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/json;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        String id = request.getParameter("person_id");
        String ope = request.getParameter("case");
        if(ope.equals("1"))
        {
            if(q.find(id) != -1)
                printWriter.println("��ǰID�Ѿ��ڶ��У������ظ��Ŷ�");
            else
            {
                printWriter.println("�����û����Ϊ��"+id+" ��ǰ�滹��"+q.size()+"λ�û������Ŷ�");
                q.push(request.getParameter("person_id"));
            }
        }
        else if(ope.equals("2"))
        {
            int pos = q.find(id);
            if(pos != -1)
                printWriter.println("����û����Ϊ��"+id+" ��ǰ�滹��"+(pos - 1)+"λ�û������Ŷ�");
            else
                printWriter.println("��IDδ�ڶ���,�����Ŷ�");
        }
        else
        {
            if(q.empty() == false)
                printWriter.println("���ӳɹ���" + " ���ӱ��Ϊ" + q.pop());
            else
                printWriter.println("����Ϊ�գ��޷�����");
        }
    }
}
