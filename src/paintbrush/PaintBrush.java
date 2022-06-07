/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Applet.java to edit this template
 */
package paintbrush;

import Classes.*;
import java.applet.Applet;
import java.awt.BasicStroke;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;

/**
 *
 * @author Rana Mostafa
 */
public class PaintBrush extends Applet implements ActionListener,MouseMotionListener,MouseListener{

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    Color brushColor;
    Button bRect,bOval,bLine;
    Button bRed,bGreen,bBlue,bOrange,bGray,bYellow;
    Button bClear,bEraser,bHand;
    Button bUndo,bSave,bOpen;
    Checkbox cFill,cDott;  
    int lCounter,rCounter,oCounter,eCounter,hCounter;
    char shape;
    Point SP,EP;
    Vector<Line> lineVec;
    Vector<Rect> rectVec;
    Vector<Oval> ovelVec;
    Vector<Eraser> eraserVec;
    Vector<Hand> handVec;
    Vector <Character> drawnShape;
    boolean dotted,filled;
    int width,height;
    int counter;
    private final GraphicsConfiguration gConfig = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
   
    public void init() 
    {
        setLayout(null);
        dotted=filled=false;
        lineVec = new Vector();
        rectVec = new Vector();
        ovelVec = new Vector();
        eraserVec = new Vector();
        handVec = new Vector();
        drawnShape = new Vector();
        counter=0;
        lCounter=rCounter=oCounter=eCounter=0;
        /////////Colors Buttons//////////
        //Red button
        bRed=new Button("       ");
        bRed.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                brushColor=Color.RED.darker();
            }
        });
        bRed.setBackground(Color.RED.darker());
        bRed.setBounds(30,2,35,30);
        add(bRed);
        
        //Green button
        bGreen=new Button("       ");
        bGreen.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                brushColor=Color.GREEN.darker();
            }
        });
        bGreen.setBackground(Color.GREEN.darker());
        bGreen.setBounds(65,2,35,30);
        add(bGreen);
        
        //Blue button
        bBlue=new Button("       ");
        bBlue.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                brushColor=Color.BLUE;
            }
        });
        bBlue.setBackground(Color.BLUE);
        bBlue.setBounds(100,2,35,30);
        add(bBlue);
        
        //Yellow button
        bYellow=new Button("       ");
        bYellow.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                brushColor=Color.YELLOW;
            }
        });
        bYellow.setBackground(Color.YELLOW);
        bYellow.setBounds(135,2,35,30);
        add(bYellow);
        
        //Gray button
        bGray=new Button("       ");
        bGray.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                brushColor=Color.DARK_GRAY;
            }
        });
        bGray.setBackground(Color.DARK_GRAY);
        bGray.setBounds(170,2,35,30);
        add(bGray);
        
        //Orange button
        bOrange=new Button("       ");
        bOrange.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                brushColor=Color.ORANGE;
            }
        });
        bOrange.setBackground(Color.ORANGE);
        bOrange.setBounds(205,2,35,30);
        add(bOrange);
        /////////End of Colors Buttons//////////
        
        ////////Shapes Buttons//////////////////
        ////////Rectangle button
        bRect=new Button("Rect");
        bRect.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                shape='R';
            }
        });
        bRect.setFont(new Font("Courier",Font.BOLD,18));
        bRect.setBounds(275,2,60,30);
        add(bRect);
        
        /////////Oval button
        bOval=new Button("Oval");
        bOval.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                shape='O';
            }
        });
        bOval.setFont(new Font("Courier",Font.BOLD,18));
        bOval.setBounds(337,2,60,30);
        add(bOval);
        
        ///////////Line button
        bLine=new Button("Line");
        bLine.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                shape='L';
            }
        });
        bLine.setFont(new Font("Courier",Font.BOLD,18));
        bLine.setBounds(399,2,60,30);
        add(bLine);
        //////////////////End of Shapes buttons///////////////////
        
        ////////////Fill Shape checkbox///////////////
        cFill= new Checkbox("Filled");
        cFill.addItemListener(new ItemListener() {
             public void itemStateChanged(ItemEvent e) {   
                 if(e.getStateChange()==1)
                    filled=true;
                 else
                     filled=false;
             }    
          });    
        cFill.setBounds(515, 0, 100, 20);
        cFill.setFont(new Font("Courier", Font.BOLD,18));
        add(cFill);
        
        
        
        ////////////Dotted Shape checkbox///////////////
        cDott= new Checkbox("Dotted");
        cDott.addItemListener(new ItemListener() {
             public void itemStateChanged(ItemEvent e) {   
                 if(e.getStateChange()==1)
                    dotted=true;
                 else
                    dotted=false;
             }    
          });    
        cDott.setBounds(515, 20, 100, 20);
        cDott.setFont(new Font("Courier", Font.BOLD,18));
        add(cDott);
        
        
        ////////////Clear button///////////////
        bClear=new Button("Clear All");
        bClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawnShape.clear();
                rectVec.clear();
                lineVec.clear();
                ovelVec.clear();
                eraserVec.clear();
                handVec.clear();
                shape=' ';
                repaint();
            }
        });
        bClear.setFont(new Font("Courier",Font.BOLD,18));
        bClear.setBounds(625,2,120,30);
        add(bClear);
        
        ////////////Eraser Button///////////////
        bEraser=new Button("Eraser");
        bEraser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape='E';
            }
        });
        bEraser.setFont(new Font("Courier",Font.BOLD,18));
        bEraser.setBounds(747,2,100,30);//682
        add(bEraser);
        
        
        ////////////Free hand button///////////////
        bHand=new Button("Hand Free");
        bHand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape='H';
            }
        });
        bHand.setFont(new Font("Courier",Font.BOLD,18));
        bHand.setBounds(850,2,120,30);//785
        add(bHand);
        
        
        ////////////Undo button///////////////
        bUndo=new Button("Undo");
        bUndo.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if(drawnShape.size()>0)
                {
                    switch(drawnShape.elementAt(drawnShape.size()-1))
                    {
                        case 'R':
                            rectVec.removeElementAt(rectVec.size()-1);
                            break;
                        
                        case 'O':
                            ovelVec.removeElementAt(ovelVec.size()-1);
                            break;
                            
                        case 'L':
                            lineVec.removeElementAt(lineVec.size()-1);
                            break;
                            
                        case 'E':
                            eraserVec.removeElementAt(eraserVec.size()-1);
                            break;
                        case 'H':
                             handVec.removeElementAt(handVec.size()-1);
                             break;
                    }
                    drawnShape.removeElementAt(drawnShape.size()-1);
                }
                        
                else
                    System.out.println("There is nothing to Undo");
                repaint();
            }
        });
        bUndo.setFont(new Font("Courier",Font.BOLD,18));
        bUndo.setBounds(1015,2,60,30);//1007
        add(bUndo);
        
        
        ////////////Save button///////////////
        bSave=new Button("Save");
        bSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                draw();
                System.out.println("Image Saved Successfully");
            }
        });
        bSave.setFont(new Font("Courier",Font.BOLD,18));
        bSave.setBounds(1128,2,60,30);
        add(bSave);
        
        
       
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    
    
    
    @Override
    public void paint(Graphics g)
    {
        try
        {
            lCounter=rCounter=oCounter=eCounter=hCounter=0;
            float[] dash = {15,15,15};
            Graphics2D g2d = (Graphics2D) g.create();
            for(int i=0;i<drawnShape.size();i++)
            {
                switch(drawnShape.elementAt(i))
                {
                    case 'R':
                    {
                        if(rectVec.get(rCounter).isDotted())
                            g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,0,dash,0 ));
                        else
                            g2d.setStroke(new BasicStroke(0));

                        g2d.setColor(rectVec.get(rCounter).getColor());
                        g2d.drawRect((int)rectVec.get(rCounter).getSP().getX(),(int)rectVec.get(rCounter).getSP().getY(),rectVec.get(rCounter).getWidth(),rectVec.get(rCounter).getHeigth());
                        if (rectVec.get(rCounter).isIsFilled())
                            g2d.fillRect((int)rectVec.get(rCounter).getSP().getX(),(int)rectVec.get(rCounter).getSP().getY(),rectVec.get(rCounter).getWidth(),rectVec.get(rCounter).getHeigth());
                        rCounter++;
                        break;
                    }
                    case 'O':
                    {
                        if(ovelVec.get(oCounter).isDotted())
                            g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,0,dash,0 ));
                        else
                            g2d.setStroke(new BasicStroke(0));

                        g2d.setColor(ovelVec.get(oCounter).getColor());
                        g2d.drawOval((int)ovelVec.get(oCounter).getSP().getX(),(int)ovelVec.get(oCounter).getSP().getY(),ovelVec.get(oCounter).getWidth(),ovelVec.get(oCounter).getHeigth());
                        if (ovelVec.get(oCounter).isIsFilled())
                            g2d.fillOval((int)ovelVec.get(oCounter).getSP().getX(),(int)ovelVec.get(oCounter).getSP().getY(),ovelVec.get(oCounter).getWidth(),ovelVec.get(oCounter).getHeigth());
                        oCounter++;
                        break;
                    }
                    case 'L':
                    {
                        if(lineVec.get(lCounter).isDotted())
                            g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,0,dash,0 ));
                        else
                            g2d.setStroke(new BasicStroke(0));

                        g2d.setColor(lineVec.get(lCounter).getColor());
                        g2d.drawLine((int)lineVec.get(lCounter).getSP().getX(),(int)lineVec.get(lCounter).getSP().getY(),(int)lineVec.get(lCounter).getEP().getX(),(int)lineVec.get(lCounter).getEP().getY());
                        lCounter++;
                        break;
                    }

                    case 'E':
                    {
                        g2d.setColor(eraserVec.get(eCounter).color);
                        g2d.fillOval((int)eraserVec.get(eCounter).getSP().getX(),(int)eraserVec.get(eCounter).getSP().getY(),eraserVec.get(eCounter).width,eraserVec.get(eCounter).heigth);
                        eCounter++;
                        break;
                    }
                    case 'H':
                    {
                        g2d.setColor(handVec.get(hCounter).getColor());
                        g2d.fillOval((int)handVec.get(hCounter).getSP().getX(),(int)handVec.get(hCounter).getSP().getY(),handVec.get(hCounter).width,handVec.get(eCounter).heigth);
                        hCounter++;
                        break;
                    }
                }
            }


            switch(shape)
            {
                case 'R':
                {
                    g2d.setColor(brushColor);
                    if(dotted)
                        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,0,dash,0 ));
                    else
                    g2d.setStroke(new BasicStroke(0));

                    width=Math.abs((int)EP.getX()-(int)SP.getX());
                    height=Math.abs((int)EP.getY()-(int)SP.getY());
                    Point P = new Point(Math.min((int)SP.getX(), (int)EP.getX()),Math.min((int)SP.getY(), (int)EP.getY()));
                    g2d.drawRect((int)P.getX(), (int)P.getY(), width, height);
                    if(filled)
                        g2d.fillRect((int)P.getX(), (int)P.getY(), width, height);
                    break;
                }

                case 'O':
                {
                    g2d.setColor(brushColor);
                    if(dotted)
                        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,0,dash,0 ));
                    else
                    g2d.setStroke(new BasicStroke(0));

                    width=Math.abs((int)EP.getX()-(int)SP.getX());
                    height=Math.abs((int)EP.getY()-(int)SP.getY());
                    Point P = new Point(Math.min((int)SP.getX(), (int)EP.getX()),Math.min((int)SP.getY(), (int)EP.getY()));
                    g2d.drawOval((int)P.getX(), (int)P.getY(), width, height);
                    if(filled)
                        g2d.fillOval((int)P.getX(), (int)P.getY(), width, height);
                    break;
                }
                case 'L':
                {
                    g2d.setColor(brushColor);
                    if(dotted)
                        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,0,dash,0 ));
                    else
                    g2d.setStroke(new BasicStroke(0));

                    g2d.drawLine((int)SP.getX(), (int)SP.getY(), (int)EP.getX(), (int)EP.getY());
                    break;
                }

                case 'E':
                {
                    g2d.setColor(Color.WHITE);
                    g2d.fillOval((int)SP.getX(),(int)SP.getY(),15,15);
                    break;
                }

                case 'H':
                {
                    g2d.setColor(brushColor);
                    g2d.fillOval((int)SP.getX(),(int)SP.getY(),15,15);
                    break;
                }
            }
            g2d.dispose();
        }
        catch (Exception e)
        {
            
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        EP=new Point(e.getX(),e.getY());
        switch(shape)
        {			
            case 'E':
                eraserVec.add(new Eraser(EP));
                drawnShape.add('E');
                break;
            case 'H':
                handVec.add(new Hand(EP,brushColor));
                drawnShape.add('H');
                break;
            
        }
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
        SP=new Point(e.getX(),e.getY());
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
        switch(shape)
        {
            case 'L':
                lineVec.add(new Line(SP,EP,'L',brushColor,dotted));
                drawnShape.add('L');
                break;
            case 'R':
                width=Math.abs((int)EP.getX()-(int)SP.getX());
                height=Math.abs((int)EP.getY()-(int)SP.getY());
                SP = new Point(Math.min((int)SP.getX(), (int)EP.getX()),Math.min((int)SP.getY(), (int)EP.getY()));
                rectVec.add(new Rect(SP,width,height,'R',brushColor,dotted,filled));
                drawnShape.add('R');
                break;
            case 'O':
                
                width=Math.abs((int)EP.getX()-(int)SP.getX());
                height=Math.abs((int)EP.getY()-(int)SP.getY());
                SP = new Point(Math.min((int)SP.getX(), (int)EP.getX()),Math.min((int)SP.getY(), (int)EP.getY()));
                ovelVec.add(new Oval(SP,width,height,'O',brushColor,dotted,filled));
                drawnShape.add('O');
                break;
        }	
        EP=null;
	repaint();
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
    public void draw()
    {
        try
        {
        BufferedImage img=gConfig.createCompatibleImage(2000, 2000, Transparency.BITMASK);
        Graphics g = img.createGraphics();
        Graphics2D g2d = (Graphics2D)g;
                    
        lCounter=rCounter=oCounter=eCounter=hCounter=0;
        float[] dash = {15,15,15};
        for(int i=0;i<drawnShape.size();i++)
        {
            switch(drawnShape.elementAt(i))
            {
                case 'R':
                {
                    if(rectVec.get(rCounter).isDotted())
                        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,0,dash,0 ));
                    else
                        g2d.setStroke(new BasicStroke(0));
                    
                    g2d.setColor(rectVec.get(rCounter).getColor());
                    g2d.drawRect((int)rectVec.get(rCounter).getSP().getX(),(int)rectVec.get(rCounter).getSP().getY(),rectVec.get(rCounter).getWidth(),rectVec.get(rCounter).getHeigth());
                    if (rectVec.get(rCounter).isIsFilled())
                        g2d.fillRect((int)rectVec.get(rCounter).getSP().getX(),(int)rectVec.get(rCounter).getSP().getY(),rectVec.get(rCounter).getWidth(),rectVec.get(rCounter).getHeigth());
                    rCounter++;
                    break;
                }
                case 'O':
                {
                    if(ovelVec.get(oCounter).isDotted())
                        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,0,dash,0 ));
                    else
                        g2d.setStroke(new BasicStroke(0));
                    
                    g2d.setColor(ovelVec.get(oCounter).getColor());
                    g2d.drawOval((int)ovelVec.get(oCounter).getSP().getX(),(int)ovelVec.get(oCounter).getSP().getY(),ovelVec.get(oCounter).getWidth(),ovelVec.get(oCounter).getHeigth());
                    if (ovelVec.get(oCounter).isIsFilled())
                        g2d.fillOval((int)ovelVec.get(oCounter).getSP().getX(),(int)ovelVec.get(oCounter).getSP().getY(),ovelVec.get(oCounter).getWidth(),ovelVec.get(oCounter).getHeigth());
                    oCounter++;
                    break;
                }
                case 'L':
                {
                    if(lineVec.get(lCounter).isDotted())
                        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,0,dash,0 ));
                    else
                        g2d.setStroke(new BasicStroke(0));
                    
                    g2d.setColor(lineVec.get(lCounter).getColor());
                    g2d.drawLine((int)lineVec.get(lCounter).getSP().getX(),(int)lineVec.get(lCounter).getSP().getY(),(int)lineVec.get(lCounter).getEP().getX(),(int)lineVec.get(lCounter).getEP().getY());
                    lCounter++;
                    break;
                }
                
                case 'E':
                {
                    g2d.setColor(eraserVec.get(eCounter).color);
                    g2d.fillOval((int)eraserVec.get(eCounter).getSP().getX(),(int)eraserVec.get(eCounter).getSP().getY(),eraserVec.get(eCounter).width,eraserVec.get(eCounter).heigth);
                    eCounter++;
                    break;
                }
                case 'H':
                {
                    g2d.setColor(handVec.get(hCounter).getColor());
                    g2d.fillOval((int)handVec.get(hCounter).getSP().getX(),(int)handVec.get(hCounter).getSP().getY(),handVec.get(hCounter).width,handVec.get(eCounter).heigth);
                    hCounter++;
                    break;
                }
            }
        }
        
        g.dispose();
        g2d.dispose();
       
            ImageIO.write(img, "png", new File("file.png"));
        
        }
        catch(IOException ex) {}
        catch(Exception e){}
        
    }
}
