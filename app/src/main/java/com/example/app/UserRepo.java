package com.example.app;


//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import com.example.app.UserResume;

@Repository
public interface UserRepo extends JpaRepository<UserResume, String>  {
    
    UserResume findByUserId(int userId);
    
}

    

