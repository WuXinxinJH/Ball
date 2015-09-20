package am;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class Demo2 extends JPanel implements Runnable{
	//����һ�������������10��С��
	Demo3[] bs=new Demo3[10];
	
	//�ڹ��췽�����bs��ֵ
	public Demo2(){
		//����bs���� �õ�ÿһ��Ԫ��
		Random ra=new Random();
		for(int i=0;i<bs.length;i++){
			int r=ra.nextInt(25)+25;//��Χ25-50
			int x=ra.nextInt(400);
			int y=ra.nextInt(500);
			int speed=ra.nextInt(20)+3;//��Χ3-23
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
		//��С��һֱ�˶�
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
