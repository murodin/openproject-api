package tug.it.openprojectapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tug.it.openprojectapi.domain.Users;
import tug.it.openprojectapi.respository.UsersRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    public String getUserFirstLastName(Integer userId) {
        Users user = usersRepository.findById(
                Optional.ofNullable(userId).orElse(0)
        ).orElseGet(Users::getDefaultUser);

        return user.getFirstname().toUpperCase() +" "+user.getLastname().toUpperCase();
    }
}
