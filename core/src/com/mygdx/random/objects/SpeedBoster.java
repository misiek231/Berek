package com.mygdx.random.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.mygdx.game.Berek;
import com.mygdx.players.Player;


public class SpeedBoster extends RandomObject {

	private static final long serialVersionUID = 1L;
	
	
	
	private final float addSpeed = 3f;
	private final float workTime = 10f;
	private final float liveTime = 10f;
	
	
	public SpeedBoster(Berek game) {		
		super(game);
		
		texture = new Texture("randomObjects/SpeedBost.png");
		
		Timer.schedule(new Task() {
			
			@Override
			public void run() {
				//exist = false;
				
			}
		}, liveTime);
	}


	@Override
	public void addEffectsToPlayers(final Player player) {
		
		player.playerSpeed += addSpeed;
		
		Timer.schedule(new Task() {
			
			@Override
			public void run() {
				player.playerSpeed -= addSpeed;
				
			}
		}, workTime);
		
	}
}
