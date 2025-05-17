package com.example.twilio_demo.Models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "users")
@Data
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String role;

    // 🟢 Vrací roli uživatele (např. "ROLE_USER")
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); // nebo můžeš podle role, viz níže
    }

    // 🟢 Tohle vrací uživatelské jméno pro přihlášení
    @Override
    public String getUsername() {
        return username;
    }

    // 🟢 Vrací heslo
    @Override
    public String getPassword() {
        return password;
    }

    // ✅ Tohle všechno můžeš ponechat jako true pro základní použití
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

    @Override
    public boolean isEnabled() {
        return true;
    }
}
