package bigWork;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import bigWork.global.Global;
import bigWork.stu.entity.Student;
import bigWork.stu.service.StudentService;
import bigWork.utils.CtxUtils;

//@SuppressWarnings("serial")
public class FirstPanel extends JPanel{
	private JLabel title;
	private JPanel titlePanel;
	JPanel buttonPanel;
	JPanel contentPanel;
	
	JLabel stuIdLabel;
	JTextField stuIdField;
	JLabel nameLabel;
	JTextField nameField;
	JLabel sexLabel;
	JTextField sexField;
	JLabel birthLabel;
	JTextField birthField;
	JLabel chineseLabel;
	JTextField chineseField;
	JLabel mathLabel;
	JTextField mathField;
	JLabel englishLabel;
	JTextField englishField;
	
	
	JButton addButton;
	JButton updateButton;
	JButton deleteButton;
	
    String[] n = { "学号", "姓名","性别", "出生日期", "语文","数学","英语" };
    JTable table = null;
    DefaultTableModel defaultModel = null;
    
    StudentService service=CtxUtils.getStudentService();
    List<Student>students;
	public FirstPanel(){
		this.setLayout(new BorderLayout());
		
		buildTitlePanel();
		bulidContentPanel();
		bulidButtonPanel();
		
	    // 把标题面板加入first panel面板
		this.add(titlePanel, BorderLayout.NORTH);
		this.add(contentPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}	
	public void buildTitlePanel(){
		// 创建标题面板
		titlePanel = new JPanel();
		
		// 设置标题面板的大小
		titlePanel.setPreferredSize(new Dimension(600, 70));
		
		// 设置标题面板上下左右的边距
		titlePanel.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
		
		// 设置标题的字体及大小
		title = new JLabel("学生信息", SwingConstants.CENTER);
		title.setFont(new Font("宋体", Font.BOLD, 14));
		// 把标题加入标题面板
		titlePanel.add(title);	
	}
	public void bulidContentPanel(){
		
		contentPanel=new JPanel();
		defaultModel = new DefaultTableModel();
		Object[][] res=getFromDB();
	    defaultModel.setDataVector(res, n);
	    table = new JTable(defaultModel);
	    table.getSelectionModel().addListSelectionListener(new SelectionListener());
	    table.setPreferredScrollableViewportSize(new Dimension(600, 200));  
	    JScrollPane s = new JScrollPane(table);
	    contentPanel.add(s,BorderLayout.CENTER);
		 
	        
	}
	public void bulidButtonPanel(){
		buttonPanel=new JPanel(new GridLayout(2, 1));
		JPanel jPanel1=new JPanel();
		JPanel jPanel2=new JPanel();
		
		addButton=new JButton("添加");
		addButton.addActionListener(new ButtonActionListener());
		updateButton=new JButton("修改");
		updateButton.addActionListener(new ButtonActionListener());
		deleteButton=new JButton("删除");
		deleteButton.addActionListener(new ButtonActionListener());
		
		stuIdLabel=new JLabel("学号:");
		stuIdField=new JTextField(5);
		nameLabel=new JLabel("姓名:");
		nameField=new JTextField(5);
		sexLabel=new JLabel("性别:");
		sexField=new JTextField(5);
		birthLabel=new JLabel("出生日期:");
		birthField=new JTextField(5);
		chineseLabel=new JLabel("语文:");
		chineseField=new JTextField(3);
		mathLabel=new JLabel("数学:");
		mathField=new JTextField(3);
		englishLabel=new JLabel("英语:");
		englishField=new JTextField(3);
		
		
		jPanel1.add(stuIdLabel);
		jPanel1.add(stuIdField);
		jPanel1.add(nameLabel);
		jPanel1.add(nameField);
		jPanel1.add(sexLabel);
		jPanel1.add(sexField);
		jPanel1.add(birthLabel);
		jPanel1.add(birthField);
		jPanel1.add(chineseLabel);
		jPanel1.add(chineseField);
		jPanel1.add(mathLabel);
		jPanel1.add(mathField);
		jPanel1.add(englishLabel);
		jPanel1.add(englishField);
		
		jPanel2.add(addButton);
		jPanel2.add(updateButton);
		jPanel2.add(deleteButton);
		
		buttonPanel.add(jPanel1);
		buttonPanel.add(jPanel2);
	}
	
	public class ButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==addButton){
				
				Student student=getNewStudent();
				if(student==null){
					JOptionPane.showMessageDialog(addButton, Global.getError());
				}
				else{
					service.saveAndFlush(student);
					JOptionPane.showMessageDialog(addButton, "添加成功");
					defaultModel.setDataVector(getFromDB(), n);
				}
				
			}
			else if(e.getSource()==updateButton){
				int index=table.getSelectedRow();
				if(index==-1){
					JOptionPane.showMessageDialog(deleteButton, "请选择行");
					return ;
				}
				int id = students.get(index).getId();
				Student cur = service.getById(id);
				Student updatedStu=getUpdateStudent(cur);
				if(updatedStu==null){
					JOptionPane.showMessageDialog(addButton, Global.getError());
				}
				else{
					service.saveAndFlush(updatedStu);
					JOptionPane.showMessageDialog(updateButton, "修改成功");
					defaultModel.setDataVector(getFromDB(), n);
				}
			}
			else if(e.getSource()==deleteButton){
				int index=table.getSelectedRow();
				if(index==-1){
					JOptionPane.showMessageDialog(deleteButton, "请选择行");
					return ;
				}
				int id = students.get(index).getId();
				service.delete(id);
				JOptionPane.showMessageDialog(deleteButton, "删除成功");
				defaultModel.setDataVector(getFromDB(), n);
			}
		}
	}
	
	Object[][] getFromDB(){
		students=service.getAll();Global.setRowNumber(students.size());
		Object[][] res=new Object[20][10];
		for(int i=0;i<students.size();i++){
			res[i][0]=students.get(i).getStuId();
			res[i][1]=students.get(i).getName();
			res[i][2]=students.get(i).getGender();
			res[i][3]=students.get(i).getBornDate();
			res[i][4]=students.get(i).getChinese();
			res[i][5]=students.get(i).getMath();
			res[i][6]=students.get(i).getEnglish();
		}
		return res;
	}
	

	public Student getNewStudent(){
		String stuIdStr=stuIdField.getText().trim();
		String nameStr=nameField.getText().trim();
		String sexStr=sexField.getText().trim();
		String birthStr=birthField.getText().trim();
		String chineseStr=chineseField.getText().trim();
		String mathStr=mathField.getText().trim();
		String englishStr=englishField.getText().trim();
		if(stuIdStr==null||stuIdStr=="") return null;
		if(nameStr==null||nameStr=="") return null;
		if(sexStr==null||sexStr=="") return null;
		if(birthStr==null||birthStr=="") return null;
		if(chineseStr==null||chineseStr=="") return null;
		if(mathStr==null||mathStr=="") return null;
		if(englishStr==null||englishStr=="") return null;
		
		Date birth;
		int chinese,math,english;
		try {
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");dateFormat.setLenient(false);
			birth=dateFormat.parse(birthStr);
			//超过当前时间
			if(birth.getTime()>new Date().getTime()) throw new Exception("出生日期超过当前时间");
			//超过100岁
			if(new Date().getTime()-birth.getTime()>1000L*60L*60L*24L*365L*100L) 
				throw new Exception("超过100岁");
			Global.setSubject("语文");
			chinese=Integer.parseInt(chineseStr);
			Global.setSubject("数学");
			math=Integer.parseInt(mathStr);
			Global.setSubject("英语");
			english=Integer.parseInt(englishStr);
			if(chinese>100||chinese<0) 
				throw new Exception("语文成绩输入不合法");
			if(math>100||math<0)
				throw new Exception("数学成绩输入不合法");
			if(english>100||english<0)
				throw new Exception("英语成绩输入不合法");
		}catch(ParseException e){
			Global.setError("日期格式输入错误");
			return null;
		}
		catch (NumberFormatException e) {
			Global.setError(Global.getSubject()+"成绩格式不对!");
			return null;
		}
		catch (Exception e) {
			Global.setError(e.getMessage());
			return null;
		}
		
		Student student=new Student(stuIdStr, nameStr, sexStr, birth, chinese, math, english);
		return student;
	}
	
	public Student getUpdateStudent(Student stu){
		String stuIdStr=stuIdField.getText().trim();
		String nameStr=nameField.getText().trim();
		String sexStr=sexField.getText().trim();
		String birthStr=birthField.getText().trim();
		String chineseStr=chineseField.getText().trim();
		String mathStr=mathField.getText().trim();
		String englishStr=englishField.getText().trim();
		if(stuIdStr==null||stuIdStr=="") return null;
		if(nameStr==null||nameStr=="") return null;
		if(sexStr==null||sexStr=="") return null;
		if(birthStr==null||birthStr=="") return null;
		if(chineseStr==null||chineseStr=="") return null;
		if(mathStr==null||mathStr=="") return null;
		if(englishStr==null||englishStr=="") return null;
		Date birth;
		int chinese,math,english;
		try {
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");dateFormat.setLenient(false);
			birth=dateFormat.parse(birthStr);
			//超过当前时间
			if(birth.getTime()>new Date().getTime()) throw new Exception("出生日期超过当前时间");
			//超过100岁
			if(new Date().getTime()-birth.getTime()>1000L*60L*60L*24L*365L*100L) 
				throw new Exception("超过100岁");
			Global.setSubject("语文");
			chinese=Integer.parseInt(chineseStr);
			Global.setSubject("数学");
			math=Integer.parseInt(mathStr);
			Global.setSubject("英语");
			english=Integer.parseInt(englishStr);
			if(chinese>100||chinese<0) 
				throw new Exception("语文成绩输入不合法");
			if(math>100||math<0)
				throw new Exception("数学成绩输入不合法");
			if(english>100||english<0)
				throw new Exception("英语成绩输入不合法");
		}catch(ParseException e){
			Global.setError("日期格式输入错误");
			return null;
		}
		catch (NumberFormatException e) {
			Global.setError(Global.getSubject()+"成绩格式不对!");
			return null;
		}
		catch (Exception e) {
			Global.setError(e.getMessage());
			return null;
		}
		
		stu.setStuId(stuIdStr);
		stu.setName(nameStr);
		stu.setGender(sexStr);
		stu.setBornDate(birth);
		stu.setChinese(chinese);
		stu.setMath(math);
		stu.setEnglish(english);
		return stu;
	}
	
	public class SelectionListener implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			Object[] data=new Object[7];
			System.out.println("---->"+table.getRowCount());
			System.out.println("???"+Global.getRowNumber());
			System.out.println("select "+table.getSelectedRow());
			if(table.getSelectedRow()==-1){
				stuIdField.setText("");;
				nameField.setText("");
				sexField.setText("");
				birthField.setText("");
				chineseField.setText("");
				mathField.setText("");
				englishField.setText("");
				return ;
			}
			if(table.getSelectedRow()>=Global.getRowNumber()){
				stuIdField.setText("");;
				nameField.setText("");
				sexField.setText("");
				birthField.setText("");
				chineseField.setText("");
				mathField.setText("");
				englishField.setText("");
				return ;
			}
			for(int i=0;i<7;i++){
				data[i]=table.getModel().getValueAt(table.getSelectedRow(), i);			
			}
			stuIdField.setText(data[0]+"");;
			nameField.setText(data[1]+"");
			sexField.setText(data[2]+"");
			birthField.setText(data[3]+"");
			chineseField.setText(data[4]+"");
			mathField.setText(data[5]+"");
			englishField.setText(data[6]+"");
			
		}
		
	}
}
