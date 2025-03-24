package devcldkai.kaipizzas.service;

import devcldkai.kaipizzas.domain.entities.Accounts;
import devcldkai.kaipizzas.domain.entities.Orders;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface IAccountsService {

    void save(Accounts accounts);

    void saveNotFullInfo(Accounts accounts);

    void delete(Accounts accounts);

    List<Accounts> getAll();

    Optional<Accounts> getById(String id);

    Optional<Accounts> getByUsername(String username);

    List<Orders> getAllHistoryOrders(String accountId);

    boolean existsByUsername(String username);

    boolean updatePassword(String username, String newPassword);

    boolean updateEmail(String username, String newEmail);

    boolean updateFirstName(String username, String newFirstName);

    boolean updateLastName(String username, String newLastName);

    boolean updatePhone(String username, String newPhone);

    boolean updateDateOfBirth(String username, Date newDateOfBirth);

    boolean updateImageUrl(String username, String newImageUrl);

    boolean updatePointRewards(String username, double pointRewards);

    boolean updateStatus(String accountId, String newStatus);

    boolean updateAbout(String newAbout, String username);
}
