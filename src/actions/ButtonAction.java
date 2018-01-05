/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import guiFrame.MyFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Ghosh Kakan
 */
public class ButtonAction implements  ActionListener{
    
    private MyFrame frame;
    private int title;
    private int index;
    private int number;
    private String gameOption;
    private int divident ;
    
    public ButtonAction(MyFrame f, String gameOption){
        this.gameOption = gameOption;
        frame = f;
        number = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if( gameOption.equals("option1")){
            numberCounting(e);
        }else if( gameOption.equals("option2") || gameOption.equals("option3")){
            oddNumberCounting(e,gameOption);
        }
        
        
    }
    
   
    // method of number counting
    private void numberCounting(ActionEvent e){
        try {
        
            
         if( frame.getreStartFlag() ){
             number = 0;
             frame.setRestartFlag(false);
             frame.setScoreCounter(0);
             System.out.println(title);
         }
            
        title = Integer.parseInt( e.getActionCommand() );
        index = frame.getHashMap().get(title);
        
        if( frame.getHashMap().get(title) != null ){
            
            
            
                if( title - number == 1){

                    frame.getButton(index).setVisible(false);
                    frame.getButton(index).setStatus(true);
                    frame.getScoreCounter();
                    frame.decrementButtonShow();
                    
                    number = title;
                    
                }else{
                    frame.setButtonShow(0);
                    frame.setGameFlag(false);
                }
        }
            
        } catch (Exception ex) {
            
            System.out.println( ex.getMessage() );
        }
    }
    
    //method odd numcer counting
    private void oddNumberCounting(ActionEvent e , String gameOption){
        
        try {
           
           
           
           if( gameOption.equals("option2")){
               divident = 1;
           }else if( gameOption.equals("option3")){
               divident = 0;
           }
            
         if( frame.getreStartFlag() ){
             
             frame.setRestartFlag(false);
             frame.setScoreCounter(0);
             System.out.println(title);
         }
            
        title = Integer.parseInt( e.getActionCommand() );
        index = frame.getHashMap().get(title);
        
        if( frame.getHashMap().get(title) != null ){
            
            
            
                if( title % 2 == divident){

                    frame.getButton(index).setVisible(false);
                    frame.getButton(index).setStatus(true);
                    frame.getScoreCounter();
                    frame.decrementButtonShow();
                    
                    frame.oddEvenCounter--;
                    
                }else{
                    frame.setButtonShow(0);
                    frame.setGameFlag(false);
                }
        }
            
        } catch (Exception ex) {
            
            System.out.println( ex.getMessage() );
        }
    }
    
}


