package com.sample;

import gui.Pocetna;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
    	Pocetna p = new Pocetna();
    	p.setVisible(true);
    }

}
