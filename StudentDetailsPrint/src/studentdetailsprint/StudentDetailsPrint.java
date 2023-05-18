/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentdetailsprint;

/**
 *
 * @author srinivsi
 */
public class StudentDetailsPrint {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // array of object decalration
         Student[] list = new Student[2];
         Student s1 = new Student();
         s1.setName("parmin");
         s1.setAge(14);
         Student s2 = new Student();
         s2.setName("peter");
         s2.setAge(17);
         list[0]=s1;
          list[1]=s2;
          System.out.println(list[0].getName()+ " "+list[0].getAge());
    }
    
}
