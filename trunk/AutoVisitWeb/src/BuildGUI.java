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
		JLabel l01=new JLabel("说明：1.使用此软件之前，请登录您自己的校内网 " );
		JLabel l02=new JLabel("     2.页面url类似 http://home.xiaonei.com/getuser.do?id=240068850");
		JLabel l03=new JLabel("     3.当自动访问了100个页面，您需要手动输入验证码");
		JLabel l1=new JLabel("起始ID");
		JLabel l2=new JLabel("间隔时间(秒)");
		JLabel l3=new JLabel("备注");
		final JTextField t1=new JTextField("235744068",8);
		final JTextField t2=new JTextField("3",8);
		final JTextArea t3=new JTextArea(12,30);
		
		JScrollPane sp=new JScrollPane(t3);
		t1.setEditable(true);
		t2.setEditable(true);
		
//		JButton b1=new JButton("开始登录");
//		final JButton b2=new JButton("显示间隔时间(秒)");
		final JButton b3=new JButton("确认");
		
//		b2.setEnabled(false);
		b3.setEnabled(true);
		
		t1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("起始ID："+t1.getText());
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
					System.out.println("间隔时间(秒)不能为空");
					return;
				}
				String pwd=new String(t2.getText());
				System.out.println(t1.getText()+"的间隔时间(秒)是"+pwd);
			}



			
		});
		*/	
		
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.print("起始ID是：	"+t1.getText());
				String pwd=new String(t2.getText());
				System.out.println("	：间隔时间是：	"+pwd);
				time=pwd;
				System.out.println("time:	"+time);
				
			}
		});
		
/*		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("备注内容是："+t3.getText());
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
		setTitle("校内网——刷!");
		pack();
		setVisible(true);
		
		
	}
	
	
	public static void main(String args[]){
		new BuildGUI();
		
		System.out.println(BuildGUI.time);
		
	}

}
