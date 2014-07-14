package EngineSprite;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class EngineSprite {
	
	public Texture texture;
	public String name;
	public int x;
	public int y;
	
	public int sx;
	public int sy;
	
	public float scalex = 1.0f;
	public float scaley = 1.0f;
	
	
	
	public EngineSprite(){
		
	}
	
	public EngineSprite(String name){
		try {
			texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(name));
			
			this.name = name;
			this.sx = texture.getImageWidth();
			this.sy = texture.getImageHeight();
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void draw(){
		GL11.glPushMatrix();
		GL11.glColor3f(1.0f, 1.0f, 1.0f);
		texture.bind();
		GL11.glBegin(GL11.GL_QUADS);
			//lefttop
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2f(x, y);
			//righttop
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2f(x+(float)sx*scalex, y);
			//rightbottom
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2f(x+(float)sx*scalex,(float) y+(float)sy*scaley);
			//leftbottom
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2f(x, y+(float)sy*scaley);
			
		GL11.glEnd();
		GL11.glPopMatrix();
	}
	
	public void draw(int x, int y){
		this.x = x;
		this.y = y;
		draw();
	}
	
	public void scale(float scalex, float scaley){
		this.scalex = scalex;
		this.scaley = scaley;
	}
}
