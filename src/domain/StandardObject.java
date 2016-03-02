/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author ricardocasanova
 */
public class StandardObject implements Serializable
{
    private String protocolo;
    private Object objeto;

    public StandardObject(String protocolo, Object objeto)
    {
        this.protocolo = protocolo;
        this.objeto = objeto;
    }

    public String getProtocolo()
    {
        return protocolo;
    }

    public void setProtocolo(String protocolo)
    {
        this.protocolo = protocolo;
    }

    public Object getObjeto()
    {
        return objeto;
    }

    public void setObjeto(Object objeto)
    {
        this.objeto = objeto;
    }
}
