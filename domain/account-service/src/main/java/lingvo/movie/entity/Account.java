package lingvo.movie.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

/**
 * Created by yaroslav on 10.05.16.
 */
@Entity
@Table(name = "ACCOUNT")
@Data
@ToString(of = {"name", "email"}) @EqualsAndHashCode(of = {"name", "email"})
public class Account implements UserDetails {
    @Id
    @GeneratedValue
    Long id;

    @Size(max=20)
    @Column(nullable = false, unique = true)
    String name;

    @Size(min=3, max=20)
    @Column(nullable = false)
    String password;

    @Pattern(regexp = "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)", message = "Email is not in valid format")
    @Column(unique = true)
    String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLES")
    List<Authority> authorities;

    boolean enabled = true;

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
