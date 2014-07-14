package EngineDraw;


import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;

public class EngineDraw {
	
	public void drawBox(int x, int y, int sx, int sy, Color col) {	
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glColor3f(col.r, col.g, col.b);
		GL11.glBegin(GL11.GL_QUADS);
			//lefttop
			GL11.glVertex2f(x, y);
			//righttop
			GL11.glVertex2f(x+sx, y);
			//rightbottom
			GL11.glVertex2f(x+sx, y+sy);
			//leftbottom
			GL11.glVertex2f(x, y+sy);	
		GL11.glEnd();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}	
	
	public void drawCircle(int x, int y, int diameter, Color col){
		
	}

	
}
