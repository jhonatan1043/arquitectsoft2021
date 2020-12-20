/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generals;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author Poseidon
 */
public class ValidarAlfaNumerico {

    public void validarNumerico(JTextField field) {
        field.addKeyListener(new KeyAdapter() {
            public void KeyTyped(KeyEvent event) {
                char caracter = event.getKeyChar();
                if (!Character.isDigit(caracter) && caracter != '.') {
                    event.consume();
                }
                if (caracter == '.' && field.getText().contains(".")) {
                    event.consume();
                }
            }
        });
    }
}
