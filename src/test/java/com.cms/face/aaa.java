package com.cms.face;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;

import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core.IplImage;

import static com.googlecode.javacv.cpp.opencv_core.cvReleaseImage;

/**
 *
 * Use JavaCV/OpenCV to capture camera images
 *
 * There are two functions in this demo:
 * 1) show real-time camera images
 * 2) capture camera images by mouse-clicking anywhere in the JFrame,
 * the jpg file is saved in a hard-coded path.
 *
 * @author ljs
 * 2011-08-19
 *
 */
public class aaa {

        public static String savedImageFile = "c:\\tmp\\my.jpg";

        //timer for image capture animation
        static class TimerAction implements ActionListener {
            private Graphics2D g;
            private CanvasFrame canvasFrame;
            private int width,height;

            private int delta=10;
            private int count = 0;

            private Timer timer;
            public void setTimer(Timer timer){
                this.timer = timer;
            }

            public TimerAction(CanvasFrame canvasFrame){
                this.g = (Graphics2D)canvasFrame.getCanvas().getGraphics();
                this.canvasFrame = canvasFrame;
                this.width = canvasFrame.getCanvas().getWidth();
                this.height = canvasFrame.getCanvas().getHeight();
            }
            public void actionPerformed(ActionEvent e) {
                int offset = delta*count;
                if(width-offset>=offset && height-offset >= offset) {
                    g.drawRect(offset, offset, width-2*offset, height-2*offset);
                    canvasFrame.repaint();
                    count++;
                }else{
                    //when animation is done, reset count and stop timer.
                    timer.stop();
                    count = 0;
                }
            }
        }

        public static void main(String[] args) throws Exception {
            //open camera source
            OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
            grabber.start();

            //create a frame for real-time image display
            CanvasFrame canvasFrame = new CanvasFrame("Camera");
            IplImage image = grabber.grab();
            int width = image.width();
            int height = image.height();
            canvasFrame.setCanvasSize(width, height);

            //onscreen buffer for image capture
            final BufferedImage bImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D bGraphics = bImage.createGraphics();

            //animation timer
            TimerAction timerAction = new TimerAction(canvasFrame);
            final Timer timer=new Timer(10, timerAction);
            timerAction.setTimer(timer);

            //click the frame to capture an image
            canvasFrame.getCanvas().addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    timer.start(); //start animation
                    try {
                        ImageIO.write(bImage, "jpg", new File(savedImageFile));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            });

            //real-time image display
            while(canvasFrame.isVisible() && (image=grabber.grab()) != null){
                if(!timer.isRunning()) { //when animation is on, pause real-time display
                    canvasFrame.showImage(image);
                    //draw the onscreen image simutaneously
                    bGraphics.drawImage(image.getBufferedImage(),null,0,0);
                }
            }

            //release resources
            cvReleaseImage(image);
            grabber.stop();
            canvasFrame.dispose();
        }

    }


