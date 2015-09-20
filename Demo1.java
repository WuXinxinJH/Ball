package am;

import javax.swing.JFrame;

public class Demo1 extends JFrame{
	/*
	 * 窗口
	 * 大小(500,600)
	 * 居中
	 * 标题(my ball)
	 * 背景颜色为黑色
	 * 点关闭退出程序
	 */
	public Demo1() {
		// TODO Auto-generated constructor stub
		this.setSize(900,600);
		this.setLocationRelativeTo(null);
		this.setTitle("my ball");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Demo2 d2=new Demo2();
		this.add(d2);
		
		Thread th=new Thread(d2);
		th.start();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Demo1();
	}
}
