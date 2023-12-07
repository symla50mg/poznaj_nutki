import enums.Notes;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Utilities {

    public static String getSoundPath(Notes note) {
        switch (note) {
            case NOTE_C:
                return "src/sounds/C.wav";
            case NOTE_D:
                return "src/sounds/D.wav";
            case NOTE_E:
                return "src/sounds/E.wav";
            case NOTE_F:
                return "src/sounds/F.wav";
            case NOTE_G:
                return "src/sounds/G.wav";
            case NOTE_A:
                return "src/sounds/A.wav";
            case NOTE_H:
                return "src/sounds/H.wav";
            case NOTE_CIS:
                return "src/sounds/CIS.wav";
            case NOTE_DIS:
                return "src/sounds/DIS.wav";
            case NOTE_FIS:
                return "src/sounds/FIS.wav";
            case NOTE_GIS:
                return "src/sounds/GIS.wav";
            case NOTE_B:
                return "src/sounds/B.wav";
            default:
                return "src/sounds/C.wav";
        }
    }

    public static String getImagePath(Notes note) {
        switch (note) {
            case NOTE_C:
                return "src/images/C.png";
            case NOTE_D:
                return "src/images/D.png";
            case NOTE_E:
                return "src/images/E.png";
            case NOTE_F:
                return "src/images/F.png";
            case NOTE_G:
                return "src/images/G.png";
            case NOTE_A:
                return "src/images/A.png";
            case NOTE_H:
                return "src/images/H.png";
            case NOTE_CIS:
                return "src/images/CIS.png";
            case NOTE_DIS:
                return "src/images/DIS.png";
            case NOTE_FIS:
                return "src/images/FIS.png";
            case NOTE_GIS:
                return "src/images/GIS.png";
            case NOTE_B:
                return "src/images/B.png";
            default:
                return "src/images/C.png";
        }
    }

    public static void playSound(Notes note, Clip clip, AudioInputStream sound){
        try{
            sound = AudioSystem.getAudioInputStream(new File(Utilities.getSoundPath(note)));
            clip = AudioSystem.getClip();
            clip.open(sound);
            clip.start();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
