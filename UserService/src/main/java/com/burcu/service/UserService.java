package com.burcu.service;

import com.burcu.dto.request.BalanceRequestDto;
import com.burcu.dto.request.CreateUserRequestDto;
import com.burcu.dto.request.UpdateUserRequestDto;
import com.burcu.dto.response.BalanceResponseDto;
import com.burcu.dto.response.UserResponseDto;
import com.burcu.dto.response.ViewProfileResponseDto;
import com.burcu.entity.User;
import com.burcu.exception.ErrorType;
import com.burcu.exception.UserServiceException;
import com.burcu.mapper.UserMapper;
import com.burcu.repository.UserRepository;
import com.burcu.utility.JwtTokenManager;
import com.burcu.utility.ServiceManager;
import com.burcu.utility.enums.EStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService extends ServiceManager<User,String> {
    private final UserRepository userRepository;
    private final JwtTokenManager jwtTokenManager;


    public UserService(UserRepository userRepository, JwtTokenManager jwtTokenManager) {
        super(userRepository);
        this.userRepository = userRepository;
        this.jwtTokenManager = jwtTokenManager;
    }

    /**
     * Kullanıcı oluşturmayı sağlayan method.
     * @param dto
     * @return
     */
    public Boolean createUser(CreateUserRequestDto dto) {
        try {
            userRepository.saveAll(List.of());
            save(UserMapper.INSTANCE.fromCreateUserRequestDtoToUser(dto));
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
        Optional<Long> authId=jwtTokenManager.getIdFromToken(dto.getToken());
        if (authId.isEmpty()){
            throw new UserServiceException(ErrorType.USER_NOT_FOUND);
        }

        User user= userRepository.findByAuthId(authId.get()).get();
        user.setEmail(dto.getEmail());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setAddress(dto.getAddress());
        user.setAbout(dto.getAbout());
        user.setAvatar(dto.getAvatar());
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setBalance(dto.getBalance());

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

    /**
     * Girilen token bilgisine göre böyle bir kayıtın olup olmadığı kontrol edilir.
     * @param token
     * @return
     */

    public UserResponseDto findByToken(String token) {
        Optional<Long> authId= jwtTokenManager.getIdFromToken(token);
        if (authId.isEmpty()){
            throw new UserServiceException(ErrorType.USER_NOT_FOUND);
        }
        User user= userRepository.findByAuthId(authId.get()).get();
        return UserMapper.INSTANCE.fromUserToUserResponseDto(user);
    }

    /**
     * Bakiye yüklemesi yapılır.
     * @param dto
     * @return
     */

    // payment service ile.
    public BalanceResponseDto topUpBalance(BalanceRequestDto dto) {
        Optional<Long> authId= jwtTokenManager.getIdFromToken(dto.getToken());
        if (authId.isEmpty()){
            throw new UserServiceException(ErrorType.USER_NOT_FOUND);
        }
        User user= userRepository.findByAuthId(authId.get()).get();
        user.setBalance(user.getBalance()+dto.getBalance());
        update(user);
        return UserMapper.INSTANCE.fromUserToBalanceResponseDto(user);
    }


    /**
     * Kullanıcının profilini görüntülemeyi sağlar.
     * @param token
     * @return
     */
    public ViewProfileResponseDto viewProfile(String token) {
        Optional<Long> authId= jwtTokenManager.getIdFromToken(token);
        if (authId.isEmpty()){
            throw new UserServiceException(ErrorType.USER_NOT_FOUND);
        }
        User user= userRepository.findByAuthId(authId.get()).get();
        return UserMapper.INSTANCE.fromUserToViewProfileResponseDto(user);
    }



}


