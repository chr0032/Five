package com.hybrid.controllers;

import com.gluonhq.particle.application.ParticleApplication;
import com.gluonhq.particle.view.ViewManager;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;

import javax.inject.Inject;
import org.controlsfx.control.action.Action;
import org.controlsfx.control.action.ActionProxy;

import javafx.scene.web.WebView;

public class ManuelController {

    @Inject ParticleApplication app;
    @Inject private ViewManager viewManager;
    
    @FXML
    private WebView webView;
    @FXML private Pane manuel;
    @FXML
    private ResourceBundle resources;
    private Action actionHome;
    WebEngine engine;

    public void initialize() {
    	
    	System.out.println("ManuelController initialize()...");
    	
    	engine = webView.getEngine();
    	
    	engine.load("http://chr0032.dothome.co.kr/project/Manuel.html");
    	
    }
    
    public void postInit() {
        app.getParticle().getToolBarActions().add(0, actionHome);
    }
    
    public void dispose() {
        app.getParticle().getToolBarActions().remove(actionHome);
    }
    
    @ActionProxy(text = "Back")
    private void goHome() {
        viewManager.switchView("primary");
    }
    
}
