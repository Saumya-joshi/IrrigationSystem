package irrigationSystem;

import java.awt.AlphaComposite;

import java.awt.Color;

import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.BasicStroke;
import java.awt.EventQueue;
import java.awt.RenderingHints;

class Helper extends JPanel implements ActionListener{

	private final int DELAY = 150;
    private Timer timer;

    float opacity = 1.0f;
    final static int CYCLE_TIME = 1000;
    long cycleStart; 
    boolean linear = true;
    
    int flagColor=1;
    
    public Helper() {

        initTimer();
    }

    private void initTimer() {

        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    public Timer getTimer() {
        
        return timer;
    }
	
    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);
        
//        BasicStroke bs1 = new BasicStroke(8, BasicStroke.CAP_BUTT,
//                BasicStroke.JOIN_BEVEL);
//        g2d.setStroke(bs1);
//        g2d.setPaint(Color.blue);
//        g2d.drawLine(20, 30, 250, 30);

        BasicStroke bs2 = new BasicStroke(8, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_BEVEL);      

        
        Graphics2D gFade = (Graphics2D) g.create();
        gFade.setComposite(AlphaComposite.SrcOver.derive(opacity));
        
        //switchColor=switchColor%10;
        if(opacity==0){
        	if(flagColor==1)
        		flagColor=0;
        	else
        		flagColor=1;
        }
        
    	if(flagColor==1)
    		gFade.setColor(Color.red);
    	else
    		gFade.setColor(Color.orange);
        
        
        gFade.setStroke(bs2);
        //CIRCLE 1
        gFade.drawLine(175, 70, 60, 280);
        gFade.drawLine(200, 100, 200, 600);
        gFade.drawLine(210, 70, 420, 450);
        gFade.drawLine(240, 40, 545, 40);
        //CIRCLE 2    
        //gFade.setColor(Color.yellow);
        gFade.drawLine(90, 370, 200, 600);
        gFade.drawLine(100, 360, 350, 430);
        gFade.drawLine(110, 350, 545, 350);
        //CIRCLE 3
        gFade.drawLine(250, 610, 545, 610);
        gFade.drawLine(200, 580, 420, 200);
        //CIRCLE 4
        gFade.drawLine(410, 200, 410, 400);
        
        //CIRCLE 6
        gFade.drawLine(1110, 70, 1205, 280);
        gFade.drawLine(1100, 100, 1100, 600);
        gFade.drawLine(1100, 70, 900, 450);
        gFade.drawLine(1050, 40, 755, 40);
        //CIRCLE 7        
        gFade.drawLine(1160, 300, 900, 210);
        gFade.drawLine(1200, 360, 1130, 570);
        gFade.drawLine(1155, 310, 755, 310);
        //CIRCLE 8
        gFade.drawLine(1050, 610, 755, 610);
        gFade.drawLine(1090, 580, 920, 200);
        //CIRCLE 9
        gFade.drawLine(900, 200, 900, 400);
                
        
        BasicStroke bs4 = new BasicStroke();
        g2d.setStroke(bs4);
        
        int w = getWidth();
        int h = getHeight();

        Random r = new Random();

        for (int i = 0; i < 100000; i++) {
        	g2d.setPaint(Color.blue);
            int x = Math.abs(r.nextInt(750-550)+550) ;
            int y = Math.abs(r.nextInt(650-10)+10) ;
            g2d.drawLine(x, y, x, y);
        }
        
//CIRCLE 1
        
        Ellipse2D.Double hole = new Ellipse2D.Double();
        hole.width = 100;
        hole.height = 100;
        hole.x = 150;
        hole.y = 10;
        g2d.setStroke(bs2);
        g2d.setPaint(Color.blue);
        g2d.draw(hole);
        g2d.setPaint(Color.green);
        g2d.fill(hole);
        g2d.setPaint(Color.blue);
        g2d.drawLine(253, 53, 360, 170);
        g2d.drawLine(243, 93, 350, 210);
        g2d.setStroke(bs4);
        for (int i = 0; i < 250; i++) {
        	g2d.setPaint(Color.blue);
        	int x,y;
        	x = Math.abs(r.nextInt(350-335)+335) ;
            y = Math.abs(r.nextInt(200-190)+190) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(350-330)+330) ;
            y = Math.abs(r.nextInt(190-180)+180) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(360-320)+320) ;
            y = Math.abs(r.nextInt(180-170)+170) ;
            g2d.drawLine(x, y, x, y);       
            x = Math.abs(r.nextInt(355-310)+310) ;
            y = Math.abs(r.nextInt(170-160)+160) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(345-300)+300) ;
            y = Math.abs(r.nextInt(160-150)+150) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(335-290)+290) ;
            y = Math.abs(r.nextInt(150-140)+140) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(325-280)+280) ;
            y = Math.abs(r.nextInt(140-130)+130) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(315-270)+270) ;
            y = Math.abs(r.nextInt(130-120)+120) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(305-260)+260) ;
            y = Math.abs(r.nextInt(120-110)+110) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(295-250)+250) ;
            y = Math.abs(r.nextInt(110-100)+100) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(290-245)+245) ;
            y = Math.abs(r.nextInt(100-90)+90) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(285-245)+245) ;
            y = Math.abs(r.nextInt(90-80)+80) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(275-250)+250) ;
            y = Math.abs(r.nextInt(80-70)+70) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(260-250)+250) ;
            y = Math.abs(r.nextInt(70-60)+60) ;
            g2d.drawLine(x, y, x, y);
        }
        
//CIRCLE 2
       
        hole.width = 100;
        hole.height = 100;
        hole.x = 10;
        hole.y = 280;
        g2d.setStroke(bs2);
        g2d.setPaint(Color.blue);
        g2d.draw(hole);
        g2d.setPaint(Color.green);
        g2d.fill(hole);
        g2d.setPaint(Color.blue);
        g2d.drawLine(105, 300, 350, 210);
        g2d.drawLine(113, 340, 370, 240);
        g2d.setStroke(bs4);
        for (int i = 0; i < 500; i++) {
        	g2d.setPaint(Color.blue);
        	int x,y;
        	x = Math.abs(r.nextInt(125-110)+110) ;
            y = Math.abs(r.nextInt(340-320)+320) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(150-125)+125) ;
            y = Math.abs(r.nextInt(330-320)+320) ;
            g2d.drawLine(x, y, x, y);  
        	x = Math.abs(r.nextInt(175-110)+110) ;
            y = Math.abs(r.nextInt(320-310)+310) ;
            g2d.drawLine(x, y, x, y);      
            x = Math.abs(r.nextInt(200-110)+110) ;
            y = Math.abs(r.nextInt(310-300)+300) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(230-120)+120) ;
            y = Math.abs(r.nextInt(300-290)+290) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(255-150)+150) ;
            y = Math.abs(r.nextInt(290-280)+280) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(280-175)+175) ;
            y = Math.abs(r.nextInt(280-270)+270) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(305-205)+205) ;
            y = Math.abs(r.nextInt(270-260)+260) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(330-230)+230) ;
            y = Math.abs(r.nextInt(260-250)+250) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(355-260)+260) ;
            y = Math.abs(r.nextInt(250-240)+240) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(365-285)+285) ;
            y = Math.abs(r.nextInt(240-230)+230) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(355-315)+315) ;
            y = Math.abs(r.nextInt(230-220)+220) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(350-340)+340) ;
            y = Math.abs(r.nextInt(220-210)+210) ;
            g2d.drawLine(x, y, x, y);
        }
        
//CIRCLE 3
        
        hole.width = 100;
        hole.height = 100;
        hole.x = 150;
        hole.y = 550;
        g2d.setStroke(bs2);
        g2d.setPaint(Color.blue);
        g2d.draw(hole);
        g2d.setPaint(Color.green);
        g2d.fill(hole);
        g2d.setPaint(Color.blue);
        g2d.drawLine(233, 557, 350, 450);
        g2d.drawLine(255, 595, 370, 490);
        g2d.setStroke(bs4);
        for (int i = 0; i < 350; i++) {
        	g2d.setPaint(Color.blue);
        	int x,y;
        	x = Math.abs(r.nextInt(265-250)+250) ;
            y = Math.abs(r.nextInt(590-580)+580) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(280-245)+245) ;
            y = Math.abs(r.nextInt(580-570)+570) ;
            g2d.drawLine(x, y, x, y);  
        	x = Math.abs(r.nextInt(290-240)+240) ;
            y = Math.abs(r.nextInt(570-560)+560) ;
            g2d.drawLine(x, y, x, y);      
            x = Math.abs(r.nextInt(300-235)+235) ;
            y = Math.abs(r.nextInt(560-550)+550) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(310-245)+245) ;
            y = Math.abs(r.nextInt(550-540)+540) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(320-260)+260) ;
            y = Math.abs(r.nextInt(540-530)+530) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(330-270)+270) ;
            y = Math.abs(r.nextInt(530-520)+520) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(340-280)+280) ;
            y = Math.abs(r.nextInt(520-510)+510) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(355-290)+290) ;
            y = Math.abs(r.nextInt(510-500)+500) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(365-305)+305) ;
            y = Math.abs(r.nextInt(500-490)+490) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(365-315)+315) ;
            y = Math.abs(r.nextInt(490-480)+480) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(355-325)+325) ;
            y = Math.abs(r.nextInt(480-470)+470) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(355-335)+335) ;
            y = Math.abs(r.nextInt(470-460)+460) ;
            g2d.drawLine(x, y, x, y);
        }
        
//CIRCLE 4
        
        hole.width = 100;
        hole.height = 100;
        hole.x = 350;
        hole.y = 150;
        g2d.setStroke(bs2);
        g2d.setPaint(Color.blue);
        g2d.draw(hole);
        g2d.setPaint(Color.green);
        g2d.fill(hole);
        g2d.setPaint(Color.blue);
        g2d.drawLine(450, 180, 550, 180);
        g2d.drawLine(450, 220, 550, 220);
        g2d.setStroke(bs4);
        for (int i = 0; i < 3000; i++) {
        	g2d.setPaint(Color.blue);
            int x = Math.abs(r.nextInt(550-450)+450) ;
            int y = Math.abs(r.nextInt(220-180)+180) ;
            g2d.drawLine(x, y, x, y);
        }
        
//CIRCLE 5
        
        hole.width = 100;
        hole.height = 100;
        hole.x = 350;
        hole.y = 400;
        g2d.setStroke(bs2);
        g2d.setPaint(Color.blue);
        g2d.draw(hole);
        g2d.setPaint(Color.green);
        g2d.fill(hole);
        g2d.setPaint(Color.blue);
        g2d.drawLine(450, 430, 550, 430);
        g2d.drawLine(450, 470, 550, 470);
        g2d.setStroke(bs4);
        for (int i = 0; i < 3000; i++) {
        	g2d.setPaint(Color.blue);
            int x = Math.abs(r.nextInt(550-450)+450) ;
            int y = Math.abs(r.nextInt(470-430)+430) ;
            g2d.drawLine(x, y, x, y);
        }
        
//CIRCLE 6
        
        hole.width = 100;
        hole.height = 100;
        hole.x = 1050;
        hole.y = 10;
        g2d.setStroke(bs2);
        g2d.setPaint(Color.blue);
        g2d.draw(hole);
        g2d.setPaint(Color.green);
        g2d.fill(hole);
        g2d.setPaint(Color.blue);
        g2d.drawLine(1045, 55, 940, 170);
        g2d.drawLine(1055, 95, 950, 210);
        g2d.setStroke(bs4);
        for (int i = 0; i < 250; i++) {
        	g2d.setPaint(Color.blue);
        	int x,y;
        	x = Math.abs(r.nextInt(965-950)+950) ;
            y = Math.abs(r.nextInt(200-190)+190) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(975-950)+950) ;
            y = Math.abs(r.nextInt(190-180)+180) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(985-945)+945) ;
            y = Math.abs(r.nextInt(180-170)+170) ;
            g2d.drawLine(x, y, x, y);       
            x = Math.abs(r.nextInt(990-945)+945) ;
            y = Math.abs(r.nextInt(170-160)+160) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(1000-955)+955) ;
            y = Math.abs(r.nextInt(160-150)+150) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(1010-965)+965) ;
            y = Math.abs(r.nextInt(150-140)+140) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(1020-975)+975) ;
            y = Math.abs(r.nextInt(140-130)+130) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(1030-985)+985) ;
            y = Math.abs(r.nextInt(130-120)+120) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(1040-995)+995) ;
            y = Math.abs(r.nextInt(120-110)+110) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(1045-1005)+1005) ;
            y = Math.abs(r.nextInt(110-100)+100) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(1055-1010)+1010) ;
            y = Math.abs(r.nextInt(100-90)+90) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(1055-1020)+1020) ;
            y = Math.abs(r.nextInt(90-80)+80) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(1050-1030)+1030) ;
            y = Math.abs(r.nextInt(80-70)+70) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(1050-1040)+1040) ;
            y = Math.abs(r.nextInt(70-60)+60) ;
            g2d.drawLine(x, y, x, y);
        }
        
        
//CIRCLE 7
       
        hole.width = 100;
        hole.height = 100;
        hole.x = 1150;
        hole.y = 280;
        g2d.setStroke(bs2);
        g2d.setPaint(Color.blue);
        g2d.draw(hole);
        g2d.setPaint(Color.green);
        g2d.fill(hole);
        g2d.setPaint(Color.blue);
        g2d.drawLine(1147, 322, 940, 415);
        g2d.drawLine(1157, 362, 950, 450);
        g2d.setStroke(bs4);
        for (int i = 0; i < 500; i++) {
        	g2d.setPaint(Color.blue);
        	int x,y;
        	x = Math.abs(r.nextInt(975-950)+950) ;
            y = Math.abs(r.nextInt(445-435)+435) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(998-950)+950) ;
            y = Math.abs(r.nextInt(435-425)+425) ;
            g2d.drawLine(x, y, x, y);  
        	x = Math.abs(r.nextInt(1020-940)+940) ;
            y = Math.abs(r.nextInt(425-415)+415) ;
            g2d.drawLine(x, y, x, y);      
            x = Math.abs(r.nextInt(1040-955)+955) ;
            y = Math.abs(r.nextInt(415-405)+405) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(1065-975)+975) ;
            y = Math.abs(r.nextInt(405-395)+395) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(1090-1000)+1000) ;
            y = Math.abs(r.nextInt(395-385)+385) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(1115-1025)+1025) ;
            y = Math.abs(r.nextInt(385-375)+375) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(1135-1045)+1045) ;
            y = Math.abs(r.nextInt(375-365)+365) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(1155-1065)+1065) ;
            y = Math.abs(r.nextInt(365-355)+355) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(1150-1085)+1085) ;
            y = Math.abs(r.nextInt(355-345)+345) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(1150-1110)+1110) ;
            y = Math.abs(r.nextInt(345-335)+335) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(1150-1130)+1130) ;
            y = Math.abs(r.nextInt(335-325)+325) ;
            g2d.drawLine(x, y, x, y);
        }
        
        
//CIRCLE 8
        
        hole.width = 100;
        hole.height = 100;
        hole.x = 1050;
        hole.y = 550;
        g2d.setStroke(bs2);
        g2d.setPaint(Color.blue);
        g2d.draw(hole);
        g2d.setPaint(Color.green);
        g2d.fill(hole);
        g2d.setPaint(Color.blue);
        g2d.drawLine(1065, 560, 950, 450);
        g2d.drawLine(1047, 597, 930, 490);
        g2d.setStroke(bs4);
        for (int i = 0; i < 350; i++) {
        	g2d.setPaint(Color.blue);
        	int x,y;
        	x = Math.abs(r.nextInt(1050-1037)+1037) ;
            y = Math.abs(r.nextInt(595-580)+580) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(1055-1025)+1025) ;
            y = Math.abs(r.nextInt(580-570)+570) ;
            g2d.drawLine(x, y, x, y);  
        	x = Math.abs(r.nextInt(1060-1015)+1015) ;
            y = Math.abs(r.nextInt(570-560)+560) ;
            g2d.drawLine(x, y, x, y);      
            x = Math.abs(r.nextInt(1060-1000)+1000) ;
            y = Math.abs(r.nextInt(560-550)+550) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(1050-990)+990) ;
            y = Math.abs(r.nextInt(550-540)+540) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(1040-980)+980) ;
            y = Math.abs(r.nextInt(540-530)+530) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(1030-970)+970) ;
            y = Math.abs(r.nextInt(530-520)+520) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(1020-960)+960) ;
            y = Math.abs(r.nextInt(520-510)+510) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(1005-950)+950) ;
            y = Math.abs(r.nextInt(510-500)+500) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(995-940)+940) ;
            y = Math.abs(r.nextInt(500-490)+490) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(985-935)+935) ;
            y = Math.abs(r.nextInt(490-480)+480) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(975-945)+945) ;
            y = Math.abs(r.nextInt(480-470)+470) ;
            g2d.drawLine(x, y, x, y);
            x = Math.abs(r.nextInt(965-950)+950) ;
            y = Math.abs(r.nextInt(470-460)+460) ;
            g2d.drawLine(x, y, x, y);
        }
        
        
        
//CIRCLE 9
        
        hole.width = 100;
        hole.height = 100;
        hole.x = 850;
        hole.y = 150;
        g2d.setStroke(bs2);
        g2d.setPaint(Color.blue);
        g2d.draw(hole);
        g2d.setPaint(Color.green);
        g2d.fill(hole);
        g2d.setPaint(Color.blue);
        g2d.drawLine(850, 180, 750, 180);
        g2d.drawLine(850, 220, 750, 220);
        g2d.setStroke(bs4);
        for (int i = 0; i < 3000; i++) {
        	g2d.setPaint(Color.blue);
            int x = Math.abs(r.nextInt(850-750)+750) ;
            int y = Math.abs(r.nextInt(220-180)+180) ;
            g2d.drawLine(x, y, x, y);
        }
        
//CIRCLE 10
        
        hole.width = 100;
        hole.height = 100;
        hole.x = 850;
        hole.y = 400;
        g2d.setStroke(bs2);
        g2d.setPaint(Color.blue);
        g2d.draw(hole);
        g2d.setPaint(Color.green);
        g2d.fill(hole);
        g2d.setPaint(Color.blue);
        g2d.drawLine(850, 430, 750, 430);
        g2d.drawLine(850, 470, 750, 470);
        g2d.setStroke(bs4);
        for (int i = 0; i < 3000; i++) {
        	g2d.setPaint(Color.blue);
            int x = Math.abs(r.nextInt(850-750)+750) ;
            int y = Math.abs(r.nextInt(470-430)+430) ;
            g2d.drawLine(x, y, x, y);
        }
        
        g2d.setStroke(bs2);
        g2d.setPaint(Color.blue);
        g2d.drawLine(550, 10, 550, 175);
        g2d.drawLine(550, 225, 550, 425);
        g2d.drawLine(550, 475, 550, 650);
        g2d.drawLine(750, 10, 750, 175);
        g2d.drawLine(750, 225, 750, 425);
        g2d.drawLine(750, 475, 750, 650);
        
        gFade.dispose(); 
        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	long currentTime = System.nanoTime() / 1000000;
        long totalTime = currentTime - cycleStart;
        if (totalTime > CYCLE_TIME) {
          cycleStart = currentTime;
        }
        float fraction = (float) totalTime / CYCLE_TIME;
        fraction = Math.min(1.0f, fraction);
        fraction = 1 - Math.abs(1 - (2 * fraction));
        animate(fraction);
     
    }
    
    public void animate(float fraction) {
        float animationFactor;
       
        animationFactor = (float) Math.sin(fraction * (float) Math.PI / 2);

        animationFactor = Math.min(animationFactor, 1.0f);
        animationFactor = Math.max(animationFactor, 0.0f);
        
        opacity = animationFactor;
        repaint();
      }
    
}

public class RiverGraphics extends JFrame {

	 public RiverGraphics() {

	        initUI();
	    }
	    
	    private void initUI() {
	    	
	    	final Helper surface = new Helper();
	        add(surface);
	      
	        addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
	                Timer timer = surface.getTimer();
	                timer.stop();
	            }
	        });
	        
	        setTitle("Canal Structure");
	        setSize(1300, 700);
	        setLocationRelativeTo(null); 
	        setVisible(true);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	    }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                RiverGraphics ex = new RiverGraphics();
                ex.setVisible(true);
            }
        });
		
	}

}
