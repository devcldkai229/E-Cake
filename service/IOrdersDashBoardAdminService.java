package devcldkai.kaipizzas.service;

import devcldkai.kaipizzas.domain.dto.OrdersDashBoardDTO;

import java.util.List;

public interface IOrdersDashBoardAdminService {

    List<OrdersDashBoardDTO> getAllOrdersDashBoard();

    int totalProductsDashBoard();

    int totalOrdersUndeliveredDashBoard();

    int totalOrdersDeliveredDashBoard();

    int totalOrdersDashBoard();

    double totalSalesDashBoard();
}
