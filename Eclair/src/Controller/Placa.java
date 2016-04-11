/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author danie
 */
public class Placa {
    
  private String[] placa = new String[24];
  
  public void setPlaca(int x, String placa)
  {
      this.placa[x] = placa;
  }
  
  public String getPlaca(int x)
  {
      return placa[x];
  }
    
  
}
