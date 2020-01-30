package glim.antony.soapexample;

import glim.antony.soapexample.util.User;
import glim.antony.soapexample.util.UsersList;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class SoapUsersService {
    private List<User> users;

    @PostConstruct
    public void init() {
        this.users = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            User user = new User();
            user.setName("Name " + i);
            user.setSecondName("SecondName " + i);
            user.setPhone("+712345678" + i);
            user.setAddress("Some Address " + i);
            users.add(user);
        }
    }

    public UsersList getAllUsers() {
        UsersList usersList = new UsersList();
        usersList.getUsers().addAll(this.users);
        return usersList;
    }
}
