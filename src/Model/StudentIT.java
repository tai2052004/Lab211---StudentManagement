/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class StudentIT extends Student{
    
    double JavaScore;
    double CssScore;
    
    public StudentIT(){
        
    }
   

    public StudentIT( int Id, String FullName, Address address,double JavaScore, double CssScore) {
        super(Id, FullName, address);
        this.JavaScore = JavaScore;
        this.CssScore = CssScore;
    }


    public double getJavaScore() {
        return JavaScore;
    }

    public void setJavaScore(double JavaScore) {
        this.JavaScore = JavaScore;
    }

    public double getCssScore() {
        return CssScore;
    }

    public void setCssScore(double CssScore) {
        this.CssScore = CssScore;
    }

    @Override
    public double getAverage() {
        return (3 * JavaScore + CssScore)/4;
    }
    
    @Override
    public String Major(){
        return "IT";
    }
    
    
    
}
