package br.com.ggsoftware.tarefas.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;
@Entity(indexes = {
        @Index(value = "text, date DESC", unique = true)
})
public class Tarefa {


    @Id
        private Long id;

        @NotNull
        private String text;
        private Date date;
        @Generated(hash = 2078127044)
        public Tarefa(Long id, @NotNull String text, Date date) {
            this.id = id;
            this.text = text;
            this.date = date;
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
        public String getText() {
            return this.text;
        }
        public void setText(String text) {
            this.text = text;
        }
        public Date getDate() {
            return this.date;
        }
        public void setDate(Date date) {
            this.date = date;
        }


}
