package hello.Entities;


import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comments {
    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "comment")
    @NotNull
    private String comment;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @NotNull
    @Column(name = "id")
    private int id;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
