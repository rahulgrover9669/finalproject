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

public class EndpointTaskTest extends TestCase{
    private static final String result = "My Own Joke";
    private String finalresult = "dsas";
    @Override
    public void setUp() throws Exception {
        super.setUp();

    }

    public void testName() throws Exception {
     //   assertTrue("Match",result.equals("My Own Joke"));
        EndpointTask endpointTask = new EndpointTask();
      endpointTask.setListener(new EndpointTask.TaskCompleteListener() {
            @Override
            public void OnComplete(String message) {
                finalresult = message;
                assertTrue("Joke",message.equals(result));
            }
        }).execute("xyz");
        System.out.println(finalresult);
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }


}
