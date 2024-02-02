/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class StudentBizManagement {
    
    Scanner sc = new Scanner(System.in);
    FileManager fm = new FileManager();
    
    public void addStudentBiz(List<Student> list)
    {
        List<Student> listSaveToFile = new ArrayList<>();
        StudentITManagement sIT = new StudentITManagement();
        
        int studentID;
        Address add;
        double AccountingScore, Marketingscore;
        String name;
        
        studentID = sIT.inputStudentID(list);
        name = sIT.inputStudentName();
        add = sIT.InputAddress();
        AccountingScore = inputAccountingScore();
        Marketingscore = inputMarketingScore();
        StudentBiz a = new StudentBiz(studentID, name, add, AccountingScore, Marketingscore);
        list.add(a);
        listSaveToFile.add(a);
        fm.WriteStudentBizList(listSaveToFile);
    }
    
    public double inputAccountingScore()
    {
        boolean cont;
        double Ac = 0;
        do{
            try{
                System.out.println("Enter student Accounting Score : ");
                Ac = Double.parseDouble(sc.next());
                cont = false;
                if ( Ac < 0 || Ac > 10)
                {
                    System.out.println("Accounting Score must be in range 0 -> 10");
                    cont = true;
                }
            } catch ( NumberFormatException e){
                System.out.println("Accounting score must be a real number");
                cont = true;
            }
        } while ( cont );
        return Ac;
    }
    
    public double inputMarketingScore()
    {
        boolean cont ;
        double MS = 0;
        do{
            try{
                System.out.println("Enter student Marketing Score : ");
                MS = Double.parseDouble(sc.next());
                cont = false;
                if ( MS < 0 || MS > 10)
                {
                    System.out.println("Marketing Score must be in range 0 -> 10");
                    cont = true;
                }
            } catch ( NumberFormatException e){
                System.out.println("Marketing score must be a real number");
                cont = true;
            }
        } while ( cont );
        return MS;
    }
    
    public boolean checkStudentBizPass(StudentBiz sBiz)
    {
       if ( sBiz.getAcountingScore() >= 5 && sBiz.getMarketingScore() >= 5)
       {
           return true;
       }
       return false;
    }
    
    public String SubjectBizPass(StudentBiz sBiz)
    {
        String s = "";
        if ( sBiz.getAcountingScore() >= 5 )
        {
            s += "Acounting Score, ";
        }
        if ( sBiz.getMarketingScore() >= 5)
        {
            s += "Marketing Score";
        }
        if ( s.equals(""))
        {
            s = "No subject pass";
        }
        return s;
    }
    
    public int CountSubjectBizPass(StudentBiz sBiz)
    {
        int dem = 0;
        if ( sBiz.getAcountingScore() >= 5 )
        {
            dem++;
        }
        if ( sBiz.getMarketingScore() >= 5)
        {
            dem++;
        }
        return dem;
    }
    
    public String gradePoint(StudentBiz s)
    {
        return ("Accounting Score : " + s.getAcountingScore() + "," + "Marketing Score : " + s.getMarketingScore());
    }
    
    
   
}

