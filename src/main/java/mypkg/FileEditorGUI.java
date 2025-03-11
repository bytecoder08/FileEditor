package mypkg;

import mypkg.fileeditor.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;


public class FileEditorGUI extends JFrame implements ActionListener{
    FileEditor fileEditor = new FileEditor();
    String oldName=new String();
    String newName=new String();
    int  taskToDo=0;
    String path="";
    String valueEntered = "";
    JFileChooser fileChooser;
    JFrame frame = new JFrame();
    ImageIcon logo= new ImageIcon("resources\\Icon.png");
    //panels
    JPanel panel1=new JPanel();
    JPanel panel2=new JPanel();
    JPanel panel3=new JPanel();
    JPanel panel4=new JPanel();
    JScrollPane scrollPane1;
    JScrollPane scrollPane3;
    JScrollPane scrollPane4;

    JTextArea textArea1a=new JTextArea();
    JTextArea textArea3a=new JTextArea();
    JTextArea textArea4a=new JTextArea();
    //labels
    JLabel label1=new JLabel("Instructions:");
    JLabel label2a=new JLabel("Enter your text below:");
    JLabel label2b=new JLabel("Confirm renaming by clicking 'Confirm'");
    JLabel label3=new JLabel("Old File Names:");
    JLabel label4=new JLabel("New File Names:");

    //Others
    JProgressBar progressBar21=new JProgressBar();
    JTextField textField21=new JTextField();
    JTextField textField22=new JTextField();
    JButton button21=new JButton("Get Path");
    JButton button22=new JButton("Start");
    JButton button23=new JButton("Proceed");
    JButton button24=new JButton("Confirm");
    JRadioButton rButton21=new JRadioButton("Remove common words from file's name");
    JRadioButton rButton22=new JRadioButton("Add word to start of name of all files");
    JRadioButton rButton23=new JRadioButton("Change name of Files");
    JRadioButton rButton24=new JRadioButton("Change extension of Files");
    ButtonGroup buttonGroup=new ButtonGroup();

    public void fileEditorGUI(){
        buttonGroup.add(rButton21);
        buttonGroup.add(rButton22);
        buttonGroup.add(rButton23);
        buttonGroup.add(rButton24);

        progressBar21.setBounds(200,30,500,40);
        progressBar21.setMinimum(0);
        progressBar21.setMaximum(100);
        progressBar21.setValue(0);
        progressBar21.setFont(new Font("MV Boli",Font.BOLD,20));
        progressBar21.setForeground(new Color(0xFF006F));
        progressBar21.setBackground(new Color(89, 88, 86));
        progressBar21.setStringPainted(true);

        scrollPane1=new JScrollPane(textArea1a);
        scrollPane1.setBounds(0,30,903,172);
        scrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane1.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                e.getAdjustable().setValue(e.getAdjustable().getMaximum());
            }
        });

        scrollPane3=new JScrollPane(textArea3a);
        scrollPane3.setBounds(0,30,380,331);
        scrollPane3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        scrollPane4=new JScrollPane(textArea4a);
        scrollPane4.setBounds(0,30,380,331);
        scrollPane4.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        rButton21.setBounds(200,150,500,30);
        rButton21.setBackground(new Color(0,136,255));
        rButton21.setForeground(Color.black);
        rButton21.setFont(new Font("",Font.PLAIN,20));
        rButton21.setFocusable(false);
        rButton21.addActionListener(this);

        rButton22.setBounds(200,190,500,30);
        rButton22.setBackground(new Color(0,136,255));
        rButton22.setForeground(Color.black);
        rButton22.setFont(new Font("",Font.PLAIN,20));
        rButton22.setFocusable(false);
        rButton22.addActionListener(this);

        rButton23.setBounds(200,230,500,30);
        rButton23.setBackground(new Color(0,136,255));
        rButton23.setForeground(Color.black);
        rButton23.setFont(new Font("",Font.PLAIN,20));
        rButton23.setFocusable(false);
        rButton23.addActionListener(this);

        rButton24.setBounds(200,270,500,30);
        rButton24.setBackground(new Color(0,136,255));
        rButton24.setForeground(Color.black);
        rButton24.setFont(new Font("",Font.PLAIN,20));
        rButton24.setFocusable(false);
        rButton24.addActionListener(this);

        button21.setFont(new Font("arial",Font.BOLD,15));
        button21.setBackground(new Color(247, 255, 1));
        button21.setForeground(new Color(102, 1, 111));
        button21.setBounds(560,110,140,30);
        button21.setFocusable(false);
        button21.addActionListener(this);

        button22.setFont(new Font("arial",Font.BOLD,15));
        button22.setBackground(new Color(0, 255, 34));
        button22.setForeground(new Color(1, 5, 86));
        button22.setBounds(560,310,140,30);
        button22.setFocusable(false);
        button22.addActionListener(this);

        button23.setFont(new Font("arial",Font.BOLD,15));
        button23.setBackground(new Color(255, 94, 0));
        button23.setForeground(new Color(0, 0, 0));
        button23.setBounds(560,360,140,30);
        button23.setFocusable(false);
        button23.addActionListener(this);

        button24.setFont(new Font("arial",Font.BOLD,15));
        button24.setBackground(new Color(0, 255, 234));
        button24.setForeground(new Color(0, 3, 52));
        button24.setBounds(560,420,140,30);
        button24.setFocusable(false);
        button24.addActionListener(this);

        textField21.setFont(new Font("arial",Font.PLAIN,20));
        textField21.setBounds(200,110,350,30);
        textField21.setBorder(new LineBorder(Color.black,2));

        textField22.setFont(new Font("arial",Font.PLAIN,20));
        textField22.setBounds(200,360,350,30);
        textField22.setBorder(new LineBorder(Color.black,2));

        label1.setBounds(1,0,900,30);
        label1.setFont(new Font("serif",Font.BOLD,30));
        label1.setForeground(Color.white);

        label2a.setBounds(200,330,350,30);
        label2a.setFont(new Font("arial",Font.ITALIC,18));
        label2a.setForeground(Color.white);

        label2b.setBounds(200,420,350,30);
        label2b.setFont(new Font("arial",Font.ITALIC,18));
        label2b.setForeground(Color.white);

        label3.setBounds(1,0,380,30);
        label3.setFont(new Font("serif",Font.BOLD,20));
        label3.setForeground(Color.white);

        label4.setBounds(1,0,380,30);
        label4.setFont(new Font("serif",Font.BOLD,20));
        label4.setForeground(Color.white);


        textArea1a.setFont(new Font("arial",Font.PLAIN,20));
        textArea1a.setBackground(new Color(241, 90, 213));
        textArea1a.setLineWrap(true);
        textArea1a.setWrapStyleWord(true);
        textArea1a.setEditable(false);
        textArea1a.append(" Welcome ! \n Now you can start...\n");
        textArea1a.append(" Select any file from the folder where you want to work... \n " +
                "You can use 'Get Path' button for this... \n" +
                " You can also enter the path of folder instead of using 'Get Path' Button...\n");

        textArea3a.setFont(new Font("arial",Font.PLAIN,20));
        textArea3a.setBackground(new Color(104, 109, 218));
        textArea3a.setLineWrap(true);
        textArea3a.setWrapStyleWord(true);
        textArea3a.setEditable(false);

        textArea4a.setFont(new Font("arial",Font.PLAIN,20));
        textArea4a.setBackground(new Color(104, 109, 218));
        textArea4a.setLineWrap(true);
        textArea4a.setWrapStyleWord(true);
        textArea4a.setEditable(false);

        //panels
        panel1.setBounds(0,0,900,200);
        panel1.setLayout(null);
        panel1.setBorder(new LineBorder(Color.black,1));
        panel1.setBackground(new Color(134, 0, 0));
        panel1.add(label1);
        panel1.add(scrollPane1);

        panel2.setBounds(0,200,900,520);
        panel2.setBorder(new LineBorder(Color.black,1));
        panel2.setLayout(null);
        panel2.setBackground(new Color(1, 5, 86));
        panel2.add(progressBar21);
        panel2.add(textField21);
        panel2.add(button21);
        panel2.add(rButton21);
        panel2.add(rButton22);
        panel2.add(rButton23);
        panel2.add(rButton24);
        panel2.add(button22);
        panel2.add(label2a);
        panel2.add(textField22);
        panel2.add(button23);
        panel2.add(label2b);
        panel2.add(button24);

        panel3.setBounds(900, 0, 380, 360);
        panel3.setLayout(null);
        panel3.setBorder(new LineBorder(Color.black,1));
        panel3.setBackground(new Color(70, 1, 86));
        panel3.add(label3);
        panel3.add(scrollPane3);

        panel4.setBounds(900, 360, 380, 360);
        panel4.setLayout(null);
        panel4.setBorder(new LineBorder(Color.black,1));
        panel4.setBackground(new Color(70, 1, 86));
        panel4.add(label4);
        panel4.add(scrollPane4);


        //frame
        frame.setTitle("File Editor");
        frame.setSize(1293,757);
        frame.setLayout(null);
        frame.setResizable(false);

        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);

        frame.setIconImage(logo.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button21){
            fileChooser=new JFileChooser();
            int response = fileChooser.showOpenDialog(null);
            if (response==JFileChooser.APPROVE_OPTION){
                textField21.setText(fileChooser.getCurrentDirectory().getAbsolutePath());
            }
        textArea1a.append(" Select task you want to perform...\n");
        }
            path = new String(textField21.getText());
            if (!path.equals("")){
                fill(20);
            }
        //////
        if (e.getSource()==rButton21) {
            taskToDo=1;
            System.out.println(taskToDo);
        } else if (e.getSource()==rButton22) {
            taskToDo=2;
            System.out.println(taskToDo);
        } else if (e.getSource()==rButton23) {
            taskToDo=3;
            System.out.println(taskToDo);
        } else if (e.getSource()==rButton24) {
            taskToDo=4;
            System.out.println(taskToDo);
        }
        if (e.getSource()==rButton21||e.getSource()==rButton22||e.getSource()==rButton23||e.getSource()==rButton24){
            fill(40);
            textArea1a.append(" Press 'Start' to begin process...\n");
        }
        //////
            System.out.println("Enter key start");
        if (e.getSource()==button22){
            oldName=fileEditor.listFiles(path,taskToDo);
            textArea3a.setText(oldName);
            fill(60);
            textArea1a.append(" Enter whatever you  want to add or remove...\n And click on 'Proceed'...\n");
        }
        //////
        if (e.getSource()==button23){
            System.out.println("entre value");
            valueEntered=textField22.getText();
            newName=fileEditor.doTask(valueEntered,taskToDo);
            textArea4a.setText(newName);
            fill(80);
            textArea1a.append(" Click 'Confirm' to start renaming...\n");
        }
        //////
        if (e.getSource()==button24){
            System.out.println("confirm");
            int done=fileEditor.doRename(path);
            if (done==1){
                fill(100);
            }
        }
    }

        int counter=0;
    public void fill(int setBar){
        while(counter<=setBar){
            progressBar21.setValue(counter);
            try{
                Thread.sleep(10);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            counter++;
            if (counter==100){
                progressBar21.setString("Process Complete !");
                print();
            }
        }
    }
    public void print(){
        textArea1a.append(" Operation complete......\n Thank You!");
        System.out.println("Operation complete.\n Thank You!");
    }
    public static void main(String [] args)
    {
        FileEditorGUI fileEditorMain = new FileEditorGUI();
        fileEditorMain.fileEditorGUI();
    }
}