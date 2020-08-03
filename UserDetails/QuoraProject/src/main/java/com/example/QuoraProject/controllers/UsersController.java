package com.example.QuoraProject.controllers;

import com.example.QuoraProject.dto.ImageDto;
import com.example.QuoraProject.dto.UserDto;
import com.example.QuoraProject.entity.User;
import com.example.QuoraProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/users")
@CrossOrigin( origins = "*", methods = { RequestMethod.PUT , RequestMethod.GET , RequestMethod.POST } )
public class UsersController {


    @Autowired
    UserService userService;

    @PostMapping(path="/addUsers", produces="application/json")
    public User addusers(@Validated @RequestBody User user )
    {
        System.out.println(user.getUsername());
        return userService.saveUsers(user);
    }

    @PostMapping(path="/updateUsers", produces ="application/json")
    public User updateUserDetails(@RequestBody UserDto updatedUser){
        System.out.println(updatedUser);
        return userService.updateUser(updatedUser);
    }

    @PostMapping(path="/uploadImage")
    public JSONObject uploadImage(@RequestParam("Image") MultipartFile file) throws IOException {
//        System.out.println(file.toString());
//        return "";
        JSONObject obj=new JSONObject();
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        ImageDto img = new ImageDto();
        System.out.println(file.getOriginalFilename());
        img.setImageName(file.getOriginalFilename());
        img.setImgByte(file.getBytes());
        String res = userService.saveImg(img);
        System.out.println(res);
        obj.put("imageId",res);
        return obj;
    }

    @GetMapping (path="/retrieveImage/{imageId}")
    public ImageDto getImage(@PathVariable("imageId") String imgId){
        return userService.getImg(imgId);
    }

    @GetMapping("/validateUser")
    public String validateuser()
    {
        return "\"user validated\"";
    }

    @GetMapping("/getUsers")
    public List<User> getusers()
    {
       return userService.findAllUsers();
    }

    @GetMapping(path = "search/{keyword}", produces = "application/json")
    public List<UserDto> getSearchResult(@PathVariable("keyword") String keyword) {
        return userService.searchResult(keyword);
    }
}
