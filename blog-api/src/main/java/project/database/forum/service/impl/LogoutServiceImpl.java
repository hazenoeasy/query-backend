package project.database.forum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import project.database.forum.service.struct.LogoutService;

/**
 * @author Yuh Z
 * @date 12/9/21
 */
@Service
public class LogoutServiceImpl implements LogoutService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Override
    public void logout(String token) {
        redisTemplate.delete("TOKEN_"+token);
    }
}
