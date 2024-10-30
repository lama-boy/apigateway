package msa.prj.apigateway.service;

import lombok.RequiredArgsConstructor;
import msa.prj.apigateway.dto.CustomUserDetail;
import msa.prj.apigateway.entity.UserEntity;
import msa.prj.apigateway.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException {

        //DB에서 조회
        UserEntity userData = userRepository.findByUserId(user_id);

        if (userData != null) {
            //UserDetails에 담아서 return하면 AutneticationManager가 검증 함
            return new CustomUserDetail(userData);
        }

        return null;
    }


}
