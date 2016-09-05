package com.hybrid.actions;

import com.gluonhq.particle.annotation.ParticleActions;
import com.gluonhq.particle.application.ParticleApplication;
import com.gluonhq.particle.view.ViewManager;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.inject.Inject;
import org.controlsfx.control.action.ActionProxy;

@ParticleActions
public class MenuActions {

    @Inject ParticleApplication app;
    @Inject ViewManager viewManager;
    
    @ActionProxy(text="Exit", accelerator="alt+F4")
    private void exit() {
        app.exit();
    }
    
    @ActionProxy(text="BaseBall Game")
    private void BaseBall() {
    	System.out.println("Menu BaseBall Game Item clicked....");
    	viewManager.switchView("baseball");
    }   
    
    @ActionProxy(text="Manuel")
    private void Manuel() {
    	System.out.println("Menu Manuel Item clicked....");
    	viewManager.switchView("manuel");
    } 
    
    @ActionProxy(text="About")
    private void about() {
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Team Five Application");
        alert.setHeaderText("About Team Five Application");
        alert.setGraphic(new ImageView(new Image(MenuActions.class.getResource("/icon.png").toExternalForm(), 48, 48, true, true)));
        alert.setContentText("This is a Team Five Application");
        alert.showAndWait();
    }
    
  
}