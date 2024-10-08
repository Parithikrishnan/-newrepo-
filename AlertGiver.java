import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AlertGiver {
    private Timer timer;
    private String musicFilePath;

    public AlertGiver(String musicFilePath) {
        this.musicFilePath = musicFilePath;
        this.timer = new Timer();
    }

    public void setAlarm(int hour, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);

        long delay = calendar.getTimeInMillis() - System.currentTimeMillis();
        if (delay < 0) {
            delay += 24 * 60 * 60 * 1000; 
        }

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                playMusic();
            }
        }, delay);
    }

    private void playMusic() {
        try {
            File musicFile = new File(musicFilePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AlertGiver alarmClock = new AlertGiver("C:\\waste\\hello.wav");
        Scanner inputGetter = new Scanner(System.in);
        String inputGetting = inputGetter.nextLine();
        String[] hour = inputGetting.split("/");
        System.out.println("Alarm set for " + hour[0] + ":" + hour[1] + "pm");
        alarmClock.setAlarm(Integer.parseInt(hour[0]), Integer.parseInt(hour[1])); 
    }
}
