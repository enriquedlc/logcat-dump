package com.example.logcatdump;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;

public class LogcatManager {

    private static final String TAG = "LogcatManager";
    private static final String LOGCAT_FILE_NAME = "logcat.txt";

    public static void saveLogcatToFile() {
        File logcatFile = new File(Environment.getExternalStorageDirectory(), LOGCAT_FILE_NAME);
        try {
            if (!logcatFile.exists()) {
                logcatFile.createNewFile();
            }

            // Comando para volcar el logcat en un archivo
            String[] command = new String[]{"logcat", "-d", "-f", logcatFile.getAbsolutePath()};
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();

            Log.i(TAG, "Logcat saved to " + logcatFile.getAbsolutePath());
        } catch (IOException | InterruptedException e) {
            Log.e(TAG, "Failed to save logcat to file", e);
        }
    }
}