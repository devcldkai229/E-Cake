package devcldkai.kaipizzas.service.impl;

import devcldkai.kaipizzas.domain.entities.Rewards;
import devcldkai.kaipizzas.repository.RewardsRepository;
import devcldkai.kaipizzas.repository.impl.RewardsRepositoryImpl;
import devcldkai.kaipizzas.service.IRewardsService;

import java.util.List;
import java.util.Optional;

public class RewardsService implements IRewardsService {

    private RewardsRepository rewardsRepository = new RewardsRepositoryImpl();

    public static IRewardsService getInstance(){
        return new RewardsService();
    }

    @Override
    public List<Rewards> getAll() {
        return rewardsRepository.selectAllRewards();
    }

    @Override
    public Optional<Rewards> getById(int id) {
        return rewardsRepository.selectRewardById(id);
    }

    @Override
    public void save(Rewards rewards) {
        rewardsRepository.save(rewards);
    }

    @Override
    public boolean updateUnitsOfStock(int id, int quantity) {
        return rewardsRepository.updateQuantity(id, quantity);
    }

    public static void main(String[] args){
        List<Rewards> rewardsList = RewardsService.getInstance().getAll();
        for(Rewards rewards : rewardsList){
            System.out.println(rewards);
        }
    }
}
