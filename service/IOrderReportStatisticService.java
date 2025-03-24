package devcldkai.kaipizzas.service;

import devcldkai.kaipizzas.domain.dto.OrderReportDTO;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public interface IOrderReportStatisticService {

    List<OrderReportDTO> getAllDeliveredByStartDateAndEndDate(LocalDateTime startDate, LocalDateTime endDate) throws SQLException;

}
