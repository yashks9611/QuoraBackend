package com.example.QuoraProject.services.impl;

import com.example.QuoraProject.dto.ImageDto;
import com.example.QuoraProject.dto.UserDto;
import com.example.QuoraProject.entity.Img;
import com.example.QuoraProject.entity.User;
import com.example.QuoraProject.repository.impl.ImgRepository;
import com.example.QuoraProject.repository.impl.UsersRepository;
import com.example.QuoraProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sun.tools.jconsole.JConsole;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    ImgRepository imgRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
     public User saveUsers(User users)
     {
         users.setPassword(passwordEncoder.encode(users.getPassword()));
         System.out.println(users.getUsername());
         return usersRepository.save(users);
     }

     @Override
    public List<User> findAllUsers()
     {
         return usersRepository.findAll();
     }

    @Override
    public List<UserDto> searchResult(String keyword) {
        List<User> itemsList = usersRepository.findAll();
        List<UserDto> foundList = new ArrayList<>();

        for (User items : itemsList) {
            if (items.getUsername().toLowerCase().contains(keyword.toLowerCase())
//                    || items.getFirstname().toLowerCase().contains(keyword.toLowerCase())
//                    || items.getLastname().toLowerCase().contains(keyword.toLowerCase())
            ) {
                UserDto itemDto = new UserDto();
                itemDto.setUserId(items.getUserId());
                itemDto.setFirstname(items.getFirstname());
                itemDto.setLastname(items.getLastname());
                itemDto.setUsername(items.getUsername());
                itemDto.setBio(items.getBio());
                itemDto.setEmail(items.getEmail());
                itemDto.setProfileType(items.isProfileType());
                itemDto.setPassword(items.getPassword());
                itemDto.setImageId(items.getImageId());
                itemDto.setBackgroundImageId(items.getBackgroundImageId());
                itemDto.setPoints(items.getPoints());
                foundList.add(itemDto);
            }
        }
        return foundList;
    }

    @Override
    public User updateUser(UserDto updatedUser) {
        User newUser = usersRepository.findById(updatedUser.getUserId()).get();
        if(updatedUser.getImageId()!=null) {
            newUser.setImageId(updatedUser.getImageId());
        }
        if (updatedUser.getBackgroundImageId()!=null){
            newUser.setBackgroundImageId(updatedUser.getBackgroundImageId());
        }
        if (updatedUser.getBio()!=null){
            newUser.setBio(updatedUser.getBio());
        }
        if (updatedUser.getFirstname()!=null){
            newUser.setFirstname(updatedUser.getFirstname());
        }
        if (updatedUser.getLastname()!=null){
            newUser.setLastname(updatedUser.getLastname());
        }
        if (updatedUser.getEmail()!=null){
            newUser.setEmail(updatedUser.getEmail());
        }
        if (updatedUser.getUsername()!=null){
            newUser.setUsername(updatedUser.getUsername());
        }
        if (updatedUser.getPoints()!=null){
            newUser.setPoints(updatedUser.getPoints());
        }
        newUser.setProfileType(updatedUser.isProfileType());

        usersRepository.save(newUser);
        System.out.println(newUser.getUsername());
        return newUser;
    }

    @Override
    public String saveImg(ImageDto imgSave){
        Img img = new Img();
        img.setImageName(imgSave.getImageName());
        img.setImgByte(compressBytes(imgSave.getImgByte()));
        Img savedImg = imgRepository.save(img);
        System.out.println(savedImg.getImgId());
        return savedImg.getImgId();
    }

    @Override
    public ImageDto getImg(String imgId) {
        Img retImg = imgRepository.findById(imgId).get();
        ImageDto img = new ImageDto();
        img.setImageName(retImg.getImageName());
        img.setImgByte(decompressBytes(retImg.getImgByte()));
        return img;
    }

    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }

    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }
}
