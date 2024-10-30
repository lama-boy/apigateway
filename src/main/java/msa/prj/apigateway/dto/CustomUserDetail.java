package msa.prj.apigateway.dto;

import lombok.RequiredArgsConstructor;
import msa.prj.apigateway.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
public class CustomUserDetail implements UserDetails {

    private final UserEntity userEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collection = new ArrayList<>();

        collection.add(new GrantedAuthority() {

            @Override
            public String getAuthority() {

                return userEntity.getRole();
            }
        });

        return collection;
    }

    public String getUserId() {
        return userEntity.getUser_id();
    }

    public String getUserInterest() {
        return userEntity.getInterest();
    }

    @Override
    public String getPassword() {

        return userEntity.getUser_pw();
    }

    @Override
    public String getUsername() {

        return userEntity.getUser_name();
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

    @Override
    public boolean isEnabled() {

        return true;
    }
}