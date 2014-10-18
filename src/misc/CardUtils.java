package DS.misc;

import java.util.Random;


public class CardUtils {
	
	/*
	 * This method randomly shuffles a deck of cards
	 * Input: Array of card objects
	 * Output: Array of card objects
	 */
	
	public static Object[] shuffle(Object[] inputSet)
	{
		if (inputSet==null||inputSet.length==0)
			return null;
		else
		{

			
			Random random = new Random(new java.util.Date().getTime());
			
			for(int i=0;i<inputSet.length;i++)
			{
				int randomIndex = i;
				
				while(randomIndex == i)
				{
					randomIndex = random.nextInt(inputSet.length-1);
				}
				
				swap(inputSet, i,randomIndex);
			}
			return inputSet;
		}	
		
	}
	
	private static void swap(Object[] inputSet, int i, int randomIndex) {

		Object temp = inputSet[i];
		inputSet[i] = inputSet[randomIndex];
		inputSet[randomIndex] = temp;
		
	}
	
	/*
	 * This method randomly deals a deck of cards equally among a given number of players.
	 * Any remainder is discarded.
	 * Input: Array of card objects
	 * Output: Array of lists, each list depicts an individual player's collection.
	 * 
	 * parameter startCard: index of starting card, starts at 0 , ends at inputSet's size -1
	 * parameter chunkSize: cannot be 0 or lesser, cannot be larger than inputSet's size 
	 * parameter numPlayers: cannot be 0 or lesser, cannot be larger than inputSet's size 
	 * parameter startPlayer: index of starting player, starts at 0 , ends at numPlayer's size -1
	 */

	public static java.util.List[] deal(Object[] inputSet,int startCard,int chunkSize,int numPlayers,int startPlayer)
	{
		if(!validated(inputSet,startCard,chunkSize,numPlayers,startPlayer))
			return null;
		else
		{
			java.util.List[] output = new java.util.List[numPlayers];
			int roundVolume = chunkSize*numPlayers; 
			Object[] shiftedSet = shiftToStart(inputSet,startCard);
			
			int curPos =0;
			while(true)
			{
				if(curPos+roundVolume>shiftedSet.length)
				{
					int remainder = shiftedSet.length - curPos;
					if(remainder>=numPlayers)
					{
						chunkSize = remainder/numPlayers;
						roundVolume = chunkSize*numPlayers; 
					}
					else
						break;
				}
					
				
				int playerPos = startPlayer;
				
				for(int i=0;i<numPlayers;i++)
				{
					if(output[playerPos]==null)
						output[playerPos] = new java.util.ArrayList();
					
					for(int j=0;j<chunkSize;j++)
					{
						output[playerPos].add(shiftedSet[curPos++]);
					}
					
					playerPos = (playerPos+1)%numPlayers;
				}
			}
			
			return output;
			
		}
		
	}

	private static boolean validated(Object[] inputSet, int startPoint,
			int chunkSize, int numPlayers,int startPlayer) {
		
		
			boolean validSet = inputSet!=null&&inputSet.length>0;
			if(!validSet)
			{
				System.out.println("No cards given");
				return false;
			}
				
			boolean validStart = startPoint>=0&&startPoint<inputSet.length;
			if(!validStart)
				System.out.println("Invalid starting point min: 0, max: "+(inputSet.length-1));
			
			boolean validChunk = chunkSize>0&&chunkSize<=inputSet.length;
			if(!validChunk)
				System.out.println("Invalid Chunk size min: 1, max: "+(inputSet.length));
			
			boolean validPlayers = numPlayers>0&&numPlayers<=inputSet.length;
			if(!validPlayers)
			{
				System.out.println("Invalid number of Players min: 1, max: "+(inputSet.length));
				return false;
			}
				
			boolean validStartPlayer = startPlayer>=0&&startPlayer<numPlayers;
			if(!validStartPlayer)
				System.out.println("Invalid starting player min: 0, max: "+(numPlayers-1));
			
			return validSet&&validStart&&validChunk&&validPlayers&&validStartPlayer;
		
		
		
		
	}

	private static Object[] shiftToStart(Object[] inputSet, int startPoint) {
		
		if(startPoint == 0)
			return inputSet;
		else
		{
			Object[] shiftedSet = new Object[inputSet.length];
			 
			for(int i =0;i<shiftedSet.length;i++)
			{
				shiftedSet[i]= inputSet[startPoint];
				startPoint = (startPoint+1)%shiftedSet.length;
			}		
			
			return shiftedSet;
		}
		
		
	}


	
	
	public static void main(String args[])
	{
		//testShuffle();
		testDeal();
	}
	
	private static void testDeal()
	{
		Object[] cards1 = new Object[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17"};
		Object[] cards2 = new Object[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};
		
//		java.util.List[] deal1 = deal(cards1,0,3,5,0);
//		displayDeal(deal1);
//		
//		java.util.List[] deal2 = deal(cards1,0,2,5,0);
//		displayDeal(deal2);
		
//		java.util.List[] deal3 = deal(cards1,0,2,17,0);
//		displayDeal(deal3);
		
//		java.util.List[] deal4 = deal(cards1,9,1,1,0);
//		displayDeal(deal4);
		
//		java.util.List[] deal5 = deal(null,0,3,5,0);
//		displayDeal(deal5);
		
//		java.util.List[] deal6 = deal(cards1,17,3,5,0);
//		displayDeal(deal6);
		
//		java.util.List[] deal7 = deal(cards1,0,18,5,0);
//		displayDeal(deal7);
		
//		java.util.List[] deal8 = deal(cards1,0,3,18,0);
//		displayDeal(deal8);
		
		java.util.List[] deal9 = deal(cards2,0,1,3,0);
		displayDeal(deal9);
		
	}
	
	private static void testShuffle()
	{
		Object[] cards = new Object[]{"card1",null,"0",new Integer(35),new Double(22)};
		
		Object[] shuffled1 = shuffle(cards);
		displayCards(shuffled1);
		
		Object[] shuffled2 = shuffle(cards);
		displayCards(shuffled2);
		
		Object[] shuffled3 = shuffle(cards);
		displayCards(shuffled3);
		
		Object[] empty1 = shuffle(null);
		displayCards(empty1);
		
		Object[] empty2 = shuffle(new Object[]{});
		displayCards(empty2);
	}

	private static void displayCards(Object[] cards) {
	
	if(cards==null||cards.length==0)
		System.out.println("empty deck of cards");
	else for(int i=0;i<cards.length;i++)
			System.out.print(" "+cards[i]);
	System.out.println();
	
}
	private static void displayDeal(java.util.List[] deal) {
		
		if(deal==null||deal.length==0)
			System.out.println("empty deal");
		else for(int i=0;i<deal.length;i++)
		{
			java.util.List playerBundle = deal[i];
			
			if(playerBundle==null||playerBundle.isEmpty())
				System.out.println("empty playerBundle "+i);
			else for(int j=0;j<playerBundle.size();j++)
				System.out.print(playerBundle.get(j)+" ");
			System.out.println();	
		}
	}

}
