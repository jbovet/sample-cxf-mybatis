package cl.tuxy.cxf.controller;

import cl.tuxy.cxf.model.User;
import cl.tuxy.cxf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Camilo Jorquera on 15-10-18
 */
@RequestMapping("/api/v1/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.listUsers();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id) {
        return userService.getUserByid(id);
    }

}