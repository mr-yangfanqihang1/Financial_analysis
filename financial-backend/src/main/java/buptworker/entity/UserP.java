package buptworker.entity;

public class UserP {
    Integer id;
    Double p;

    public UserP() {
    }

    public UserP(Integer id, double p) {
        this.id = id;
        this.p = p;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getP() {
        return p;
    }

    public void setP(Double p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "UserP{" +
                "id=" + id +
                ", p=" + p +
                '}';
    }
}
