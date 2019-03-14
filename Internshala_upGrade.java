
/*Descprition
 * Coder Name:- Patel Neel RakeshKumar
 * Phone no.:-  +91-8469933555
 * Aim:-        Make priority queue for enter details
 * Submiting to:- upGrad company for Internship program.
 * Date and time:- THU 14 MAR 2019 1:07
 *Total Warning and Error : Warning 1      Error 0
 */
package Example;


import java.util.*;


//IN THIS PROGRAM THERE ARE 3 CLASSES WHICH ARE PUBLIC FOR ACCESSING VALUES
class Student
{ //CLASS STUDENT IS FOR USE VALUES FROM ONE CLASS TO ANOTHER
   private int token;
   private String name;
   private float cgpa;
   public Student(int token, String name, float cgpa) 
   {
      super();
      this.token = token;
      this.name = name;
      this.cgpa = cgpa;
   }
   //this methods returns value for the methods 
   		public String getName() 
   		{
   				return name;
   		}
   		public float getCgpa()
   		{
   				return cgpa;
   		}
   		public int getToken()
   		{
   				return token;
   		}
}

public class Internshala_upGrade {

  public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int noofEvents = Integer.parseInt(scan.nextLine()); //how much values want to enter. that number of inputs are scanned here.
        PriorityQueue<Student> PQlist =
                new PriorityQueue<>(new Comparator<Student>() { //this is inbuilt function from java there are many methods in java
            @Override
            public int compare(Student o1, Student o2) { //comparing two students objects which are return values from super class.
                if(o1.getCgpa() != o2.getCgpa())
                    return o1.getCgpa() < o2.getCgpa() ? 1 : -1;//this is ternary operation
                else
                {
                    if(!o1.getName().equals(o2.getName()))
                        return o1.getName().compareTo(o2.getName());
                    else
                        return o1.getToken() < o2.getToken() ? 1 : -1;
                    
                    /*
                     * comparing values are per task
                     * for alphabetic order
                     */
                }
            }
        });
        

        
        /*
         * logic for entering details for students and ending the loop when 
         * list is full and Served event is "SERVED"*/
        
        while(noofEvents>0){
            String event = scan.next();

            if(event.equals("ENTER")){
            	float cgpa = scan.nextFloat();
            	int token = scan.nextInt();
            	String name = scan.next();
                PQlist.add(new Student(token, name, cgpa));//add() method is use for entering details in PriorityQueue
            }else if(PQlist.size() > 0 && event.equals("SERVED")){ //object.size() is method of PriorityQueue
            	PQlist.remove();//object.remove() is method of PriorityQueue
            }

            noofEvents--;
        }

        
        
        
        
        //when list is empty it will print empty
        
        if(PQlist.size() == 0) {
            System.out.println("EMPTY");
            return;
        }
        //this loop for printing the name as per the task or you can change

        while(PQlist.size() > 0){
            System.out.println(PQlist.poll().getName());
        }
    }
  
}