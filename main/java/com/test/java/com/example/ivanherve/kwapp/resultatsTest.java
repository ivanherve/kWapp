package com.example.ivanherve.kwapp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ivan HERVE on 15-11-17.
 */
public class resultatsTest {

    resultats relsult;

    @Test
    public void getResult() throws Exception {
        assertEquals(2043.0,relsult.getResultOnIndex(0));
    }

    @Test
    public void getTextViewValeur1() throws Exception {

    }

}