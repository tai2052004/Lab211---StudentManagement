/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class FileManager {
    public String StudentIT = "StudentIT.txt";
   public String StudentBiz = "StudentBiz.txt";
   int lastReadPosition1 = 0;
   int lastReadPosition2 = 0;
   
   public void WriteStudentITList(List<Student> list)
   {
       Address a ;
       DecimalFormat df = new DecimalFormat("#.##");
       try ( FileWriter fw = new FileWriter(StudentIT,true);BufferedWriter bw = new BufferedWriter(fw))
       {
           for (Student s : list)
           {
               if ( s instanceof StudentIT)
               {
                a = s.getAddress();
                bw.write(s.getId()+","+s.getFullName()+","+a.getCountry()+","+a.getCity()+","+a.getDistrict()+","+a.getStreet()+","+((StudentIT) s).getJavaScore()+","+((StudentIT) s).getCssScore()+","+df.format(s.getAverage()));
                bw.newLine();
               }
           }
       } catch ( IOException e)
       {
           System.out.println("IO exception");
       }
   }
   
   public List<Student> ReadStudentITList() throws FileNotFoundException, IOException
   {
       List<Student> ReadFromFile = new ArrayList<>();
       String line;
       Address a ;
       try(BufferedReader br = new BufferedReader(new FileReader(StudentIT)))
       {
           if (lastReadPosition1 > 0) {
                br.skip(lastReadPosition1); 
            }
          while ( (line = br.readLine()) != null)
          {
              a = new Address();
              String [] larr  = line.split(",");
              a.setCountry(larr[2]);
              a.setCity(larr[3]);
              a.setDistrict(larr[4]);
              a.setStreet(larr[5]);
              ReadFromFile.add(new StudentIT(Integer.parseInt(larr[0].trim()),larr[1].trim(), a, Double.parseDouble(larr[6].trim()), Double.parseDouble(larr[7].trim())));
              lastReadPosition1 += line.length() + System.lineSeparator().length();
          }
       } 
       saveLastReadPosition1(lastReadPosition1);
       return ReadFromFile;
   }
   
   public void UpdateStudentITList(List<Student> list)
   {
       Address a ;
       DecimalFormat df = new DecimalFormat("#.##");
       try ( FileWriter fw = new FileWriter(StudentIT);BufferedWriter bw = new BufferedWriter(fw))
       {
           for (Student s : list)
           {
               if ( s instanceof StudentIT)
               {
               a = s.getAddress();
               bw.write(s.getId()+","+s.getFullName()+","+a.getCountry()+","+a.getCity()+","+a.getDistrict()+","+a.getStreet()+","+((StudentIT) s).getJavaScore()+","+((StudentIT) s).getCssScore()+","+df.format(s.getAverage()));
               bw.newLine();
               }
           }
       } catch ( IOException e)
       {
           System.out.println("IO exception");
       }
   }
   
    public void WriteStudentBizList(List<Student> list)
   {
       Address a ;
       DecimalFormat df = new DecimalFormat("#.##");
       try ( FileWriter fw = new FileWriter(StudentBiz,true);BufferedWriter bw = new BufferedWriter(fw))
       {
           for (Student s : list)
           {
               if ( s instanceof StudentBiz)
               {
               a = s.getAddress();
               bw.write(s.getId()+","+s.getFullName()+","+a.getCountry()+","+a.getCity()+","+a.getDistrict()+","+a.getStreet()+","+((StudentBiz) s).getAcountingScore()+","+((StudentBiz) s).getMarketingScore()+","+df.format(s.getAverage()));
               bw.newLine();
               }
           }
       } catch ( IOException e)
       {
           System.out.println("IO exception");
       }
   }
    
    public void UpdateStudentBizList(List<Student> list)
   {
       Address a ;
       DecimalFormat df = new DecimalFormat("#.##");
       try ( FileWriter fw = new FileWriter(StudentBiz);BufferedWriter bw = new BufferedWriter(fw))
       {
           for (Student s : list)
           {
               if ( s instanceof StudentBiz)
               {
               a = s.getAddress();
               bw.write(s.getId()+","+s.getFullName()+","+a.getCountry()+","+a.getCity()+","+a.getDistrict()+","+a.getStreet()+","+((StudentBiz) s).getAcountingScore()+","+((StudentBiz) s).getMarketingScore()+","+df.format(s.getAverage()));
               bw.newLine();
               }
           }
       } catch ( IOException e)
       {
           System.out.println("IO exception");
       }
   }
   
   public List<Student> ReadStudentBizList() throws FileNotFoundException, IOException
   {
       List<Student> ReadFromFile = new ArrayList<>();
       Address a ;
       String line;
       try(BufferedReader br = new BufferedReader(new FileReader(StudentBiz)))
       {
           if (lastReadPosition2 > 0) {
                br.skip(lastReadPosition2); 
            }
          while ( (line = br.readLine()) != null)
          {
              a = new Address();
              String [] larr  = line.split(",");
              a.setCountry(larr[2]);
              a.setCity(larr[3]);
              a.setDistrict(larr[4]);
              a.setStreet(larr[5]);
              ReadFromFile.add(new StudentBiz(Integer.parseInt(larr[0].trim()),larr[1].trim(), a, Double.parseDouble(larr[6].trim()), Double.parseDouble(larr[7].trim())));
              lastReadPosition2 += line.length() + System.lineSeparator().length();
          }
       } 
       saveLastReadPosition2(lastReadPosition2);
       return ReadFromFile;
   }
   
   
   private void saveLastReadPosition1(int position) {
        try (FileWriter fileWriter = new FileWriter("lastReadPosition1.txt")) {
            fileWriter.write(String.valueOf(lastReadPosition1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
   private void saveLastReadPosition2(int position) {
        try (FileWriter fileWriter = new FileWriter("lastReadPosition2.txt")) {
            fileWriter.write(String.valueOf(lastReadPosition2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

