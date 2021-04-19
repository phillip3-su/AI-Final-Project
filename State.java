package Scripts;

import java.util.ArrayList;
import java.util.List;

import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.api.model.Entity;
import org.osbot.rs07.api.model.Player;
import org.osbot.rs07.script.Script;

public class State
{
	Player agent;
	Position agentPosition;
	int range = 20;
	Area agentBounds;
	Area consideredArea;
	Area initialArea;
	ArrayList<Entity> knownTrees;
	boolean inventoryFull;
	boolean inventoryEmpty;
	
	public State(Player agent, ArrayList<Entity> knownTrees, boolean inventoryFull, boolean inventoryEmpty)
	{
		this.agent = agent;
		agentPosition = agent.getPosition();
		
		this.inventoryFull = inventoryFull;
		this.inventoryEmpty = inventoryEmpty;
		
		createConsideredArea();
		
		this.knownTrees = knownTrees;
		
	}
	
	public ArrayList<Entity> getConsideredTrees()
	{
		ArrayList<Entity> consideredTrees = new ArrayList<Entity>();
		for(int i = 0; i < knownTrees.size(); i++)
		{
			if(consideredArea.contains(knownTrees.get(i)))
			{
				consideredTrees.add(knownTrees.get(i));
			}
		}
		
		return consideredTrees;
	}
	
	public void createConsideredArea()
	{
		agentPosition = agent.getPosition();
		Position boundsNW = new Position(3136, 3240, 0);
		Position boundsSE = new Position(3266, 3200, 0);
		agentBounds = new Area(boundsNW.getX(), boundsNW.getY(), boundsSE.getX(), boundsSE.getY());
		
		initialArea = agentPosition.getArea(range);
		List<Position> initallyConsideredPositions = initialArea.getPositions();
		
		Position consideredNW = initallyConsideredPositions.get(initallyConsideredPositions.size()-41); //NorthWest Corner
		if(consideredNW.getX() < boundsNW.getX())
		{
			consideredNW = new Position(3136, consideredNW.getY(), consideredNW.getZ());
		}
		if(consideredNW.getY() > boundsNW.getY())
		{
			consideredNW = new Position(consideredNW.getX(), 3240, consideredNW.getZ());
		}
		
		Position consideredSE = initallyConsideredPositions.get(40);                      //SouthEast Corner
		if(consideredSE.getX() > boundsSE.getX())
		{
			consideredSE = new Position(3266, consideredSE.getY(), consideredSE.getZ());
		}
		if(consideredSE.getY() < boundsSE.getY())
		{
			consideredSE = new Position(consideredSE.getX(), 3200, consideredSE.getZ());
		}
		
		consideredArea = new Area(consideredNW, consideredSE);
	}
	
	public Area getConsiderArea()
	{
		return consideredArea;
	}
	
	public Position getAgentPosition()
	{
		return agentPosition;
	}
	
//	ArrayList<Action> getLegalActions()
//	{
//		
//	}
}
