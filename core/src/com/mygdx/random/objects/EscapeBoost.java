package com.mygdx.random.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.mygdx.game.Berek;
import com.mygdx.players.Player;

public class EscapeBoost extends RandomObject {

	private final float liveTime = 10f;
	
	public EscapeBoost(Berek game) {
		super(game);
		// TODO Auto-generated constructor stub
		
		texture = new Texture("randomObjects/EscapeBoost.png");
		
		Timer.schedule(new Task() {
			
			@Override
			public void run() {
				exist = false;
				
			}
		}, liveTime);
	}	

	@Override
	public void addEffectsToPlayers(Player playerTouchet, Player playerNotTouchet) {
		// TODO Auto-generated method stub
		
	}

}
