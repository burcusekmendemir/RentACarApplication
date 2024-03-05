package com.burcu.service;

import com.burcu.dto.request.CreateUserRequestDto;
import com.burcu.dto.request.UpdateUserRequestDto;
import com.burcu.entity.User;
import com.burcu.exception.ErrorType;
import com.burcu.exception.UserServiceException;
import com.burcu.mapper.UserMapper;
import com.burcu.repository.UserRepository;
import com.burcu.utility.ServiceManager;
import com.burcu.utility.enums.EStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService extends ServiceManager<User,String> {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    /**
     * Kullanıcı oluşturmayı sağlayan method.
     * @param dto
     * @return
     */
    public Boolean createUser(CreateUserRequestDto dto) {
        try {
            User user= UserMapper.INSTANCE.fromCreateUserRequestDtoToUser(dto);
            save(user);
            return true;
        }catch (Exception e){
            throw new UserServiceException(ErrorType.USER_NOT_CREATED);
        }
    }


    /**
     * Kullanıcı bilgilerini güncellemeyi sağlar.
     * @param dto
     * @return
     */
    public User updateUser(UpdateUserRequestDto dto) {
        Optional<User> userOptional= userRepository.findByAuthId(dto.getAuthId());
        if (userOptional.isEmpty()){
            throw new UserServiceException(ErrorType.USER_NOT_FOUND);
        }

        User user= userOptional.get();
        user.setEmail(dto.getEmail());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setAddress(dto.getAddress());
        user.setAbout(dto.getAbout());
        user.setAvatar(dto.getAvatar());
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());

        return update(user);

    }

    /**
     * Kullanıcının statusunu aktif eder.
     * @param authId
     * @return
     */
    public Boolean activateUser(Long authId) {
        Optional<User> userOptional=userRepository.findByAuthId(authId);
        if (userOptional.isEmpty()){
            throw new UserServiceException(ErrorType.USER_NOT_FOUND);
        }
        User user= userOptional.get();
        user.setStatus(EStatus.ACTIVE);
        update(user);
        return true;
    }
}


