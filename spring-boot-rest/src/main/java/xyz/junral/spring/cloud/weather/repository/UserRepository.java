package xyz.junral.spring.cloud.weather.repository;

import xyz.junral.spring.cloud.weather.domain.User;

import java.util.List;

public interface UserRepository {

    /**
     * 新增或修改用户
     * @param user
     * @return
     */
    User saveOrUpdate(User user);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(Long id);

    /**
     * 根据用户id获取用户
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 获取所有用户的列表
     * @return
     */
    List<User> listUser();
}
