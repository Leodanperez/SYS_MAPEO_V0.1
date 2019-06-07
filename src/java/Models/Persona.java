/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author GUSTAVO MANRIQUE
 */
public class Persona {
    
    private char Cdocidentidad_Cod;
    private String Vpersona_Nrodoc;
    private char Clrmilitares_Mesproc;
    private int Mlrmilitares_Numproc;
    private char CcatPersona_Cod;
    private int Cmilitares_Cip;
    private char Cgrados_Cod;
    private char Carmas_Codarmas;
    private String Vpersonal_ApellNom;
    private char Cunidades_Cod;
    private char Csitumil_Cod;
    private char Cestadocivil_Cod;
    private char Cpersona_Sexo;
    private Date Dpersona_Fecnac;
    private Date Dpersona_Fecingsecpub;
    private Date Dmilitar_Fechalta;
    private char Cusuarios_Cod;
    private String  Vusuarios_Login;

    public Persona() {
    }

    public char getCdocidentidad_Cod() {
        return Cdocidentidad_Cod;
    }

    public void setCdocidentidad_Cod(char Cdocidentidad_Cod) {
        this.Cdocidentidad_Cod = Cdocidentidad_Cod;
    }

    public String getVpersona_Nrodoc() {
        return Vpersona_Nrodoc;
    }

    public void setVpersona_Nrodoc(String Vpersona_Nrodoc) {
        this.Vpersona_Nrodoc = Vpersona_Nrodoc;
    }

    public char getClrmilitares_Mesproc() {
        return Clrmilitares_Mesproc;
    }

    public void setClrmilitares_Mesproc(char Clrmilitares_Mesproc) {
        this.Clrmilitares_Mesproc = Clrmilitares_Mesproc;
    }

    public int getMlrmilitares_Numproc() {
        return Mlrmilitares_Numproc;
    }

    public void setMlrmilitares_Numproc(int Mlrmilitares_Numproc) {
        this.Mlrmilitares_Numproc = Mlrmilitares_Numproc;
    }

    public char getCcatPersona_Cod() {
        return CcatPersona_Cod;
    }

    public void setCcatPersona_Cod(char CcatPersona_Cod) {
        this.CcatPersona_Cod = CcatPersona_Cod;
    }

    public int getCmilitares_Cip() {
        return Cmilitares_Cip;
    }

    public void setCmilitares_Cip(int Cmilitares_Cip) {
        this.Cmilitares_Cip = Cmilitares_Cip;
    }

    public char getCgrados_Cod() {
        return Cgrados_Cod;
    }

    public void setCgrados_Cod(char Cgrados_Cod) {
        this.Cgrados_Cod = Cgrados_Cod;
    }

    public char getCarmas_Codarmas() {
        return Carmas_Codarmas;
    }

    public void setCarmas_Codarmas(char Carmas_Codarmas) {
        this.Carmas_Codarmas = Carmas_Codarmas;
    }

    public String getVpersonal_ApellNom() {
        return Vpersonal_ApellNom;
    }

    public void setVpersonal_ApellNom(String Vpersonal_ApellNom) {
        this.Vpersonal_ApellNom = Vpersonal_ApellNom;
    }

    public char getCunidades_Cod() {
        return Cunidades_Cod;
    }

    public void setCunidades_Cod(char Cunidades_Cod) {
        this.Cunidades_Cod = Cunidades_Cod;
    }

    public char getCsitumil_Cod() {
        return Csitumil_Cod;
    }

    public void setCsitumil_Cod(char Csitumil_Cod) {
        this.Csitumil_Cod = Csitumil_Cod;
    }

    public char getCestadocivil_Cod() {
        return Cestadocivil_Cod;
    }

    public void setCestadocivil_Cod(char Cestadocivil_Cod) {
        this.Cestadocivil_Cod = Cestadocivil_Cod;
    }

    public char getCpersona_Sexo() {
        return Cpersona_Sexo;
    }

    public void setCpersona_Sexo(char Cpersona_Sexo) {
        this.Cpersona_Sexo = Cpersona_Sexo;
    }

    public Date getDpersona_Fecnac() {
        return Dpersona_Fecnac;
    }

    public void setDpersona_Fecnac(Date Dpersona_Fecnac) {
        this.Dpersona_Fecnac = Dpersona_Fecnac;
    }

    public Date getDpersona_Fecingsecpub() {
        return Dpersona_Fecingsecpub;
    }

    public void setDpersona_Fecingsecpub(Date Dpersona_Fecingsecpub) {
        this.Dpersona_Fecingsecpub = Dpersona_Fecingsecpub;
    }

    public Date getDmilitar_Fechalta() {
        return Dmilitar_Fechalta;
    }

    public void setDmilitar_Fechalta(Date Dmilitar_Fechalta) {
        this.Dmilitar_Fechalta = Dmilitar_Fechalta;
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
    
}
