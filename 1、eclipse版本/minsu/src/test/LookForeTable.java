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

import serviceImpl.CustomerServiceImpl;
import serviceImpl.ForeGroundServiceImpl;
import util.JdbcUtil;

public class LookForeTable extends JFrame{
	ForeGroundServiceImpl cSI;		//ҵ�����㣨�˿ͱ�����
	
	public LookForeTable() {
		//1�����ô����С
		setBounds(100, 100, 500, 495);
		
		//2�����ô���:����
		setLocationRelativeTo(null);
		
		//3�����ùرմ���ģ�ֻ�رմ��壬���رճ���
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		//4�����ñ���
		setTitle("ס����ʷ��¼");
		
		//5���Ӵ����У���ȡ����
		Container c = getContentPane();
		
		//6�����ã��߽粼�֣�border����
		c.setLayout(new BorderLayout());
		
		//6�����ɣ�����塢����塢�����
		JPanel pUp = new JPanel();
		JPanel pCenter = new JPanel();
		JPanel pDown = new JPanel();
		
		//7����ȡ�����ģ��������:
		ResultSet rs = JdbcUtil.getResultSet("select * from ForeGround");
	
		
		//8�����ɣ����ģ��
		DefaultTableModel dt = new DefaultTableModel();
		JTable table = new JTable(dt);
		
		//9����ȡ�ַ�������
		ResultSetMetaData rsmd = null;
		try {
			rsmd = rs.getMetaData();
			int numRSColumn = rsmd.getColumnCount();	//��ȡ�ַ������ݵģ�����
			
//			//�������������ģ��
//			for(int i = 1; i <= numRSColumn; i++) {
//				dt.addColumn(rsmd.getColumnName(i));
//			}
			
			dt.addColumn("���֤��");
			dt.addColumn("�����");
			dt.addColumn("��סʱ��");
			dt.addColumn("�˷�ʱ��");
			dt.addColumn("���ѣ�Ԫ��");
			
			table.getColumnModel().getColumn(0).setPreferredWidth(125);
			table.getColumnModel().getColumn(1).setPreferredWidth(50);
			
			
			
			Vector<Object> newRow;
			cSI = new ForeGroundServiceImpl();
			while(rs.next()) {
				newRow = new Vector<>();
				newRow.addElement(rs.getObject("fGId"));
				newRow.addElement(rs.getObject("fGRoomNum"));
				newRow.addElement(rs.getObject("fGGetTime"));
				newRow.addElement(rs.getObject("fGLeaveTime"));
				newRow.addElement(rs.getObject("fGExpense"));
				dt.addRow(newRow);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//10�����ɱ�ǩ
		JLabel lUp = new JLabel("ǰ̨��");
		
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
		LookForeTable l = new LookForeTable();
		l.setVisible(true); 
		
		
	}
}
