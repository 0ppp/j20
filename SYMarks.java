package SY;

import java.io.*;

public class SYMarks

{

	public int c,m,e;
    
public void get() throws Exception
    
{
    	
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

System.out.println("Enter computer total");
     
   c = Integer.parseInt(br.readLine());

        
System.out.println("Enter maths total");
        

m = Integer.parseInt(br.readLine());

   
     System.out.println("Enter electronic total");
    
    e = Integer.parseInt(br.readLine());
	}

	
public void put()

    {

    	System.out.println("Computer total is: "+c);
        

System.out.println("Maths total is: "+m);
    
    System.out.println("Electronic total is: "+e);
	
}

}


