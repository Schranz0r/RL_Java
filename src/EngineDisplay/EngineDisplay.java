package EngineDisplay;

import java.awt.Image;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.ImageData;

public class EngineDisplay {
	

	public int RefreshRate = 60;
	public boolean VSync = true;
	public int Width = 800;
	public int Height = 600;
	
	
	public void SetDisplay(int width, int height, String title){
		try {
			Width = width;
			Height = height;
			
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle(title);
			Display.setSwapInterval(RefreshRate);
			Display.setVSyncEnabled(VSync);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	
	public void SetDisplayTo3D(){
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GLU.gluPerspective(45, (float)Width/(float)Height, 0.2f, 1000);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}
	
	public void SetDisplayTo2D(){
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glShadeModel(GL11.GL_SMOOTH);        
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL11.GL_LIGHTING);                    
 
		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);                
        GL11.glClearDepth(1);                                       
 
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
 
        GL11.glViewport(0,0,Width,Height);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
 
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, Width, Height, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}	
	public boolean isCloseRequested(){
		return Display.isCloseRequested();
	}
	
	public void closeDisplay(){
		Display.destroy();
	}
	
	public void update(){
		Display.update();
		Clear();
	}
	
	public void Clear(){
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);	
	}
}
