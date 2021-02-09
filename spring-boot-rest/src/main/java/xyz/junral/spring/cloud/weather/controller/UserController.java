package xyz.junral.spring.cloud.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.junral.spring.cloud.weather.domain.User;
import xyz.junral.spring.cloud.weather.repository.UserRepository;

import java.util.List;

/**
 * User Controller.
 * @author Junral
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 获取用户列表
     * @return
     */
    @GetMapping
    public List<User> getUsers() {
        return userRepository.listUser();
    }

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userRepository.getUserById(id);
    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.saveOrUpdate(user);
    }

    /**
     * 修改用户
     * @param id
     * @param user
     */
    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        User oldUser = userRepository.getUserById(id);
        if (oldUser != null) {
            user.setId(id);
            userRepository.saveOrUpdate(user);
        }
    }

    /**
     * 删除用户
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userRepository.deleteUser(id);
    }

}
