package EngineInput;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class  EngineMouse {
	public static int getMouseX(){
		return Mouse.getX();
	}
	public static int getMouseY(){
		return (Display.getHeight()-1)-Mouse.getY();
	}	
	
	public static boolean isLeftMouseDown(){
		return Mouse.isButtonDown(0);
	}
	
	public static boolean isRightMouseDown(){
		return Mouse.isButtonDown(1);
	}
}
