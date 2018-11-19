package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;



import java.awt.BorderLayout;
import javax.swing.JButton;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.border.SoftBevelBorder;

import Arithmetic.TrafficAttack;
import cpu.AllInfo;
import jnetcapforcapture.CaptureCore;
import warninghierarchy.Net;
import warninghierarchy.Web;

import javax.swing.border.BevelBorder;



public class UI {
	private JFrame frmDdos;
	private JProgressBar bar = new JProgressBar();
	
	//netlayout
	private static JButton netRed ;
	private static  JButton netYellow ;
	private static JButton netBule;
	private static JButton netNormal;
	//weblayout
	private static JButton webRed ;
	private static  JButton webYellow ;
	private static JButton webBule;
	private static JButton webNormal;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.frmDdos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDdos = new JFrame();
		frmDdos.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\360Downlod\\01300000303347122708186242221.jpg"));
		frmDdos.setFont(new Font("Blackadder ITC", Font.BOLD | Font.ITALIC, 12));
		frmDdos.setBackground(Color.BLUE);
		frmDdos.setAlwaysOnTop(true);
		frmDdos.setTitle("DDos\u5165\u4FB5\u68C0\u6D4B\u8F6F\u4EF6");
		frmDdos.setResizable(false);
		frmDdos.setBounds(100, 100, 536, 443);
		frmDdos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDdos.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		frmDdos.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("              DDos\u5165\u4FB5\u68C0\u6D4B");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
				

	

		JPanel panel_1 = new JPanel();
		frmDdos.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		frmDdos.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 0));
		panel_4.setBorder(new CompoundBorder(new EmptyBorder(2, 2, 2, 2), null));
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Network Layer");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(53, 10, 102, 15);
		// panel_4.add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("Application Layer");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(280, 10, 121, 15);

		JLabel lblNewLabel_5 = new JLabel("\u7F51\u7EDC\u5C42\u68C0\u6D4B");
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_5.setForeground(new Color(0, 204, 51));
		lblNewLabel_5.setBounds(96, 146, 97, 27);
		panel_4.add(lblNewLabel_5);
				bar.setForeground(new Color(0, 255, 0));
				bar.setBounds(10, 69, 510, 39);
				panel_4.add(bar);
		
				bar.setOrientation(JProgressBar.HORIZONTAL);
				bar.setMaximum(5000);
				bar.setValue(0);
				bar.setStringPainted(true);
				bar.setBackground(new Color(0, 0, 0));
				// panel.add(lblNewLabel, BorderLayout.CENTER);

				JButton btnNewButton = new JButton("\u5F00\u59CB");
				btnNewButton.setBackground(Color.LIGHT_GRAY);
				btnNewButton.setForeground(new Color(0, 0, 102));
				btnNewButton.setBounds(407, 25, 113, 29);
				panel_4.add(btnNewButton);
				btnNewButton.setFont(new Font("宋体", Font.PLAIN, 17));
				
				JPanel panel_5 = new JPanel();
				panel_5.setLayout(null);
				panel_5.setBackground(new Color(0, 0, 0));
				panel_5.setBounds(32, 196, 215, 208);
				panel_4.add(panel_5);
				
			
				
			//网络层的显示
			netRed = new JButton("\u7EA2\u8272\u9884\u8B66");
//				netRed.setBackground(new Color(255, 0, 0));
				netRed.setBounds(0, 0, 215, 39);
				panel_5.add(netRed);
				
				 netYellow = new JButton("\u9EC4\u8272\u9884\u8B66");
//				netYellow.setBackground(new Color(255, 255, 0));
				netYellow.setBounds(10, 39, 193, 39);
				panel_5.add(netYellow);
				
				 netBule = new JButton("\u84DD\u8272\u9884\u8B66");
//				netBule.setBackground(new Color(0, 0, 255));
				netBule.setBounds(20, 78, 169, 39);
				panel_5.add(netBule);
				
				 netNormal = new JButton("\u6B63\u5E38");
//				netNormal.setBackground(new Color(0, 255, 0));
				netNormal.setBounds(56, 116, 106, 39);
				panel_5.add(netNormal);
				
				//网络层的显示
				
				JLabel label = new JLabel("\u5E94\u7528\u5C42\u68C0\u6D4B");
				label.setForeground(new Color(0, 204, 51));
				label.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 17));
				label.setBounds(330, 146, 97, 27);
				panel_4.add(label);
				
				JLabel lblDdos = new JLabel("DDoS\u5165\u4FB5\u68C0\u6D4B");
				lblDdos.setForeground(new Color(0, 204, 51));
				lblDdos.setFont(new Font("宋体", Font.BOLD, 31));
				lblDdos.setBounds(53, 10, 268, 49);
				panel_4.add(lblDdos);
				
				JPanel panel_7 = new JPanel();
				panel_7.setLayout(null);
				panel_7.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, new Color(178, 34, 34), new Color(65, 105, 225), null));
				panel_7.setBackground(new Color(153, 204, 204));
				panel_7.setBounds(542, 166, 215, 215);
				panel_4.add(panel_7);
				
				JPanel panel_6 = new JPanel();
				panel_6.setLayout(null);
				panel_6.setBackground(Color.BLACK);
				panel_6.setBounds(279, 196, 215, 208);
				panel_4.add(panel_6);
				
				
				
				//应用层的显示
				webRed = new JButton("\u7EA2\u8272\u9884\u8B66");
//				webRed.setBackground(Color.RED);
				webRed.setBounds(0, 0, 215, 39);
				panel_6.add(webRed);
				
				 webYellow = new JButton("\u9EC4\u8272\u9884\u8B66");
//				webYellow.setBackground(Color.YELLOW);
				webYellow.setBounds(10, 39, 193, 39);
				panel_6.add(webYellow);
				
				webBule = new JButton("\u84DD\u8272\u9884\u8B66");
//				webBule.setBackground(Color.BLUE);
				webBule.setBounds(20, 78, 169, 39);
				panel_6.add(webBule);
				
				 webNormal = new JButton("\u6B63\u5E38");
//				webNormal.setBackground(Color.GREEN);
				webNormal.setBounds(56, 116, 106, 39);
				panel_6.add(webNormal);
				//应用层的显示
				
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
				
								new Thread(new Runnable() {
									@Override
									public void run() {
										for (int i = 0; i <= 5000; i++) {
											bar.setValue(i);
											try {
												Thread.sleep(10);
									
											} catch (InterruptedException e) {
											}
										
										}
										webNormal.setBackground(Color.GREEN);
										netNormal.setBackground(Color.GREEN);
									}
									
									
									
								}).start();
								
								
								
								String str = btnNewButton.getText();
								if (str.equals("开始"))
								{
				
									btnNewButton.setText("结束");
									// CaptureCore sCaptureCore = new CaptureCore();
									 AllInfo allInfo = new AllInfo("56032");
									 allInfo.start();
									// sCaptureCore.start();
									// Test test=new Test();
									// test.start();

									CaptureCore captureCore=new CaptureCore();
									captureCore.start();

					
								

									// 实时的数据
									double double1[] = new double[25];
									double1 = CaptureCore.getD();
									// 历史的统计的数据
									double[] Real_Time_Array = {44,46,55,44,49,41,44,39,47,45,47,43,40,36,43,36,42,36,44,42,44,43,45,46,44};

									String string = TrafficAttack.getArithmeticResult(double1, Real_Time_Array);
									
									if (string.equals("正常")) {
										webNormal.setBackground(Color.GREEN);
										

									} else {
										Web.Applicationcalculationweight();
										Net.Netcalculationweight();
									}
									
									

								} else
								{
									btnNewButton.setText("开始");
				
								}
				
							}
						});

	}


	public static JButton getNetRed() {
		return netRed;
	}

	public static void setNetRed(JButton netRed) {
		UI.netRed = netRed;
	}

	public static JButton getNetYellow() {
		return netYellow;
	}

	public static void setNetYellow(JButton netYellow) {
		UI.netYellow = netYellow;
	}

	public static JButton getNetBule() {
		return netBule;
	}

	public static void setNetBule(JButton netBule) {
		UI.netBule = netBule;
	}

	public static JButton getNetNormal() {
		return netNormal;
	}

	public static void setNetNormal(JButton netNormal) {
		UI.netNormal = netNormal;
	}

	public static JButton getWebRed() {
		return webRed;
	}

	public static void setWebRed(JButton webRed) {
		UI.webRed = webRed;
	}

	public static JButton getWebYellow() {
		return webYellow;
	}

	public static void setWebYellow(JButton webYellow) {
		UI.webYellow = webYellow;
	}

	public static JButton getWebBule() {
		return webBule;
	}

	public static void setWebBule(JButton webBule) {
		UI.webBule = webBule;
	}

	public static JButton getWebNormal() {
		return webNormal;
	}

	public static void setWebNormal(JButton webNormal) {
		UI.webNormal = webNormal;
	}


}
