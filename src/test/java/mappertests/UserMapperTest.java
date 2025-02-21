package usermappertest;

import com.demo_project.DemoProject.domain.dto.UserDto;
import com.demo_project.DemoProject.domain.entities.User;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserMapperTest {
    private final ModelMapper modelMapper = new ModelMapper();

    @Test
    void testUserToUserDto() {
        User user = new User();
        //user.setId(1L);
        user.setName("asdf");
        user.setEmail("asfdsfsfsfsdf");
        user.setPhoneNumber(123455);
        user.setPassword("dasgsdg12");
        //user.setUserRoles();
        UserDto userDto = modelMapper.map(user, UserDto.class);

        assertThat(userDto).isNotNull();
        assertThat(userDto.getName()).isEqualTo(user.getName());
        assertThat(userDto.getEmail()).isEqualTo(user.getEmail());
        assertThat(userDto.getPhoneNumber()).isEqualTo(user.getPhoneNumber());
        assertThat(userDto.getPassword()).isEqualTo(user.getPassword());

    }

    @Test
    void testUserDtoToUser() {
        UserDto userDto = new UserDto();
        userDto.setName("sgdfs");
        userDto.setEmail("sfgsdsfsfsd");
        userDto.setPhoneNumber(32423);
        userDto.setPassword("sdgdsgsdg");

        User user = modelMapper.map(userDto, User.class);

        assertThat(user).isNotNull();
        assertThat(user.getName()).isEqualTo(userDto.getName());
        assertThat(user.getEmail()).isEqualTo(userDto.getEmail());
        assertThat(user.getPhoneNumber()).isEqualTo(userDto.getPhoneNumber());
        assertThat(user.getPassword()).isEqualTo(userDto.getPassword());
    }

}
