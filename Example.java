package SMS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Example {
    JLabel label1, label2, label3, line;
    JTextField t1, t2, t3;
    JButton sub, clr , show;
    JMenuBar f;
    JMenu ins, view, del , update , help ;
    JMenuItem C1, P1, C2, P2, P3 , C4 , P4 , CH ;
    Font font = new Font("Arial", Font.BOLD, 18);
    JFrame frame = new JFrame("SMS");
    public Example() {

        frame.setBounds(160, 40, 1000, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // creating a navbar
        f = new JMenuBar();
        ins = new JMenu("insert");
        C1 = new JMenuItem("Customer");
        P1 = new JMenuItem("Product");
        ins.add(C1);
        ins.add(P1);
        f.add(ins);

        view = new JMenu("view");
        C2 = new JMenuItem("Customer");
        P2 = new JMenuItem("Product");
        CH = new JMenuItem("Customer History");
        view.add(C2);
        view.add(P2);
        view.add(CH);
        f.add(view);

        del = new JMenu("Delete");
        P3 = new JMenuItem("Product");
        del.add(P3);
        f.add(del);
        frame.setJMenuBar(f);

        update = new JMenu("update");
        C4 = new JMenuItem("Customer");
        P4 = new JMenuItem("Product");
        update.add(C4);
        update.add(P4);
        f.add(update);
        frame.setJMenuBar(f);

        help = new JMenu("Help");
        help.add(help);
        f.add(help);
        frame.setJMenuBar(f);

        //using a navbar
        C1.addActionListener(new ActionListener() {
                                 @Override
                                 public void actionPerformed(ActionEvent e) {
                                     frame = new JFrame("Insert");
                                     frame.setBounds(160, 40, 550, 300);
                                     frame.setVisible(true);
                                     frame.setLayout(null);

                                     // Label 1 for Customer Name
                                     label1 = new JLabel("Name");
                                     label1.setBounds(120, 40, 160, 30);
                                     label1.setFont(font);
                                     frame.add(label1);

                                     // Text field for Product
                                     t1 = new JTextField();
                                     t1.setBounds(240, 40, 160, 30);
                                     t1.setText("");
                                     frame.add(t1);

                                     label2 = new JLabel("Mobile No");
                                     label2.setBounds(120, 90, 160, 30);
                                     label2.setFont(font);
                                     frame.add(label2);

                                     // Text field for Mobile
                                     t2 = new JTextField();
                                     t2.setBounds(240, 90, 160, 30);
                                     t2.setText("");
                                     frame.add(t2);

                                     sub = new JButton("Insert");
                                     sub.setBounds(120, 140, 100, 30);
                                     frame.add(sub);
                                     sub.addActionListener(new ActionListener() {

                                                               @Override
                                                               public void actionPerformed(ActionEvent e) {
                                                                   String N = t1.getText();
                                                                   String M = t2.getText();

                                                                   if(N.isEmpty() || M.length()!= 10 || M.isEmpty()){
                                                                       JOptionPane.showMessageDialog(sub, " Fill above text field ");
                                                                   } else{
                                                                   try {
                                                                       Connection con = DriverManager.getConnection(
                                                                               "jdbc:mysql://localhost:3306/store_management_system", "root", "1234");
                                                                       Statement st = con.createStatement();
                                                                       String que= "INSERT INTO customers values('" + N + "', '" + M + "')";
                                                                       st.executeUpdate(que);
                                                                       JOptionPane.showMessageDialog(sub, "Data inserted Successfully");
                                                                       con.close();
                                                                   } catch (Exception ex) {
                                                                       ex.printStackTrace();
                                                                       JOptionPane.showMessageDialog(sub, "Database Error: " + ex.getMessage());
                                                                   } }
                                                               }
                                                           }
                                     );
                                     clr = new JButton("Clear");
                                     clr.setBounds(290, 140, 100, 30);
                                     frame.add(clr);
                                     clr.addActionListener(new ActionListener(){
                                         @Override
                                         public void actionPerformed(ActionEvent e) {
                                             t1.setText("");
                                             t2.setText("");
                                         }
                                     });
                                 }
                             });

        P1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame = new JFrame("Insert");
                frame.setBounds(160, 40, 550, 300);
                frame.setVisible(true);
                frame.setLayout(null);

                // Label 1 for Customer Name
                label1 = new JLabel("Product Name");
                label1.setBounds(120, 40, 200, 30);
                label1.setFont(font);
                frame.add(label1);

                // Text field for Product
                t1 = new JTextField();
                t1.setBounds(260, 40, 160, 30);
                t1.setText("");
                frame.add(t1);

                label2 = new JLabel("Product Price");
                label2.setBounds(120, 90, 200, 30);
                label2.setFont(font);
                frame.add(label2);

                // Text field for Mobile
                t2 = new JTextField();
                t2.setBounds(260, 90, 160, 30);
                t2.setText("");
                frame.add(t2);

                label3 = new JLabel("Product Wt ");
                label3.setBounds(120, 140, 200, 30);
                label3.setFont(font);
                frame.add(label3);

                // Text field for Mobile
                t3 = new JTextField();
                t3.setBounds(260, 140, 160, 30);
                t3.setText("");
                frame.add(t3);


                sub = new JButton("Insert");
                sub.setBounds(120, 190, 100, 30);
                frame.add(sub);
                sub.addActionListener(new ActionListener() {

                                          @Override
                                          public void actionPerformed(ActionEvent e) {
                                              String PN = t1.getText();
                                              String PP = t2.getText();
                                              String PW = t3.getText();

                                              if(PN.isEmpty() || PP.isEmpty() || PW.isEmpty()){
                                                  JOptionPane.showMessageDialog(sub, " Fill above text field ");
                                              }
                                              else{
                                                  try {
                                                      Connection con = DriverManager.getConnection(
                                                              "jdbc:mysql://localhost:3306/store_management_system", "root", "1234");
                                                      Statement st = con.createStatement();
                                                      String que= "INSERT INTO products values('" + PN + "', '" +PP+ "', '" +PW+ "')";
                                                      st.executeUpdate(que);
                                                      JOptionPane.showMessageDialog(sub, PN+" inserted Successfully");
                                                      con.close();
                                                  } catch (Exception ex) {
                                                      ex.printStackTrace();
                                                      JOptionPane.showMessageDialog(sub, "Database Error: " + ex.getMessage());
                                                  } }
                                          }
                                      }
                );
                clr = new JButton("Clear");
                clr.setBounds(290, 190, 100, 30);
                frame.add(clr);
                clr.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        t1.setText("");
                        t2.setText("");
                        t3.setText("");
                    }
                });
            }
        });

        C2.addActionListener (new ActionListener() {
                                  @Override
                                  public void actionPerformed(ActionEvent e) {
                                      frame = new JFrame("view");
                                      frame.setBounds(160, 40, 550, 300);
                                //      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                      frame.setVisible(true);
                                      frame.setLayout(null);

                                      // Label 1 for Customer Name
                                      label1 = new JLabel("Mobile No");
                                      label1.setBounds(120, 40, 160, 30);
                                      label1.setFont(font);
                                      frame.add(label1);

                                      // Text field for Product
                                      t1 = new JTextField();
                                      t1.setBounds(240, 40, 160, 30);
                                      t1.setText("");
                                      frame.add(t1);

                                      sub = new JButton("view");
                                      sub.setBounds(120, 100, 100, 30);
                                      frame.add(sub);
                                      sub.addActionListener(new ActionListener() {
                                          @Override
                                          public void actionPerformed(ActionEvent c) {
                                               String M = t1.getText();
                                              if (M.isEmpty()) {
                                                                     JOptionPane.showMessageDialog(sub, " Fill above text field ");
                                                                       if (M.length() != 10) {
                                                                            JOptionPane.showMessageDialog(sub, "Number must be 10 digit ");
                                                                       }
                                              }
                                              else{
                                              JFrame Sframe = new JFrame("View Customer");
                                              //   Sframe.setTitle("Data viewer");
                                              Sframe.setBounds(400,150,500, 350);
                                              if(frame!=null){
                                                  frame.dispose();
                                              }
                                              Sframe.setVisible(true);
                                              Sframe.setLayout(new BorderLayout());
                                              DefaultTableModel model = new DefaultTableModel();
                                              JTable table = new JTable(model);
                                              JScrollPane scrollPane = new JScrollPane(table);
                                              scrollPane.setPreferredSize(new Dimension(500,500));
                                              Sframe.add(scrollPane,BorderLayout.CENTER);
                                              Sframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                              try {
                                                  Class.forName("com.mysql.cj.jdbc.Driver");
                                                  Connection conn = DriverManager.getConnection(
                                                          "jdbc:mysql://localhost:3306/store_management_system", "root", "1234");
                                                  String query = "select * from customers where cust_id = ? ";
                                                  PreparedStatement stmt = conn.prepareStatement(query);

                                                  stmt.setString(1,M);
                                                  stmt.executeQuery();
                                                  ResultSet rs =stmt.executeQuery();
//                                                  if(!rs.next()){
//                                                      JOptionPane.showMessageDialog(sub, "result not found ");
//                                                  }
                                                  //st.executeQuery(query);;
                                                  ResultSetMetaData rsmd = rs.getMetaData();
                                                  model = (DefaultTableModel) table.getModel();

                                                  int cols = rsmd.getColumnCount();
                                                  String[] colName = new String[cols];
                                                  for (int i = 0; i < cols; i++) {
                                                      colName[i] = rsmd.getColumnName(i + 1);
                                                      model.setColumnIdentifiers(colName);
                                                      String name,id;
                                                      while(rs.next()){
                                                          name = rs.getString(1);
                                                          id = rs.getString(2);
                                                          String []row = {name,id};
                                                          model.addRow(row);
                                                      }
                                                  }
                                              } catch (Exception ex) {
                                                  ex.printStackTrace();
                                                  JOptionPane.showMessageDialog(sub, "Database Error: " + ex.getMessage());
                                              } }
                                          }
                                      });

                                      clr = new JButton("Clear");
                                      clr.setBounds(290, 100, 100, 30);
                                      frame.add(clr);
                                      clr.addActionListener(new ActionListener() {
                                          @Override
                                          public void actionPerformed(ActionEvent f) {
                                              t1.setText("");
                                          }
                                      });

                                      show = new JButton("view all");
                                      show.setBounds(100, 150, 320, 30);
                                      frame.add(show);
                                      show.addActionListener(new ActionListener() {
                                          @Override
                                          public void actionPerformed(ActionEvent c) {

                                              JFrame Sframe = new JFrame("View All Customers");
                                              //   Sframe.setTitle("Data viewer");
                                                  Sframe.setBounds(400,150,500, 350);
                                              if(frame!=null){
                                                  frame.dispose();
                                              }
                                              Sframe.setVisible(true);
                                              Sframe.setLayout(new BorderLayout());
                                              DefaultTableModel model = new DefaultTableModel();
                                              JTable table = new JTable(model);
                                              JScrollPane scrollPane = new JScrollPane(table);
                                         scrollPane.setPreferredSize(new Dimension(500,500));
                                              Sframe.add(scrollPane,BorderLayout.CENTER);

                                              Sframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                                  try {
                                                      Class.forName("com.mysql.cj.jdbc.Driver");
                                                      Connection conn = DriverManager.getConnection(
                                                              "jdbc:mysql://localhost:3306/store_management_system", "root", "1234");
                                                      Statement st = conn.createStatement();
                                                      String query = "select * from customers";
                                                      ResultSet rs = st.executeQuery(query);
                                                      ResultSetMetaData rsmd = rs.getMetaData();
                                                      model = (DefaultTableModel) table.getModel();

                                                      int cols = rsmd.getColumnCount();
                                                      String[] colName = new String[cols];
                                                      for (int i = 0; i < cols; i++) {
                                                          colName[i] = rsmd.getColumnName(i + 1);
                                                            model.setColumnIdentifiers(colName);
                                                            String name , id;
                                                            while(rs.next()){
                                                                name = rs.getString(1);
                                                                id = rs.getString(2);
                                                                String []row = {name,id};
                                                                model.addRow(row);
;                                                            }
                                                      }
                                                  } catch (Exception ex) {
                                                      ex.printStackTrace();
                                                      JOptionPane.showMessageDialog(sub, "Database Error: " + ex.getMessage());
                                                  }
                                          }
                                      });

                                  }
        });

                P2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame = new JFrame("view");
                        frame.setBounds(160, 40, 550, 300);
                        frame.setVisible(true);
                        frame.setLayout(null);

                        // Label 1 for Customer Name
                        label1 = new JLabel("Product Name");
                        label1.setBounds(100, 40, 200, 30);
                        label1.setFont(font);
                        frame.add(label1);

                        // Text field for Product
                        t1 = new JTextField();
                        t1.setBounds(240, 40, 160, 30);
                        t1.setText("");
                        frame.add(t1);

                        sub = new JButton("view");
                        sub.setBounds(120, 100, 100, 30);
                        frame.add(sub);
                        sub.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent c) {
                                String PN = t1.getText();
                                if (PN.isEmpty()) {
                                    JOptionPane.showMessageDialog(sub, " Fill above text field ");
                                }
                                else{
                                    JFrame Sframe = new JFrame("View Customer");
                                    //   Sframe.setTitle("Data viewer");
                                    Sframe.setBounds(400,150,500, 350);
                                    if(frame!=null){
                                        frame.dispose();
                                    }
                                    Sframe.setVisible(true);
                                    Sframe.setLayout(new BorderLayout());
                                    DefaultTableModel model = new DefaultTableModel();
                                    JTable table = new JTable(model);
                                    JScrollPane scrollPane = new JScrollPane(table);
                                    scrollPane.setPreferredSize(new Dimension(500,500));
                                    Sframe.add(scrollPane,BorderLayout.CENTER);

                                    Sframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                    try {
                                        Class.forName("com.mysql.cj.jdbc.Driver");
                                        Connection conn = DriverManager.getConnection(
                                                "jdbc:mysql://localhost:3306/store_management_system", "root", "1234");
                                        String query = "select * from products where pro_name =  ? ";
                                        PreparedStatement stmt = conn.prepareStatement(query);
                                        stmt.setString(1,PN);
                                        // String query = "select * from customers where cust_id = (' "+M+" ') ";
                                        ResultSet rs =stmt.executeQuery();
//                                        if(!rs.next()){
//                                            JOptionPane.showMessageDialog(sub, "result not found ");
//                                        }
                                        //st.executeQuery(query);;
                                        ResultSetMetaData rsmd = rs.getMetaData();
                                        model = (DefaultTableModel) table.getModel();

                                        int cols = rsmd.getColumnCount();
                                        String[] colName = new String[cols];
                                        for (int i = 0; i < cols; i++) {
                                            colName[i] = rsmd.getColumnName(i + 1);
                                            model.setColumnIdentifiers(colName);
                                            String name,price,qty;
                                            while(rs.next()){
                                                name = rs.getString(1);
                                                price = rs.getString(2);
                                                qty = rs.getString(3);
                                                String []row = {name,price,qty};
                                                model.addRow(row);
                                            }
                                        }
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                        JOptionPane.showMessageDialog(sub, "Database Error: " + ex.getMessage());
                                    } }
                            }
                        });


                        clr = new JButton("Clear");
                        clr.setBounds(290, 100, 100, 30);
                        frame.add(clr);
                        clr.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                t1.setText("");
                            }
                        });

                        show = new JButton("view all");
                        show.setBounds(100, 150, 320, 30);
                        frame.add(show);
                        show.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent c) {

                                JFrame Sframe = new JFrame("View All Products");
                                Sframe.setBounds(400,150,500, 350);
                                if(frame!=null){
                                    frame.dispose();
                                }
                                Sframe.setVisible(true);
                                Sframe.setLayout(new BorderLayout());
                                DefaultTableModel model = new DefaultTableModel();
                                JTable table = new JTable(model);
                                JScrollPane scrollPane = new JScrollPane(table);
                                scrollPane.setPreferredSize(new Dimension(500,500));
                                Sframe.add(scrollPane,BorderLayout.CENTER);

                                Sframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                try {
                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                    Connection conn = DriverManager.getConnection(
                                            "jdbc:mysql://localhost:3306/store_management_system", "root", "1234");
                                    Statement st = conn.createStatement();
                                    String query = "select * from products";
                                    ResultSet rs = st.executeQuery(query);
                                    ResultSetMetaData rsmd = rs.getMetaData();
                                    model = (DefaultTableModel) table.getModel();

                                    int cols = rsmd.getColumnCount();
                                    String[] colName = new String[cols];
                                    for (int i = 0; i < cols; i++) {
                                        colName[i] = rsmd.getColumnName(i + 1);
                                        model.setColumnIdentifiers(colName);
                                        String name , price , qty;
                                        while(rs.next()){
                                            name = rs.getString(1);
                                            price = rs.getString(2);
                                            qty = rs.getString(3);
                                            String []row = {name,price,qty};
                                            model.addRow(row);
                                        }
                                    }
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                    JOptionPane.showMessageDialog(sub, "Database Error: " + ex.getMessage());
                                }
                            }
                        });
                    }
                });

                CH.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame = new JFrame("view");
                        frame.setBounds(160, 40, 550, 300);
                        frame.setVisible(true);
                        frame.setLayout(null);

                        // Label 1 for Customer Name
                        label1 = new JLabel("Mobile number");
                        label1.setBounds(80, 40, 200, 30);
                        label1.setFont(font);
                        frame.add(label1);

                        // Text field for Product
                        t1 = new JTextField();
                        t1.setBounds(260, 40, 160, 30);
                        t1.setText("");
                        frame.add(t1);

                        sub = new JButton("view");
                        sub.setBounds(120, 100, 100, 30);
                        frame.add(sub);
                        sub.addActionListener(new ActionListener() {

                                                  @Override
                                                  public void actionPerformed(ActionEvent e) {
                                                      String MN = t1.getText();
                                                      if (MN.isEmpty()) {
                                                          JOptionPane.showMessageDialog(sub, " Fill above text field ");
                                                          if(MN.length()!=10){
                                                              JOptionPane.showMessageDialog(sub, "Number must be 10 digit ");
                                                          }
                                                      } else {

                                                          JFrame Sframe = new JFrame("View Product");
                                                          //   Sframe.setTitle("Data viewer");
                                                          Sframe.setBounds(400, 150, 500, 350);
                                                          if (frame != null) {
                                                              frame.dispose();
                                                          }
                                                          Sframe.setVisible(true);
                                                          Sframe.setLayout(new BorderLayout());
                                                          DefaultTableModel model = new DefaultTableModel();
                                                          JTable table = new JTable(model);
                                                          JScrollPane scrollPane = new JScrollPane(table);
                                                          scrollPane.setPreferredSize(new Dimension(500, 500));
                                                          Sframe.add(scrollPane, BorderLayout.CENTER);
                                                          Sframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                                          try {
                                                              Class.forName("com.mysql.cj.jdbc.Driver");
                                                              Connection conn = DriverManager.getConnection(
                                                                      "jdbc:mysql://localhost:3306/store_management_system", "root", "1234");
                                                              String query = "select  * from purchased where mob_no = ? ";
                                                              PreparedStatement stmt = conn.prepareStatement(query);
                                                              stmt.setString(1,MN);
                                                              stmt.executeQuery();

                                                             ResultSet rs = stmt.executeQuery();
                                                              if(!rs.next()){
                                                                  JOptionPane.showMessageDialog(sub, "result not found ");
                                                              }
                                                             ResultSetMetaData rsmd = rs.getMetaData();
                                                             model = (DefaultTableModel) table.getModel();


                                                                  int cols = rsmd.getColumnCount();
                                                                  String[] colName = new String[cols];
                                                                  for (int i = 0; i < cols; i++) {
                                                                      colName[i] = rsmd.getColumnName(i + 1);
                                                                      model.setColumnIdentifiers(colName);
                                                                      String mobile, name, qty, Dt;

                                                                      while (rs.next()) {
                                                                          mobile = rs.getString(1);
                                                                          name = rs.getString(2);
                                                                          qty = rs.getString(3);
                                                                          Dt = rs.getString(4);
                                                                          String[] row = {mobile, name, qty, Dt};
                                                                          model.addRow(row);
                                                                      }
                                                                  }

                                                          } catch (Exception ex) {
                                                              ex.printStackTrace();
                                                              JOptionPane.showMessageDialog(sub, "Database Error: " + ex.getMessage());
                                                          }

                                                      }
                                                  }
                                              }
                        );
                        clr = new JButton("Clear");
                        clr.setBounds(290, 100, 100, 30);
                        frame.add(clr);
                        clr.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                t1.setText("");
                            }
                        });

                        show = new JButton("view all");
                        show.setBounds(100, 150, 320, 30);
                        frame.add(show);
                        show.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent c) {

                                JFrame Sframe = new JFrame("View All purchased Products");
                                //   Sframe.setTitle("Data viewer");
                                Sframe.setBounds(400,150,500, 350);
                                if(frame!=null){
                                    frame.dispose();
                                }
                                Sframe.setVisible(true);
                                Sframe.setLayout(new BorderLayout());
                                DefaultTableModel model = new DefaultTableModel();
                                JTable table = new JTable(model);
                                JScrollPane scrollPane = new JScrollPane(table);
                                scrollPane.setPreferredSize(new Dimension(500,500));
                                Sframe.add(scrollPane,BorderLayout.CENTER);

                                Sframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                try {
                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                    Connection conn = DriverManager.getConnection(
                                            "jdbc:mysql://localhost:3306/store_management_system", "root", "1234");
                                    Statement st = conn.createStatement();
                                    String query = "select * from purchased";
                                    ResultSet rs = st.executeQuery(query);
                                    ResultSetMetaData rsmd = rs.getMetaData();
                                    model = (DefaultTableModel) table.getModel();

                                    int cols = rsmd.getColumnCount();
                                    String[] colName = new String[cols];
                                    for (int i = 0; i < cols; i++) {
                                        colName[i] = rsmd.getColumnName(i + 1);
                                        model.setColumnIdentifiers(colName);
                                        String mobile , product , qty , DT;
                                        while(rs.next()){
                                            mobile = rs.getString(1);
                                            product = rs.getString(2);
                                            qty = rs.getString(3);
                                            DT = rs.getString(4);

                                            String []row = {mobile,product,qty,DT};
                                            model.addRow(row);
                                        }
                                    }
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                    JOptionPane.showMessageDialog(sub, "Database Error: " + ex.getMessage());
                                }
                            }
                        });

                    }
                });

                P3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame = new JFrame("Delete");
                        frame.setBounds(160, 40, 550, 300);
                        frame.setVisible(true);
                        frame.setLayout(null);

                        // Label 1 for Customer Name
                        label1 = new JLabel("Product Name");
                        label1.setBounds(100, 40, 160, 30);
                        label1.setFont(font);
                        frame.add(label1);

                        // Text field for Product
                        t1 = new JTextField();
                        t1.setBounds(240, 40, 160, 30);
                        t1.setText("");
                        frame.add(t1);

                        sub = new JButton("Delete");
                        sub.setBounds(120, 100, 100, 30);
                        frame.add(sub);
                        sub.addActionListener(new ActionListener() {

                                                  @Override
                                                  public void actionPerformed(ActionEvent e) {
                                                      String PN = t1.getText();

                                                      if (PN.isEmpty()) {
                                                          JOptionPane.showMessageDialog(sub, " Fill above text field ");
                                                      } else {

                                                          try {
                                                              Connection conn = DriverManager.getConnection(
                                                                      "jdbc:mysql://localhost:3306/store_management_system", "root", "1234");
                                                              Statement stmt = conn.createStatement();
                                                              String query = " DELETE FROM products where pro_name = '"+PN+"' ";
                                                              stmt.executeUpdate(query);
                                                              //ResultSet rs = stmt.executeQuery(query);
                                                              JOptionPane.showMessageDialog(sub, PN + " Deleted Successfully");
                                                              conn.close();
                                                          } catch (Exception ex) {
                                                              ex.printStackTrace();
                                                              JOptionPane.showMessageDialog(sub, "Database Error: " + ex.getMessage());
                                                          }
                                                      }
                                                  }
                                              }
                        );
                        clr = new JButton("Clear");
                        clr.setBounds(290, 100, 100, 30);
                        frame.add(clr);
                        clr.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                t1.setText("");
                            }
                        });
                    }
                });

                C4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame = new JFrame("Update");
                        frame.setBounds(160, 40, 550, 300);
                        frame.setVisible(true);
                        frame.setLayout(null);

                        // Label 1 for Customer Name
                        label1 = new JLabel("Old No.");
                        label1.setBounds(120, 40, 160, 30);
                        label1.setFont(font);
                        frame.add(label1);

                        // Text field for Product
                        t1 = new JTextField();
                        t1.setBounds(240, 40, 160, 30);
                        t1.setText("");
                        frame.add(t1);

                        label2 = new JLabel("New No.");
                        label2.setBounds(120, 90, 160, 30);
                        label2.setFont(font);
                        frame.add(label2);

                        // Text field for Mobile
                        t2 = new JTextField();
                        t2.setBounds(240, 90, 160, 30);
                        t2.setText("");
                        frame.add(t2);

                        sub = new JButton("Update");
                        sub.setBounds(120, 140, 100, 30);
                        frame.add(sub);
                        sub.addActionListener(new ActionListener() {

                                                  @Override
                                                  public void actionPerformed(ActionEvent e) {
                                                      String ON = t1.getText();
                                                      String NN = t2.getText();

                                                      if (ON.isEmpty() || NN.isEmpty()) {
                                                          JOptionPane.showMessageDialog(sub, " Fill above text field ");
                                                          if (ON.length() != 10 || NN.length() != 10) {
                                                              JOptionPane.showMessageDialog(sub, " Number must be 10 digit ");
                                                          }
                                                      } else {

                                                          try {
                                                              Connection conn = DriverManager.getConnection(
                                                                      "jdbc:mysql://localhost:3306/store_management_system", "root", "1234");
                                                              Statement stmt = conn.createStatement();
                                                              String query = "update  customers set cust_id = '" + NN + "' where cust_id = '"+ON+"' ";
                                                              stmt.executeUpdate(query);
                                                              JOptionPane.showMessageDialog(sub, "Old Number Updated Successfully");
                                                              conn.close();
                                                          } catch (Exception ex) {
                                                              ex.printStackTrace();
                                                              JOptionPane.showMessageDialog(sub, "Database Error: " + ex.getMessage());
                                                          }
                                                      }
                                                  }
                                              }
                        );
                        clr = new JButton("Clear");
                        clr.setBounds(290, 140, 100, 30);
                        frame.add(clr);
                        clr.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                t1.setText("");
                                t2.setText("");
                            }
                        });
                    }
                });

                P4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame = new JFrame("Update");
                        frame.setBounds(160, 40, 550, 300);
                        frame.setVisible(true);
                        frame.setLayout(null);

                        // Label 1 for Customer Name
                        label1 = new JLabel("Product Name");
                        label1.setBounds(120, 40, 200, 30);
                        label1.setFont(font);
                        frame.add(label1);

                        // Text field for Product
                        t1 = new JTextField();
                        t1.setBounds(260, 40, 160, 30);
                        t1.setText("");
                        frame.add(t1);

                        label2 = new JLabel("New Price");
                        label2.setBounds(120, 90, 200, 30);
                        label2.setFont(font);
                        frame.add(label2);

                        // Text field for Mobile
                        t2 = new JTextField();
                        t2.setBounds(260, 90, 160, 30);
                        t2.setText("");
                        frame.add(t2);

                        sub = new JButton("Update");
                        sub.setBounds(120, 140, 100, 30);
                        frame.add(sub);
                        sub.addActionListener(new ActionListener() {

                                                  @Override
                                                  public void actionPerformed(ActionEvent e) {
                                                      String PN = t1.getText();
                                                      String NP = t2.getText();

                                                      if (PN.isEmpty() || NP.isEmpty()) {
                                                          JOptionPane.showMessageDialog(sub, " Fill above text field ");
                                                      } else {

                                                          try {
                                                              Connection conn = DriverManager.getConnection(
                                                                      "jdbc:mysql://localhost:3306/store_management_system", "root", "1234");
                                                              Statement stmt = conn.createStatement();
                                                              String query = "UPDATE products set pro_price =  '" + NP + "' where pro_name = '"+PN+"' ";
                                                              stmt.executeUpdate(query);
                                                              JOptionPane.showMessageDialog(sub, "Price Updated Successfully");
                                                              conn.close();
                                                          } catch (Exception ex) {
                                                              ex.printStackTrace();
                                                              JOptionPane.showMessageDialog(sub, "Database Error: " + ex.getMessage());
                                                          }
                                                      }
                                                  }
                                              }
                        );
                        clr = new JButton("Clear");
                        clr.setBounds(290, 140, 100, 30);
                        frame.add(clr);
                        clr.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                t1.setText("");
                                t2.setText("");
                            }
                        });
                    }
                });


                // Register page
                Font Tfont = new Font("Arial", Font.BOLD, 32);
                line = new JLabel(" Store Management System ");
                line.setBounds(260, 50, 500, 50);
                line.setFont(Tfont);
                frame.add(line);

                // Label 1 for Mobile
                label1 = new JLabel("Mobile Number");
                label1.setBounds(300, 180, 160, 30);
                label1.setFont(font);
                frame.add(label1);

                // Text field for Mobile
                t1 = new JTextField();
                t1.setBounds(480, 180, 160, 30);
                t1.setText("");
                frame.add(t1);

                // Label 2 for Product
                label2 = new JLabel("Product Name");
                label2.setBounds(300, 230, 160, 30);
                label2.setFont(font);
                frame.add(label2);

                // Text field for Product
                t2 = new JTextField();
                t2.setBounds(480, 230, 160, 30);
                t2.setText("");
                frame.add(t2);

                // Label 3 for Quantity
                label3 = new JLabel("Quantity");
                label3.setBounds(300, 280, 160, 30);
                label3.setFont(font);
                frame.add(label3);

                // Text field for Quantity
                t3 = new JTextField();
                t3.setBounds(480, 280, 160, 30);
                t3.setText("");
                frame.add(t3);

                sub = new JButton("Submit");
                sub.setBounds(320, 360, 100, 30);
                frame.add(sub);
                sub.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String M = t1.getText();
                        String P = t2.getText();
                        String Q = t3.getText();
                        LocalDateTime cDT = LocalDateTime.now();
                        cDT.format(DateTimeFormatter.ofPattern("yyyy-MM-dd  -  HH:mm:ss"));

                        if (P.isEmpty() || Q.isEmpty() || M.isEmpty()) {
                            JOptionPane.showMessageDialog(sub, " Fill above text field ");
                            if (M.length() != 10 && M.length() > 0) {
                                JOptionPane.showMessageDialog(sub, "Number must be 10 digit  ");
                            }
                        } else {
                            String query = "INSERT INTO purchased values('" + M + "', '" + P + "', '" + Q + "', '" + cDT + "')";
                            try {
                                Connection conn = DriverManager.getConnection(
                                        "jdbc:mysql://localhost:3306/store_management_system", "root", "1234");
                                Statement statement = conn.createStatement();

                                statement.executeUpdate(query);
                                JOptionPane.showMessageDialog(sub, "Data Submitted Successfully");
                                conn.close();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                                JOptionPane.showMessageDialog(sub, "Database Error: " + ex.getMessage());
                            }
                        }
                    }
                });

                clr = new JButton("Clear");
                clr.setBounds(500, 360, 100, 30);
                frame.add(clr);
                clr.addActionListener(new ActionListener() {
                                          @Override
                                          public void actionPerformed(ActionEvent e) {
                                              t1.setText(null);
                                              t2.setText(null);
                                              t3.setText(null);
                                          }
                                      }
                );
                frame.setVisible(true);

                label1 = new JLabel("Developed by - ");
                label1.setBounds(890, 500, 90, 30);
                frame.add(label1);

                Font Nfont = new Font("Serif", Font.PLAIN, 18);

                label1 = new JLabel("Anurag Jain");
                label1.setBounds(880, 520, 160, 30);
                frame.add(label1);
                label1.setFont(Nfont);

                label2 = new JLabel("Mayank Sen");
                label2.setBounds(880, 540, 160, 30);
                frame.add(label2);
                label2.setFont(Nfont);

            }


    public static void main(String[] args) {
        new Example();

}
    }
