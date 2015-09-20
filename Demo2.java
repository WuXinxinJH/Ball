package am;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class Demo2 extends JPanel implements Runnable{
	//定义一个数组用来存放10个小球
	Demo3[] bs=new Demo3[10];
	
	//在构造方法里给bs赋值
	public Demo2(){
		//遍历bs数组 得到每一个元素
		Random ra=new Random();
		for(int i=0;i<bs.length;i++){
			int r=ra.nextInt(25)+25;//范围25-50
			int x=ra.nextInt(400);
			int y=ra.nextInt(500);
			int speed=ra.nextInt(20)+3;//范围3-23
			int direction=ra.nextInt(4)+1;
			int red=ra.nextInt(255);
			int green=ra.nextInt(255);
			int blue=ra.nextInt(255);
			Color col=new Color(red,green,blue);
			bs[i]=new Demo3(r, x, y, speed, direction, col,this);
			
		}
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		this.setBackground(Color.black);
		
		for(int i=0;i<bs.length;i++){
			Demo3 b=bs[i];
			g.setColor(b.col);
			b.drawBall(g);
		}
	}
	public void run() {
		// TODO Auto-generated method stub
		//让小球一直运动
		while(true){
			for(int i=0;i<bs.length;i++){
				Demo3 b=bs[i];
				b.move();
				repaint();
			}
			
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		}
	}
}
