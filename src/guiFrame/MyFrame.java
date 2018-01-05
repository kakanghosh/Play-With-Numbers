/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiFrame;


import actions.ButtonAction;
import java.awt.*;
import javax.swing.*;
import customComponent.*;
import java.awt.event.*;
import java.util.*;
import multiThread.ShowButtonThread;
import multiThread.TimeClass;



/**
 *
 * @author Ghosh Kakan
 */
public class MyFrame extends javax.swing.JFrame {
     
    
    private MyButton[] number;
    private int num;
    private int buttonIndex;
    private int numberOfButton;
    private int score;
    private int index;
    private boolean gameFlag;
    private int buttonShow;
    private ButtonAction action;
    private HashMap<Integer, Integer> mapButton;
    private ShowButtonThread t;
    private boolean restartFlag = false;
    private String gameOption = null;
    public int oddEvenCounter;
    public int time;
    public boolean pause;
    public TimeClass timer;
    
    /**
     * Creates new form MyFrame
     */
  
    public MyFrame(String gameOption) {
        
        this.gameOption = gameOption;
        
        initComponents();
        
        initilize();
        
       startGameThread();
       
        
        
        
    }
    
    
    //start the thread
    public void startGameThread(){
          t = new ShowButtonThread(this,gameOption);
          t.start();
          
        timer = new TimeClass(this, t);
        timer.start();
    }
    
    
    //odd even counter
    public int getOddEvenCounter(){
        return oddEvenCounter;
    }
    
    
    /**
    * Initialize the 
    * component and design the game interface
    */
    public void initilize(){
        
        int xCoor = 6, yCoor = 8;  // first x, y cordinate gapes between button
        numberOfButton = 25;   
        score = 0;
        index = 0;
        buttonShow = 0;
        buttonIndex = 0;
        gameFlag = true;
        
        scoreCounter.setFont( new Font("Sans-Sarif", Font.BOLD, 20) );
        
        number = new MyButton[numberOfButton]; // array of buttons
        mapButton = new HashMap<Integer,Integer>(); // creating hash map object

        
        for( int i = 0; i < numberOfButton/5; i++){
           
            for( int j = 0; j < numberOfButton/5; j++){
            
                number[buttonIndex] = new MyButton( Integer.toString(++num) ); // setting the titles of the button
                number[buttonIndex].setBounds(xCoor,yCoor,80,65); // set position and of the button
                number[buttonIndex].setVisible(false);
                number[buttonIndex].setFont( new Font("Garamond", Font.BOLD, 25) );
                
                
                gamePanel.add(number[buttonIndex]);  // adding buttons to the panel

                xCoor+= 80;  // setting the position after of a button by its x cordinates
                buttonIndex++; // increment button index 
                index++;  // increment the indeces

                }

                xCoor = 6; // for new row setting button
                yCoor += 66; 
        }
        
        
        setTitle("Number Counting v1.1");  // setting the game title
        scoreCounter.setText("0"); // score Counter
        
        setupActions(); // calling setup action method
        
        
        
    }
    
    /*
    Adding action listener
    for every button
    */
    
    private void setupActions(){
     
        action = new ButtonAction(this,gameOption);
        
        for( int i = 0; i < numberOfButton; i++){
             
            number[i].addActionListener(action);
        
        }
        
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                t.pauseThread();
                
                
                
            }
        });
        
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                  mapButton.clear();
                
                  t.restartThread();
    
                  gameFlag = true;
                  buttonShow = 0;
                  scoreCounter.setText("0");
                  restartFlag = true;
                  
                  time = 0;
                  
                  timer.stopThread();
                  
                  startGameThread();
            }
            
        });
        
       
                
        
    }
    
    // set button condition
    public void setButtonCondition(boolean f){
       
        
        for( int i = 0; i < numberOfButton; i++){
                    number[i].setEnabled(f);
                }
    }
    
    //get restart flag method
    public boolean getreStartFlag(){
        return restartFlag;
    }
    
    //set restart flag
    public void setRestartFlag(boolean f){
        restartFlag = f;
    }
   
    /*
       score counter method
    */
    public void getScoreCounter(){
        
        score++;
        scoreCounter.setText( Integer.toString(score) );
    } 
    
    //get score method
    
    public int getScore(){
        return score;
    }
    
    //set score
    public void setScoreCounter(int s){
        score = s;
    }
    
    /**
     * 
     * @param index
     * @return 
     * Button getting method
     */
    public MyButton getButton(int index){
        return number[index];
    }
    
    
    
   
    /*
    set game flag
    */
    public void setGameFlag(boolean f){
        gameFlag = f;
    }
    
    /*
    get game flag
    */
    public  boolean getGameFlag(){
        return gameFlag;
    }
    
    /*
    increment s=button show
    */
    
    public void incrementButtonShow(){
        buttonShow++;
    }
    
    /*
    decrement s=button show
    */
    
    public void decrementButtonShow(){
        buttonShow--;
    }
    
    /*
    get no of button show
    */
    
    public int getNoOfButtonShow(){
        return buttonShow;
    }
    
    /*
    set button show
    */
    public void setButtonShow(int n){
        buttonShow = n;
    }
    
    
    //get hash map table
    public HashMap<Integer,Integer> getHashMap(){
        return mapButton;
    }
    
    //get pause button
    public JButton getPauseButton(){
        return pauseButton;
    }
    
    
    //get timer label
    public JLabel getTimerLabel(){
        return timerLabel;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gamePanel = new javax.swing.JPanel();
        scorePanel = new javax.swing.JPanel();
        scoreBoardLabel = new javax.swing.JLabel();
        scoreSeparator = new javax.swing.JSeparator();
        scoreCounter = new javax.swing.JLabel();
        pauseButton = new javax.swing.JButton();
        restartButton = new javax.swing.JButton();
        timePanel = new javax.swing.JPanel();
        timerLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Number Counting   v 1.1");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        gamePanel.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 412, Short.MAX_VALUE)
        );
        gamePanelLayout.setVerticalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        scorePanel.setBackground(new java.awt.Color(102, 204, 255));

        scoreBoardLabel.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        scoreBoardLabel.setText("Score Board");

        scoreCounter.setText("score");

        javax.swing.GroupLayout scorePanelLayout = new javax.swing.GroupLayout(scorePanel);
        scorePanel.setLayout(scorePanelLayout);
        scorePanelLayout.setHorizontalGroup(
            scorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scorePanelLayout.createSequentialGroup()
                .addGroup(scorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scorePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scoreSeparator))
                    .addGroup(scorePanelLayout.createSequentialGroup()
                        .addGroup(scorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(scorePanelLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(scoreBoardLabel))
                            .addGroup(scorePanelLayout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(scoreCounter)))
                        .addGap(0, 62, Short.MAX_VALUE)))
                .addContainerGap())
        );
        scorePanelLayout.setVerticalGroup(
            scorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scorePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scoreBoardLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scoreSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(scoreCounter)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pauseButton.setText("Pause");

        restartButton.setText("Restart");

        timerLabel.setText("Duration: ");

        javax.swing.GroupLayout timePanelLayout = new javax.swing.GroupLayout(timePanel);
        timePanel.setLayout(timePanelLayout);
        timePanelLayout.setHorizontalGroup(
            timePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timePanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(timerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addContainerGap())
        );
        timePanelLayout.setVerticalGroup(
            timePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(timerLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scorePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addComponent(timePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(pauseButton)
                            .addGap(18, 18, 18)
                            .addComponent(restartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(timePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(restartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(scorePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(683, 409));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    
           //    System.out.println("Clsing...");
              
              t.setPauseCondition(true);
              setButtonCondition(false);
              
              int n = JOptionPane.showConfirmDialog(null, "Are You Sure? " , "Exit", JOptionPane.YES_NO_OPTION);
               
               if( n == JOptionPane.YES_OPTION ){
                   
                   dispose();
                   new GameMenu().setVisible(true);
                         
               }else{
                   t.setPauseCondition(false);
                   setButtonCondition(true);
               }
          
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gamePanel;
    private javax.swing.JButton pauseButton;
    private javax.swing.JButton restartButton;
    private javax.swing.JLabel scoreBoardLabel;
    private javax.swing.JLabel scoreCounter;
    private javax.swing.JPanel scorePanel;
    private javax.swing.JSeparator scoreSeparator;
    private javax.swing.JPanel timePanel;
    private javax.swing.JLabel timerLabel;
    // End of variables declaration//GEN-END:variables
}
