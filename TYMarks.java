package TY;

import java.io.*;


public class TYMarks

{
	
	public int t,p;

    public void get() throws Exception

    {
    

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

   
     System.out.println("Enter theory marks");
   
     t = Integer.parseInt(br.readLine());

     
   System.out.println("Enter practical marks");
   
     p=Integer.parseInt(br.readLine());
	
}

 
   public void put()

    {
    
	System.out.println("Therory marks: "+t);
       
 System.out.println("Practical marks: "+p);

	}

}

