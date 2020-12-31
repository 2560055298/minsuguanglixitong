package test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import pojo.Customer;
import serviceImpl.CustomerServiceImpl;
import util.JdbcUtil;

/**
 * �鿴������ס״̬
 * @author ������
 *
 */
public class LookRoomState extends JFrame{
	CustomerServiceImpl cSI;		//ҵ�����㣨�˿ͱ�����
	
	public LookRoomState() {
		//1�����ô����С
		setBounds(100, 100, 500, 495);
		
		//2�����ô���:����
		setLocationRelativeTo(null);
		
		//3�����ùرմ���ģ�ֻ�رմ��壬���رճ���
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		//4�����ñ���
		setTitle("����״̬");
		
		//5���Ӵ����У���ȡ����
		Container c = getContentPane();
		
		//6�����ã��߽粼�֣�border����
		c.setLayout(new BorderLayout());
		
		//6�����ɣ�����塢����塢�����
		JPanel pUp = new JPanel();
		JPanel pCenter = new JPanel();
		JPanel pDown = new JPanel();
		
		//7����ȡ�����ģ��������:
		ResultSet rs = JdbcUtil.getResultSet("select * from room");
	
		
		//8�����ɣ����ģ��
		DefaultTableModel dt = new DefaultTableModel();
		JTable table = new JTable(dt);
		
		//9����ȡ�ַ�������
		ResultSetMetaData rsmd = null;
		try {
			rsmd = rs.getMetaData();
			int numRSColumn = rsmd.getColumnCount();	//��ȡ�ַ������ݵģ�����
			
			dt.addColumn("�˿�����");
			//�������������ģ��
//			for(int i = 1; i <= numRSColumn; i++) {
//				dt.addColumn(rsmd.getColumnName(i));
//			}
			
			dt.addColumn("�����");
			dt.addColumn("��������");
			dt.addColumn("����۸�");
			dt.addColumn("����״̬");
			
			Vector<Object> newRow;
			cSI = new CustomerServiceImpl();
			while(rs.next()) {
				newRow = new Vector<>();
				Customer customer = cSI.selCustomerInfoByCustomer(rs.getInt("rNum"));
				if(customer != null) {
					newRow.addElement(customer.getcName());
				}else {
					newRow.addElement("��");
				}
				newRow.addElement(rs.getInt("rNum"));
				newRow.addElement(rs.getString("rType"));
				newRow.addElement(rs.getInt("rPrice"));
				newRow.addElement(rs.getString("rState"));
				dt.addRow(newRow);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//10�����ɱ�ǩ
		JLabel lUp = new JLabel("������ס��");
		
		//11�����ͼƬ
		JLabel l = new JLabel();
		Icon icon = new ImageIcon("image\\������Ϣ����.jpg");
		l.setIcon(icon);
		l.setSize(1000,580);
		l.setLocation(0, 0);
		
		//12����������У���ӱ���
		pUp.add(lUp);	
		
		//13����table����ӵ����ɹ������ϣ���������ӵ����������
		JScrollPane scrollPane = new JScrollPane(table);
		pCenter.add(scrollPane);
		
		//14����������У���ӱ���
		pDown.add(l);
		
		//15��������壬���������ӣ�������
		c.add(pUp, BorderLayout.NORTH);
		c.add(pCenter, BorderLayout.CENTER);
		c.add(pDown, BorderLayout.SOUTH);
		
		//16�����ô��ڴ�С�����ɱ�
		setResizable(false);
		
		//17������table����ͷ���ж��������϶���
		table.getTableHeader().setReorderingAllowed(false);		//����������λ�ã������ƶ�
		table.getTableHeader().setResizingAllowed(false);		//���ü�ࣺ���ɸ���
		table.enable(false);		//�������ݣ��������޸�
	}
	
	public static void main(String[] args) {
		LookRoomState l = new LookRoomState();
		l.setVisible(true); 
		
		
	}
}
