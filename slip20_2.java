 import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


class Slip20_2 extends JFrame implements ActionListener
{          
            JLabel l1,l2,l3,l4;
            JTextField t1,t2,t3,t4;
            JButton b1,b2,b3,b4;
            String sql;
            JPanel p,p1;

            Connection con;
            PreparedStatement ps;
            Statement stmt ;
            ResultSet rs ;
            ResultSetMetaData rsmd ;

            Slip20_2()
            {

                        l1 = new JLabel(" Name :");
                        l2 = new JLabel(" Address:");
                        l3 = new JLabel(" Phone :");
                        l4 = new JLabel(" Email :");   

                        t1 = new JTextField(20);
                        t2 = new JTextField(20);
                        t3 = new JTextField(20);
                        t4 = new JTextField(20);

                        b1 = new JButton(" Add ");
                        b2 = new JButton(" Delete ");
                        b3 = new JButton(" Next ");
                        b4 = new JButton(" Previous ");

                        b1.addActionListener(this);
                        b2.addActionListener(this);
                        b3.addActionListener(this);
                        b4.addActionListener(this);

                        p=new JPanel();
                        p1=new JPanel();
                        add(l1);
                        add(t1);
                        add(b1);

                        add(l2);
                        add(t2);
                        add(b2);

                        add(l3);
                        add(t3);
                        add(b3);

                        add(l4);
                        add(t4);
                        add(b4);

                        setLayout(new GridLayout(4,3));
                        setSize(400,400);
                        setVisible(true);
                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            }

            public void actionPerformed(ActionEvent e)
            {
                        if((JButton)b1==e.getSource())
                        {
                                    String name = t1.getText();
                                    String addr = t2.getText();
                                    String phno = t3.getText();
                                    String mail = t4.getText();
                                    System.out.println("Accept Values");

                                    try
                                    {
                                               	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        									con=DriverManager.getConnection("jdbc:odbc:user1","","");                                   
sql = "insert into Phone values(?,?,?,?)";
                                                ps = con.prepareStatement(sql);
                                                ps.setString(1,name);
                                                ps.setString(2,addr);
                                                ps.setString(3,phno);
                                                ps.setString(4,mail);

                                                System.out.println("values set");
                                                int n=ps.executeUpdate();
                                                if(n!=0)
                                                {
                                                            JOptionPane.showMessageDialog(null,"Record insered ...");                                  
                                                }

                                                else
                                                            JOptionPane.showMessageDialog(null,"Record NOT inserted ");

                                    }//end of try
                                    catch(Exception ex)
                                    {
                                                System.out.println(ex);          
                                                //ex.printStackTrace();
                                    }

                        }//end of if
                        else if(b2==e.getSource())
                        {
                                    try
                                    {
                                                
        									Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        									con=DriverManager.getConnection("jdbc:odbc:user1","","");                                             
stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                                    String nm = t1.getText();
                                    int no = stmt.executeUpdate("delete from Phone where name = '"+nm+"'");
                                    if(no!=0)         
                                                JOptionPane.showMessageDialog(null,"Record Deleted");
                                    else
                                                JOptionPane.showMessageDialog(null,"Record NOT Deleted");
                                    }//end of try
                                    catch(Exception ex)
                                    {
                                                System.out.println(ex);          
                                    }

                        }//end of if
                        else if(b3==e.getSource())
                        {
                                    try
                                    {
                                                	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        									con=DriverManager.getConnection("jdbc:odbc:user1","","");                                                
stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                                                String nm = t1.getText();
                                                rs = stmt.executeQuery("select * from Phone");
                                                //                                                         
                                                while(rs.next())
                                                {
                                                            if(rs.getString(1).equals(nm))
                                                            {                       rs.next();

                                                                        t1.setText(rs.getString(1));
                                                                        t2.setText(rs.getString(2));
                                                                        t3.setText(rs.getString(3));
                                                                        t4.setText(rs.getString(4));
                                                                        break;
                                                            }
                                                }
                                                if(rs.isLast())
                                                            JOptionPane.showMessageDialog(null,"can't move forword");

                                    }//end of try
                                    catch(Exception ex)
                                    {
                                                System.out.println(ex);          

                                    }

                        }//end of if
                        else if(b4==e.getSource())
                        {
                                    try
                                    {
                                                	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        									con=DriverManager.getConnection("jdbc:odbc:user1","","");                                                             stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                                                String nm = t1.getText();
                                                rs = stmt.executeQuery("select * from Phone");
                                                //                                                         
                                                while(rs.next())
                                                {
                                                            if(rs.getString(1).equals(nm))
                                                            {           rs.previous();

                                                                        t1.setText(rs.getString(1));
                                                                        t2.setText(rs.getString(2));
                                                                        t3.setText(rs.getString(3));
                                                                        t4.setText(rs.getString(4));
                                                                        break;
                                                            }
                                                }
                                                if(rs.isFirst())
                                                            JOptionPane.showMessageDialog(null,"can't move backward");

                                    }//end of try
                                    catch(Exception ex)
                                    {
                                                System.out.println(ex);          
                                    }

                        }//end of if
            }
            public static void main(String a[])
            {
                        Slip20_2 ob= new Slip20_2();
            }
}
