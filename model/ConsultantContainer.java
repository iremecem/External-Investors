package model;

import java.util.LinkedList;

// TODO: Auto-generated Javadoc
/**
 * A class that holds all of the accounts created in the program.
 * @author Eren Þenoðlu, Batuhan Özçömlekçi
 * @version 23.12.2018
 */


	public class ConsultantContainer {
		
	/** The list. */
	public LinkedList<Consultant> list;
	
	/**
	 * Constructs a new ConsultantContainer object and initializes three objects.
	 */
	public ConsultantContainer()
	{
		list = new LinkedList<Consultant>();
		list.add( new Consultant( 75,42,"Harold Dirksen","You are expecting to get high profit from stocks. Definitely not an easy task, but I'm here to help you !","C:\\Users\\erens\\eclipse-workspace\\Project\\src\\consultantOne.png") );
		list.add( new Consultant( 225,65,"Brian Schwartz","I think you need some good advice about stocks. You came to the right guy.That should be"  
							+  "doable for someone like me, right?","C:\\Users\\erens\\eclipse-workspace\\Project\\src\\consultantTwo.jpg" ) );
		list.add( new Consultant( 475,95,"Matthew Hedberg","You are expecting to get high profit from stocks. Definitely not an easy task, but I'm here to help you !","C:\\Users\\erens\\eclipse-workspace\\Project\\src\\consultantThree.jpg" ) );
	} 
	/**
	 * Returns the consultant object with given ID.
	 * @param ID the ID of the consultant.
	 * @return the consultant
	 */
	public Consultant getConsultant(int ID) {
		return list.get(ID);
		
	}
}
