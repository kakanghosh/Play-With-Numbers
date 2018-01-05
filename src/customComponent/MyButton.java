/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customComponent;

/**
 *
 * @author Ghosh Kakan
 */
import javax.swing.JButton;

/**
 *
 * @author Ghosh Kakan
 */
public class MyButton extends JButton{
    
    private boolean status ;
    private static int buttonCounter;

    public MyButton(String number) {
        super(number);
        status = true;
    }
    
    public void setStatus(boolean b){
        status = b;
    }
    
    public boolean getStatus(){
        return status;
    }
    
    
    
    
}
