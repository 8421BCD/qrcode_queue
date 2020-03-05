import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;
import java.io.*;
import java.sql.*;
import javax.swing.table.DefaultTableCellRenderer;
public class Clock extends Thread
{
    private queue q;
    public Clock(){}
    public Clock(queue que)
    {
        this.q = que;
    }
    public void run()
    {
        while(true)
        {
            try
            {
                if(q.empty() == false) q.pop();
                sleep(5000);
            }
            catch(InterruptedException ex)
            {
                break;
            }
        }
    }
}
