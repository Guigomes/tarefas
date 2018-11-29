package br.com.ggsoftware.tarefas.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;
@Entity(indexes = {
        @Index(value = "idTarefa, dataHoje DESC", unique = true)
})
public class TarefaFazer {


    @Id
    private Long id;
    @NotNull
    private int idTarefa;
    @NotNull

    private Date dataHoje;


    private boolean  feito;
    private String comentario;
@Generated(hash = 1898728749)
public TarefaFazer(Long id, int idTarefa, @NotNull Date dataHoje, boolean feito,
        String comentario) {
    this.id = id;
    this.idTarefa = idTarefa;
    this.dataHoje = dataHoje;
    this.feito = feito;
    this.comentario = comentario;
}
@Generated(hash = 1334507638)
public TarefaFazer() {
}
public Long getId() {
    return this.id;
}
public void setId(Long id) {
    this.id = id;
}
public int getIdTarefa() {
    return this.idTarefa;
}
public void setIdTarefa(int idTarefa) {
    this.idTarefa = idTarefa;
}
public Date getDataHoje() {
    return this.dataHoje;
}
public void setDataHoje(Date dataHoje) {
    this.dataHoje = dataHoje;
}
public boolean getFeito() {
    return this.feito;
}
public void setFeito(boolean feito) {
    this.feito = feito;
}
public String getComentario() {
    return this.comentario;
}
public void setComentario(String comentario) {
    this.comentario = comentario;
}


}
