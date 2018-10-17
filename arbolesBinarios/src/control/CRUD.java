/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import model.nodo;
/**
 *
 * @author macbookair
 */
public abstract class CRUD {
    nodo raiz;
    //Create
    protected nodo insert(nodo r, nodo nn){
        if(r != null){//el árbol tiene nodos
            if(nn.getId() < r.getId()){// se ubicará a la izq
                if(r.getIzq() != null){//hay nodos a la izq
                    return this.insert(r.getIzq(), nn);//recursivo
                }else{
                    r.setIzq(nn);
                    return nn;
                }
            }else{//se ubicará a la der
                if(r.getDer() != null){//hay nodos a la der
                    return this.insert(r.getDer(), nn);//recursivo
                }else{//no hay para donde moverse
                    r.setDer(nn);
                    return nn;
                }
            }
        }else{//el árbol está vacío
            this.raiz = nn;
            return this.raiz;
        }
    }
    //Read
    protected nodo search(nodo r, int id){
        if(r != null){
            if(r.getId() != id){
                if(id < r.getId()){//el valor puede estar a la izq
                    if(r.getIzq() != null){//se puede mover a la izq
                        return this.search(r.getIzq(), id);// llamada recursiva
                    }else{//no hay valores hacia la izq
                        return null;
                    }
                }else{//el valor puede estar a la der
                    if(r.getDer() != null){//se puede mover a la der
                        return this.search(r.getDer(), id);//llamada recursiva
                    }else{//no se puede mover para la der
                        return null;
                    }
                }
            }else{
                return r;
            }
        }else{
            return null;
        }
    }
}
