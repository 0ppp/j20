import SY.*;

import TY.*;

import java.io.*;


class Student

{

	int rno;
  
  String name;

    SYMarks s = new SYMarks();

    TYMarks t = new TYMarks();

 
   public void get() throws Exception

    {
		
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    System.out.println("Enter roll no: ");

        rno = Integer.parseInt(br.readLine());

  
      System.out.println("Enter name: ");
     
   name = br.readLine();
      
  s.get();
    
    t.get();
   
 }


    public void put()
    
{
    	
System.out.println("Roll no: "+rno);

        System.out.println("Name: "+name);

        s.put();
     
   t.put();
	
}

 
   void cal()throws Exception
 
   {
    	
int total,per;
   
     total = s.c + t.t + t.p+ s.e + s.m ; 

     
   System.out.println("Total is:"+total);
 
       per = total/3;
	   
 if(per >= 70)
	
		System.out.println("Grade:A");

        else
      
  if(per > 60 &&  per <= 70)
        
    System.out.println("Grade:B");
    
    else
        if(per > 50 && per <= 60)
 

           System.out.println("Grade:C");
     
   else
      
  if(per <= 40)
  
          System.out.println("Grade:Fail");

	}

}



class Slip20_1

{
	
public static void main(String arg[]) throws Exception
    
{
    	

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter no of Students : ");
     
   int n = Integer.parseInt(br.readLine());
        
 
       Student s1[] = new Student[n];
  

      for(int i=0;i<n;i++)
  
      {
			
s1[i] = new Student();
         
   s1[i].get();
        
    s1[i].put();
          
  s1[i].cal();
        
}
	
}

}