package TestDate;

public enum Tare {
    pcs("pcs."), kg("kg."), pack("pack"), l("l"), g("g"), bottles("bottles"), box("box"), m("m"), sm("sm"), unit("unit");

    String name;

    Tare(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Tare{" +
                "name='" + name + '\'' +
                '}';
    }
}
