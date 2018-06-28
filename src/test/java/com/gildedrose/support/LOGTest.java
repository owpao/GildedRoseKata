package com.gildedrose.support;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class LOGTest {
    @Test
    public void messageDebugTest(){
        LOG.LOG_4J_CONFIGURED = true;
        LOG.debug("test");
    }

    @Test(expected = RuntimeException.class)
    public void messageDebugWillNotWorkSinceLOG4JisNotConfigured(){
        LOG.LOG_4J_CONFIGURED = false;
        LOG.debug("TEST");
    }

}