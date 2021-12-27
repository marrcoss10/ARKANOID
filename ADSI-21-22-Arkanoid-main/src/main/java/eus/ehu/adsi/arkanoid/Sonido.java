package eus.ehu.adsi.arkanoid;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sonido {
    public void reproducir(){
        //se busca el fichero de audio
        File file = new File("src/main/resources/Vitality_-_Electro_Shock_Sport_Dance.wav");
        AudioInputStream audioStream = null;
        try {
            audioStream = AudioSystem.getAudioInputStream(file);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        try {
            clip.open(audioStream);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //se ejecuta el clip
        clip.start();
    }
}
