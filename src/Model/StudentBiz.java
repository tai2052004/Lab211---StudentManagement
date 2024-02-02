/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class StudentBiz extends Student{
    
    double AcountingScore;
    double MarketingScore;
    
    public StudentBiz(int Id, String FullName, Address Address, double AcountingScore, double MarketingScore) {
        super(Id, FullName, Address);
        this.AcountingScore = AcountingScore;
        this.MarketingScore = MarketingScore;
        
    }

    public double getAcountingScore() {
        return AcountingScore;
    }

    public void setAcountingScore(double AcountingScore) {
        this.AcountingScore = AcountingScore;
    }

    public double getMarketingScore() {
        return MarketingScore;
    }

    public void setMarketingScore(double MarketingScore) {
        this.MarketingScore = MarketingScore;
    }


    @Override
    public double getAverage() {
        return (AcountingScore * 2 + MarketingScore)/3;
    }
    
    @Override
    public String Major()
    {
        return "Biz";
    }
}
