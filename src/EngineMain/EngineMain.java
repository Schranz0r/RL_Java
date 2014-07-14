/**
 * Projectname: GameEngine
 * Package: EngineMain
 * From: sliver
 * Date: 13.07.2014
 * Time: 13:20:26
 */
package EngineMain;

import java.awt.Font;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import EngineDisplay.EngineDisplay;
import EngineDraw.EngineDraw;
import EngineInput.EngineMouse;
import EngineSprite.EngineSprite;

/**
 * @author sliver
 */
public class EngineMain {
	/*################################################################################################# 
	 *  									GAME - VARIABLES
	 *################################################################################################# 
	 */	
	//Create the display
	public static EngineDisplay display = new EngineDisplay();
	public static int WIDTH = 800;
	public static int HEIGHT = 600;
	
	public static TrueTypeFont font2;
	
	/*################################################################################################# 
	 *  									GAME - MAIN
	 *################################################################################################# 
	 */
	public static void main(String[] args){
		display.SetDisplay(WIDTH, HEIGHT, "My Game Engine v0.2");
		GameLoop();
	}
	
	
	/*#################################################################################################
	 *  									GAME - LOOP
	 *#################################################################################################
	 */
	public static void GameLoop(){
		display.SetDisplayTo2D();	
		
		EngineSprite sprite = new EngineSprite("res/test.png");
		EngineDraw box = new EngineDraw();
		Color myColor = new Color(255, 0, 128);
		
		
		TrueTypeFont font;
		Font awtfont = new Font("Arial",Font.BOLD,50);
		font = new TrueTypeFont(awtfont, true);
		
		while(!display.isCloseRequested()){
			
			font.drawString(100, 100, "NICE LOOKING FONTS!", Color.green);
			sprite.draw();
			
			box.drawBox(EngineMouse.getMouseX(),EngineMouse.getMouseY(), 50, 50, myColor);
			
			display.update();
		}
		
		display.closeDisplay();
		
	}

	
}
