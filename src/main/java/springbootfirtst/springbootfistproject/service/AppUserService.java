package springbootfirtst.springbootfistproject.service;


import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import springbootfirtst.springbootfistproject.models.AppUser;
import springbootfirtst.springbootfistproject.repo.AppUserRepo;


@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final AppUserRepo appUserRepo;
    private static final String msg = "NOT FOUND EXCEPTION FOR THE EMAIL %s";
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepo.findByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException(String.format(msg, username))
        );
    }


    public String signUpUser(AppUser appUser) {
        boolean present = appUserRepo.findByEmail(appUser.getEmail())
                .isPresent();
        if (present) {
            throw new IllegalStateException("email already taken ");
        }
        String encodedPassword = passwordEncoder.encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);



        appUserRepo.save(appUser);

        return "It worked";
    }






}
