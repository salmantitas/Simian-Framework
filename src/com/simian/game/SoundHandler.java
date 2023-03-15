package com.simian.game;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class SoundHandler {
    int MAX_CLIP = 30;
    Clip clip;
    URL soundURL[] = new URL[MAX_CLIP];

    public SoundHandler() {
        initializeSounds();
    }

    private void initializeSounds() {
        // GAME CODE //

    }

    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {

        }
    }

    public void playMusic(int i) {
        setFile(i);
        play();
        loop();
    }

    public void stopMusic(int i) {
        clip.stop();
    }

    public void playSound(int i) {
        setFile(i);
        play();
    }

    private void play() {
        clip.start();
    }

    private void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
