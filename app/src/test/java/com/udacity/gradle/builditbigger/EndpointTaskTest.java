package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.content.Context;
import android.test.ApplicationTestCase;
import android.util.Pair;

import com.example.JavaJokes;

import junit.textui.TestRunner;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by Rahul on 23/10/2017.
 */

public class EndpointTaskTest extends TestRunner {
    public EndpointTaskTest() {
        super();
    }

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void name() throws Exception {

        new EndpointTask().execute(new Pair<Context, String>(Application.class.newInstance().getApplicationContext(), JavaJokes.Joker()));


        assertTrue(true);
    }

    @Test
    public void doInBackground() throws Exception {

    }

    @Test
    public void onPostExecute() throws Exception {

    }




}