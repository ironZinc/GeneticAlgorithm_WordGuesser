package application;

public class Individual 
{
	private String word;
	private String hashed;
	public Individual(int myLength)
	{
		word = "";
		for(int i = 0; i < myLength; i++)
		{
			word += (char) (97 + (int)(26 * Math.random()));
		}
		hashed = encode(word);
	}
	
	public Individual(Individual a, Individual b)
	{
		word = "";
		for(int i = 0; i < a.getWordLength(); i++)
		{
			if((int)(Math.random() * 10) + 1 <= 5)
			{
				word += a.getWord().substring(i, i + 1);
			}else {
				word += b.getWord().substring(i, i + 1);
			}
		}
		hashed = encode(word);
	}
	
	public Individual(String w)
	{
		word = w;
	}
	
	public int getWordLength()
	{
		return word.length();
	}
	
	public String getWord()
	{
		return word;
	}
	
	public String getHashed()
	{
		return hashed;
	}
	
    public int getFitness(String target)
    {
    	int score = 0;
//    	if(target.length() != hashed.length())
//    	{
//    		System.out.println("not same length");
//    		return -1;
//    	}
    	//else {
//    		for(int i = 0; i < target.length(); i++) 
//    		{
////    			if(target.charAt(i) == word.charAt(i))
////    			{
////    				score += 1;
////    			}
//    			
//    		}
    	//}
    	score = Math.abs(Integer.parseInt(hashed) - Integer.parseInt(target));
    	return score;
    }
    
    public int getFitnessSimple(String target)
    {
    	int score = 0;
    	if(target.length() != word.length())
    	{
    		System.out.println("not same length");
    		return -1;
    	}
    	else {
    		for(int i = 0; i < word.length(); i++)
    		{
    			if(target.charAt(i) == word.charAt(i))
    			{
    				score += 1;
    			}
    		}
    	}
    	return (score * 100) / target.length();
    }
    
    public Individual createChild(Individual x)
    {
    	Individual child = new Individual(this, x);
    	return child;
    }
    
    public void mutate()
    {
    	int ind = (int) (Math.random() * getWordLength());
    	String newWord = "";
    	if(ind == 0)
    	{
    		newWord = (char)(97 + (int)(Math.random() * 26)) + word.substring(1, word.length());
    	}else {
    		newWord = word.substring(0, ind) + (char)(97 + (int)(Math.random() * 26)) + word.substring(ind + 1, word.length());
    	}
    	word = newWord;
    }
    
    public String toString()
    {
    	return this.getWord();
    }
    
//    public String encode(String file) {
//        int hash = 0;
//        file = file.toUpperCase();
//
//        for(int i = 0; i < file.length(); i++) {
//                hash = (hash * 61 + file.charAt(i)) - 32;
//        }
//        return new Integer(hash).toString();
//    }
    
    public String encode(String file) 
    {
        int hash = 0;
        file = file.toUpperCase();

        for(int i = 0; i < file.length(); i++) {
            hash = (hash * 31 + file.charAt(i)) + 32;
        }
        return new Integer(hash).toString();
    }
    
}
