package chapter4.snippets;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
class User {
    private Long ID;
    private String name;
}