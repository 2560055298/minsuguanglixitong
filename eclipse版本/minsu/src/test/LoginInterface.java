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
 * ��¼����
 * @author ������
 *
 */
public class LoginInterface extends JFrame{
	public LoginInterface() {
		//1�����ô��ڴ�С
		setSize(1000, 600);
		
		//2�����ô��ڣ����ھ���
		setLocationRelativeTo(null);
		
		//3�����ùرմ���ʱ��Ĭ�Ϲرճ���
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//4�����ñ���
		setTitle("ͬ����ջ");
		
		//5���Ӵ����У���ȡ����
		Container c = getContentPane();
		
		//6�����þ��Բ���
		c.setLayout(null);
		
		//6�������ı���
		JTextField text = new JTextField();
		text.setBounds(414, 244, 207, 30);
		
		//7�����������
		JPasswordField pwd = new JPasswordField();
		pwd.setBounds(414, 294, 207, 30);
		
		//8�����ͼƬ
		JLabel l = new JLabel();
		Icon icon = new ImageIcon("image\\��¼����.jpg");
		l.setIcon(icon);
		l.setSize(2000, 600);
		l.setLocation(0, 0);
		
		//9����Ӱ�ť
		JButton b1 = new JButton();
		b1.setBounds(441, 383, 114, 27);
		b1.setContentAreaFilled(false);
		 
		//10���԰�ťb1��ʵ�ּ���
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//11����������׼�Ի���
				if(text.getText().trim().equals("root") && new String(pwd.getPassword()).trim().equals("123456")) {
					MainInterface mainInterface = new MainInterface();
					mainInterface.setVisible(true);
					dispose();
				}else if(text.getText().trim().equals("") || new String(pwd.getPassword()).trim().equals("")){
					JOptionPane.showMessageDialog(null, "�����룺�˺�����", "��ʾ��", JOptionPane.ERROR_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "�˺Ż��������", "��ʾ��", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		c.add(text);
		c.add(pwd);
		c.add(b1);
		
		c.add(l);
		
		//���ô��ڴ�С���ɱ�
		setResizable(false);
		//���ã����ڿɼ�
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		LoginInterface login = new LoginInterface();
	}
}
