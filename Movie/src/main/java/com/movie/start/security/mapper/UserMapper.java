package com.movie.start.security.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.movie.start.security.dto.AuthenticationDto;
import com.movie.start.security.entity.UserEntity;
@Component
public class UserMapper {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private PasswordEncoder encoder;

	public UserEntity authentication2User(AuthenticationDto authenticationDto) {
		String pass = encoder.encode(authenticationDto.getPassword());
		authenticationDto.setPassword(pass);

		return modelMapper.map(authenticationDto, UserEntity.class);
	}

}
