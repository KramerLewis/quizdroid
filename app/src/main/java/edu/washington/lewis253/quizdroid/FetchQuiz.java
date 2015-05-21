package edu.washington.lewis253.quizdroid;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class FetchQuiz extends Service {
    public FetchQuiz() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return 0;
    }




    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
