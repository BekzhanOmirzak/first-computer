package springbootfirtst.springbootfistproject.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import springbootfirtst.springbootfistproject.models.AppUser;
import springbootfirtst.springbootfistproject.models.AppUserRole;
import springbootfirtst.springbootfistproject.models.RegistrationRequest;
import springbootfirtst.springbootfistproject.util.EmailValidator;


@Service
@AllArgsConstructor
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final AppUserService appUserService;

    public String register(RegistrationRequest request) {

        boolean validEmail = emailValidator.test(request.getEmail());

        if (!validEmail) {
            throw new IllegalArgumentException("email is not found");
        }


        return appUserService.signUpUser(
                new AppUser(
                        request.getFirstname(),
                        request.getLastname(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );

    }







}
