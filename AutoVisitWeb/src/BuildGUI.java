import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.*;
import java.io.*; 
public class BuildGUI extends JFrame{
	public static String time=null;
	BuildGUI(){
		JPanel p0=new JPanel();
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		JLabel l01=new JLabel("˵����1.ʹ�ô����֮ǰ�����¼���Լ���У���� " );
		JLabel l02=new JLabel("     2.ҳ��url���� http://home.xiaonei.com/getuser.do?id=240068850");
		JLabel l03=new JLabel("     3.���Զ�������100��ҳ�棬����Ҫ�ֶ�������֤��");
		JLabel l1=new JLabel("��ʼID");
		JLabel l2=new JLabel("���ʱ��(��)");
		JLabel l3=new JLabel("��ע");
		final JTextField t1=new JTextField("235744068",8);
		final JTextField t2=new JTextField("3",8);
		final JTextArea t3=new JTextArea(12,30);
		
		JScrollPane sp=new JScrollPane(t3);
		t1.setEditable(true);
		t2.setEditable(true);
		
//		JButton b1=new JButton("��ʼ��¼");
//		final JButton b2=new JButton("��ʾ���ʱ��(��)");
		final JButton b3=new JButton("ȷ��");
		
//		b2.setEnabled(false);
		b3.setEnabled(true);
		
		t1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("��ʼID��"+t1.getText());
			}
		});
		
		t2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
//				b2.setEnabled(true);
				b3.setEnabled(true);
				
			}
		});
		
//		b1.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e){
//				t1.setText("");
//				t2.setText("");
//				t1.setEditable(true);
//			b2.setEnabled(false);
//				b3.setEnabled(false);
//			}
//		});
		
		
/*		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(t2.getText().equals("")){
					System.out.println("���ʱ��(��)����Ϊ��");
					return;
				}
				String pwd=new String(t2.getText());
				System.out.println(t1.getText()+"�ļ��ʱ��(��)��"+pwd);
			}



			
		});
		*/	
		
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.print("��ʼID�ǣ�	"+t1.getText());
				String pwd=new String(t2.getText());
				System.out.println("	�����ʱ���ǣ�	"+pwd);
				time=pwd;
				System.out.println("time:	"+time);
				
			}
		});
		
/*		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("��ע�����ǣ�"+t3.getText());
			}

		
		}
		);
*/	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p0.add(l01);
		p0.add(l02);
		p0.add(l03);
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
//		p2.add(b1);
//		p2.add(b2);
		p2.add(b3);
		p3.add(l3);
		p3.add(sp);
//		p3.add(b4);
		
//		getContentPane().add(p0);
		getContentPane().add("North", p0);
		getContentPane().add("Center", p1);
		getContentPane().add("South", p2);
		setTitle("У��������ˢ!");
		pack();
		setVisible(true);
		
		
	}
	
	
	public static void main(String args[]){
		new BuildGUI();
		
		System.out.println(BuildGUI.time);
		
	}

}
