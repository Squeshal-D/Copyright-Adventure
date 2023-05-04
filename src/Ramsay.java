
public class Ramsay extends Character{

	String name = "Gordon Ramsay";
	String desc = "Aggressive Chef";
	String quest = "Enter the kitchen";
	String preBattle = "You're feeling a little hungry, so you take a trip to the local kitchen. Using the equipment available, you make a PB&J."
			+ "\nA man dressed in white approaches as you chomp away. \"Do you have any idea where you are? You're in Hell's Kitchen!\"";
	String move1 = "Pan Slam";
	String move2 = "Gordonmet";
	String move1Desc = "Very unoriginal. Does 15 damage.";
	String move2Desc = "Exquisitely gourmet. Cook a meal for Gordon or a teammate! Heals 20 hp.";
	int hp = 50;
	int maxhp = 50;
	
	public String getName()
	{
		return name;
	}
	
	public String getDesc()
	{
		return desc;
	}
	
	public String getQuest()
	{
		return quest;
	}
	
	public String getPreBattle()
	{
		return preBattle;
	}
	
	public String getMove1()
	{
		return move1;
	}
	
	public String getMove2()
	{
		return move2;
	}
	
	public String getMove1Desc()
	{
		return move1Desc;
	}
	
	public String getMove2Desc()
	{
		return move2Desc;
	}
	
	public int getHP()
	{
		return hp;
	}
	
	public int getMaxHP()
	{
		return maxhp;
	}
	
	public void loseHP(int i)
	{
		hp -= i;
	}
	
	public void healMax()
	{
		hp = maxhp;
	}
	
	public void changeQuest(String s)
	{
		quest = s;
	}
	
	public void move1Exec(Character player, Character enemy)
	{
		System.out.println(player.getName() + " hits " + enemy.getName() + " with a frying pan for 15 dmg!");
		enemy.loseHP(15);
	}
	
	public void move2Exec(Character player, Character enemy)
	{
		boolean teammate = false;
		for (int i = 0; i<Game.party.size(); i++)
		{
			if (Game.party.get(i).getQuest().equals("Enter the kitchen") && player.getQuest().equals("Enter the kitchen"))
			{
				teammate = true;
			}
		}
		if (teammate)
		{
			System.out.println("Who will be receiving this delicious meal?");
			for (int i = 0; i<Game.party.size(); i++)
			{
				System.out.println((i+1) + ". " + Game.party.get(i).getName() + " (" + Game.party.get(i).getHP() + "/" + Game.party.get(i).getMaxHP() + ")");
			}
			int p = 0;
			while (p < 1 || p > Game.party.size())
			{
				p = (Game.intCheck(Game.userIn));
				if (p < 1 || p > Game.party.size())
				{
					System.out.println("Invalid input. Try again.");
				}
			}
			System.out.println(Game.party.get(p-1).getName() + " eats the meal and recovers 20 hp!");
			Game.party.get(p-1).loseHP(-20);
			if (Game.party.get(p-1).getHP() > Game.party.get(p-1).getMaxHP())
			{
				Game.party.get(p-1).loseHP(Game.party.get(p-1).getHP() - Game.party.get(p-1).getMaxHP());
			}
		}
		else
		{
			System.out.println(player.getName() + " eats a gourmet meal and recovers 30 hp!");
			player.loseHP(-30);
			if (player.getHP() > player.getMaxHP())
			{
				player.loseHP(player.getHP() - player.getMaxHP());
			}
		}
	}
	
}
