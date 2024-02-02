/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Address;
import Model.FileManager;
import Model.Student;
import Model.StudentBiz;
import Model.StudentBizManagement;
import Model.StudentIT;
import Model.StudentITManagement;
import java.text.DecimalFormat;
import java.util.*;

/**
 *
 * @author Admin
 */
public class School {
    static Scanner sc = new Scanner(System.in);
    static StudentITManagement sIT = new StudentITManagement();
    StudentBizManagement sBiz = new StudentBizManagement();
    FileManager fm = new FileManager();
    
    public void Exporting(List<Student> list)
    {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("==========STUDENT=============");
        System.out.println("|-----Name-----|-----GPA-----|-------Major-----|");
        System.out.println("|--------------|-------------|-----------------|");
        for ( Student s : list)
        {
            System.out.printf("| %-12s | %-11s | %-15s |\n", s.getFullName(), df.format(s.getAverage()), s.Major());
            System.out.println("|--------------|-------------|-----------------|");
        }
    }
    
    public void Sorting ( List<Student> list)
    {
        DecimalFormat df = new DecimalFormat("#.##");
        List<Student> listSort = new ArrayList<>();
        listSort.addAll(list);
        Collections.sort(listSort, (o1,o2) -> o1.getFullName().compareTo(o2.getFullName()));
        System.out.println("Sort succesfully");
        System.out.println("|-----Name-----|-----GPA-----|-------Major-----|");
        System.out.println("|--------------|-------------|-----------------|");
        for ( Student s : listSort)
        {
            System.out.printf("| %-12s | %-11s | %-15s |\n", s.getFullName(), df.format(s.getAverage()), s.Major());
            System.out.println("|--------------|-------------|-----------------|");
        }
    }
    
    public void Count( List<Student> listCount)
    {
        
        Hashtable<String, List<Student>>  countStudent = new Hashtable<>();
        
        for ( Student s : listCount)
        {
            Address a = s.getAddress();
            if ( countStudent.containsKey(a.getCity()))
            {
                List<Student> sameCity = countStudent.get(a.getCity());
                sameCity.add(s);
                countStudent.put(a.getCity(), sameCity);
            }
            else {
                List<Student> sameCity = new ArrayList<>();
                sameCity.add(s);
                countStudent.put(a.getCity(), sameCity);
            }
        }
        
        if ( countStudent.isEmpty())
        {
            System.out.println("No student in list");
        }
        else{
            List<String> b = new ArrayList<>();
            for ( String s : countStudent.keySet())
            {
                if ( countStudent.get(s).size() == 1)
                {
                    b.add(s);
                }
            }
            for (String key : b) {
                    countStudent.remove(key);
                }
            for ( String s : countStudent.keySet())
            {
                int dem = 0;
                System.out.println();
                System.out.println("======="+s+" CITY=======");
                System.out.println("|-----Name-----|-------Major-----|");
                System.out.println("|--------------|-----------------|");
                for ( Student a : countStudent.get(s))
                {
                    System.out.printf("| %-12s | %-15s |\n", a.getFullName(), a.Major());
                    System.out.println("|--------------|-----------------|");
                    dem++;
                }
                System.out.println("======= TOTAL : "+dem+" ===========");
            }
        }
        
    }
    
    public void UpdateAndDelete(List<Student> listUpdate, int id)
    {
        boolean cont = false;
        List<Student> listToModify = new ArrayList<>();
        List<StudentIT> listModifyIT = new ArrayList<>();
        List<StudentBiz> listModifyBiz = new ArrayList<>();
        int count = 0;
        
        for ( Student s : listUpdate)
        {
            if ( s.getId() == id)
            {
                count++;
                listToModify.add(s);
                if ( s.Major().equalsIgnoreCase("IT"))
                {
                    listModifyIT.add((StudentIT) s);
                }
                else {
                    listModifyBiz.add((StudentBiz) s);
                }
            }
        }
        if ( count == 0)
        {
            System.out.println("ID not existed");
        }
        else{
                System.out.println("Do you want to update or deleted ( U / D ) : ");
                String option = sc.next();
                cont = true;
                if ( option.equals("U"))
                {
                    Update(listToModify,listModifyIT,listModifyBiz,id);
                }
                else if ( option.equalsIgnoreCase("D"))
                {
                    delete(listUpdate,id);
                }
                else {
                    System.out.println("Invalid choice");
                }
                fm.UpdateStudentITList(listUpdate);
                fm.UpdateStudentBizList(listUpdate);
        }
        
    }
    
    public void Update(List<Student> list,List<StudentIT> list1, List<StudentBiz> list2, int id)
    {
        int choice, newId ;
        double JavaSC, CssSC, AccSC, MktSC;
        String name, country , city, district, street;
        int NewId;
        boolean cont = false;
        for ( Student s : list)
        {
                do{
                   choice = menuForUpdate();
                   switch (choice)
                   {
                       case 1 : 
                         
                           NewId = sIT.inputStudentID(list);
                           checkIdExisted(list,NewId);
                           break;
                      
                       case 2 :
                           System.out.println("Enter new name : ");
                           name = sc.next();
                           s.setFullName(name);
                           break;
                           
                       case 3 :
                           Address a = s.getAddress();
                          
                           do {
                                choice = menuForUpdateAddress(); 
                                sc.nextLine();
                           switch ( choice )
                           {
                               case 1 :
                                   System.out.println("Enter new Country : ");
                                   country = sc.nextLine();
                                   a.setCountry(country);
                                   break;
                                   
                               case 2 :
                                   System.out.println("Enter new City : ");
                                   city = sc.nextLine();
                                   a.setCity(city);
                                   break;
                                   
                               case 3 : 
                                   System.out.println("Enter new District : ");
                                   district = sc.nextLine();
                                   a.setDistrict(district);
                                   break;
                                   
                               case 4 :
                                   System.out.println("Enter new Street : ");
                                   street = sc.nextLine();
                                   a.setStreet(street);
                                   break;
                                   
                               default :
                                   break;
                           }
                           System.out.println("Do you want to keep update address (Y / N ) : ");
                           String option = sc.next();
                           if ( option.equalsIgnoreCase("Y"))
                           {
                               cont = true;
                           }
                           else {
                               cont = false;
                           }
                           } while ( cont );
                           break;
                           
                       case 4 :
                           do{
                               cont = false;
                               if ( s.Major().equalsIgnoreCase("IT"))
                               {
                                   choice = menuForUpdateITScore();
                                   switch ( choice )
                                   {
                                       case 1 :
                                           JavaSC = sIT.inputJavaScore();
                                           for ( StudentIT z : list1)
                                           {
                                               z.setJavaScore(JavaSC);
                                           }
                                        break;
                                        
                                       case 2 : 
                                           CssSC = sIT.inputCSSScore();
                                           for ( StudentIT z : list1)
                                           {
                                               z.setCssScore(CssSC);
                                           }
                                        break;              
                                   }
                               }
                               else if ( s.Major().equalsIgnoreCase("Biz"))
                               {
                                   choice = menuForUpdateBizScore();
                                   switch ( choice )
                                   {
                                       case 1 :
                                           AccSC = sBiz.inputAccountingScore();
                                           for ( StudentBiz z : list2)
                                           {
                                               z.setAcountingScore(AccSC);
                                           }
                                        break;
                                        
                                       case 2 : 
                                           MktSC = sBiz.inputMarketingScore();
                                           for ( StudentBiz z : list2)
                                           {
                                               z.setMarketingScore(MktSC);
                                           }
                                        break;              
                                   }
                               }
                           System.out.println("Do you want to keep update Score (Y / N ) : ");
                           String option = sc.next();
                           if ( option.equalsIgnoreCase("Y"))
                           {
                               cont = true;
                           }
                           else {
                               cont = false;
                           }
                           } while (cont);
                           break;
                   }
                } while (cont);      
        }
    }
    
    public int menuForUpdate()
    {
        List<String> menu = new ArrayList<>();
        menu.add("1. Update Id");
        menu.add("2. Update name");
        menu.add("3. Update Address");
        menu.add("4. Update Score");
        menu.add("5. Exit");
        
        for( int i = 0; i < menu.size(); i++)
        {
            System.out.println(menu.get(i));
        }
        System.out.println("What do you want to update : ");
        int ch = sc.nextInt();

        return ch;
    }
    
    public int menuForUpdateAddress()
    {
        List<String> menu = new ArrayList<>();
        menu.add("1. Update Country");
        menu.add("2. Update City");
        menu.add("3. Update District");
        menu.add("4. Update Street");
        menu.add("5. Exit");
        
        for( int i = 0; i < menu.size(); i++)
        {
            System.out.println(menu.get(i));
        }
        System.out.println("What do you want to update : ");
        int ch = sc.nextInt();
        
        return ch;
    }
    
    public int  menuForUpdateITScore()
    {
        List<String> menu = new ArrayList<>();
        menu.add("1. Update Java Score");
        menu.add("2. Update CSS Score");
        menu.add("3. Exit");
        
        for( int i = 0; i < menu.size(); i++)
        {
            System.out.println(menu.get(i));
        }
        System.out.println("What do you want to update : ");
        int ch = sc.nextInt();
        
        return ch;
        
    }
    
    public int  menuForUpdateBizScore()
    {
        List<String> menu = new ArrayList<>();
        menu.add("1. Update Accounting Score");
        menu.add("2. Update Marketing Score");
        menu.add("3. Exit");
        
        for( int i = 0; i < menu.size(); i++)
        {
            System.out.println(menu.get(i));
        }
        System.out.println("What do you want to update : ");
        int ch = sc.nextInt();
        
        return ch;
        
    }
    
    public void delete (List<Student> list, int id)
    {
        list.removeIf(v -> v.getId() == id);
        System.out.println("Remove successful !");
    }    
    
    public boolean checkIdExisted(List<Student> list, int id)
    {
        for ( Student s : list )
        {
            if ( s.getId() == id)
            {
                return true;
            }
        }
        return false;
    }
    
    public void Report(List<Student> list)
    {
        System.out.println("==========STUDENT=============");
        System.out.println("|-----Name-----|-----TotalSubjectPassed-----|------------SubjectPassed----------|---------------GradeOfEachSubject---------------|");
        System.out.println("|--------------|----------------------------|-----------------------------------|------------------------------------------------|");
        for ( Student s : list)
        {
            if ( s instanceof StudentIT)
            {
                System.out.printf("| %-12s | %-26s | %-33s | %-46s |\n", s.getFullName(), sIT.CountSubjectITPass((StudentIT) s), sIT.SubjectITPass((StudentIT) s), sIT.gradePoint((StudentIT) s));
                System.out.println("|--------------|----------------------------|-----------------------------------|------------------------------------------------|");
            }
            else if ( s instanceof StudentBiz)
            {
                System.out.printf("| %-12s | %-26s | %-33s | %-46s |\n", s.getFullName(), sBiz.CountSubjectBizPass((StudentBiz) s), sBiz.SubjectBizPass((StudentBiz) s), sBiz.gradePoint((StudentBiz) s));
                System.out.println("|--------------|----------------------------|-----------------------------------|------------------------------------------------|");
            }
        }
    }
}
