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
public class Oval extends GeoShape
{
    int width,heigth;
    boolean isFilled;
    public Oval(){}
		
    public Oval(Point sp,int width,int heigth,char Shape ,Color currentColor,boolean dotted, boolean filled)
    {
	super(sp,Shape,currentColor,dotted);
        this.width=width;
        this.heigth=heigth;
        this.isFilled=filled;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public boolean isIsFilled() {
        return isFilled;
    }

    public void setIsFilled(boolean isFilled) {
        this.isFilled = isFilled;
    }
    
}
