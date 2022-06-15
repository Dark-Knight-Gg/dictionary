package com.example.dictionary;
import com.gtranslate.Audio;
import com.gtranslate.Language;
import java.io.InputStream;

import com.sun.speech.freetts.VoiceManager;
public class Speech {
    public void speech(String text) {
        InputStream sound = null;

            Audio audio = Audio.getInstance();
            sound = audio.getAudio(text, Language.ENGLISH);
            audio.play(sound);
    }
}
}
