/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import model.notas;
/**
 *
 * @author macbookair
 */
public class cNotas extends CRUD{
    //Constructor
    public cNotas() {
    }
    //CRUD (create, insert)
    private notas create(String nom, float n1, float n2, float n3, float def, int id){
        return new notas(nom, n1, n2, n3, def, id); 
    }
    public boolean insert(String nom, float n1, float n2, float n3, float def, int id){
        if(this.insert(this.raiz, this.create(nom, n1, n2, n3, def, id)) != null){
            return true;
        }else{
            return false;
        }
    }
    //Read
    private String inOrden(notas r){
        String resp = "";
        if(r != null){
            // 1. Se mueve a la izquierda
            if(r.getIzq() != null){//puede continuar moviendose a la izq
                resp = this.inOrden((notas)r.getIzq());
            }
            // 2. Consulta la raíz (r)
            resp = resp + r.getId()+","+r.getNombreMat()+","+r.getN1()+","+r.getN2()+","+r.getN3()+","+r.getDef()+"\n";
            System.out.println(r.getId()+","+r.getNombreMat()+","+r.getN1()+","+r.getN2()+","+r.getN3()+","+r.getDef());
            // 3. Se mueve a la derecha
            if(r.getDer() != null){//puede continuar moviendose a la izq
                resp = resp + this.inOrden((notas)r.getDer());
            }
        }
        return resp;
    }
    private String preOrden(notas r){
        String resp = "";
        if(r != null){
            // 1. Consulta la raíz (r)
            resp = resp + r.getId()+","+r.getNombreMat()+","+r.getN1()+","+r.getN2()+","+r.getN3()+","+r.getDef()+"\n";
            System.out.println(r.getId()+","+r.getNombreMat()+","+r.getN1()+","+r.getN2()+","+r.getN3()+","+r.getDef());
            // 2. Se mueve a la izquierda
            if(r.getIzq() != null){//puede continuar moviendose a la izq
                resp = resp + this.inOrden((notas)r.getIzq());
            }
            // 3. Se mueve a la derecha
            if(r.getDer() != null){//puede continuar moviendose a la izq
                resp = resp + this.inOrden((notas)r.getDer());
            }
        }
        return resp;
    }
    private String postOrden(notas r){
        String resp = "";
        if(r != null){
            // 1. Se mueve a la izquierda
            if(r.getIzq() != null){//puede continuar moviendose a la izq
                resp = this.inOrden((notas)r.getIzq());
            }
            // 2. Se mueve a la derecha
            if(r.getDer() != null){//puede continuar moviendose a la izq
                resp = resp + this.inOrden((notas)r.getDer());
            }
            // 3. Consulta la raíz (r)
            resp = resp + r.getId()+","+r.getNombreMat()+","+r.getN1()+","+r.getN2()+","+r.getN3()+","+r.getDef()+"\n";
            System.out.println(r.getId()+","+r.getNombreMat()+","+r.getN1()+","+r.getN2()+","+r.getN3()+","+r.getDef());
        }
        return resp;
    }
    public String showAll(){
        String respuesta = "inOrden\n"+this.inOrden((notas)this.raiz);
        respuesta = respuesta + "\npreOrden\n" + this.preOrden((notas)this.raiz);
        respuesta = respuesta + "\npostOrden\n"+ this.postOrden((notas)this.raiz);
        return respuesta;
    }
    public String select(int id){
        notas r =  (notas)this.search(this.raiz, id);
        if(r != null){//encontró un nodo con el identificador id
            return r.getId()+","+r.getNombreMat()+","+r.getN1()+","+r.getN2()+","+r.getN3()+","+r.getDef();
        }else{//no encontró ninguna coincidencia
            return null;
        }
    }
}
