package com.connorbrezinsky.turbulent.guiutils;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Gui {

	int x, y, width, height;
	Color color;
	public boolean isVisible = true;

	Image i;

	List<GuiComponent> components = new ArrayList<>();

	public Gui(int _x, int _y, int w, int h) {
		x = _x;
		y = _y;
		width = w;
		height = h;
		color = Color.black;
	}

	public Gui(int _x, int _y, int w, int h, Color c) {
		x = _x;
		y = _y;
		width = w;
		height = h;
		color = c;
	}

	public Gui addSprite(Image s){
		i = s;
		return this;
	}

	public void render(Graphics g){
		if(isVisible){
			if(i == null){
				g.setColor(color);
				g.fillRect(x, y, width, height);
			}else{
				i.draw(x, y, width, height);
			}

			for(GuiComponent gc : components){
				gc.render(g);
			}
		}
	}

	public Gui hide(){
		isVisible = false;
		return this;
	}
	
	public void unHide(){
		isVisible = true;
	}

}
