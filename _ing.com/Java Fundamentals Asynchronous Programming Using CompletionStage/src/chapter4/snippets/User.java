package chapter4.snippets;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
class User {
    private Long ID;
    private String name;

    public User(Long ID) {
        this.ID = ID;
        if (ID.equals(1L)) name = this.name = "Isabella";
        if (ID.equals(2L)) name = this.name = "Kim";
        if (ID.equals(3L)) name = this.name = "Miel";
    }

    public User(Long ID, String name) {
        this.ID = ID;
        this.name = name;
    }

}