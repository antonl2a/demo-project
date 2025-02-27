package domain.mapping;

import com.demo_project.DemoProject.domain.dto.UserDto;
import com.demo_project.DemoProject.domain.entities.User;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ModelMapperTest {
    private final ModelMapper modelMapper = new ModelMapper();

    @Test
    void successfulMappingUserDtoToUser() {
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
