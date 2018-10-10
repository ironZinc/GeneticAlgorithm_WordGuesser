package application;

import java.util.ArrayList;
import java.util.List;

public class Population 
{
	private Individual[] members;
	public Population(int popSize, int len)
	{
		members = new Individual[popSize];
		for(int i = 0; i < popSize; i++)
		{
			members[i] = new Individual(len);
		}
	}
	public Population(ArrayList<Individual> arr)
	{
		members = new Individual[arr.size()];
		for(int i = 0; i < members.length; i++)
		{
			members[i] = arr.get(i);
		}
	}
	
	public Individual getMember(int x)
	{
		return members[x];
	}
	
	public int getLength()
	{
		return members.length;
	}
	
	public void sortPopulation(String target)
    {
        for (int i = 0; i < members.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < members.length; j++)
                if (members[j].getFitness(target) > members[index].getFitness(target)) 
                    index = j;
      
            Individual weakerMember = members[index];  
            members[index] = members[i];
            members[i] = weakerMember;
        }
    }
	
	public void sortPopulationSimple(String target)
    {
        for (int i = 0; i < members.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < members.length; j++)
                if (members[j].getFitnessSimple(target) < members[index].getFitnessSimple(target)) 
                    index = j;
      
            Individual weakerMember = members[index];  
            members[index] = members[i];
            members[i] = weakerMember;
        }
    }
	
    public List<Individual> selectFromPopulation(int bestSample, int luckyFew, String target)
    {
    	this.sortPopulation(target);
    	List<Individual> parents = new ArrayList<Individual>();
    	for(int i = 0; i < bestSample; i++)
    	{
    		parents.add(members[members.length - i - 1]);
    	}
    	for(int i = 0; i < luckyFew; i++)
    	{
    		parents.add(members[(int)(Math.random() * (members.length - bestSample))]);
    	}
    	return parents;
    }
    
    public List<Individual> selectFromPopulationSimple(int bestSample, int luckyFew, String target)
    {
    	this.sortPopulationSimple(target);
    	List<Individual> parents = new ArrayList<Individual>();
    	for(int i = 0; i < bestSample; i++)
    	{
    		parents.add(members[members.length - i - 1]);
    	}
    	for(int i = 0; i < luckyFew; i++)
    	{
    		parents.add(members[(int)(Math.random() * (members.length - bestSample))]);
    	}
    	return parents;
    }
    
    public Population createChildren(List<Individual> breeders, int numChildPerPair)
    {
    	ArrayList<Individual> nextPop = new ArrayList<Individual>();
    	for(int i = 0; i < breeders.size()/2; i++)
    	{
    		for(int j = 0; j < numChildPerPair; j++) 
    		{
    			nextPop.add(breeders.get(i).createChild(breeders.get(breeders.size() - 1 - i)));
    		}
    	}
    	return new Population(nextPop);
    }
    
    public void mutatePop(int chance)
    {
    	for(int i = 0; i < members.length; i++)
    	{
    		if(Math.random() * 100 < chance)
    		{
    			members[i].mutate();
    		}
    		Main.addToOutput(members[i].toString() + "\n");
    		System.out.println(members[i].toString() + "\n");
    	}
    }

}
