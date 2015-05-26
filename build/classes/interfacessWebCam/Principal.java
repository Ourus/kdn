/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfacessWebCam;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import javax.swing.JFrame;

/**
 *
 * @author Adriano
 */
public class Principal {
    public static void main(String[] args) {
        JFrame window = new JFrame("Painel de Teste");
        window.add(new WebcamPanel(Webcam.getDefault()));
        window.pack();
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
