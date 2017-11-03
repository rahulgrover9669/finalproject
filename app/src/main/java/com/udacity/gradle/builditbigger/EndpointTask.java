package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;
import android.widget.Toast;

import com.example.JavaJokes;
import com.example.mylibrary.MainActivity2;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by Rahul on 22/10/2017.
 */

public class EndpointTask extends AsyncTask<String,String, String> {

    private static com.example.rahul.myapplication.backend.myApi.MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(String... params) {

        if (myApiService == null) {  // Only do this once
            com.example.rahul.myapplication.backend.myApi.MyApi.Builder builder = new com.example.rahul.myapplication.backend.myApi.MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    // "https://cloud-182806.appspot.com/_ah/api/
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

    //    context = params[0].first;
      //  String name = params[0].second;

        try {
            return myApiService.sayHi(name).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }


    }


   @Override
    protected void onPostExecute(String o) {
        super.onPostExecute(o);
        Log.d("TAG","RETURNVAL"+String.valueOf(o));
        if(taskCompleteListener!=null){
            taskCompleteListener.OnComplete(result);
            Log.d("TASG","RESULTTTTT"+o.toString());
        }
        else {
            Log.d("TASG","RESULTTTTT");
        }
    }

    public static interface TaskCompleteListener {
        public void OnComplete(String message);
    }
}
