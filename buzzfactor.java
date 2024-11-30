package tcs_codevita;
import java.util.*;
public class buzzfactor {
	public static void main(String args[])
    {
        Scanner codeinput=new Scanner(System.in);
       
        int N=codeinput.nextInt();
        if(N < 1 || N > 500)
        {
        	System.out.println("Error");
        	codeinput.close();
        	return;
        }
        
        int[] itemIds = new int[N];
        int[] Itemcosts = new int[N];
        for(int i =0; i<N; i++)
        {
            itemIds[i] = codeinput.nextInt();
        }

        for(int i=0; i<N; i++)
        {
            Itemcosts[i]=codeinput.nextInt();
        }
        
        int bg = codeinput.nextInt();
        
        int free=0;
        int worth=0;
        
        for (int i=0; i<N; i++)
        {
        	int idnow=itemIds[i];
        	int costnow=Itemcosts[i];
        	
        	if(costnow <= bg)
        	{
        		int f_count = 0;
        		for(int id: itemIds)
        		{
        			if (id != idnow && idnow % id ==0)
        			{
        				f_count++;
        			}
        		}
        		
        	if (f_count>0)
        	{
        		int[] f = new int[f_count];
        		int f_i = 0;
        		
        		for(int id: itemIds)
        		{
        			if(id != idnow && idnow % id ==0)
        			{
        				f[f_i] = id;
        				f_i++;
        			}
        		}
        		
        		int worth_now = 0;
        		for(int f_print : f)
        		{
        			for (int j = 0; j<N; j++)
        			{
        				if(itemIds[j] == f_print )
        				{
        					worth_now += Itemcosts[j];
        					break;
        					
        				}
        			}
        		}
        		
        		System.out.println("Checking ID: " + idnow + " Cost: " + costnow);
        		System.out.println("Found factors: " + f_count + " Worth: " + worth_now);
        		
        		if(f_count > free)
        		{
        			free = f_count;
        			worth = worth_now;
        			
        		}
        		else if(f_count == free && worth_now > worth)
        		{
        			worth = worth_now;
        		}
        		
        	}
        }
        }
        
        System.out.println(free + " " + worth);
      
        
    }

}
