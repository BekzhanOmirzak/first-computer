package springbootfirtst.springbootfistproject.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springbootfirtst.springbootfistproject.models.RegistrationRequest;
import springbootfirtst.springbootfistproject.service.RegistrationService;

@RestController
@RequestMapping("api/registration")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

    @PostMapping("post")
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

}
