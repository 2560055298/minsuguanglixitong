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
	private int num;			//�����
	private String rType;		//��������
	private String cid;			//���֤��
	private String iDate;		//��ס����
	private String oDate;		//�˷�����
	private int money;			//���˽��
	
	RoomServiceImpl room;		//�����ģ�ҵ�����㣨����
	CustomerServiceImpl cSI;	//�˿ͱ�ģ�ҵ�����㣨����
	
	public CheckOutInterface() {
		//1�����ô��ڴ�С
				setSize(1000, 600);
				
				//2�����ô��ڣ����ھ���
				setLocationRelativeTo(null);
				
				//3�����ùرմ���ʱ���ڲس��򣬵����ر�
				setDefaultCloseOperation(HIDE_ON_CLOSE);
				
				//4�����ñ���
				setTitle("ͬ����ջ---���˴���");
				
				//5���Ӵ����У���ȡ����
				Container c = getContentPane();
				
				//6�����þ��Բ���
				c.setLayout(null);
				
				//7�����ͼƬ
				JLabel l = new JLabel();
				Icon icon = new ImageIcon("image\\���˽���.jpg");
				l.setIcon(icon);
				l.setSize(2000, 600);
				l.setLocation(0, 0);
				//��ǩ��  800, 80   115
				//���ݣ�  
				
				/*8������������򣩼�����Ӧ��ʾ��ǩ��*/
				//---1������������ţ������򣩼���ǩ
				JComboBox<Integer> comboBox = new JComboBox<>();
				JLabel lCnum = new JLabel("����ţ�");				//�������֤����ǩ
				
				lCnum.setBounds(685, 82, 142, 20);					//Ϊ���֤��ǩ���ã�λ�á���С
				lCnum.setFont(new Font("����", Font.BOLD, 15));		//Ϊ���֤��ǩ���ã�����
				lCnum.setForeground(Color.yellow);					//���ñ�ǩ��������ɫ
				
				room = new RoomServiceImpl();		//��ȡ����������
				
				int p = 100;						//��Ϊѭ������
				int q = p + 2;						//��Ϊѭ������
				for(int n = 1; n <= 6; n++) {		//ѭ����ӷ����
					for(; p < q; p++) {
						if(room.selRoomState(p)) {	//����ס�ķ����
							comboBox.addItem(p);
						}
					}
					p += 98;
					q = p + 2;
				}
				comboBox.setBounds(800, 76, 80, 26);
				
				
				//---2�����������������ͣ���ǩ���ı���
				JTextField roomType = new JTextField();					//���������֤���ı���
				roomType.setBounds(800, 120, 142, 20);					//Ϊ���֤�ı������ã�λ�á���С
				
				JLabel lRoomType = new JLabel("�������ͣ�");				//�������֤����ǩ
				lRoomType.setBounds(685, 120, 150, 26);					//Ϊ���֤��ǩ���ã�λ�á���С
				lRoomType.setFont(new Font("����", Font.BOLD, 15));		//Ϊ���֤��ǩ���ã�����
				lRoomType.setForeground(Color.yellow);					//���ñ�ǩ��������ɫ
				
				
			
				
				//---3�����������֤���ı��򣩼�����ǩ��
				JTextField cId = new JTextField();					//���������֤���ı���
				cId.setBounds(800, 160, 142, 20);					//Ϊ���֤�ı������ã�λ�á���С
				
				JLabel lCid = new JLabel("���֤�ţ�");				//�������֤����ǩ
				lCid.setBounds(685, 160, 150, 26);					//Ϊ���֤��ǩ���ã�λ�á���С
				lCid.setFont(new Font("����", Font.BOLD, 15));		//Ϊ���֤��ǩ���ã�����
				lCid.setForeground(Color.yellow);					//���ñ�ǩ��������ɫ
				
				
				//---4����������סʱ�䣨�ı��򣩼�����ǩ��
				JTextField iTDate = new JTextField();						//��������סʱ�䣺�ı���
				iTDate.setBounds(800, 196, 142, 20);						//Ϊ��סʱ���ı������ã�λ�á���С

				JLabel lInputDate = new JLabel("��ס���ڣ�");				//�������֤����ǩ
				lInputDate.setBounds(685, 200, 142, 20);					//Ϊ���֤��ǩ���ã�λ�á���С
				lInputDate.setFont(new Font("����", Font.BOLD, 15));			//Ϊ���֤��ǩ���ã�����
				lInputDate.setForeground(Color.yellow);						//���ñ�ǩ��������ɫ
				
				//---5���������˷����ڣ��ı��򣩼�����ǩ��
				JTextField oTDate = new JTextField();						//���������˷�����)�ı���
				oTDate.setBounds(800, 240, 142, 20);							//Ϊ(�˷�����)�ı������ã�λ�á���С
				
				JLabel lOutputDate = new JLabel("�˷����ڣ�");				//�������֤����ǩ
				lOutputDate.setBounds(685, 240, 142, 20);					//Ϊ���֤��ǩ���ã�λ�á���С
				lOutputDate.setFont(new Font("����", Font.BOLD, 15));		//Ϊ���֤��ǩ���ã�����
				lOutputDate.setForeground(Color.YELLOW);					//���ñ�ǩ��������ɫ
				
			

				
				//---6���������������ѽ��ı��򣩼�����ǩ��
				JTextField spend = new JTextField();				//���������֤���ı���
				spend.setBounds(800, 280, 142, 20);					//Ϊ���֤�ı������ã�λ�á���С
				//800, 280
				JLabel Lspend = new JLabel("�������ѽ�");		//�������֤����ǩ
				Lspend.setBounds(685, 280, 142, 20);				//Ϊ���֤��ǩ���ã�λ�á���С
				Lspend.setFont(new Font("����", Font.BOLD, 15));		//Ϊ���֤��ǩ���ã�����
				Lspend.setForeground(Color.YELLOW);					//���ñ�ǩ��������ɫ
				//685, 280
				

				
				
				//---7������������ѯ���˷�����Ϣ���ͣ��ύ���ˣ���ť
				JButton bLook = new JButton("��ѯ������Ϣ");
				JButton bSettle = new JButton("�ύ����");
				
				bLook.setBounds(710, 340, 120, 26);
				bSettle.setBounds(860, 340, 120, 26);
				
				//---8.1�����䰴ť��
				JButton b1 = new JButton("��ѯ����״̬");
				b1.setBounds(710, 380, 120, 26);
				/*�԰�ťʵ�ּ�������*/
				//---��b1����ѯ����״̬����ť��ʵ�ּ���
				b1.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						LookRoomState room = new LookRoomState();
						room.setVisible(true);
					}
					
				});
				c.add(b1);
				
				//---8.2�����䰴ť��
				JButton b2 = new JButton("��ѯ��ʷ��¼");
				b2.setBounds(860, 380, 120, 26);
				/*�԰�ťʵ�ּ�������*/
				//---��b1����ѯ����״̬����ť��ʵ�ּ���
				b2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						LookForeTable room = new LookForeTable();
						room.setVisible(true);
					}
					
				});
				c.add(b2);
				

				
				//8���ԣ���ѯ������Ϣ���ͣ��ύ���ˣ���ť���У�������
				bLook.addActionListener(new ActionListener() {		//�ԣ�����ѯ������Ϣ����ť���У�������
					@Override
					public void actionPerformed(ActionEvent e) {
						room = new RoomServiceImpl();
						num = (int) comboBox.getSelectedItem();	//��ȡ������ѡ�еģ������
						
						//�����Ƿ�����ס��
						boolean flag = room.selRoomState(num);
						if(flag) {	//���䣺����ס
							cSI = new CustomerServiceImpl();							//�����˿ͱ����ݲ㣩�ģ�һ������
							Customer c = cSI.selCustomerInfoByCustomer(num);			//ͨ������ţ���ѯ�ù˿���Ϣ
							cid = c.getcId();		
							iDate = c.getcGetTime().toString();							//����ס���ڣ�תΪ�ַ���
							
							SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");	//�������ڸ�ʽ
							oDate = df.format(new Date());								//new Date()Ϊ��ȡ��ǰϵͳʱ��
							rType = room.selRoomType(num);								//��ȡ����ס��������
							
							int iMonth = Integer.valueOf(iDate.substring(5, 7));		//��ȡ����ס���ڵģ��·�����
							int oMonth = Integer.valueOf(oDate.substring(5, 7));		//��ȡ����ס���ڵģ�������
							int iday = Integer.valueOf(iDate.substring(8, 10));			//��ȡ���˷����ڵģ��·�����
							int oday = Integer.valueOf(oDate.substring(8, 10));			//��ȡ���˷����ڵģ�������
							int dayMoney = room.selRoomPrice(num);
							int distanceTime = (oMonth - iMonth)*30 + (oday - iday);	//��סʱ����˷�ʱ�䣺�������
							
							if(distanceTime == 0) {
								distanceTime = 1;
							}
							money = distanceTime * dayMoney;
							
							System.out.println("��סʱ��" + iDate);
							System.out.println("�˷�ʱ��" + oDate);
							
							roomType.setText(rType);  		//���ã���������
							cId.setText(cid);				//���ã����֤��
							iTDate.setText(iDate);			//����:��סʱ��
							oTDate.setText(oDate);			//����:����ʱ��
							
							spend.setText(dayMoney + "/��  * " + distanceTime + " = " + money + "Ԫ");		//����:���˽��
						}else if(!flag){//���䣺δ��ס
							JOptionPane.showMessageDialog(null, "�˷��䣨δ��ס�����������", "��ʾ��", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				



				
				bSettle.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {//�ԣ����ύ������Ϣ����ť���У�������
						ForeGroundServiceImpl fgsi = new ForeGroundServiceImpl();
						fgsi.insForeGroundInfo(cid, num, oDate, iDate, money);
						cSI.delCustomerInfo(cid);
						room.upRoomInfo(num, "δ��ס");
						ImageIcon icon = new ImageIcon("image\\������ȷ��.jpg");
						JOptionPane.showMessageDialog(null, "���˳ɹ�", "��ʾ��", JOptionPane.OK_OPTION, icon);				
						
						
						//���¼���һ�Σ������
						comboBox.removeAllItems();
						int p = 100;						//��Ϊѭ������
						int q = p + 2;						//��Ϊѭ������
						for(int n = 1; n <= 6; n++) {		//ѭ����ӷ����
							for(; p < q; p++) {
								if(room.selRoomState(p)) {	//����ס�ķ����
									comboBox.addItem(p);
								}
							}
							p += 98;
							q = p + 2;
						}
						
						comboBox.setSelectedIndex(0);
						roomType.setText(""); 			//��գ���������
						cId.setText("");				//��գ����֤��
						iTDate.setText("");				//���:��סʱ��
						oTDate.setText("");				//���:����ʱ��
						spend.setText("");				//���:���˽��

					}
				});
				
				//�����֤���ı��򣩼�����ǩ��������������
				c.add(cId);
				c.add(lCid);
				
				//������ţ������򣩼���ǩ������������
				c.add(lCnum);
				c.add(comboBox);
				
				//������ڱ�ǩ�����ı���
				c.add(iTDate);
				c.add(lInputDate);
				
				//������ڱ�ǩ�����ı���
				c.add(oTDate);
				c.add(lOutputDate);
				
				//���������ѽ��ı��򣩼�����ǩ��������������
				c.add(spend);
				c.add(Lspend);
				
				//��ӣ����˷������ͣ��ı������ǩ
				c.add(roomType);
				c.add(lRoomType);
				
				//��ӣ���ѯ���˷�����Ϣ���ͣ��ύ���ˣ���ť
				c.add(bLook);
				c.add(bSettle);
				
				//������ͼƬ�ı�ǩ����ӵ�������
				c.add(l);
			
				//���ô��ڴ�С���ɱ�
				setResizable(false);
				//setDefaultCloseOperation(EXIT_ON_CLOSE);
				

	}
	
	public static void main(String[] args) {
		CheckOutInterface c = new CheckOutInterface();
		c.setVisible(true);
	}
}
