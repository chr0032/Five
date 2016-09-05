package com.hybrid;

import com.gluonhq.particle.application.ParticleApplication;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import static org.controlsfx.control.action.ActionMap.actions;

public class MainApplication extends ParticleApplication {

    public MainApplication() {
        super("Team Five Application");
    }

    @Override
    public void postInit(Scene scene) {
    	scene.getStylesheets().add(MainApplication.class.getResource("style.css").toExternalForm());
        
        setTitle("Team Five Application");

        getParticle().buildMenu("File -> [exit]", "Native -> [BaseBall]", "Webapp -> [Manuel]", "Help -> [about]");
        
        getParticle().getToolBarActions().addAll(actions("---", "about", "exit"));
    }
    
    	public static void main(String[] args) {
			
    		launch(args);
    		
    		
    		
		}
    
    
}