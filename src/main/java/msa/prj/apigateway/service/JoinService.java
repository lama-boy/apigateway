package msa.prj.apigateway.service;

import lombok.RequiredArgsConstructor;
import msa.prj.apigateway.dto.JoinDto;
import msa.prj.apigateway.entity.UserEntity;
import msa.prj.apigateway.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserRepository userRepository;

    public void joinProcess(JoinDto joinDto){
        String user_id = joinDto.getUser_id();
        String user_name = joinDto.getUser_name();
        String user_pw = joinDto.getUser_pw();

        Boolean isExist = userRepository.userIdVerification(user_id);

        if(!isExist){
            return;
        }


        UserEntity userEntity = new UserEntity();
        userEntity.setUser_id(user_id);
        userEntity.setUser_name(user_name);
        userEntity.setUser_pw(bCryptPasswordEncoder.encode(user_pw));
        userEntity.setRole("ROLE_USER");

        userRepository.save(userEntity);
    }

}
