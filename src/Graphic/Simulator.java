package Graphic;

import java.awt.*;
import javax.swing.ImageIcon;
import java.lang.String;

public class Simulator 
{

    private DisplayFrame myDisplayer;  //JFrame
    private Circle myCircle;
    private Rectangle myRectangle;
    int PosX=200,PosY=50;
    int DirX=PosX%10+10;
    int DirY=PosY%10+10;
    int radio=10;
    int PosX2=160,PosY2=150;
    int DirX2=PosX2%10+10;
    int DirY2=PosY2%10+10;
    int radio2=10;

    //constructor
    public Simulator(DisplayFrame myDisplayer_)
    {
        this.setMyDisplayer(myDisplayer_);
        this.setMyCircle(new Circle());
        this.setMyRectangle(new Rectangle());

        //valores de las figuras
        myCircle.setHeight(60);
        myCircle.setWidth(70);
        myRectangle.setHeight(75);
        myRectangle.setWidth(100);
    }

    
    //ciclo infinito para mover las figuras
    public void startSimulation(int waitingTime) throws InterruptedException 
    {
        //ciclo infinito
        while (true)
        {
            this.moveShapes();
            this.createImages();

            //pone en espera el flujo del programa
            Thread.sleep(waitingTime);
        }
    }//end method


    //cambio los valores de las variables de las figuras que tengo
    public void moveShapes() {
        PosX+=DirX;
        PosY+=DirY;
        
        if ((PosX-radio)<=0) {
            DirX*=-1;
        }else if ((PosX+radio)>=myDisplayer.getWidth()-70) {
            DirX*=-1;
        }
        if ((PosY-radio)<=0) {
            DirY*=-1;
        }else if ((PosY+radio)>=myDisplayer.getHeight()-70) {
            DirY*=-1;
        }
        
//        int x = (int) (Math.random() * (myDisplayer.getWidth() - 100));
//        int y = (int) (Math.random() * (myDisplayer.getHeight() - 100));
        getMyCircle().setRow(PosY);
        getMyCircle().setColumn(PosX);

        PosX2+=DirX2;
        PosY2+=DirY2;
        
        if ((PosX2-radio2)<=0) {
            DirX2*=-1;
        }else if ((PosX2+radio2)>=myDisplayer.getWidth()-90) {
            DirX2*=-1;
        }
        if ((PosY2-radio2)<=0) {
            DirY2*=-1;
        }else if ((PosY2+radio2)>=myDisplayer.getHeight()-70) {
            DirY2*=-1;
        }
//        x = (int) (Math.random() * (myDisplayer.getWidth() - 100));
//        y = (int) (Math.random() * (myDisplayer.getHeight() - 100));
        getMyRectangle().setRow(PosY2);
        getMyRectangle().setColumn(PosX2);
    }

    //coloca nuevos valores aleatorios en las figuras
    public void createImages()
    {
        myDisplayer.initImage();
        Graphics graphic = myDisplayer.getGraphicsImage();

        graphic.setColor(Color.BLUE);
        graphic.fillOval(getMyCircle().getColumn(),
                getMyCircle().getRow(),
                getMyCircle().getWidth(),
                getMyCircle().getHeight());

        graphic.setColor(Color.PINK);
        graphic.fillRect(getMyRectangle().getColumn(),
                getMyRectangle().getRow(),
                getMyRectangle().getWidth(),
                getMyRectangle().getHeight());

        myDisplayer.paintAgain();
    }



    //**************************************************************************
    /*     metodos accesores      */

    public Circle getMyCircle() {
        return myCircle;
    }

    public void setMyCircle(Circle myCircle) {
        this.myCircle = myCircle;
    }

    public DisplayFrame getMyDisplayer() {
        return myDisplayer;
    }

    public void setMyDisplayer(DisplayFrame myDisplayer) {
        this.myDisplayer = myDisplayer;
    }

    public Graphic.Rectangle getMyRectangle() {
        return myRectangle;
    }

    public void setMyRectangle(Graphic.Rectangle myRectangle) {
        this.myRectangle = myRectangle;
    }
    

}
