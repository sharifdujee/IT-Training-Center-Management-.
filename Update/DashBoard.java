/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Update;
//import java.db.Connection;

import db.MyConnection;
import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.awt.Color;
import java.awt.Component;
import java.sql.DriverManager;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.util.Date;
//import java.org.jfree.data.general.DefaultPieDataset;
//import java.sql.SQLException;

//import org.jfree.data.general.DefaultPieDataSet;
//chart package
/**
 *
 * @author Asus
 */
public class DashBoard extends javax.swing.JFrame {

    Color defaultColor = new Color(102, 153, 255);
    Color hoverColor = new Color(0, 153, 255);
    DefaultTableModel dtm;
    DefaultTableModel dtm1;

    //int xx, xy;
    public DashBoard() {
        initComponents();
        setemployee();
        setNumber();
        setTime();

        //fsize();
        dtm = new DefaultTableModel(new String[]{"Id", "Name", "User_Name", "Email", "Password", "Joining", "Salary"}, 0);
        jTable2.setModel(dtm);
        jTable2.setShowHorizontalLines(true);
        jTable2.setShowVerticalLines(true);
        jTable2.setBackground(Color.GREEN);
        dtm1 = new DefaultTableModel(new String[]{"ID", "Name", "User_Name", "Email", "Password", "Course", "Round", "Tsp", "DOB"}, 0);
        jTable1.setModel(dtm1);
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
        jTable1.setBackground(Color.GREEN);

        // showchart();
    }

    //Chart 
//   public void showPieChart(String tableName1, String tableName2) {
//
//        DefaultPieDataset barDataset = new DefaultPieDataset();
//        JFreeChart piechart;
//
//        if (tableName1.equals("registration")) {
//            barDataset.setValue("registration", new Integer(MyFunction.countLocalStudents(tableName1)));
//            barDataset.setValue("employee", new Integer(MyFunction.countInternationalStudents(tableName2)));
//            barDataset.setValue("Leaved Local", new Integer(MyFunction.countLeavedLocStudents(tableName1)));
//            barDataset.setValue("Leaved International", new Integer(MyFunction.countLeavedIntStudents(tableName2)));
    //create chart
    /*
            piechart = ChartFactory.createPieChart3D("Students Visualization", barDataset, true, true, false);
        } else {
            barDataset.setValue("Local", new Integer(MyFunction.countLocalEmployees(tableName1)));
            barDataset.setValue("International", new Integer(MyFunction.countInternationalEmployees(tableName2)));
            barDataset.setValue("Not Working Local", new Integer(MyFunction.countLeavedLocEmployees(tableName1)));
            barDataset.setValue("Not Working International", new Integer(MyFunction.countLeavedIntEmployees(tableName2)));
 //create chart
            piechart = ChartFactory.createPieChart3D("Employees Visualization", barDataset, true, true, false);
        }

        PiePlot piePlot = (PiePlot) piechart.getPlot();
        piePlot.setBackgroundPaint(new Color(255, 255, 204));

        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelPieChart.removeAll();
        panelPieChart.add(barChartPanel, BorderLayout.CENTER);
        panelPieChart.validate();
    }
public void showLineChart(String tableName1, String tableName2) {
        //create dataset for the graph
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        JFreeChart linechart;

        if (tableName1.equals("local_students")) {
            dataset.setValue(MyFunction.countLocalStudents(tableName1), "Member", "Loc");
            dataset.setValue(MyFunction.countInternationalStudents(tableName2), "Member", "Int");
            dataset.setValue(MyFunction.countLeavedLocStudents(tableName1), "Member", "LeaLoc");
            dataset.setValue(MyFunction.countLeavedIntStudents(tableName2), "Member", "LeaInt");


    //create chart
            linechart = ChartFactory.createLineChart("Employees Visualization", "", "Number of People",
                    dataset, PlotOrientation.VERTICAL, true, true, false);
        }

        //create plot object
        CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
        lineCategoryPlot.setBackgroundPaint(new Color(255, 255, 204));

        //create render object to change the moficy the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        Color lineChartColor = new Color(0, 175, 58);
        lineRenderer.setSeriesPaint(0, lineChartColor);

        //create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        panelLineChart.removeAll();
        panelLineChart.add(lineChartPanel, BorderLayout.CENTER);
        panelLineChart.validate();
    }
public void showBarChart(String tableName1, String tableName2) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        JFreeChart chart;

        if (tableName1.equals("local_students")) {
            dataset.setValue(MyFunction.countLocalStudents(tableName1), "Member", "Loc");
            dataset.setValue(MyFunction.countInternationalStudents(tableName2), "Member", "Int");
            dataset.setValue(MyFunction.countLeavedLocStudents(tableName1), "Member", "LeaLoc");
            dataset.setValue(MyFunction.countLeavedIntStudents(tableName2), "Member", "LeaInt");

            //create chart
            chart = ChartFactory.createBarChart("Students Visualization", "", "Number of People",
                    dataset, PlotOrientation.VERTICAL, true, true, false);
        } else {
            dataset.setValue(MyFunction.countLocalEmployees(tableName1), "Member", "LeaLoc");
            dataset.setValue(MyFunction.countInternationalEmployees(tableName2), "Member", "Int");
            dataset.setValue(MyFunction.countLeavedLocEmployees(tableName1), "Member", "NotWrokLoc");
            dataset.setValue(MyFunction.countLeavedIntEmployees(tableName2), "Member", "NotWrokInt");
 //create chart
            chart = ChartFactory.createBarChart("Employees Visualization", "", "Number of People",
                    dataset, PlotOrientation.VERTICAL, true, true, false);
            
        }

        CategoryPlot categoryPlot = chart.getCategoryPlot();
        categoryPlot.setBackgroundPaint(new Color(255, 255, 204));
        
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        Color clr3 = new Color(16, 103, 242);
        renderer.setSeriesPaint(0, clr3);

        ChartPanel barpChartPanel = new ChartPanel(chart);
        panelBarChart.removeAll();
        panelBarChart.add(barpChartPanel, BorderLayout.CENTER);
        panelBarChart.validate();

    }
     */
 /*
     */
    // Dynamic Date and Time Set
    public void setTime() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        //  Logger.getLogger(Assesment.class.getName()).log(Level.SEVERE, null, ex);
                        Logger.getLogger(Assesment.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Date ddate = new Date();
                    SimpleDateFormat tf = new SimpleDateFormat("h:mm:ss aa");
                    SimpleDateFormat df = new SimpleDateFormat("EEEE, dd-MM-yyyy");
                    String ttimee = tf.format(ddate);
                    time.setText(ttimee.split(" ")[0] + " " + ttimee.split(" ")[1]);
                    date.setText(df.format(ddate));
                }
            }
        }).start();

    }

    //Employee Show 
    public void setemployee() {
        temployee.setText(String.valueOf(totalEmploy()));
    }

    public void setNumber() {
//Employees.setText(String.valueOf(totalEmploy()));
        ttraine.setText(String.valueOf(totaltrainee()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        employeereg = new javax.swing.JButton();
        login = new javax.swing.JButton();
        tr = new javax.swing.JButton();
        ass = new javax.swing.JButton();
        res = new javax.swing.JButton();
        scs = new javax.swing.JButton();
        comi = new javax.swing.JButton();
        add = new javax.swing.JButton();
        pay = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        elogin = new javax.swing.JButton();
        trainee = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ttraine = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        temployee = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel11.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        employeereg.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        employeereg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Update/Image/add_user_group_woman_man_24px.png"))); // NOI18N
        employeereg.setText("Employee_Registration");
        employeereg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                employeeregMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                employeeregMouseExited(evt);
            }
        });
        employeereg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeregActionPerformed(evt);
            }
        });

        login.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Update/Image/user_log.png"))); // NOI18N
        login.setText("T_Log in");
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginMouseExited(evt);
            }
        });
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        tr.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        tr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Update/Image/add_user_group_woman_man_24px.png"))); // NOI18N
        tr.setText("Trainee_Registration ");
        tr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                trMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                trMouseExited(evt);
            }
        });
        tr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trActionPerformed(evt);
            }
        });

        ass.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        ass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Update/Image/exam.png"))); // NOI18N
        ass.setText("Assessment");
        ass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                assMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                assMouseExited(evt);
            }
        });
        ass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assActionPerformed(evt);
            }
        });

        res.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        res.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Update/Image/ER.png"))); // NOI18N
        res.setText("Result");
        res.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                resMouseExited(evt);
            }
        });
        res.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resActionPerformed(evt);
            }
        });

        scs.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        scs.setText("Scholarship");
        scs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                scsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                scsMouseExited(evt);
            }
        });
        scs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scsActionPerformed(evt);
            }
        });

        comi.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        comi.setText("Comission");
        comi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                comiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                comiMouseExited(evt);
            }
        });
        comi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comiActionPerformed(evt);
            }
        });

        add.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Update/Image/university_icon-icons.com_49967.png"))); // NOI18N
        add.setText("Admission");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addMouseExited(evt);
            }
        });
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        pay.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        pay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Update/Image/pd.png"))); // NOI18N
        pay.setText("Payment");
        pay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                payMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                payMouseExited(evt);
            }
        });
        pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Update/Image/logout.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        elogin.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        elogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Update/Image/user_log.png"))); // NOI18N
        elogin.setText("E_Log_IN");
        elogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eloginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                eloginMouseExited(evt);
            }
        });
        elogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eloginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(elogin)
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(login)
                            .addComponent(ass)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pay)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(res, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(comi)
                                                    .addComponent(scs))))
                                        .addComponent(add)))
                                .addGap(10, 10, 10)))
                        .addGap(53, 53, 53))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(tr)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(employeereg)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(employeereg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(elogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tr)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(res)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(add)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        trainee.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jPanel6.setBackground(new java.awt.Color(153, 255, 153));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Number of Trainee");

        ttraine.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ttraine, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(ttraine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel5.setText("Isdb_Bisew  IT Scholarship Programs");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("OK"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Trainee & Employee DataSet", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Employee Information");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 490, 229));

        jTable1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 410, 230));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Trainee Information");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, -1, -1));

        jPanel7.setBackground(new java.awt.Color(153, 255, 153));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Number of Employee");

        temployee.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(temployee, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(temployee, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jButton1.setBackground(new java.awt.Color(102, 255, 0));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setText("Employee");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 255, 0));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setText("Trainee");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Update/Image/idb-bisew.png"))); // NOI18N
        jLabel7.setText("jLabel7");

        time.setBackground(new java.awt.Color(0, 204, 0));
        time.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        date.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        date.setForeground(new java.awt.Color(51, 255, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(269, 269, 269))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(245, 245, 245))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(229, 229, 229)
                                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(trainee, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(220, 220, 220))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 939, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(trainee)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel7)
                        .addGap(52, 52, 52)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5)
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton1))
                        .addGap(241, 241, 241))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))))
        );

        jMenu1.setText("Employee");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem4.setText("Admission");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItem5.setText("Comission");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Employee Registration ");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseEntered(evt);
            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem6.setText("Log in");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem7.setText("Payment ");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem8.setText("Result ");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem9.setText("Scholarship ");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem10.setText("Trainee Registration");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Trainee");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Log In");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItem3.setText("Assessment ");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Logout ");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(730, 730, 730))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void employeeregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeregActionPerformed
        // TODO add your handling code here:
        Employee_Registration ER = new Employee_Registration();
        ER.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_employeeregActionPerformed

    private void trActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trActionPerformed
        // TODO add your handling code here:
        Trainee_Registration treg = new Trainee_Registration();
        treg.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_trActionPerformed

    private void resActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resActionPerformed
        // TODO add your handling code here:
        Result res = new Result();
        res.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_resActionPerformed

    private void scsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scsActionPerformed
        // TODO add your handling code here:
        SetScholarship ss = new SetScholarship();
        ss.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_scsActionPerformed

    private void comiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comiActionPerformed
        // TODO add your handling code here:
        Comission cm = new Comission();
        cm.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_comiActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        Admission ad = new Admission();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addActionPerformed

    private void payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payActionPerformed
        // TODO add your handling code here:
        Payment paye = new Payment();
        paye.setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_payActionPerformed

    private void employeeregMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeregMouseEntered
        // TODO add your handling code here:
        employeereg.setBackground(hoverColor);
    }//GEN-LAST:event_employeeregMouseEntered

    private void employeeregMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeregMouseExited
        // TODO add your handling code here:
        employeereg.setBackground(Color.RED);
    }//GEN-LAST:event_employeeregMouseExited

    private void trMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trMouseEntered
        // TODO add your handling code here:
        tr.setBackground(hoverColor);
    }//GEN-LAST:event_trMouseEntered

    private void trMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trMouseExited
        // TODO add your handling code here:
        tr.setBackground(Color.ORANGE);
    }//GEN-LAST:event_trMouseExited

    private void resMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resMouseEntered
        // TODO add your handling code here:
        res.setBackground(hoverColor);
    }//GEN-LAST:event_resMouseEntered

    private void resMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resMouseExited
        // TODO add your handling code here:
        res.setBackground(Color.RED);
    }//GEN-LAST:event_resMouseExited

    private void scsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scsMouseEntered
        // TODO add your handling code here:
        scs.setBackground(hoverColor);
    }//GEN-LAST:event_scsMouseEntered

    private void scsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scsMouseExited
        // TODO add your handling code here:
        scs.setBackground(Color.GREEN);
    }//GEN-LAST:event_scsMouseExited

    private void comiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comiMouseEntered
        // TODO add your handling code here:
        comi.setBackground(hoverColor);
    }//GEN-LAST:event_comiMouseEntered

    private void comiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comiMouseExited
        // TODO add your handling code here:
        comi.setBackground(Color.black);
    }//GEN-LAST:event_comiMouseExited

    private void addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseEntered
        // TODO add your handling code here:
        add.setBackground(hoverColor);
    }//GEN-LAST:event_addMouseEntered

    private void addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseExited
        // TODO add your handling code here:
        add.setBackground(Color.YELLOW);
    }//GEN-LAST:event_addMouseExited

    private void payMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_payMouseEntered
        // TODO add your handling code here:
        pay.setBackground(hoverColor);
    }//GEN-LAST:event_payMouseEntered

    private void payMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_payMouseExited
        // TODO add your handling code here:
        pay.setBackground(Color.RED);
    }//GEN-LAST:event_payMouseExited

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
        Trainee_Log_IN log = new Trainee_Log_IN();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_loginActionPerformed

    private void loginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseExited
        // TODO add your handling code here:
        login.setBackground(Color.ORANGE);
    }//GEN-LAST:event_loginMouseExited

    private void loginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseEntered
        // TODO add your handling code here:
        login.setBackground(hoverColor);
    }//GEN-LAST:event_loginMouseEntered

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked
        // TODO add your handling code here:
        login.setBackground(hoverColor);
    }//GEN-LAST:event_loginMouseClicked

    private void assActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assActionPerformed
        // TODO add your handling code here:
        Assesment test = new Assesment();
        test.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_assActionPerformed

    private void assMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_assMouseExited
        // TODO add your handling code here:
        ass.setBackground(hoverColor);
    }//GEN-LAST:event_assMouseExited

    private void assMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_assMouseEntered
        // TODO add your handling code here:
        ass.setBackground(hoverColor);
    }//GEN-LAST:event_assMouseEntered

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        try {
            showid();

        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_formWindowOpened

    private void eloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eloginActionPerformed
        // TODO add your handling code here:
        Employee_Login el = new Employee_Login();
        el.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_eloginActionPerformed

    private void eloginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eloginMouseEntered
        // TODO add your handling code here:
        elogin.setBackground(hoverColor);
    }//GEN-LAST:event_eloginMouseEntered

    private void eloginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eloginMouseExited
        // TODO add your handling code here:
        elogin.setBackground(Color.YELLOW);
    }//GEN-LAST:event_eloginMouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Rohan@2008oxford");
            PreparedStatement ps = c.prepareStatement("Select * From employee");
            ResultSet rs = ps.executeQuery();
            dtm.setRowCount(0);
            while (rs.next()) {
                Object Data[] = {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getInt(7)};
                dtm.addRow(Data);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Rohan@2008oxford");
            PreparedStatement ps = c.prepareStatement("Select * From registration");
            ResultSet rs = ps.executeQuery();
            //dtm1.setRowCount(0);
            while (rs.next()) {
                Object data[] = {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getDate(9)};
                dtm1.addRow(data);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_jMenuItem2MouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        Employee_Registration Emr = new Employee_Registration();
        Emr.show();
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuItem2MouseEntered

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Trainee_Log_IN tl = new Trainee_Log_IN();
        tl.show();
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        Assesment AS = new Assesment();
        AS.show();
        dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        Admission Ad = new Admission();
        Ad.show();
        dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        Comission Co = new Comission();
        Co.show();
        dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        Employee_Login EL = new Employee_Login();
        EL.show();
        dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        Trainee_Registration Tr = new Trainee_Registration();
        Tr.show();
        dispose();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        SetScholarship Sc = new SetScholarship();
        Sc.show();
        dispose();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        Result rr = new Result();
        rr.show();
        dispose();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        Payment pp = new Payment();
        pp.show();
        dispose();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void showid() throws SQLException {

    }

    private void showmarks() throws SQLException {

    }

    public int totalEmploy() {
        int tt = 0;
        Connection c = MyConnection.getConnection();
        Statement st;
        try {
            st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT Count(*) FROM employee");
            while (rs.next()) {
                tt = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return tt;
    }

    public int totaltrainee() {
        int tt = 0;
        Connection c = MyConnection.getConnection();
        Statement st;
        try {
            st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT Count(*) FROM registration");
            while (rs.next()) {
                tt = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return tt;
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton ass;
    private javax.swing.JButton comi;
    private javax.swing.JLabel date;
    private javax.swing.JButton elogin;
    private javax.swing.JButton employeereg;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton login;
    private javax.swing.JButton pay;
    private javax.swing.JButton res;
    private javax.swing.JButton scs;
    private javax.swing.JLabel temployee;
    private javax.swing.JLabel time;
    private javax.swing.JButton tr;
    private javax.swing.JLabel trainee;
    private javax.swing.JLabel ttraine;
    // End of variables declaration//GEN-END:variables
}
