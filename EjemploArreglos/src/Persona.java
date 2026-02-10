public class Persona {

    private int id;
    private String name;
    private boolean isActive;


    public Persona() {
    }

    public Persona(int id, String name){
        this.id=id;
        this.name=name;
        this.isActive=true;
    }



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", isActive=").append(isActive);
        sb.append('}');
        return sb.toString();
    }



}