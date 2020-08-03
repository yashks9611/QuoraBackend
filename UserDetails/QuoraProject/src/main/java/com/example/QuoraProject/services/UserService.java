package com.example.QuoraProject.services;

import com.example.QuoraProject.dto.ImageDto;
import com.example.QuoraProject.dto.UserDto;
import com.example.QuoraProject.entity.User;

import java.util.List;

public interface UserService{

    public User saveUsers(User users);
    public User updateUser(UserDto updatedUser);
    public List<User> findAllUsers();
    public List<UserDto> searchResult(String keyword);
    public String saveImg(ImageDto img);
    public ImageDto getImg(String imgId);
}
