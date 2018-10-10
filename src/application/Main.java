package application;
	

import java.awt.Scrollbar;
import java.io.IOException;
import java.util.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application 
{    
	private String hash = "";
	private static int numGens = 0;
	private int wordLen = 0;
	private String inputSimple = "";
	private static String output = "";
	@Override
    public void start(Stage primaryStage) 
	{
        Button b1 = new Button();
        b1.setText("Encode text");
        Button b2 = new Button();
        b2.setText("Start decoding");
        Button b3 = new Button();
        b3.setText("See learning process for guessing this input:");
        Button b4 = new Button();
        b4.setText("Go to Genetic Process Page");
        Button b5 = new Button();
        b5.setText("Go to Hash Cracker Page");
        Button b6 = new Button();
        b6.setText("Go to Hash Cracker Page");
        Button b7 = new Button();
        b7.setText("Go to Genetic Process Page");
       // b1.setAlignment(new Pos(12, 13, 15, 11));
        Label l1 = new Label("Enter to see hash");
        Label l2 = new Label("Hash to decode:");
        Label l3 = new Label("Hash: ");
        Label l4 = new Label("Decoded string: ");
        Label l5 = new Label("Length of original word (needed and has to be an int)");
        Label l6 = new Label("Enter a string to view the genetic process:");
        Text t5 = new Text();
        Label l8 = new Label("Genetic Machine Learning");
        Label l9 = new Label("This is a showcase of a genetic machine learning algorism I wrote. It contains 2 pages. The Hash Cracker page includes a simple hash encoder, the output from which can be typed into the hash text box. The length of original string also needs to be inputed. The cracker will try to use machine learning to solve this problem that otherwise would be hard to solve using math. In the Genetic Process page, one can see the generations as they learn. Simply input a string and watch the algorism guess it.");
        Label placeHolder = new Label("                ");
        Label placeHolder2 = new Label("                ");
        Label placeHolder3 = new Label("          ");
        Label placeHolder4 = new Label("          ");
        TextField t1 = new TextField();
        TextField t2 = new TextField();
        TextField t3 = new TextField();
        TextField t4 = new TextField();
        Scrollbar s1 = new Scrollbar();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        GridPane grid0 = new GridPane();
        grid0.setAlignment(Pos.CENTER);
        ScrollPane scroll = new ScrollPane();
    	Scene sceneScroll = new Scene(scroll, 800, 600);
        t5.wrappingWidthProperty().bind(sceneScroll.widthProperty());
        scroll.setFitToWidth(true);
        scroll.setContent(t5);
        Stage newWindow = new Stage();
        newWindow.setTitle("Genetic Process");
        newWindow.setScene(sceneScroll);
       
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) 
            {
            	l3.setText("Hash: " + encode(t1.getText()));
            }
        });
        
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) 
            {
            	hash = t2.getText();
            	wordLen = Integer.parseInt(t3.getText());
            	Population p = new Population(50, wordLen);
            	l4.setText(crack(p, hash));
            	numGens = 0;
            }
        });
        
        b3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) 
            {
            	inputSimple = t4.getText();
            	Population p = new Population(50, inputSimple.length());
            	t5.setText(crackSimple(p, inputSimple));
            	newWindow.show();
            	output = "";
            	numGens = 0;
            }
        });
        
        
//        b2.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
////                t.setText(System.getProperty("os.name"));
////                t.setVisible(true);
//            	try 
//            	{
////					String[] cmd = {"mkdir", "thingy"};
////					String[] cmd2 = {"cd", "~"};
//            		Runtime.getRuntime().exec("ssh ironzinc@10.27.3.135");
//            		Runtime.getRuntime().exec("yes");
//            		Runtime.getRuntime().exec(password);
//				} 
//            	catch (IOException e) {
//					e.printStackTrace();
//				}
//            }
//        });
        
        //grid0.getStylesheets().add("application/application.css");
        grid.add(b1, 0, 2);
        grid.add(t1, 0, 1);
        grid.add(l1, 0, 0);
        grid.add(b2, 2, 4);
        grid.add(l2, 2, 0);
        grid.add(t2, 2, 1);
        grid.add(l3, 0, 3);
        grid.add(l4, 2, 5);
        grid.add(t3, 2, 3);
        grid.add(l5, 2, 2);
        grid.add(b4, 4, 1);
        grid.add(placeHolder, 3, 0);
        grid2.add(t4, 0, 1);
        grid2.add(l6, 0, 0);
        grid2.add(b3, 0, 2);
        grid2.add(b5, 2, 1);
        grid2.add(placeHolder2, 1, 0);
        grid0.add(b6, 0, 2);
        grid0.add(b7, 2, 2);
        grid0.add(placeHolder3, 1, 2);
        grid0.add(placeHolder4, 1, 1);
        grid0.add(l8, 1, 0);
        //grid0.add(l9, 1, 2);

        
        
        
        Scene sceneIntro= new Scene(grid0, 800, 600);
        Scene sceneHash = new Scene(grid, 800, 600);
    	Scene sceneGenetic = new Scene(grid2, 800, 600);
        primaryStage.setTitle("Genetic Machine Learning");
        primaryStage.setScene(sceneIntro);
        primaryStage.show();
        
        b4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) 
            {
                primaryStage.setTitle("Genetic Learning Showcase");
                primaryStage.setScene(sceneGenetic);
                primaryStage.show();
            }
        });
        
        b5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) 
            {
                primaryStage.setTitle("Hash Cracker");
                primaryStage.setScene(sceneHash);
                primaryStage.show();
            }
        });
        
        b6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) 
            {
                primaryStage.setTitle("Hash Cracker");
                primaryStage.setScene(sceneHash);
                primaryStage.show();
            }
        });
        
        b7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) 
            {
                primaryStage.setTitle("Genetic Learning Showcase");
                primaryStage.setScene(sceneGenetic);
                primaryStage.show();
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public int encode(String file) //from online
    {
        int hash = 0;
        file = file.toUpperCase();

        for(int i = 0; i < file.length(); i++) {
                hash = (hash * 31 + file.charAt(i)) + 32;
        }
        return hash;
    }
//    public static String crack(Population pop, String target)
//    {	
//    	numGens++;
//    	for(int i = 0; i < pop.getLength(); i++)
//    	{
//    		if(pop.getMember(i).getFitness(target) == 100)
//    		{
//    			return "Word decrypted: " + pop.getMember(i).getWord() + "   number of generations taken: " + numGens;
//    		}
//    	}
//    	if(numGens >= 100)
//    	{
//    		return "cannnot find it";
//    	}
//    	return crack(pop.createChildren(pop.selectFromPopulation(10, 3, target), 4), target);
//    }
//    
    public static String crack(Population pop, String target)
    {	
    	boolean cracked = false;
    	String result = "";
    	while(!cracked)
    	{
    		for(int i = 0; i < pop.getLength(); i++)
    		{
    			if(pop.getMember(i).getFitness(target) == 0)
    	    	{
    	    		cracked = true;
    	    		result = pop.getMember(i).getWord();
    	    	}
    		}
    		if(!cracked)
    		{
    			pop = pop.createChildren(pop.selectFromPopulation(10, 3, target), 4);
    			pop.mutatePop(60);
    			//pop.mutatePop(60);
    			System.out.println("Generation " + numGens);
    		}
    		numGens++;
    	}
    	return "Word decrypted: " + result + "   number of generations taken: " + numGens;
    }
    
    public static String crackSimple(Population pop, String target)
    {	
    	boolean cracked = false;
    	String result = "";
    	addToOutput("\n" + "Generation " + numGens + "\n");
    	pop.mutatePop(30);
    	while(!cracked)
    	{
    		for(int i = 0; i < pop.getLength(); i++)
    		{
    			if(pop.getMember(i).getFitnessSimple(target) == 100)
    	    	{
    	    		cracked = true;
    	    		result = pop.getMember(i).getWord();
    	    	}
    		}
    		if(!cracked)
    		{
    			numGens++;
    			addToOutput("\n" + "Generation " + numGens + "\n");
    			pop = pop.createChildren(pop.selectFromPopulationSimple(10, 3, target), 3);
    			pop.mutatePop(10);
    		}
    	}
    	numGens++;
    	addToOutput("\n" + "Word decrypted: " + result + "   number of generations taken: " + numGens + "\n");
    	return output;
    }
    
    public static void addToOutput(String str)
    {
    	output += str;
    }

    
}

