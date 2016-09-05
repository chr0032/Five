package com.hybrid.controllers;

import com.gluonhq.particle.application.ParticleApplication;
import com.gluonhq.particle.view.ViewManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import javax.inject.Inject;
import org.controlsfx.control.action.Action;
import org.controlsfx.control.action.ActionMap;
import org.controlsfx.control.action.ActionProxy;

public class BaseBallController {

    @FXML
    private Button btnstart;
    @FXML
    private Button btnclick;
    @FXML
    private Label label1;
    @FXML
    private TextField txt1;
    @FXML
    private TextField txt2;
    @FXML 
    private TextField txt3;
    @FXML
    private TextArea txtarea;
    @FXML
    private ImageView img1;
    @FXML
    private Button btnmanuel;
    @FXML
    private ResourceBundle resources;
    
    private int[] pitcher = {0,0,0}; 		//랜덤생성된 숫자 저장될 변수
    private int[] batter = {0,0,0};  		//내가 넣은 숫자가 저장될 변수
    private int strike = 0;					//스트라이크 카운트
    private int ball4 = 0;					//볼넷 카운트
    private int ballnumber = 0;				//회차 저장 1~10회까지         
    private String ingGame = " ";			//게임진행상황 저장
    private int status = 0;					//경기끝 상황 변수
    
    public void initialize() {
    	
    	btnstart.setOnAction(e -> {
    		
    			System.out.println("prepare for game......");
    			
    			Random r = new Random();
    			EndGame();
    		
			    		for(int i=0; i<3; i++) {
			    			pitcher[i] = r.nextInt(10);    			
			    				for(int a = 0; a<i; a++) {
			    					if(pitcher[a] == pitcher[i]) {
			    						i--;
			    					}		
			    				}
			    			}
				    			System.out.print(pitcher[0]);
				    			System.out.print(pitcher[1]);
				    			System.out.println(pitcher[2]);
	    });
    	
    	btnclick.setOnAction(e -> {
    		
    		System.out.println("Pitching and Batting!");
    			
    			try {
					
	    			if(pitcher[0] == 0 && pitcher[1] == 0 && pitcher[2] == 0) {
	    				
	    				txt1.setText("");
	    				txt2.setText("");
	    				txt3.setText("");
	    				txtarea.setText("Ready 버튼을 먼저 눌러주세요! ^^");
	    		
	    			} 
	    				
	    			if(Integer.valueOf(txt1.getText())>= 10) {
		    			
		    			txt1.setText("");
		    			txt2.setText("");
		    			txt3.setText("");
		    			txtarea.setText("두자리수 이상의 숫자를 입력하지 마세요! 숫자를 다시 입력해 주세요 ^^");
		    					    		
	    			}
		    				    				
		    		if(Integer.valueOf(txt2.getText())>= 10) {
		    				    					
		    			txt1.setText("");
		    			txt2.setText("");
		    			txt3.setText("");
		    			txtarea.setText("두자리수 이상의 숫자를 입력하지 마세요! 숫자를 다시 입력해 주세요 ^^");
		    					    			
		    		}
		    				    				
		    		if(Integer.valueOf(txt3.getText())>= 10) {
		    				                		
		    			txt1.setText("");
		    			txt2.setText("");
		    			txt3.setText("");
		    			txtarea.setText("두자리수 이상의 숫자를 입력하지 마세요! 숫자를 다시 입력해 주세요 ^^");
		    					                	
		    		}			
	    				
	    			batter[0] = Integer.parseInt(txt1.getText());
	    			batter[1] = Integer.parseInt(txt2.getText());
	    			batter[2] = Integer.parseInt(txt3.getText());
	    				
	    				if(batter[0]==batter[1] || batter[1]==batter[2] || batter[0]==batter[2]) {
	    					
	    					txt1.setText("");
	    					txt2.setText("");
	    					txt3.setText("");
	    					txtarea.setText("같은 숫자가 중복되었습니다! 다시 숫자를 입력해주세요 ^^");
	    							
	    				} else {
	    								
	    					for(int i=0; i<3; i++) {
	    						for(int a=0; a<3; a++) {
	    							if(pitcher[i]==batter[a]) {
	    								if(a==i) {
	    									strike = strike+1;		
	    								} else {
	    									ball4 = ball4+1;		
	    								}
	    							}
	    						}
	    					}
	                	
	    			ingGame = ingGame + (ballnumber+1) + "회 :   " + batter[0] + "  -  " + batter[1] + "  -  " + batter[2] + "     "
								      + "[" + String.valueOf(strike) + "스트라이크 / " + String.valueOf(ball4) + "볼" + "]" + "\n";  
					System.out.println("스트라이크 : " + strike + "/볼넷 : " + ball4);
					ballnumber = ballnumber+1;
					txtarea.setText(ingGame);	
					status = 0;
 	
					if(ballnumber>9) {
						status = 1;
						EndGame();
					}
								    			
					if(strike>2) {
						status = 1;
						EndGame();
					}
								    			
					if(ball4>3) {
						status = 1;
						EndGame();
					}  
					
	    	   }	
	    				
    	} catch (NumberFormatException e2) {
			txt1.setText("");
			txt2.setText("");
			txt3.setText("");
		}
    });	
}
    
	public void EndGame() {
    	
    	if(status==0){
    		   txt1.setText("");
    		   txt2.setText("");
    		   txt3.setText("");
        	   txtarea.setText("");
    	}
    	
        if(status==1){
    	       ingGame = ingGame +"정답 :     " + pitcher[0] + "  -  " + pitcher[1] + "  -  " + pitcher[2] + "     " +"게임종료!";
    	       txtarea.setText(ingGame);
        }
        
			   pitcher[0] = 0; pitcher[1] = 0; pitcher[2] = 0;
			   batter[0] = 0; batter[1] = 0; batter[2] = 0;
			   strike = 0;
			   ball4 = 0;
			   ballnumber = 0;              
			   ingGame = " ";
			   status = 0;
			   
    	}
    
    /*
     * Gluon Framework 관련
     */
    
    @Inject ParticleApplication app;
    @Inject private ViewManager viewManager;
    @Inject MenuBar menuBar;
    private Action actionHome; 
    private Menu menu;
    
    public void init() {
       ActionMap.register(this);
       actionHome =  ActionMap.action("goHome");
       
       app.getParticle().buildMenu("BaseBall Game -> [goHome, clear, item2]");
       menu = menuBar.getMenus().remove(menuBar.getMenus().size()-1);
   }
    
    public void postInit() {
        app.getParticle().getToolBarActions().add(actionHome);//add(0, actionHome) 하면 숫자가 앞에 위치하게 만듬.
        removeMenu();
        menuBar.getMenus().add(menu);
    }
    
    public void dispose() {
        app.getParticle().getToolBarActions().remove(actionHome);
        removeMenu();
    }
    
    void removeMenu(){
       for (int i = 0; i < menuBar.getMenus().size(); i++) {
          if(menuBar.getMenus().get(i).getText().equals(menu.getText())){
             menuBar.getMenus().remove(i);
             i--;
          }
       }
    }
    
    @ActionProxy(text = "Home")
    private void goHome() {
        viewManager.switchView("primary");
    }
    
    @ActionProxy(text = "Clear")
    private void clear() {
        System.out.println("BaseBallController.clear()...");
    
    }
    
    @ActionProxy(text = "Item2")
    private void item2() {
        System.out.println("BaseBallController.item2()...");
    }
}