package devcldkai.kaipizzas.mapper;

import devcldkai.kaipizzas.domain.dto.OrderedUserDTO;
import devcldkai.kaipizzas.domain.entities.Orders;

import java.time.format.DateTimeFormatter;

public class OrderedUserDTOMappers {

    private OrderedUserDTOMappers() {}

    public static OrderedUserDTO mapToOrderedUserDTO(Orders orders, String accountId) {
        OrderedUserDTO orderedUserDTO = new OrderedUserDTO();
        orderedUserDTO.setAccountId(accountId);
        orderedUserDTO.setId(orders.getId());
        orderedUserDTO.setTotal(orders.getTotal());
        orderedUserDTO.setStatus(orders.getStatus());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        orderedUserDTO.setOrderedDate(formatter.format(orders.getOrderDate()));
        orderedUserDTO.setRequiredDate(formatter.format(orders.getRequiredDate()));
        orderedUserDTO.setShippedDate(orders.getShippedDate()!=null?
                formatter.format(orders.getShippedDate())
                :"#NoData");
        return orderedUserDTO;
    }
}
