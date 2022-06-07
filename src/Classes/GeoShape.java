package Classes;


import java.awt.Color;
import java.awt.Point;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rana Mostafa
 */
public class GeoShape 
{
	private Point SP; 
	private char shape;
	private boolean dotted;
	private Color color;
	
	public GeoShape(){}
	public GeoShape(Point sp, char Shape ,Color currentColor,boolean dotted)
        {
            this.SP=sp;
            this.shape=Shape;
            this.dotted=dotted;
            this.color= currentColor;
        }

        public Point getSP() 
        {
            return SP;
        }

        public void setSP(Point SP) 
        {
            this.SP = SP;
        }

        
        public char getShape() 
        {
            return shape;
        }

        public void setShape(char shape) 
        {
            this.shape = shape;
        }

        public boolean isDotted() 
        {
            return dotted;
        }

        public void setDotted(boolean dotted) 
        {
            this.dotted = dotted;
        }
        
        public Color getColor() 
        {
            return color;
        }

        public void setColor(Color color) 
        {
            this.color = color;
        }
        
        
}
