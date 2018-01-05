/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiThread;

import guiFrame.*;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author Ghosh Kakan
 */
public class ShowButtonThread extends Thread{
    
       private MyFrame frame;
       private boolean shutDown;
       private Random randomNumber;
       private int indexNumber;
       private volatile int titleNumber;
       private int sleepTimer;
       private volatile boolean pause;
       private String gameOption = null;
       private Random ranValue;
       private int value;
       private boolean even = false;
  
      
       
       public ShowButtonThread(MyFrame f , String gameOption){
           
           this.gameOption = gameOption;
           
           this.frame = f;
           shutDown = false;
           randomNumber = new Random();
           ranValue = new Random();
           titleNumber = 1;
           pause = false;
           sleepTimer = 800;
       }
    
       
    @Override
    public void run() {
        
            try {
                sleep(1000);
            } catch (Exception e) {
            }
        
           if( gameOption.equals("option1") ){
              
               frame.setTitle("Number Counting");
               numberCounting();
           }else if(gameOption.equals("option2")){
               
               frame.setTitle("Find The Odd Number");
               oddEvenCounter();
           }else if(gameOption.equals("option3") ){
               
               frame.setTitle("Find The Even Number");
               oddEvenCounter();
           }
        
    }
    
    
    //stop the threads
    public  void stopThread(){
         
         try {
            
            frame.setButtonCondition(false);           
            frame.getPauseButton().setEnabled(false);
            shutDown = true;
            
            frame.setGameFlag(false);
            
            JOptionPane.showMessageDialog(null,"Game Over \n score is : "+ frame.getScore(),"Game Over" , JOptionPane.YES_NO_CANCEL_OPTION);
            frame.setScoreCounter(0);
            
        } catch (Exception e) {
        }
    }
    
    //pause method
    public void pauseThread(){
         
        try {
              if( !pause){
              System.out.println("Thread has been paused");
              pause = true;
              
              frame.getPauseButton().setText("Start");
              frame.setButtonCondition(false);
              
         }else{
              System.out.println("Thread has been played again");
              pause = false;
              
              frame.getPauseButton().setText("Pause");
              frame.setButtonCondition(true);
        }
          
           //sleep(200);   
              
        } catch (Exception e) {
        }
    }
    
    
    //restart thread method
    
    public void restartThread(){
        try {
          //  sleep(100);
            
            frame.setButtonCondition(true);
            shutDown = true;
            frame.setScoreCounter(0);
            
            for( int i = 0; i < 25; i++){
                frame.getButton(i).setVisible(false);
                frame.getButton(i).setStatus(true);
            }
            
            frame.getPauseButton().setEnabled(true);
            frame.oddEvenCounter = 0;
            
        } catch (Exception e) {
        }
        
    }
 
    //get pause method
    public boolean getPauseCondition(){
        return pause;
    }
       
    //set pause method
    public void setPauseCondition( boolean f){
        pause = f;
    }
    
    
    // numberCounting process
    public void numberCounting(){
        
          while(!shutDown ){
 
            try {
   
                indexNumber = randomNumber.nextInt(25); // generate random number
                
                if( frame.getButton(indexNumber).getStatus() && !pause){
                
                    
                    
                    frameOptionController();
                    gameMotionController(); // game motion controller method
                    
                  //  if(frame.getGameFlag())
                      sleep(sleepTimer);
                    
                    titleNumber++;
                }
                
            } catch (Exception e) {
                
                System.out.println( e.getMessage() );
            }
            
        }
    }
    
    
    // odd Counting method
    public void oddEvenCounter(){
        
        while(!shutDown ){
 
            try {
                 
                
   
                indexNumber = randomNumber.nextInt(25); // generate random number
                
                if( frame.getButton(indexNumber).getStatus() && !pause){
                    
                    
                    value = ranValue.nextInt(200);
                    

                    if( gameOption.equals("option2") ){
                        
                        if( value % 2 != 0){
                            frame.oddEvenCounter++;
                        }
                    }else if( gameOption.equals("option3") ){
                        
                        if( value % 2 == 0){
                            frame.oddEvenCounter++;
                        }
                    }
                    
                    
                    
                    System.out.println( frame.oddEvenCounter );
                    
                    frame.getHashMap().put(value, indexNumber); // put Title (as key) and index (as value )
                    frame.getButton(indexNumber).setText( Integer.toString(value) );
                    frame.getButton(indexNumber).setVisible(true);  // Set Button visibily True 
                    frame.getButton(indexNumber).setStatus(false);  // Set Button status false
                    
                    frame.incrementButtonShow();
                    
                   if( ( frame.getNoOfButtonShow() == 25 && frame.oddEvenCounter > 0) || !frame.getGameFlag()){
                         
                         System.out.println("Wrong button");
                         System.out.println("game setting one");
                         stopThread();
                          
                        // break;
                        
                     }else if( frame.getNoOfButtonShow() >= 23 && frame.oddEvenCounter == 0 ){
                
                                 for( int i = 0; i < 25; i++){
                                    frame.getButton(i).setVisible(false);
                                    frame.getButton(i).setStatus(true);
                                 }

                                frame.setButtonShow(0);
                            //    frame.setGameFlag(false);
                                
                               
                            
                     }
                   
                   
                    gameMotionController(); // game motion controller method
                    
                  //  if(frame.getGameFlag())
                      sleep(sleepTimer);
                    
                    
                }
                
            } catch (Exception e) {
                
                System.out.println( e.getMessage() );
            }
            
        }
    }
   
    
    //Game motion controller method
    private void gameMotionController() {
         
         
                     if( frame.getScore() > 15 && frame.getScore() < 30  ){                  
                         sleepTimer = 780;
                    }else  if( frame.getScore() > 30 && frame.getScore() < 45  ){                  
                         sleepTimer = 750;
                    }else if( frame.getScore() > 45 && frame.getScore() < 60  ){                  
                         sleepTimer = 700;
                    }else if( frame.getScore() > 60 && frame.getScore() < 75  ){                  
                         sleepTimer = 680;
                    }else  if( frame.getScore() > 75 && frame.getScore() < 100  ){                  
                         sleepTimer = 650;
                    } if( frame.getScore() > 100  ){                  
                         sleepTimer = 600;
                    }
     }
    
    //frame controller method
    private void frameOptionController() {
        
                    frame.getHashMap().put(titleNumber, indexNumber); // put Title (as key) and index (as value )
                    frame.getButton(indexNumber).setText( Integer.toString(titleNumber) );
                    frame.getButton(indexNumber).setVisible(true);  // Set Button visibily True 
                    frame.getButton(indexNumber).setStatus(false);  // Set Button status false
                    
                    frame.incrementButtonShow();
                    
                   if(frame.getNoOfButtonShow() == 25 || !frame.getGameFlag()){
                         
                         System.out.println("Wrong button");
                         frame.setGameFlag(false);
                         System.out.println("game setting two");
                         stopThread();
                        // break;
                     }
    }
    
    
}
