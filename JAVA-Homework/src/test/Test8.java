package test;



import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * չʾ���ʹ��DefaultTableModel�ഴ�����
 * 
 * @author burns
 * 
 */
public class Test8 extends JFrame {

    JTable table = null;
    DefaultTableModel defaultModel = null;

    public Test8() {
    
        Object[][] p = {
                { "����", new Integer(91), new Integer(1949), new Integer(1910) },
                { "��ѧ��", new Integer(82), new Integer(1969), new Integer(1510) },
                { "÷��", new Integer(47), new Integer(1957), new Integer(1040) },
                { "����", new Integer(61), new Integer(1957), new Integer(1180) },
                { "���", new Integer(90), new Integer(1987), new Integer(1770) }, };
        String[] n = { "ѧ��", "����","�Ա�", "��������", "����","��ѧ","Ӣ��" };
        String[] nn = { "ѧ��", "����","�Ա�", "��������" };
        // ����һ��Ĭ�ϵı��ģ��
        defaultModel = new DefaultTableModel();
        defaultModel.setDataVector(p, n);
        table = new JTable(defaultModel);
        table.setPreferredScrollableViewportSize(new Dimension(400, 80));
      
        JScrollPane s = new JScrollPane(table);

//        Container contentPane = f.getContentPane();
//        contentPane.add(s, BorderLayout.CENTER);s
        add(s,BorderLayout.CENTER);
        setTitle("AddRemoveCells");
        pack();
        setVisible(true);
    }


    public static void main(String[] args) {
        new Test8();
    }

}