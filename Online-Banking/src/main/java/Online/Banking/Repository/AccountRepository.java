package Online.Banking.Repository;


import Online.Banking.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    // Use 'user.id' to reference the User entity's ID
    //Account findByUserId(Long userId);
    @Query("SELECT a FROM Account a WHERE a.user.id = :userId")
    Account findByUserId(@Param("userId") Long userId);

}

