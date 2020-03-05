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
                printWriter.println("当前ID已经在队中，不可重复排队");
            else
            {
                printWriter.println("您的用户编号为："+id+" 您前面还有"+q.size()+"位用户正在排队");
                q.push(request.getParameter("person_id"));
            }
        }
        else if(ope.equals("2"))
        {
            int pos = q.find(id);
            if(pos != -1)
                printWriter.println("你的用户编号为："+id+" 您前面还有"+(pos - 1)+"位用户正在排队");
            else
                printWriter.println("该ID未在队中,请先排队");
        }
        else
        {
            if(q.empty() == false)
                printWriter.println("出队成功！" + " 出队编号为" + q.pop());
            else
                printWriter.println("队列为空，无法出队");
        }
    }
}
