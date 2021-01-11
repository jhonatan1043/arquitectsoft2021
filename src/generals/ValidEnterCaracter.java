/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generals;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Poseidon
 */
public class ValidEnterCaracter {

    public static void validNum(KeyEvent evt, javax.swing.JInternalFrame form) {

        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            form.getToolkit().beep();
            evt.consume();
        } else if ((int) evt.getKeyChar() > 32 && (int) evt.getKeyChar() <= 47
                || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
                || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
            form.getToolkit().beep();
            evt.consume();
        }
    }

    public static void validMaxCaracter(JTextField field,
            KeyEvent evt, int limite,
            javax.swing.JInternalFrame form) {

        if (field.getText().length() >= limite) {
            evt.consume();
            form.getToolkit().beep();
        }
    }
}
