package com.n7484443.los.entity;

import static com.n7484443.los.render.RenderingHelper.RenderText;
import static com.n7484443.los.render.RenderingHelper.SetBlendMode;

import java.util.Random;

import org.newdawn.slick.Color;
import com.n7484443.los.develop.EvolutionS;
import com.n7484443.los.map.MapBase;
import com.n7484443.los.map.MapS;
import com.n7484443.los.map.MapUnderSea;
import com.n7484443.los.render.ColorS;
import com.n7484443.los.render.FontRenderer;
import com.n7484443.los.render.RenderingHelper;
import com.n7484443.los.render.TextureHelper;

public class CellEntity extends EntityBase{
	int time = 0;
	int eattime = 60;
	int eat;
	int maxReproduction = 60*10;
	Random r;
	public CellEntity(int x, int y, int range, MapBase map) {
		super(x, y, range, range, map, 0);
		r = new Random();
		eat = r.nextInt(99)+1;
	}
	
	public void update(){
		if(time != 0 && time % eattime == 0){
			if(((MapUnderSea)map).F > eat){
				((MapUnderSea)map).F -= eat;
			}else{
				this.EntityDelete();
				((MapUnderSea)this.map).F += eat;
			}
		}
		if(time != 0 && time % maxReproduction == 0){
			new CellEntity((int)x+r.nextInt(256)-128, (int)y+r.nextInt(256)-128, width, this.map);
		}
		texture = EvolutionS.EntityCellImageEvolution();
		time++;
	}

	public void RenderingEntity(){
		ColorS.AquaBlue.bind();
		SetBlendMode(false);
		RenderingHelper.RenderPackedCircle((int)x, (int)y, width/2);
		SetBlendMode(true);
		RenderingHelper.RenderQuadangleXY((int)x, (int)y, width, height, TextureHelper.EntityTexture[EvolutionS.EntityCellImageEvolution()]);
		Color.black.bind();
		RenderText((int)(x + width/2 - FontRenderer.getSize(String.valueOf(eat))/2), (int)y, String.valueOf(eat), false);
	}
}
