package com.example.fatec_ipi_chat;

import java.util.Date;

class Mensagem implements Comparable <Mensagem> {
    private String usuario;
    private Date date;
    private String texto;

    @Override
    public int compareTo(Mensagem o) {
        return this.date.compareTo(o.date);
    }

    public Mensagem(String usuario, Date date, String texto) {
        this.usuario = usuario;
        this.date = date;
        this.texto = texto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
