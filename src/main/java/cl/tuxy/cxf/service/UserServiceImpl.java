/**
 * Copyright (C) 2016  Jose P. Bovet Derpich (jose.bovet@gmail.com)
 * <p>
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package cl.tuxy.cxf.service;

import cl.tuxy.cxf.mapper.UserMapper;
import cl.tuxy.cxf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by josebovet on 10/17/16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> listUsers() {
        return userMapper.findAllUsers();
    }

    @Override
    public User getUserByid(Integer id) {
        return userMapper.findUserById(id);
    }


}
