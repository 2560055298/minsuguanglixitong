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
 * ������
 * @author ������
 *
 */
public class MainInterface extends JFrame{
	public MainInterface() {
			//1�����ô��ڴ�С
			setSize(1000, 600);
			
			//2�����ô��ڣ����ھ���
			setLocationRelativeTo(null);
			
			//3�����ùرմ���ʱ��Ĭ�Ϲرճ���
			setDefaultCloseOperation(EXIT_ON_CLOSE);			//��ʱ�����ã����ѣ���¼����Ҳ�ر�
			
			//4�����ñ���
			setTitle("ͬ����ջ---������");
			
			//5���Ӵ����У���ȡ����
			Container c = getContentPane();
			
			//6�����þ��Բ���
			c.setLayout(null);
			
			//7�����ͼƬ
			JLabel l = new JLabel();
			Icon icon = new ImageIcon("image\\������.jpg");
			l.setIcon(icon);
			l.setSize(1000,580);
			l.setLocation(0, 0);
			
			//8����Ӱ�ť
			JButton b1 = new JButton("��ѯ����״̬");
			JButton b2 = new JButton("������ס");
			JButton b3 = new JButton("����");
			JButton b4 = new JButton("��ѯ��ʷ��¼");
			
			//9������ť������λ�ã�����С����ɫ		
			b1.setBounds(280, 548, 114, 23);
			b2.setBounds(505, 548, 114, 23);	
			b3.setBounds(618, 548, 114, 23);	
			b4.setBounds(392, 548, 114, 23);
			
			
			/*10���԰�ťʵ�ּ�������*/
			//---��b1����ѯ����״̬����ť��ʵ�ּ���
			b1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					LookRoomState room = new LookRoomState();
					room.setVisible(true);
				}
				
			});
			
			//---��b2��������ס����ť��ʵ�ּ���
			b2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					CheckInInterface checkIn = new CheckInInterface();
					checkIn.setVisible(true);
				}
				
			});
			
			//---��b3�����ˣ���ť��ʵ�ּ���
			b3.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					CheckOutInterface checkOut = new CheckOutInterface();
					checkOut.setVisible(true);
				}
				
			});
			
			//---��b4����ѯ��ʷ״̬����ť��ʵ�ּ���
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

			
			//���ô��ڴ�С���ɱ�
			setResizable(false);
	}	
	
	public static void main(String[] args) {
		MainInterface m = new MainInterface();
		m.setVisible(true);
	}
}

