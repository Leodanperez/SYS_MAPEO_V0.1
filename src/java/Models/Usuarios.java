/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author GUSTAVO MANRIQUE
 */
public class Usuarios {

    private char Cusuarios_Cod;
    private int CusuariosCod;
    private String Vusuarios_Login;
    private String Vusuarios_Password;
    private String Vusuairos_Email;
    private String Vusuarios_Foto;
    private int Iusuarios_Intentos;
    private int Cmilitares_Cip;
    private char Cusuarios_Estado;
    private String Vpersonal_ApellNom;
    private char Cperfiles_Cod;
    private String Vperfiles_Descripcion;
    

    public Usuarios() {

    }

    public char getCusuarios_Cod() {
        return Cusuarios_Cod;
    }

    public void setCusuarios_Cod(char Cusuarios_Cod) {
        this.Cusuarios_Cod = Cusuarios_Cod;
    }

    public String getVusuarios_Login() {
        return Vusuarios_Login;
    }

    public void setVusuarios_Login(String Vusuarios_Login) {
        this.Vusuarios_Login = Vusuarios_Login;
    }

    public String getVusuarios_Password() {
        return Vusuarios_Password;
    }

    public void setVusuarios_Password(String Vusuarios_Password) {
        this.Vusuarios_Password = Vusuarios_Password;
    }

    public String getVusuairos_Email() {
        return Vusuairos_Email;
    }

    public void setVusuairos_Email(String Vusuairos_Email) {
        this.Vusuairos_Email = Vusuairos_Email;
    }

    public String getVusuarios_Foto() {
        return Vusuarios_Foto;
    }

    public void setVusuarios_Foto(String Vusuarios_Foto) {
        this.Vusuarios_Foto = Vusuarios_Foto;
    }

    public int getIusuarios_Intentos() {
        return Iusuarios_Intentos;
    }

    public void setIusuarios_Intentos(int Iusuarios_Intentos) {
        this.Iusuarios_Intentos = Iusuarios_Intentos;
    }

    public int getCmilitares_Cip() {
        return Cmilitares_Cip;
    }

    public void setCmilitares_Cip(int Cmilitares_Cip) {
        this.Cmilitares_Cip = Cmilitares_Cip;
    }

    public char getCusuarios_Estado() {
        return Cusuarios_Estado;
    }

    public void setCusuarios_Estado(char Cusuarios_Estado) {
        this.Cusuarios_Estado = Cusuarios_Estado;
    }

    public String getVpersonal_ApellNom() {
        return Vpersonal_ApellNom;
    }

    public void setVpersonal_ApellNom(String Vpersonal_ApellNom) {
        this.Vpersonal_ApellNom = Vpersonal_ApellNom;
    }

    public int getCusuariosCod() {
        return CusuariosCod;
    }

    public void setCusuariosCod(int CusuariosCod) {
        this.CusuariosCod = CusuariosCod;
    }

    public char getCperfiles_Cod() {
        return Cperfiles_Cod;
    }

    public void setCperfiles_Cod(char Cperfiles_Cod) {
        this.Cperfiles_Cod = Cperfiles_Cod;
    }

    public String getVperfiles_Descripcion() {
        return Vperfiles_Descripcion;
    }

    public void setVperfiles_Descripcion(String Vperfiles_Descripcion) {
        this.Vperfiles_Descripcion = Vperfiles_Descripcion;
    }

}
