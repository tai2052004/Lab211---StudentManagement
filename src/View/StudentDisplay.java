/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Control.School;
import Model.FileManager;
import Model.Student;
import Model.StudentBiz;
import Model.StudentBizManagement;
import Model.StudentIT;
import Model.StudentITManagement;
import java.io.IOException;
import java.util.*;


/**
 *
 * @author Admin
 */
public class StudentDisplay extends Menu{
     StudentITManagement sIT = new StudentITManagement();
     StudentBizManagement sBiz = new StudentBizManagement();
     List<Student> std = new ArrayList<>();
     FileManager fm = new FileManager();
     School s = new School();
     Scanner sc = new Scanner(System.in);
     
     
     public StudentDisplay()
     {
         super("=====Student Management=====",new String[] {"Add Student","Exporting Student List","Sorting by name","Count and return Student in the same city","Update/Delete", "Reporting","Exit"});
     }
     
      public int Menu2()
    {
        Scanner sc = new Scanner(System.in);
        int choice ;
        
            List<String> menu2 = new ArrayList<>();
            menu2.add(" Add Student IT");
            menu2.add(" Add Student Biz");
            menu2.add(" Exit");
            System.out.println("--------------------");
            for ( int i = 0; i < menu2.size(); i++)
            {
                System.out.println((i+1)+". "+menu2.get(i));
            }
            System.out.println("--------------------");
            System.out.print("Your choice : ");
            choice = sc.nextInt();
        
        
        return choice;
        
    }
     
      @Override
    public void execute(int ch) 
    {
        int option = 0, id = 0;
        boolean cont = false;
         try {
             std = fm.ReadStudentITList();
             std.addAll(fm.ReadStudentBizList());
         } catch (IOException ex) {
             System.out.println("IO exception");
         }
        do{
            switch ( ch )
            {
                case 1 :
                    do{
                        option = Menu2();
                        if ( option == 1)
                        {
                            sIT.addStudentIT(std);
                        }
                        else if ( option == 2){
                            sBiz.addStudentBiz(std);
                        }
                     } while (option >= 1 && option <= 2);
                    break;
                    
                case 2 :
                    s.Exporting(std);
                    break;
                    
                case 3 : 
                    s.Sorting(std);
                    break;
                    
                case 4 :
                    s.Count(std);
                    break;
                    
                case 5 : 
                    do{
                        System.out.println("Enter student ID : ");
                        id = sc.nextInt();
                        if ( s.checkIdExisted(std, id))
                        {
                            cont = false;
                        }
                        else {
                            System.out.println("ID not existed");
                            cont = true;
                        }
                    } while (cont);
                    
                    s.UpdateAndDelete(std, id);
                    break;
                    
                case 6 :
                    s.Report(std);
                    break;
                
                default :
                    break;
                
                
            }         
            ch = getSelected();
        } while ( ch >= 1 && ch <= 6);
    }
     
     public static void main(String[] args) {
         StudentDisplay sd = new StudentDisplay();
         sd.run();
    }

   
}
