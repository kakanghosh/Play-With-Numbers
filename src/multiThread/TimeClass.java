/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiThread;

import guiFrame.MyFrame;

/**
 *
 * @author Ghosh Kakan
 */
public class TimeClass extends Thread{

    private MyFrame frame;
    private boolean shutDown;
    private ShowButtonThread btnthread;
    
    public TimeClass(MyFrame f, ShowButtonThread t) {
        frame = f;
        btnthread = t;
    }

    @Override
    public void run() {
    //    super.run(); //To change body of generated methods, choose Tools | Templates.
        
        
        try {
              sleep(1000);
        } catch (Exception e) {
        }
        
        while(!shutDown){
            
          
            
            try {
                
             if( !btnthread.getPauseCondition() && frame.getGameFlag() ){
                   
                frame.time++;

                frame.getTimerLabel().setText("Duration: "+ Integer.toString(frame.time) + " Sec" );
                 sleep(1000);
             }
             
             
                
            } catch (Exception e) {
            }
                
        }
        
        
    }
    
    
    //stop thread
    public void stopThread(){
        shutDown = true;
    }
    
    
    
    
}
