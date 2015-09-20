package am;

import java.awt.Color;
import java.awt.Graphics;

public class Demo3 {
	//封装小球的属性及方法
	int r;//定义半径
	int x,y;//定义坐标
	int speed;//定义小球运动速度
	int direction;//定义小球运动方向
	Color col;//小球颜色
	Demo2 d2;
	
	//添加4个方向常量
	public static final int LEFT_UP=1;
	public static final int LEFT_DOWN=2;
	public static final int RIGHT_UP=3;
	public static final int RIGHT_DOWN=4;
	
	//添加无参构造方法
	public Demo3(){
		
	}
	//添加有参构造方法
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
	//画小球
	public void drawBall(Graphics g){
		g.fillArc(x, y, 2*r, 2*r, 0, 360);
	}
	//添加方法 封装小球运动
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
