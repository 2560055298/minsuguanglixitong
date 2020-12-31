package test;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import daoImpl.CustomerDaoImpl;
import serviceImpl.CustomerServiceImpl;
import serviceImpl.RoomServiceImpl;

/**
 * 入住界面
 * @author 羊羊羊
 *
 */
public class CheckInInterface extends JFrame{
	private String sID;		//顾客身份证号
	private String sName;	//顾客姓名
	private String sSex;	//顾客性别
	private int num;		//顾客入住房间号
	private Date iDate;		//顾客入住时间
	private RoomServiceImpl room;	//业务代码层：（房间表）对象
	private CustomerServiceImpl customer;	//业务代码层：（顾客表）对象
	
	public CheckInInterface() {
		//1、设置窗口大小
		setSize(1000, 600);
		
		//2、设置窗口：处于居中
		setLocationRelativeTo(null);
		
		//3、设置关闭窗口时：掩藏程序，但不关闭
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		//4、设置标题
		setTitle("同福客栈---宾客入住");
		
		//5、从窗口中：获取容器
		Container c = getContentPane();
		
		//6、设置绝对布局
		c.setLayout(null);
		
		//7、添加图片
		JLabel l = new JLabel();
		Icon icon = new ImageIcon("image\\入住界面.jpg");
		l.setIcon(icon);
		l.setSize(2000, 600);
		l.setLocation(0, 0);
		
		/*8、创建（输入框）及（相应提示标签）*/
		//---1、创建：身份证（文本框）及（标签）
		JTextField cId = new JTextField();					//创建：身份证：文本框
		cId.setBounds(800, 90, 142, 20);					//为身份证文本框设置：位置、大小
		
		JLabel lCid = new JLabel("身份证号：");				//创建身份证：标签
		lCid.setBounds(710, 88, 150, 26);					//为身份证标签设置：位置、大小
		lCid.setFont(new Font("楷书", Font.BOLD, 15));		//为身份证标签设置：字体
		lCid.setForeground(Color.black);					//设置标签：字体颜色
		
		//---2、创建：姓名（文本框）及（标签）
		JTextField cName = new JTextField();
		cName.setBounds(800, 120, 142, 20);
		
		JLabel lCName = new JLabel("姓名：");
		lCName.setBounds(710, 120, 150, 26);
		lCName.setFont(new Font("楷书", Font.BOLD, 15));
		lCName.setForeground(Color.black);		//设置标签：字体颜色
		
		//---3、创建：性别（单选框）
		JLabel lSex = new JLabel("性别："); 
		JRadioButton cRadio1 = new JRadioButton("男");
		JRadioButton cRadio2 = new JRadioButton("女");

		lSex.setBounds(710, 150, 150, 26);
		lSex.setFont(new Font("楷书", Font.BOLD, 15));
		lSex.setForeground(Color.black);		//设置标签：字体颜色
		
		cRadio1.setBounds(800, 150, 40, 26);	//设置cRadio1按钮：位置、大小
		cRadio1.setContentAreaFilled(false);	//设置按钮框：不填充（内容区域）
		
		cRadio2.setBounds(850, 150, 40, 26);	//设置cRadio2按钮：位置、大小
		cRadio2.setContentAreaFilled(false);	//设置按钮框：不填充（内容区域）
		
		ButtonGroup group=new ButtonGroup();	//将两个按钮：添加到统一组件中
		group.add(cRadio1);						//将cRadio1按钮：加入（按钮组）中（只能同时存在一个）
		group.add(cRadio2);						//将cRadio2按钮：加入（按钮组）中（只能同时存在一个）
		
		cRadio1.setSelected(true); 				// 设置第一个单选按钮选中
		

		//---4、创建：房间号（下拉框）及标签

		JComboBox<Integer> comboBox = new JComboBox<>();
		JLabel lCnum = new JLabel("房间号：");				//创建身份证：标签
		
		lCnum.setBounds(710, 174, 150, 40);					//为身份证标签设置：位置、大小
		lCnum.setFont(new Font("楷书", Font.BOLD, 15));		//为身份证标签设置：字体
		lCnum.setForeground(Color.black);					//设置标签：字体颜色
		
		room = new RoomServiceImpl();		//获取房间表对象		
		
		int p = 100;						//作为循环变量
		int q = p + 2;						//作为循环变量
		for(int n = 1; n <= 6; n++) {		//循环添加房间号
			for(; p < q; p++) {
				if(!room.selRoomState(p)) {		//如果未入住, 则添加
					comboBox.addItem(p);
				}
			}
			p += 98;
			q = p + 2;
		}
		comboBox.setBounds(800, 180, 80, 26);
		
		//---5、设置下拉框:选择入住时间,并设置标签
		JComboBox<String> years = new JComboBox<>();	//年份
		JComboBox<String> months = new JComboBox<>();	//月份
		JComboBox<String> days = new JComboBox<>();		//天数
		
		JLabel lDate = new JLabel("入住日期：");				//创建身份证：标签
		lDate.setBounds(710, 215, 150, 40);					//为身份证标签设置：位置、大小
		lDate.setFont(new Font("楷书", Font.BOLD, 15));		//为身份证标签设置：字体
		lDate.setForeground(Color.black);					//设置标签：字体颜色
		
		
		for(int i = 2019; i <= 2030; i++) {	//添加年份
			String str = new String().valueOf(i);
			years.addItem(str);
		}
		
		for(int i = 1; i <= 12; i++) {//添加月份
			String str = new String().valueOf(i);
			months.addItem(str);
		}
		
		for(int i = 1; i <= 31; i++) {//添加天数
			String str = new String().valueOf(i);
			days.addItem(str);
		}
		
		years.setBounds(800, 220, 60, 26);
		months.setBounds(860, 220, 60, 26);
		days.setBounds(920, 220, 60, 26);
		
		//---6、创建：确认（提交信息）和（清空信息）按钮
		JButton bCommit = new JButton("提交信息");
		JButton bClear = new JButton("清空信息");
		
		bCommit.setBounds(710, 280, 120, 26);
		bClear.setBounds(860, 280, 120, 26);
		
		//---7、title提示主题
		JLabel title = new JLabel("请填写下列（入住信息）");		//创建身份证：标签
		title.setBounds(735, 35, 250, 26);						//为身份证标签设置：位置、大小
		title.setFont(new Font("楷书", Font.BOLD, 18));			//为身份证标签设置：字体
		title.setForeground(Color.YELLOW);						//设置标签：字体颜色
		
		//---8.1、补充按钮：
		JButton b1 = new JButton("查询房间状态");
		b1.setBounds(710, 315, 120, 26);
		/*对按钮实现监听操作*/
		//---对b1（查询房间状态：按钮）实现监听
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LookRoomState room = new LookRoomState();
				room.setVisible(true);
			}
			
		});
		c.add(b1);
		
		//---8.2、补充按钮：
		JButton b2 = new JButton("查询历史记录");
		b2.setBounds(860, 315, 120, 26);
		/*对按钮实现监听操作*/
		//---对b1（查询房间状态：按钮）实现监听
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LookForeTable room = new LookForeTable();
				room.setVisible(true);
			}
			
		});
		c.add(b2);
		
		
		//9、将身份证（文本框）及（标签）添加到：容器内
		c.add(cId);	
		c.add(lCid);
		
		//10、将姓名（文本框）及（标签）添加到：容器内
		c.add(cName);
		c.add(lCName);
		
		//11、将性别（单选框）添加到：容器内
		c.add(lSex);
		c.add(cRadio1);
		c.add(cRadio2);
		
		//12、房间号（下拉框）及标签添加到：容器内
		c.add(lCnum);
		c.add(comboBox);
		
		//13、添加日期标签，及选择框
		c.add(lDate);
		c.add(years);
		c.add(months);
		c.add(days);
		
		//14、添加：（提交信息）按钮和（清空信息）按钮
		c.add(bCommit);
		c.add(bClear);
		
		//15、将入住提示：写入容器中
		c.add(title);
	
		//16、将带有图片的标签：添加到容器中
		c.add(l);			
		
		//17、设置窗口大小不可变
		setResizable(false);
		
		//18、对提交按钮：实现监听
		bCommit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				room = new RoomServiceImpl();
				customer = new CustomerServiceImpl();
				num = (int) comboBox.getSelectedItem();
				
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");	//设置日期格式
				String oDate = df.format(new Date());	
				
				String sYear = years.getSelectedItem().toString(); 			//获取：入住日期的（年数）
				String sMonth = months.getSelectedItem().toString();		//获取：入住日期的（月数）
				String sday = days.getSelectedItem().toString();			//获取：入住日期的（天数）
				
				String oyear = oDate.substring(0, 4);						//获取：当前日期的（年数）
				String oMonth = oDate.substring(5, 7);						//获取：当前日期的（月数）
				String oday = oDate.substring(8, 10);						//获取：当前日期的（天数）
				
				
				
				System.out.println(Integer.parseInt(sYear));
				System.out.println(Integer.parseInt(sMonth));
				System.out.println(Integer.parseInt(sday));
				
				System.out.println(Integer.parseInt(oyear));
				System.out.println(Integer.parseInt(oMonth));
				System.out.println(Integer.parseInt(oday));
				
				System.out.println(sYear.compareTo(oyear));
				System.out.println(sMonth.compareTo(oMonth));
				System.out.println(sday.compareTo(oday));
				
				if(room.selRoomState(num)) {
					JOptionPane.showMessageDialog(null, "此房间已被预定", "提示框", JOptionPane.ERROR_MESSAGE);
				}else if(cId.getText().length() != 18){	//判断：身份证号是否（是18位）
					JOptionPane.showMessageDialog(null, "身份证，有误", "提示框", JOptionPane.ERROR_MESSAGE);
				}else if(customer.isInRoom(cId.getText())){
					JOptionPane.showMessageDialog(null, "一张身份证，只能开一个房间，有误", "提示框", JOptionPane.ERROR_MESSAGE);
				}else if(!isNumeric(cName.getText())) {
					JOptionPane.showMessageDialog(null, "姓名：有误", "提示框", JOptionPane.ERROR_MESSAGE);
				}else if(Integer.parseInt(sYear) > Integer.parseInt(oyear)) {
					JOptionPane.showMessageDialog(null, "入住日期：（不能大于）当前时间", "提示框", JOptionPane.ERROR_MESSAGE);
				}else if(Integer.parseInt(sYear) == Integer.parseInt(oyear) && Integer.parseInt(sMonth) > Integer.parseInt(oMonth)) {
					JOptionPane.showMessageDialog(null, "入住日期：（不能大于）当前时间", "提示框", JOptionPane.ERROR_MESSAGE);
				}else if(Integer.parseInt(sYear) == Integer.parseInt(oyear) && Integer.parseInt(sMonth) == Integer.parseInt(oMonth) && Integer.parseInt(sday)  > Integer.parseInt(oday)) {
					JOptionPane.showMessageDialog(null, "入住日期：（不能大于）当前时间", "提示框", JOptionPane.ERROR_MESSAGE);
				}
				else {
					sID = cId.getText();
					sName = cName.getText();
					sSex = null;
					//获取选中单选框的：内容
					Enumeration<AbstractButton> radioBtns=group.getElements();  
					while (radioBtns.hasMoreElements()) {  
					    AbstractButton btn = radioBtns.nextElement();  
					    if(btn.isSelected()){  
					    	sSex=btn.getText();  
					        break;  
					    }  
					}  
					num = (int) comboBox.getSelectedItem();
					try {
						CustomerDaoImpl customer = new CustomerDaoImpl();	//创建顾客表：对象
						iDate = new SimpleDateFormat("yyyy-MM-dd").parse(sYear + "-" + sMonth + "-" + sday);
						customer.insCustomerInfo(sID, sName, sSex, num, iDate);
						room.upRoomInfo(num, "已入住");
						ImageIcon icon = new ImageIcon("image\\姓名正确勾.jpg");
						
						comboBox.removeAllItems();
						int p = 100;						//作为循环变量
						int q = p + 2;						//作为循环变量
						for(int n = 1; n <= 6; n++) {		//循环添加房间号
							for(; p < q; p++) {
								if(!room.selRoomState(p)) {	//已入住的房间号
									comboBox.addItem(p);
								}
							}
							p += 98;
							q = p + 2;
						}
						
						JOptionPane.showMessageDialog(null, "入住成功", "提示框", JOptionPane.OK_OPTION, icon);
						
					} catch (ParseException e1) {
						JOptionPane.showMessageDialog(null, "入住失败", "提示框", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
				}
			}
		});
		
		//19、对清空按钮：实现监听
		bClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cId.setText("");						//设置身份证号：为空
				cName.setText("");						//设置姓名：为空
				cRadio1.setSelected(true); 				//设置第一个单选按钮选中
				years.setSelectedIndex(0);				//设置（年份）默认值为：2019
				months.setSelectedIndex(0);				//设置（月份）默认值为：2019
				days.setSelectedIndex(0);				//设置（天数）默认值为：2019
				comboBox.setSelectedIndex(0);			//设置房间号默认值为：101
			}
		});
	}
		//20、判断字符串：是否纯中文
		public static boolean isNumeric(String str){
			String regex3 = "[\\u4e00-\\u9fa5]+";
			boolean result5 = str.matches(regex3);
			
			return result5;
			}
	
	public static void main(String[] args) {
		CheckInInterface c = new CheckInInterface();
		c.setVisible(true);
		
	}
}
