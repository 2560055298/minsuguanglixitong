package test;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import pojo.Customer;
import serviceImpl.CustomerServiceImpl;
import serviceImpl.ForeGroundServiceImpl;
import serviceImpl.RoomServiceImpl;

public class CheckOutInterface extends JFrame{
	private int num;			//房间号
	private String rType;		//房间类型
	private String cid;			//身份证号
	private String iDate;		//入住日期
	private String oDate;		//退房日期
	private int money;			//结账金额
	
	RoomServiceImpl room;		//房间表的：业务代码层（对象）
	CustomerServiceImpl cSI;	//顾客表的：业务代码层（对象）
	
	public CheckOutInterface() {
		//1、设置窗口大小
				setSize(1000, 600);
				
				//2、设置窗口：处于居中
				setLocationRelativeTo(null);
				
				//3、设置关闭窗口时：掩藏程序，但不关闭
				setDefaultCloseOperation(HIDE_ON_CLOSE);
				
				//4、设置标题
				setTitle("同福客栈---结账窗口");
				
				//5、从窗口中：获取容器
				Container c = getContentPane();
				
				//6、设置绝对布局
				c.setLayout(null);
				
				//7、添加图片
				JLabel l = new JLabel();
				Icon icon = new ImageIcon("image\\结账界面.jpg");
				l.setIcon(icon);
				l.setSize(2000, 600);
				l.setLocation(0, 0);
				//标签：  800, 80   115
				//内容：  
				
				/*8、创建（输入框）及（相应提示标签）*/
				//---1、创建：房间号（下拉框）及标签
				JComboBox<Integer> comboBox = new JComboBox<>();
				JLabel lCnum = new JLabel("房间号：");				//创建身份证：标签
				
				lCnum.setBounds(685, 82, 142, 20);					//为身份证标签设置：位置、大小
				lCnum.setFont(new Font("楷书", Font.BOLD, 15));		//为身份证标签设置：字体
				lCnum.setForeground(Color.yellow);					//设置标签：字体颜色
				
				room = new RoomServiceImpl();		//获取：房间表对象
				
				int p = 100;						//作为循环变量
				int q = p + 2;						//作为循环变量
				for(int n = 1; n <= 6; n++) {		//循环添加房间号
					for(; p < q; p++) {
						if(room.selRoomState(p)) {	//已入住的房间号
							comboBox.addItem(p);
						}
					}
					p += 98;
					q = p + 2;
				}
				comboBox.setBounds(800, 76, 80, 26);
				
				
				//---2、创建：（房间类型）标签及文本框
				JTextField roomType = new JTextField();					//创建：身份证：文本框
				roomType.setBounds(800, 120, 142, 20);					//为身份证文本框设置：位置、大小
				
				JLabel lRoomType = new JLabel("房间类型：");				//创建身份证：标签
				lRoomType.setBounds(685, 120, 150, 26);					//为身份证标签设置：位置、大小
				lRoomType.setFont(new Font("楷书", Font.BOLD, 15));		//为身份证标签设置：字体
				lRoomType.setForeground(Color.yellow);					//设置标签：字体颜色
				
				
			
				
				//---3、创建：身份证（文本框）及（标签）
				JTextField cId = new JTextField();					//创建：身份证：文本框
				cId.setBounds(800, 160, 142, 20);					//为身份证文本框设置：位置、大小
				
				JLabel lCid = new JLabel("身份证号：");				//创建身份证：标签
				lCid.setBounds(685, 160, 150, 26);					//为身份证标签设置：位置、大小
				lCid.setFont(new Font("楷书", Font.BOLD, 15));		//为身份证标签设置：字体
				lCid.setForeground(Color.yellow);					//设置标签：字体颜色
				
				
				//---4、创建：入住时间（文本框）及（标签）
				JTextField iTDate = new JTextField();						//创建：入住时间：文本框
				iTDate.setBounds(800, 196, 142, 20);						//为入住时间文本框设置：位置、大小

				JLabel lInputDate = new JLabel("入住日期：");				//创建身份证：标签
				lInputDate.setBounds(685, 200, 142, 20);					//为身份证标签设置：位置、大小
				lInputDate.setFont(new Font("楷书", Font.BOLD, 15));			//为身份证标签设置：字体
				lInputDate.setForeground(Color.yellow);						//设置标签：字体颜色
				
				//---5、创建：退房日期（文本框）及（标签）
				JTextField oTDate = new JTextField();						//创建：（退房日期)文本框
				oTDate.setBounds(800, 240, 142, 20);							//为(退房日期)文本框设置：位置、大小
				
				JLabel lOutputDate = new JLabel("退房日期：");				//创建身份证：标签
				lOutputDate.setBounds(685, 240, 142, 20);					//为身份证标签设置：位置、大小
				lOutputDate.setFont(new Font("楷书", Font.BOLD, 15));		//为身份证标签设置：字体
				lOutputDate.setForeground(Color.YELLOW);					//设置标签：字体颜色
				
			

				
				//---6、创建：本次消费金额（文本框）及（标签）
				JTextField spend = new JTextField();				//创建：身份证：文本框
				spend.setBounds(800, 280, 142, 20);					//为身份证文本框设置：位置、大小
				//800, 280
				JLabel Lspend = new JLabel("本次消费金额：");		//创建身份证：标签
				Lspend.setBounds(685, 280, 142, 20);				//为身份证标签设置：位置、大小
				Lspend.setFont(new Font("楷书", Font.BOLD, 15));		//为身份证标签设置：字体
				Lspend.setForeground(Color.YELLOW);					//设置标签：字体颜色
				//685, 280
				

				
				
				//---7、创建：（查询结账房间信息）和（提交结账）按钮
				JButton bLook = new JButton("查询结账信息");
				JButton bSettle = new JButton("提交结账");
				
				bLook.setBounds(710, 340, 120, 26);
				bSettle.setBounds(860, 340, 120, 26);
				
				//---8.1、补充按钮：
				JButton b1 = new JButton("查询房间状态");
				b1.setBounds(710, 380, 120, 26);
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
				b2.setBounds(860, 380, 120, 26);
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
				

				
				//8、对（查询结账信息）和（提交结账）按钮进行（监听）
				bLook.addActionListener(new ActionListener() {		//对：（查询结账信息）按钮进行（监听）
					@Override
					public void actionPerformed(ActionEvent e) {
						room = new RoomServiceImpl();
						num = (int) comboBox.getSelectedItem();	//获取下拉框选中的：房间号
						
						//房间是否已入住？
						boolean flag = room.selRoomState(num);
						if(flag) {	//房间：已入住
							cSI = new CustomerServiceImpl();							//创建顾客表（数据层）的：一个对象
							Customer c = cSI.selCustomerInfoByCustomer(num);			//通过房间号：查询该顾客信息
							cid = c.getcId();		
							iDate = c.getcGetTime().toString();							//将入住日期：转为字符串
							
							SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");	//设置日期格式
							oDate = df.format(new Date());								//new Date()为获取当前系统时间
							rType = room.selRoomType(num);								//获取：入住房间类型
							
							int iMonth = Integer.valueOf(iDate.substring(5, 7));		//获取：入住日期的（月份数）
							int oMonth = Integer.valueOf(oDate.substring(5, 7));		//获取：入住日期的（天数）
							int iday = Integer.valueOf(iDate.substring(8, 10));			//获取：退房日期的（月份数）
							int oday = Integer.valueOf(oDate.substring(8, 10));			//获取：退房日期的（天数）
							int dayMoney = room.selRoomPrice(num);
							int distanceTime = (oMonth - iMonth)*30 + (oday - iday);	//入住时间和退房时间：相差天数
							
							if(distanceTime == 0) {
								distanceTime = 1;
							}
							money = distanceTime * dayMoney;
							
							System.out.println("入住时间" + iDate);
							System.out.println("退房时间" + oDate);
							
							roomType.setText(rType);  		//设置：房间类型
							cId.setText(cid);				//设置：身份证号
							iTDate.setText(iDate);			//设置:入住时间
							oTDate.setText(oDate);			//设置:结账时间
							
							spend.setText(dayMoney + "/天  * " + distanceTime + " = " + money + "元");		//设置:结账金额
						}else if(!flag){//房间：未入住
							JOptionPane.showMessageDialog(null, "此房间（未入住），无需结账", "提示框", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				



				
				bSettle.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {//对：（提交结账信息）按钮进行（监听）
						ForeGroundServiceImpl fgsi = new ForeGroundServiceImpl();
						fgsi.insForeGroundInfo(cid, num, oDate, iDate, money);
						cSI.delCustomerInfo(cid);
						room.upRoomInfo(num, "未入住");
						ImageIcon icon = new ImageIcon("image\\姓名正确勾.jpg");
						JOptionPane.showMessageDialog(null, "结账成功", "提示框", JOptionPane.OK_OPTION, icon);				
						
						
						//重新加载一次：房间号
						comboBox.removeAllItems();
						int p = 100;						//作为循环变量
						int q = p + 2;						//作为循环变量
						for(int n = 1; n <= 6; n++) {		//循环添加房间号
							for(; p < q; p++) {
								if(room.selRoomState(p)) {	//已入住的房间号
									comboBox.addItem(p);
								}
							}
							p += 98;
							q = p + 2;
						}
						
						comboBox.setSelectedIndex(0);
						roomType.setText(""); 			//清空：房间类型
						cId.setText("");				//清空：身份证号
						iTDate.setText("");				//清空:入住时间
						oTDate.setText("");				//清空:结账时间
						spend.setText("");				//清空:结账金额

					}
				});
				
				//将身份证（文本框）及（标签）：加入容器中
				c.add(cId);
				c.add(lCid);
				
				//将房间号（下拉框）及标签：加入容器中
				c.add(lCnum);
				c.add(comboBox);
				
				//添加日期标签，及文本框
				c.add(iTDate);
				c.add(lInputDate);
				
				//添加日期标签，及文本框
				c.add(oTDate);
				c.add(lOutputDate);
				
				//将本次消费金额（文本框）及（标签）：加入容器中
				c.add(spend);
				c.add(Lspend);
				
				//添加（结账房间类型）文本框及其标签
				c.add(roomType);
				c.add(lRoomType);
				
				//添加（查询结账房间信息）和（提交结账）按钮
				c.add(bLook);
				c.add(bSettle);
				
				//将带有图片的标签：添加到容器中
				c.add(l);
			
				//设置窗口大小不可变
				setResizable(false);
				//setDefaultCloseOperation(EXIT_ON_CLOSE);
				

	}
	
	public static void main(String[] args) {
		CheckOutInterface c = new CheckOutInterface();
		c.setVisible(true);
	}
}
