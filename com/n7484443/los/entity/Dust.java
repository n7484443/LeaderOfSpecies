package com.n7484443.los.entity;

import static com.n7484443.los.render.RenderingHelper.SetBlendMode;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Vector2f;

import com.n7484443.los.map.MapBase;
import com.n7484443.los.math.MathS;
import com.n7484443.los.render.RenderingHelper;

public class Dust extends EntityBase {
	public double m;
	public boolean d;
	public float angle;
	public Vector2f vector;
	public float power;
	
	public Dust(int x, int y, double m, MapBase map) {
		super(x, y, (int)Math.sqrt(m), (int)Math.sqrt(m), 1, 1, map);
		this.m = m;
		d = false;
		vector = new Vector2f(0, 0);
		angle = 0;
		power = 0;
	}

	public void update() {
		if (this.nowstate == State.MOVING) {
			EntityBase entity;
			for (int i = 0; i < this.map.getEntityS().size(); i++) {
				if (this != this.map.getEntityS().get(i)) {
					entity = this.map.getEntityS().get(i);
				} else {
					continue;
				}
				double range = MathS.CircuitRange(x, y, entity.x, entity.y);
				if (range >= 300){
					if(((Dust)entity).m < m*1.3){
						continue;
					}
				}
				if (range >= width + entity.width) {
					Vector2f v = MathS.CircuitGravity(this.m, ((Dust) entity).m, x, y, entity.x, entity.y);
					double move = v.y;
					float angle = Math.round(Math.toDegrees(v.x))-90;
					if(angle<0){
						angle += 360;
					}
					float a = (float) Math.toRadians(angle);
					// float angle = Math.round((float) Math.toDegrees(v.x));
					float cosa = (float) Math.cos(a);
					float sina = (float) Math.sin(a);
					boolean c = cosa<0;
					boolean s = sina<0;
					int c1 = c? -1:1;
					int s1 = s? -1:1;
					System.out.println(m);
					x+= c1*Math.sqrt(c1*(cosa * move)*2/m);
					y-= s1*Math.sqrt(s1*(sina * move)*2/m);
				} else {
					if(this.m >= ((Dust)entity).m){
						this.m += ((Dust)entity).m;
						this.width = (int) Math.sqrt(m);
						entity.EntityDelete();
					}
				}
			}
			//vector = MathS.VectorSum(vector, new Vector2f((float)MathS.CircuitAngle(rx, ry), (float)MathS.CircuitRange(rx, ry)));
			//vector = new Vector2f((float) (MathS.CircuitAngle(rx, ry)), (float)MathS.CircuitRange(rx, ry));
			//float rx1 = (float) (((Math.cos(vector.x-90)) * vector.y));
			//float ry1 = (float) (((Math.sin(vector.x-90)) * vector.y));
			//power = (float)rx/ry;
			//angle = (float) MathS.CircuitAngle(rx, ry);
			//CheckIsOut();
		}
	}

	public void RenderingEntity() {
		SetBlendMode(false);
		Color.black.bind();
		RenderingHelper.RenderPackedCircle((int)x, (int)y, width);
		//GL11.glTranslatef(x, y, 0);
		//float a = (float) Math.toDegrees(angle);
		//GL11.glRotatef(a, 0f, 0f, 1f);
		//RenderingHelper.RenderQuadrangle(20, 0, (int) power, 10, null);
		//GL11.glRotatef(a, 0f, 0f, -1f);
		//GL11.glTranslatef(-x, -y, 0);
	}

}
