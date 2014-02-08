package com.thecherno.rain.graphics;

import java.util.Random;

import com.thecherno.rain.entity.mob.Player;
import com.thecherno.rain.entity.projectile.Projectile;
import com.thecherno.rain.level.tile.Tile;

public class Screen {
	
	public int width, height;
	public int[] pixels;
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	protected Sprite sprite;
	public int xOffset,yOffset;
	
	
	public int[] tiles = new int[MAP_SIZE*MAP_SIZE];
	
	private Random random = new Random();
	
	public Screen(int width,int height){
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		
		for(int i = 0; i< MAP_SIZE*MAP_SIZE;i++){
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	
	public void clear(){
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = 0;
		}
		
	}
	
	
	public void renderTile(int xp, int yp, Tile tile){
		xp -=xOffset;
		yp -=yOffset;
		for(int y = 0; y<tile.sprite.SIZE;y++){
			int ya = yp + y;
			for(int x = 0; x<tile.sprite.SIZE;x++){
				int xa = xp + x;
				if(xa < -tile.sprite.SIZE||xa>=width||ya<0||ya>=height)break;
				if(xa<0)xa = 0;
				pixels[xa+ya*width] = tile.sprite.pixels[x+y*tile.sprite.SIZE];
			}
		}
	}
	public void renderProjectile(int xp, int yp, Projectile p){
		xp -=xOffset;
		yp -=yOffset;
		for(int y = 0; y<p.getSpriteSize();y++){
			int ya = yp + y;
			for(int x = 0; x<p.getSpriteSize();x++){
				int xa = xp + x;
				if(xa < -p.getSpriteSize()||xa>=width||ya<0||ya>=height)break;
				if(xa<0)xa = 0;
				int col = p.getSprite().pixels[x+y*p.getSprite().SIZE];
				if (col != 0xff000000) pixels[xa+ya*width] = col;
			}
		}
	}
	
	public void renderPlayer(int xp, int yp, Sprite sprite){
		xp -=xOffset;
		yp -=yOffset;
		for(int y = 0; y<32;y++){
			int ya = yp + y;
			for(int x = 0; x<32;x++){
				int xa = xp + x;
				if(xa < -32||xa>=width||ya<0||ya>=height)break;
				if(xa<0)xa = 0;
				int col = sprite.pixels[x+y*32];
				if(col != 0xff000000)pixels[xa+ya*width] = col;
			}
		}
	}
	public void renderKnight(int xp, int yp, Sprite sprite){
		xp -=xOffset;
		yp -=yOffset;
		for(int y = 0; y<48;y++){
			int ya = yp + y;
			for(int x = 0; x<48;x++){
				int xa = xp + x;
				if(xa < -48||xa>=width||ya<0||ya>=height)break;
				if(xa<0)xa = 0;
				int col = sprite.pixels[x+y*48];
				if(col != 0xff000000)pixels[xa+ya*width] = col;
			}
		}
	}
	public void renderKnight1(int xp, int yp, Sprite sprite){
		xp -=xOffset;
		yp -=yOffset;
		for(int y = 0; y<48;y++){
			int ya = yp + y;
			for(int x = 0; x<48;x++){
				int xa = xp + x;
				if(xa < -48||xa>=width||ya<0||ya>=height)break;
				if(xa<0)xa = 0;
				int col = sprite.pixels[x+y*48];
				if(col != 0xff000000)pixels[xa+ya*width] = col;
			}
		}
	}
	
	public void setOffset(int xOffset,int yOffset){
		this.xOffset = xOffset; 
		this.yOffset = yOffset;
	}

}
