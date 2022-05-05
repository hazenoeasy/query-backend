package project.database.forum.vo.params;

import lombok.Data;

/**
 * @author Yuh Z
 * @date 5/5/22
 */
@Data
public class RegisterParams {
    private String username;
    private String password;
    private String email;
    private String country;
    private String state;
    private String city;
    private String profile;
}
