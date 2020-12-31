package test;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * 登录窗口
 * @author 羊羊羊
 *
 */
public class LoginInterface extends JFrame{
	public LoginInterface() {
		//1、设置窗口大小
		setSize(1000, 600);
		
		//2、设置窗口：处于居中
		setLocationRelativeTo(null);
		
		//3、设置关闭窗口时：默认关闭程序
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//4、设置标题
		setTitle("同福客栈");
		
		//5、从窗口中：获取容器
		Container c = getContentPane();
		
		//6、设置绝对布局
		c.setLayout(null);
		
		//6、创建文本框
		JTextField text = new JTextField();
		text.setBounds(414, 244, 207, 30);
		
		//7、创建密码框
		JPasswordField pwd = new JPasswordField();
		pwd.setBounds(414, 294, 207, 30);
		
		//8、添加图片
		JLabel l = new JLabel();
		Icon icon = new ImageIcon("image\\登录界面.jpg");
		l.setIcon(icon);
		l.setSize(2000, 600);
		l.setLocation(0, 0);
		
		//9、添加按钮
		JButton b1 = new JButton();
		b1.setBounds(441, 383, 114, 27);
		b1.setContentAreaFilled(false);
		 
		//10、对按钮b1：实现监听
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//11、创建：标准对话框
				if(text.getText().trim().equals("root") && new String(pwd.getPassword()).trim().equals("123456")) {
					MainInterface mainInterface = new MainInterface();
					mainInterface.setVisible(true);
					dispose();
				}else if(text.getText().trim().equals("") || new String(pwd.getPassword()).trim().equals("")){
					JOptionPane.showMessageDialog(null, "请输入：账号密码", "提示框", JOptionPane.ERROR_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "账号或密码错误", "提示框", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		c.add(text);
		c.add(pwd);
		c.add(b1);
		
		c.add(l);
		
		//设置窗口大小不可变
		setResizable(false);
		//设置：窗口可见
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		LoginInterface login = new LoginInterface();
	}
}
