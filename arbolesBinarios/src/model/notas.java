/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author macbookair
 */
public class notas extends nodo{
    //Atributos
    String nombreMat;
    float n1;
    float n2;
    float n3;
    float def;
    //Métodos
    //Constructores

    public notas() {
    }

    public notas(String nombreMat, float n1, float n2, float n3, float def, int id) {
        super(id);
        this.nombreMat = nombreMat;
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.def = def;
    }

    public String getNombreMat() {
        return nombreMat;
    }

    public void setNombreMat(String nombreMat) {
        this.nombreMat = nombreMat;
    }

    public float getN1() {
        return n1;
    }

    public void setN1(float n1) {
        this.n1 = n1;
    }

    public float getN2() {
        return n2;
    }

    public void setN2(float n2) {
        this.n2 = n2;
    }

    public float getN3() {
        return n3;
    }

    public void setN3(float n3) {
        this.n3 = n3;
    }

    public float getDef() {
        return def;
    }

    public void setDef(float def) {
        this.def = def;
    }
    
    
}
