package com.hybrid.views;

import com.gluonhq.particle.annotation.ParticleView;
import com.gluonhq.particle.view.FXMLView;
import com.hybrid.controllers.BaseBallController;

@ParticleView(name = "baseball", isDefault = false)
public class BaseBallGame extends FXMLView {
    
    public BaseBallGame() {
        super(BaseBallGame.class.getResource("baseball.fxml"));
    }
    
    
    @Override
   	public void init() {
       	((BaseBallController) getController()).init();
   	}
    
    @Override
    public void start() {
        ((BaseBallController) getController()).postInit();
    }
    
    @Override
    public void stop() {
        ((BaseBallController) getController()).dispose();
    }
    
}
