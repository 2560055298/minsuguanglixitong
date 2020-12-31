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
 * ��ס����
 * @author ������
 *
 */
public class CheckInInterface extends JFrame{
	private String sID;		//�˿����֤��
	private String sName;	//�˿�����
	private String sSex;	//�˿��Ա�
	private int num;		//�˿���ס�����
	private Date iDate;		//�˿���סʱ��
	private RoomServiceImpl room;	//ҵ�����㣺�����������
	private CustomerServiceImpl customer;	//ҵ�����㣺���˿ͱ�����
	
	public CheckInInterface() {
		//1�����ô��ڴ�С
		setSize(1000, 600);
		
		//2�����ô��ڣ����ھ���
		setLocationRelativeTo(null);
		
		//3�����ùرմ���ʱ���ڲس��򣬵����ر�
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		//4�����ñ���
		setTitle("ͬ����ջ---������ס");
		
		//5���Ӵ����У���ȡ����
		Container c = getContentPane();
		
		//6�����þ��Բ���
		c.setLayout(null);
		
		//7�����ͼƬ
		JLabel l = new JLabel();
		Icon icon = new ImageIcon("image\\��ס����.jpg");
		l.setIcon(icon);
		l.setSize(2000, 600);
		l.setLocation(0, 0);
		
		/*8������������򣩼�����Ӧ��ʾ��ǩ��*/
		//---1�����������֤���ı��򣩼�����ǩ��
		JTextField cId = new JTextField();					//���������֤���ı���
		cId.setBounds(800, 90, 142, 20);					//Ϊ���֤�ı������ã�λ�á���С
		
		JLabel lCid = new JLabel("���֤�ţ�");				//�������֤����ǩ
		lCid.setBounds(710, 88, 150, 26);					//Ϊ���֤��ǩ���ã�λ�á���С
		lCid.setFont(new Font("����", Font.BOLD, 15));		//Ϊ���֤��ǩ���ã�����
		lCid.setForeground(Color.black);					//���ñ�ǩ��������ɫ
		
		//---2���������������ı��򣩼�����ǩ��
		JTextField cName = new JTextField();
		cName.setBounds(800, 120, 142, 20);
		
		JLabel lCName = new JLabel("������");
		lCName.setBounds(710, 120, 150, 26);
		lCName.setFont(new Font("����", Font.BOLD, 15));
		lCName.setForeground(Color.black);		//���ñ�ǩ��������ɫ
		
		//---3���������Ա𣨵�ѡ��
		JLabel lSex = new JLabel("�Ա�"); 
		JRadioButton cRadio1 = new JRadioButton("��");
		JRadioButton cRadio2 = new JRadioButton("Ů");

		lSex.setBounds(710, 150, 150, 26);
		lSex.setFont(new Font("����", Font.BOLD, 15));
		lSex.setForeground(Color.black);		//���ñ�ǩ��������ɫ
		
		cRadio1.setBounds(800, 150, 40, 26);	//����cRadio1��ť��λ�á���С
		cRadio1.setContentAreaFilled(false);	//���ð�ť�򣺲���䣨��������
		
		cRadio2.setBounds(850, 150, 40, 26);	//����cRadio2��ť��λ�á���С
		cRadio2.setContentAreaFilled(false);	//���ð�ť�򣺲���䣨��������
		
		ButtonGroup group=new ButtonGroup();	//��������ť����ӵ�ͳһ�����
		group.add(cRadio1);						//��cRadio1��ť�����루��ť�飩�У�ֻ��ͬʱ����һ����
		group.add(cRadio2);						//��cRadio2��ť�����루��ť�飩�У�ֻ��ͬʱ����һ����
		
		cRadio1.setSelected(true); 				// ���õ�һ����ѡ��ťѡ��
		

		//---4������������ţ������򣩼���ǩ

		JComboBox<Integer> comboBox = new JComboBox<>();
		JLabel lCnum = new JLabel("����ţ�");				//�������֤����ǩ
		
		lCnum.setBounds(710, 174, 150, 40);					//Ϊ���֤��ǩ���ã�λ�á���С
		lCnum.setFont(new Font("����", Font.BOLD, 15));		//Ϊ���֤��ǩ���ã�����
		lCnum.setForeground(Color.black);					//���ñ�ǩ��������ɫ
		
		room = new RoomServiceImpl();		//��ȡ��������		
		
		int p = 100;						//��Ϊѭ������
		int q = p + 2;						//��Ϊѭ������
		for(int n = 1; n <= 6; n++) {		//ѭ����ӷ����
			for(; p < q; p++) {
				if(!room.selRoomState(p)) {		//���δ��ס, �����
					comboBox.addItem(p);
				}
			}
			p += 98;
			q = p + 2;
		}
		comboBox.setBounds(800, 180, 80, 26);
		
		//---5������������:ѡ����סʱ��,�����ñ�ǩ
		JComboBox<String> years = new JComboBox<>();	//���
		JComboBox<String> months = new JComboBox<>();	//�·�
		JComboBox<String> days = new JComboBox<>();		//����
		
		JLabel lDate = new JLabel("��ס���ڣ�");				//�������֤����ǩ
		lDate.setBounds(710, 215, 150, 40);					//Ϊ���֤��ǩ���ã�λ�á���С
		lDate.setFont(new Font("����", Font.BOLD, 15));		//Ϊ���֤��ǩ���ã�����
		lDate.setForeground(Color.black);					//���ñ�ǩ��������ɫ
		
		
		for(int i = 2019; i <= 2030; i++) {	//������
			String str = new String().valueOf(i);
			years.addItem(str);
		}
		
		for(int i = 1; i <= 12; i++) {//����·�
			String str = new String().valueOf(i);
			months.addItem(str);
		}
		
		for(int i = 1; i <= 31; i++) {//�������
			String str = new String().valueOf(i);
			days.addItem(str);
		}
		
		years.setBounds(800, 220, 60, 26);
		months.setBounds(860, 220, 60, 26);
		days.setBounds(920, 220, 60, 26);
		
		//---6��������ȷ�ϣ��ύ��Ϣ���ͣ������Ϣ����ť
		JButton bCommit = new JButton("�ύ��Ϣ");
		JButton bClear = new JButton("�����Ϣ");
		
		bCommit.setBounds(710, 280, 120, 26);
		bClear.setBounds(860, 280, 120, 26);
		
		//---7��title��ʾ����
		JLabel title = new JLabel("����д���У���ס��Ϣ��");		//�������֤����ǩ
		title.setBounds(735, 35, 250, 26);						//Ϊ���֤��ǩ���ã�λ�á���С
		title.setFont(new Font("����", Font.BOLD, 18));			//Ϊ���֤��ǩ���ã�����
		title.setForeground(Color.YELLOW);						//���ñ�ǩ��������ɫ
		
		//---8.1�����䰴ť��
		JButton b1 = new JButton("��ѯ����״̬");
		b1.setBounds(710, 315, 120, 26);
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
		b2.setBounds(860, 315, 120, 26);
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
		
		
		//9�������֤���ı��򣩼�����ǩ����ӵ���������
		c.add(cId);	
		c.add(lCid);
		
		//10�����������ı��򣩼�����ǩ����ӵ���������
		c.add(cName);
		c.add(lCName);
		
		//11�����Ա𣨵�ѡ����ӵ���������
		c.add(lSex);
		c.add(cRadio1);
		c.add(cRadio2);
		
		//12������ţ������򣩼���ǩ��ӵ���������
		c.add(lCnum);
		c.add(comboBox);
		
		//13��������ڱ�ǩ����ѡ���
		c.add(lDate);
		c.add(years);
		c.add(months);
		c.add(days);
		
		//14����ӣ����ύ��Ϣ����ť�ͣ������Ϣ����ť
		c.add(bCommit);
		c.add(bClear);
		
		//15������ס��ʾ��д��������
		c.add(title);
	
		//16��������ͼƬ�ı�ǩ����ӵ�������
		c.add(l);			
		
		//17�����ô��ڴ�С���ɱ�
		setResizable(false);
		
		//18�����ύ��ť��ʵ�ּ���
		bCommit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				room = new RoomServiceImpl();
				customer = new CustomerServiceImpl();
				num = (int) comboBox.getSelectedItem();
				
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");	//�������ڸ�ʽ
				String oDate = df.format(new Date());	
				
				String sYear = years.getSelectedItem().toString(); 			//��ȡ����ס���ڵģ�������
				String sMonth = months.getSelectedItem().toString();		//��ȡ����ס���ڵģ�������
				String sday = days.getSelectedItem().toString();			//��ȡ����ס���ڵģ�������
				
				String oyear = oDate.substring(0, 4);						//��ȡ����ǰ���ڵģ�������
				String oMonth = oDate.substring(5, 7);						//��ȡ����ǰ���ڵģ�������
				String oday = oDate.substring(8, 10);						//��ȡ����ǰ���ڵģ�������
				
				
				
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
					JOptionPane.showMessageDialog(null, "�˷����ѱ�Ԥ��", "��ʾ��", JOptionPane.ERROR_MESSAGE);
				}else if(cId.getText().length() != 18){	//�жϣ����֤���Ƿ���18λ��
					JOptionPane.showMessageDialog(null, "���֤������", "��ʾ��", JOptionPane.ERROR_MESSAGE);
				}else if(customer.isInRoom(cId.getText())){
					JOptionPane.showMessageDialog(null, "һ�����֤��ֻ�ܿ�һ�����䣬����", "��ʾ��", JOptionPane.ERROR_MESSAGE);
				}else if(!isNumeric(cName.getText())) {
					JOptionPane.showMessageDialog(null, "����������", "��ʾ��", JOptionPane.ERROR_MESSAGE);
				}else if(Integer.parseInt(sYear) > Integer.parseInt(oyear)) {
					JOptionPane.showMessageDialog(null, "��ס���ڣ������ܴ��ڣ���ǰʱ��", "��ʾ��", JOptionPane.ERROR_MESSAGE);
				}else if(Integer.parseInt(sYear) == Integer.parseInt(oyear) && Integer.parseInt(sMonth) > Integer.parseInt(oMonth)) {
					JOptionPane.showMessageDialog(null, "��ס���ڣ������ܴ��ڣ���ǰʱ��", "��ʾ��", JOptionPane.ERROR_MESSAGE);
				}else if(Integer.parseInt(sYear) == Integer.parseInt(oyear) && Integer.parseInt(sMonth) == Integer.parseInt(oMonth) && Integer.parseInt(sday)  > Integer.parseInt(oday)) {
					JOptionPane.showMessageDialog(null, "��ס���ڣ������ܴ��ڣ���ǰʱ��", "��ʾ��", JOptionPane.ERROR_MESSAGE);
				}
				else {
					sID = cId.getText();
					sName = cName.getText();
					sSex = null;
					//��ȡѡ�е�ѡ��ģ�����
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
						CustomerDaoImpl customer = new CustomerDaoImpl();	//�����˿ͱ�����
						iDate = new SimpleDateFormat("yyyy-MM-dd").parse(sYear + "-" + sMonth + "-" + sday);
						customer.insCustomerInfo(sID, sName, sSex, num, iDate);
						room.upRoomInfo(num, "����ס");
						ImageIcon icon = new ImageIcon("image\\������ȷ��.jpg");
						
						comboBox.removeAllItems();
						int p = 100;						//��Ϊѭ������
						int q = p + 2;						//��Ϊѭ������
						for(int n = 1; n <= 6; n++) {		//ѭ����ӷ����
							for(; p < q; p++) {
								if(!room.selRoomState(p)) {	//����ס�ķ����
									comboBox.addItem(p);
								}
							}
							p += 98;
							q = p + 2;
						}
						
						JOptionPane.showMessageDialog(null, "��ס�ɹ�", "��ʾ��", JOptionPane.OK_OPTION, icon);
						
					} catch (ParseException e1) {
						JOptionPane.showMessageDialog(null, "��סʧ��", "��ʾ��", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
				}
			}
		});
		
		//19������հ�ť��ʵ�ּ���
		bClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cId.setText("");						//�������֤�ţ�Ϊ��
				cName.setText("");						//����������Ϊ��
				cRadio1.setSelected(true); 				//���õ�һ����ѡ��ťѡ��
				years.setSelectedIndex(0);				//���ã���ݣ�Ĭ��ֵΪ��2019
				months.setSelectedIndex(0);				//���ã��·ݣ�Ĭ��ֵΪ��2019
				days.setSelectedIndex(0);				//���ã�������Ĭ��ֵΪ��2019
				comboBox.setSelectedIndex(0);			//���÷����Ĭ��ֵΪ��101
			}
		});
	}
		//20���ж��ַ������Ƿ�����
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
