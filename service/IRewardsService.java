package devcldkai.kaipizzas.service;

import devcldkai.kaipizzas.domain.entities.Rewards;

import java.util.List;
import java.util.Optional;

public interface IRewardsService {

    List<Rewards> getAll();

    Optional<Rewards> getById(int id);

    void save(Rewards rewards);

    boolean updateUnitsOfStock(int id, int quantity);

}
