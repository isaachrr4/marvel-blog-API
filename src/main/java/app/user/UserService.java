package app.user;

import app.helpers.dtos.ResourceCreationResponse;
import app.user.dtos.UserResponse;
import app.user.dtos.NewUserRequest;
import app.helpers.datasource.EntitySearcher;
import java.util.List;

import app.util.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepo;
    private final EntitySearcher entitySearcher;

    @Autowired
    public UserService(UserRepository userRepo, EntitySearcher entitySearcher) {
        this.userRepo = userRepo;
        this.entitySearcher = entitySearcher;

    }

    public List<UserResponse> fetchAllUsers() {
        return userRepo.findAll()
                .stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }


    public List<UserResponse> search(Map<String, String> requestParamMap) {
        if (requestParamMap.isEmpty()) return fetchAllUsers();
        Set<User> matchingUsers = entitySearcher.searchForEntity(requestParamMap, User.class);
        if (matchingUsers.isEmpty()) throw new ResourceNotFoundException();
        return matchingUsers.stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }


    public ResourceCreationResponse createUser(@Valid NewUserRequest newUserReq){
        User newUser = newUserReq.extractResource();

        if(userRepo.existsByUsername(newUser.getUsername())){
            //throw new Exception("This username is taken");
        }

/*        int randomInt = ThreadLocalRandom.current().nextInt(0, 1000000);
        newUser.setUserId(randomInt);*/

        newUser.setRoleId(2);
        userRepo.save(newUser);

        return new ResourceCreationResponse(newUser.getUserId());
    }



}
