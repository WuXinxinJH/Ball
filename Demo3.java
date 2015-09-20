package am;

import java.awt.Color;
import java.awt.Graphics;

public class Demo3 {
	//��װС������Լ�����
	int r;//����뾶
	int x,y;//��������
	int speed;//����С���˶��ٶ�
	int direction;//����С���˶�����
	Color col;//С����ɫ
	Demo2 d2;
	
	//���4��������
	public static final int LEFT_UP=1;
	public static final int LEFT_DOWN=2;
	public static final int RIGHT_UP=3;
	public static final int RIGHT_DOWN=4;
	
	//����޲ι��췽��
	public Demo3(){
		
	}
	//����вι��췽��
	public Demo3(int r, int x, int y, int speed, int direction, Color col,Demo2 d2) {
		super();
		this.r = r;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.direction = direction;
		this.col = col;
		this.d2=d2;
	}
	//��С��
	public void drawBall(Graphics g){
		g.fillArc(x, y, 2*r, 2*r, 0, 360);
	}
	//��ӷ��� ��װС���˶�
	public void move(){
		switch(direction){
		case LEFT_UP:
			x-=speed;
			y-=speed;
			if(x<0){
				direction=RIGHT_UP;
			}
			if(y<0){
				direction=LEFT_DOWN;
			}
			break;
		case LEFT_DOWN:
			x-=speed;
			y+=speed;
			if(x<0){
				direction=RIGHT_DOWN;
			}
			if(y>d2.getHeight()-2*r){
				direction=LEFT_UP;
			}
			break;
		case RIGHT_UP:
			x+=speed;
			y-=speed;
			if(x>d2.getWidth()-2*r){
				direction=LEFT_UP;
			}
			if(y<0){
				direction=RIGHT_DOWN;
			}
			break;
		case RIGHT_DOWN:
			x+=speed;
			y+=speed;
			if(x>d2.getWidth()-2*r){
				direction=LEFT_DOWN;
			}
			if(y>d2.getHeight()-2*r){
				direction=RIGHT_UP;
			}
			break;
		}
	}
}
