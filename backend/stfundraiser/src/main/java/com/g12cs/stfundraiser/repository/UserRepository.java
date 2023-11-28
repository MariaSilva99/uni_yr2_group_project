/*package com.g12cs.stfundraiser.repository;

public interface UserRepository extends CrudRepository<User, Integer>{
    //	NOTE: CAN CREATE SIMPLER 'DERIVED' QUERIES E.G. findBy[field] ETC.
    @Query("SELECT u FROM User u WHERE u.username = :username")
    public User getUserByUsername(@Param("username") String username);
    *//*
    @Query("INSERT INTO users (active, email, first_name, last_name, password, role, username)" +
            " VALUES('1', ':e', ':f', ':l', ':p', ':r', ':u')")
    public int registerUser(@Param("e") String email, @Param("f") String name, @Param("l") String lName,
                            @Param("p") String passw, @Param("r") String role, @Param("u") String username);
     *//*
}*/

package com.g12cs.stfundraiser.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.g12cs.stfundraiser.models.User;

public interface UserRepository extends  JpaRepository<User, Integer>{
    User findByUsername(String username);
    User findById(int id);
    User findByEmail(String email);
    List<User> findByRole ( String role );


}





