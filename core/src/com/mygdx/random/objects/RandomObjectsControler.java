package com.mygdx.random.objects;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.mygdx.game.Berek;

public class RandomObjectsControler {

	Berek game;
	SpriteBatch batch;
	
	int removeObjectIndex = -1;
	
	int randomObjectNumber = 0;
	
	List<RandomObject> randomObjects;
	
	public RandomObjectsControler(Berek game, SpriteBatch batch) {
		
		this.game = game;
		this.batch = batch;
		
		randomObjects = new ArrayList<RandomObject>();
	}
	
	public void startRandom(){
		
		Timer.schedule(new Task(){

			@Override
			public void run() {
			
				if(randomObjectNumber < 3){
					
					switch (MathUtils.random(1,4)) {
					
						case 1:
						
							randomObjects.add(new SpeedBoster(game)); 
							System.out.println("object added");
						
							break;
							
						case 2:
							
							randomObjects.add(new SlowPlayerObject(game)); 
							System.out.println("object added");
						
							break;
							
						case 3:
							
							randomObjects.add(new EscapeBoost(game)); 
							System.out.println("object added");
						
							break;
							
						case 4:
							
							randomObjects.add(new TimeBoost(game)); 
							System.out.println("object added");
						
							break;
						
						default:
							break;
					}	
					
					
				}	
			}
		}, 1, 1);	
		
	}	
	
	public void drowObjects(){
		
		removeObjectIndex = -1;
		
		for (RandomObject randomObject : randomObjects) {
			
			if(game.player1.overlaps(randomObject)){
				
				randomObject.addEffectsToPlayers(game.player1 , game.player2);	
				randomObject.exist = false;
			}
		
			if(game.player2.overlaps(randomObject)){
				
				randomObject.addEffectsToPlayers(game.player2, game.player1);		
				randomObject.exist = false;
			}
			
			batch.draw(randomObject.getTexture(), randomObject.getX(), randomObject.getY(), randomObject.getWidth(), randomObject.getHeight());
			
			if(!randomObject.exist)
				removeObjectIndex = randomObjects.indexOf(randomObject);

			
			System.out.println(removeObjectIndex);
		}	
		
		if(removeObjectIndex != -1){
			
			randomObjects.remove(removeObjectIndex);
		}
	}	
}
