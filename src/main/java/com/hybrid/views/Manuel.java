package com.hybrid.views;

import com.gluonhq.particle.annotation.ParticleView;
import com.gluonhq.particle.view.FXMLView;
import com.hybrid.controllers.ManuelController;

@ParticleView(name = "manuel", isDefault = false)
public class Manuel extends FXMLView {
    
    public Manuel() {
        super(Manuel.class.getResource("manuel.fxml"));
    }
    
    @Override
    public void start() {
        ((ManuelController) getController()).postInit();
    }
    
    @Override
    public void stop() {
        ((ManuelController) getController()).dispose();
    }
    
}