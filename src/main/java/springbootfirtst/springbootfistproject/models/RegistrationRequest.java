package springbootfirtst.springbootfistproject.models;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {

    private final String firstname;
    private final String lastname;
    private final String email;
    private final String password;
}
