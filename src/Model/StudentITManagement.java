/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Model;

import java.util.* ;

/**
 *
 * @author Admin
 */
public class StudentITManagement {

 
    Scanner sc = new Scanner(System.in);
    FileManager fm = new FileManager();
    
    public void addStudentIT(List<Student> list)
    {
       
        List<Student> listSaveToFile = new ArrayList<>();
        
        int studentID;
        Address add;
        double JavaScore, CSSscore;
        String name;
        
        studentID = inputStudentID(list);
        name = inputStudentName();
        add = InputAddress();
        JavaScore = inputJavaScore();
        CSSscore = inputCSSScore();
        StudentIT a = new StudentIT(studentID, name, add, JavaScore, CSSscore);
        list.add(a);
        listSaveToFile.add(a);
        fm.WriteStudentITList(listSaveToFile);
    }
    
    public int inputStudentID(List<Student> list)
    {
        
        boolean cont = false;
        int i = 0;
        do{
            try{
                System.out.println("Enter student Id : ");
                 i = Integer.parseInt(sc.next());
                cont = false;
                for ( Student s : list)
                {
                    if (s.getId() == i)
                    {
                        System.out.println("ID existed");
                        cont = true;
                    }
                }
            } catch ( NumberFormatException e)
            {
                System.out.println("Student ID must be an integer");
                cont = true;
            }
        }while (cont);
        sc.nextLine();
        return i;
    }
    
    public Address InputAddress()
    {
        Address a = new Address();
        System.out.println("Enter your country : ");
        String country = sc.nextLine();
        System.out.println("Enter your city : ");
        String city = sc.nextLine();
        System.out.println("Enter your district : ");
        String district = sc.nextLine();
        System.out.println("Enter your street : ");
        String street = sc.nextLine();
        a.setCountry(country);
        a.setCity(city);
        a.setDistrict(district);
        a.setStreet(street);
        
        return a;
        
    }
    
    public String inputStudentName()
    {
        System.out.println("Enter student name : ");
        String n = sc.nextLine();
        return n;
    }
    
    public double inputJavaScore()
    {
        boolean cont ;
        double jc = 0;
        do{
            try{
                System.out.println("Enter student Java Score : ");
                jc = Double.parseDouble(sc.next());
                cont = false;
                if ( jc < 0 || jc > 10)
                {
                    System.out.println("Java Score must be in range 0 -> 10");
                    cont = true;
                }
            } catch ( NumberFormatException e){
                System.out.println("Java score must be a real number");
                cont = true;
            }
        } while ( cont );
        return jc;
    }
    
    public double inputCSSScore()
    {
        boolean cont ;
        double CS = 0;
        do{
            try{
                System.out.println("Enter student CSS Score : ");
                CS = Double.parseDouble(sc.next());
                cont = false;
                if ( CS < 0 || CS > 10)
                {
                    System.out.println("CSS Score must be in range 0 -> 10");
                    cont = true;
                }
            } catch ( NumberFormatException e){
                System.out.println("CSS score must be a real number");
                cont = true;
            }
        } while ( cont );
        return CS;
    }
    
    public boolean checkStudentITPass(StudentIT sIT)
    {
       if ( sIT.getCssScore() >= 5 && sIT.getJavaScore() >= 5)
       {
           return true;
       }
       return false;
    }
    
    public String SubjectITPass(StudentIT sIT)
    {
        String s = "";
        if ( sIT.getJavaScore() >= 5 )
        {
            s += "Java Score, ";
        }
        if ( sIT.getCssScore() >= 5)
        {
            s += "CSS Score";
        }
        if ( s.equals(""))
        {
            s = "No subject pass";
        }
        return s;
    }
    
    public int CountSubjectITPass(StudentIT sIT)
    {
        int dem = 0;
        if ( sIT.getJavaScore() >= 5 )
        {
            dem++;
        }
        if ( sIT.getCssScore() >= 5)
        {
            dem++;
        }
        return dem;
    }
    public String gradePoint(StudentIT s)
    {
        return ("Java Score : " + s.getJavaScore() + "," + "Css Score : " + s.getCssScore());
    }
    
}
