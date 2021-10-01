package hello.Entities;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "weight")
public class Weight {
        @Column(name = "first_value")
        @NotNull
        private String first_value;

        @Column(name = "second_value")
        @NotNull
        private String second_value;

        @Column(name = "difference")
        @NotNull
        private String difference;

        @Id
        private int id;
        public void setId(int id) {
            this.id = id;
        }
        public int getId() {
            return id;
        }

        public String Getdifference(){
            return difference;
        }

}
