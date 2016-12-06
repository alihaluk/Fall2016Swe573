package tr.edu.boun.healthtracker.app;

import android.app.Application;

import com.splunk.mint.Mint;

/**
 * Created by haluks on 01/11/2016.
 */

public class HTApp extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();

        Mint.initAndStartSession(this, "e3d2958f");
    }
}
