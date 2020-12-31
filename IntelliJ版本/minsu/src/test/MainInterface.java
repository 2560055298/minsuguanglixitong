package test;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 主界面
 * @author 羊羊羊
 *
 */
public class MainInterface extends JFrame{
	public MainInterface() {
			//1、设置窗口大小
			setSize(1000, 600);
			
			//2、设置窗口：处于居中
			setLocationRelativeTo(null);
			
			//3、设置关闭窗口时：默认关闭程序
			setDefaultCloseOperation(EXIT_ON_CLOSE);			//此时若设置，则会把：登录界面也关闭
			
			//4、设置标题
			setTitle("同福客栈---主界面");
			
			//5、从窗口中：获取容器
			Container c = getContentPane();
			
			//6、设置绝对布局
			c.setLayout(null);
			
			//7、添加图片
			JLabel l = new JLabel();
			Icon icon = new ImageIcon("image\\主界面.jpg");
			l.setIcon(icon);
			l.setSize(1000,580);
			l.setLocation(0, 0);
			
			//8、添加按钮
			JButton b1 = new JButton("查询房间状态");
			JButton b2 = new JButton("宾客入住");
			JButton b3 = new JButton("结账");
			JButton b4 = new JButton("查询历史记录");
			
			//9、给按钮：设置位置，及大小，颜色		
			b1.setBounds(280, 548, 114, 23);
			b2.setBounds(505, 548, 114, 23);	
			b3.setBounds(618, 548, 114, 23);	
			b4.setBounds(392, 548, 114, 23);
			
			
			/*10、对按钮实现监听操作*/
			//---对b1（查询房间状态：按钮）实现监听
			b1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					LookRoomState room = new LookRoomState();
					room.setVisible(true);
				}
				
			});
			
			//---对b2（宾客入住：按钮）实现监听
			b2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					CheckInInterface checkIn = new CheckInInterface();
					checkIn.setVisible(true);
				}
				
			});
			
			//---对b3（结账：按钮）实现监听
			b3.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					CheckOutInterface checkOut = new CheckOutInterface();
					checkOut.setVisible(true);
				}
				
			});
			
			//---对b4（查询历史状态：按钮）实现监听
			b4.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					LookForeTable checkOut = new LookForeTable();
					checkOut.setVisible(true);
				}
				
			});

			
			c.add(b1);
			c.add(b2);
			c.add(b3);
			c.add(b4);
			c.add(l);

			
			//设置窗口大小不可变
			setResizable(false);
	}	
	
	public static void main(String[] args) {
		MainInterface m = new MainInterface();
		m.setVisible(true);
	}
}

