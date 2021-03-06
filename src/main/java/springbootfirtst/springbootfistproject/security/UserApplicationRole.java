package springbootfirtst.springbootfistproject.security;


import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static springbootfirtst.springbootfistproject.security.UserApplicationPermission.*;

public enum UserApplicationRole {

    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE)),
    TRAINEE(Sets.newHashSet(COURSE_READ, STUDENT_READ));

    private final Set<UserApplicationPermission> permissions;

    UserApplicationRole(Set<UserApplicationPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserApplicationPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }



}


