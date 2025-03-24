package devcldkai.kaipizzas.service.impl;

import devcldkai.kaipizzas.authentication.*;
import devcldkai.kaipizzas.domain.entities.Accounts;
import devcldkai.kaipizzas.domain.entities.Orders;
import devcldkai.kaipizzas.repository.UserRepository;
import devcldkai.kaipizzas.repository.impl.UserRepositoryImpl;
import devcldkai.kaipizzas.service.IAccountsService;

import java.sql.Date;
import java.util.*;

public class AccountsService implements IAccountsService {

    private UserRepository userRepository = new UserRepositoryImpl();

    private PasswordEncoder passwordEncoder = new BcryptPasswordEncoder();

    public static IAccountsService getInstance() {
        return new AccountsService();
    }

    @Override
    public void save(Accounts accounts) {
        String encodePassword = passwordEncoder.encode(accounts.getPassword());
        accounts.setPassword(encodePassword);
        userRepository.save(accounts);
    }

    @Override
    public void saveNotFullInfo(Accounts accounts) {
        String encodePassword = passwordEncoder.encode(accounts.getPassword());
        accounts.setPassword(encodePassword);
        userRepository.savePatch(accounts);
    }

    @Override
    public void delete(Accounts accounts) {
        userRepository.delete(accounts);
    }

    @Override
    public List<Accounts> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<Accounts> getById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<Accounts> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<Orders> getAllHistoryOrders(String accountId) {
        return userRepository.findAllOrderedOfAccount(accountId);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.userWithEmailExists(username);
    }

    @Override
    public boolean updatePassword(String username, String newPassword) {
        String encodePassword = passwordEncoder.encode(newPassword);
        return userRepository.updatePassword(username, encodePassword);
    }

    @Override
    public boolean updateEmail(String username, String newEmail) {
        return userRepository.updateEmail(username, newEmail);
    }

    @Override
    public boolean updateFirstName(String username, String newFirstName) {
        return userRepository.updateFirstName(username, newFirstName);
    }

    @Override
    public boolean updateLastName(String username, String newLastName) {
        return userRepository.updateLastName(username, newLastName);
    }

    @Override
    public boolean updatePhone(String username, String newPhone) {
        return userRepository.updatePhone(username, newPhone);
    }

    @Override
    public boolean updateDateOfBirth(String username, Date newDateOfBirth) {
        return userRepository.updateDateOfBirth(username, newDateOfBirth);
    }

    @Override
    public boolean updateImageUrl(String username, String newImageUrl) {
        return userRepository.updateImageUrl(username, newImageUrl);
    }

    @Override
    public boolean updatePointRewards(String username, double pointRewards) {
        return userRepository.updatePointRewards(username, pointRewards);
    }

    @Override
    public boolean updateStatus(String accountId, String newStatus) {
        return userRepository.updateStatus(accountId, newStatus);
    }

    @Override
    public boolean updateAbout(String newAbout, String username) {
        return userRepository.updateAbout(newAbout, username);
    }

    public static void main(String[] args){
        AuthenticationManager authenticationManager = new ProviderManager();

        Date dateOfBirth = new Date(2004, 8, 22); // 15/06/2000 (Lưu ý: năm bắt đầu từ 1900)

        // Tạo một đối tượng Accounts
//        Accounts myAccount = new Accounts(
//                "user123",
//                "secure123",
//                "user123@example.com",
//                "John",
//                "Doe",
//                dateOfBirth,
//                "0123456789"
//        );

//        Accounts admin = new Accounts(
//                "admin",
//                "admin12345",
//                "devcldkai229@gmail.com",
//                "Kai",
//                "Nguyen",
//                dateOfBirth,
//                "0978504380"
//        );
//        admin.setRoleId(1);

        //System.out.println(myAccount);

       // AccountsService.getInstance().save(admin);
        String role = RoleService.getInstance().getRole(1).orElseThrow(
                () -> new RuntimeException("No role found")
        );

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(role));

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("cesblus204", "user12345", authorities);
        AuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

        authenticationManager.addAuthenticationProvider(authenticationProvider);
        Authentication isAuthenticated = authenticationManager.authenticate(token);
        Collection<GrantedAuthority> authorities1 = (Collection<GrantedAuthority>) isAuthenticated.getAuthorities();
        authorities1.stream().forEach(System.out::println);

//
//        System.out.println(isAuthenticated.isAuthenticated());


//        List<Orders> orders = AccountsService.getInstance().getAllHistoryOrders("3b3f62e5-2dbd-4602-bc8a-4862d168d94d");
//
//        List<OrderedUser> ordersDtoList = orders.stream()
//                .map(x-> OrderedUserDTOMappers.mapToOrderedUserDTO(x, "3b3f62e5-2dbd-4602-bc8a-4862d168d94d")).toList()
//                .stream().sorted(Comparator.comparingLong(OrderedUser::getId).reversed()).toList();
//
//        ordersDtoList.forEach(System.out::println);


    }
}
