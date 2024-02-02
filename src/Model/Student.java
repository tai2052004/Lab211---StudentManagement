/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
import Model.Address;
public abstract class Student {
    int Id;
    String FullName;
    Address address;
    
    public Student(){
        
    }
    

    public Student(int Id, String FullName, Address address) {
        this.Id = Id;
        this.FullName = FullName;
        this.address = address;
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public abstract double getAverage();
    public abstract String Major();
  
    
    
  
    
    
}
