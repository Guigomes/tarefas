package br.com.ggsoftware.tarefas.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;
@Entity(indexes = {
        @Index(value = "nome, dataInicio DESC", unique = true)
})
public class Tarefa {


    @Id
        private Long id;

        @NotNull
        private String nome;
    @NotNull
        private int periodo;

    @NotNull
            private int  periodicidade;
    @NotNull
            private Date dataInicio;
            private Date dataFim;
    @NotNull
            private Date dataInclusao;
            private int valorPeridiocidade;
            private Date dataProximoDiaTarefa;
        @Generated(hash = 1878237495)
        public Tarefa(Long id, @NotNull String nome, int periodo, int periodicidade,
                @NotNull Date dataInicio, Date dataFim, @NotNull Date dataInclusao,
                int valorPeridiocidade, Date dataProximoDiaTarefa) {
            this.id = id;
            this.nome = nome;
            this.periodo = periodo;
            this.periodicidade = periodicidade;
            this.dataInicio = dataInicio;
            this.dataFim = dataFim;
            this.dataInclusao = dataInclusao;
            this.valorPeridiocidade = valorPeridiocidade;
            this.dataProximoDiaTarefa = dataProximoDiaTarefa;
        }
        @Generated(hash = 1689118484)
        public Tarefa() {
        }
        public Long getId() {
            return this.id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getNome() {
            return this.nome;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }
        public int getPeriodo() {
            return this.periodo;
        }
        public void setPeriodo(int periodo) {
            this.periodo = periodo;
        }
        public int getPeriodicidade() {
            return this.periodicidade;
        }
        public void setPeriodicidade(int periodicidade) {
            this.periodicidade = periodicidade;
        }
        public Date getDataInicio() {
            return this.dataInicio;
        }
        public void setDataInicio(Date dataInicio) {
            this.dataInicio = dataInicio;
        }
        public Date getDataFim() {
            return this.dataFim;
        }
        public void setDataFim(Date dataFim) {
            this.dataFim = dataFim;
        }
        public Date getDataInclusao() {
            return this.dataInclusao;
        }
        public void setDataInclusao(Date dataInclusao) {
            this.dataInclusao = dataInclusao;
        }
        public int getValorPeridiocidade() {
            return this.valorPeridiocidade;
        }
        public void setValorPeridiocidade(int valorPeridiocidade) {
            this.valorPeridiocidade = valorPeridiocidade;
        }
        public Date getDataProximoDiaTarefa() {
            return this.dataProximoDiaTarefa;
        }
        public void setDataProximoDiaTarefa(Date dataProximoDiaTarefa) {
            this.dataProximoDiaTarefa = dataProximoDiaTarefa;
        }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", periodo=" + periodo +
                ", periodicidade=" + periodicidade +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", dataInclusao=" + dataInclusao +
                ", valorPeridiocidade=" + valorPeridiocidade +
                ", dataProximoDiaTarefa=" + dataProximoDiaTarefa +
                '}';
    }
}
