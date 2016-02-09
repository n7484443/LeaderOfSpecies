package com.n7484443.los.math;

import org.newdawn.slick.geom.Vector2f;

public class MathS {
	public static double G = 6.673*0.01;
	public static float sqrt3 = 1.73f;
	
	public static Vector2f CircuitGravity(double m1, double m2, float x1, float y1, float x2, float y2){
		float F = (float) (G * m1 * m2 / Math.pow(CircuitRange(x1, y1, x2, y2), 2));
		double angle = CircuitAngle(x1, y1, x2, y2);
		return new Vector2f((float) angle,F);
	}
	
	public static double CircuitAngle(float x1, float y1, float x2, float y2){
		float dx = x2-x1;
		float dy = y2-y1;
		return Math.atan2(dx, dy);
	}
	
	public static double CircuitAngle(float rx, float ry){
		return Math.atan2(rx, ry);
	}
	
	public static double CircuitRange(float x1, float y1, float x2, float y2){
		float dx = x2-x1;
		float dy = y2-y1;
		return Math.sqrt(Math.pow(dx,2) + Math.pow(dy,2));
	}
	
	public static double CircuitRange(float rx, float ry){
		return Math.sqrt(Math.pow(rx,2) + Math.pow(ry,2));
	}
	
	public static Vector2f VectorSum(Vector2f v1, Vector2f v2){
		//x = angle y = F
		float x = 0,y=0;
		x += Math.cos(v1.x) * v1.y;
		y += Math.sin(v1.x) * v1.y;
		x += Math.cos(v2.x) * v2.y;
		y += Math.sin(v2.x) * v2.y;
		float angle = (float) CircuitAngle(x,y);
		if(angle < Math.toRadians(0)) angle += Math.toRadians(360);
		float F = (float)CircuitRange(x, y);
		//System.out.println(angle + ":" + F);
		return new Vector2f(angle, F);
	}
	
	public static float AngleToPublic(float theta){
		if(90-theta < 0){
			return 450-theta;
		}
		return 90 - theta;
	}
}
