package ua.goit.dev88.converter;

import ua.goit.dev88.model.dao.User;
import ua.goit.dev88.model.dto.UserDto;

public class ConvertUser {
    public UserDto from(User user){
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(user.getPassword()).build();
    }
}
