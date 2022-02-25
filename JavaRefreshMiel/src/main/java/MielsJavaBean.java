//https://stackoverflow.com/questions/3295496/what-is-a-javabean-exactly

import java.io.Serializable;

public class MielsJavaBean implements Serializable {
    private String name = "Miel";

    public MielsJavaBean() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
