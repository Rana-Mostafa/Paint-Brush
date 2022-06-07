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
public class Line extends GeoShape
{
    Point EP;
    public Line(){}
		
    public Line(Point sp, Point EP,char Shape ,Color currentColor,boolean dotted)
    {
        super(sp,Shape,currentColor,dotted);
        this.EP=EP;
    }

    public Point getEP() {
        return EP;
    }

    public void setEP(Point EP) {
        this.EP = EP;
    }
    
    
}
