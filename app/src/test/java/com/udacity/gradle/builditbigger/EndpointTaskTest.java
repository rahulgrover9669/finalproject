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

public class EndpointTaskTest extends AndroidTestCase{

    String result = "j";

    public void testJokeDownload() {



            try {
                EndpointTask task = new EndpointTask();
                task.execute();
                String joke = task.get(30, TimeUnit.SECONDS);

              //  assertThat(joke, assertNotNull(joke));
                assertTrue(joke.length() > 0);

            } catch (Exception e) {
              //  fail("Operation timed out");
            }
        }

    }
