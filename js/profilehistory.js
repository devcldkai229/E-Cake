function filterStatusOrders(event){
    let status = document.getElementById("order-type").value;
    let time = document.getElementById("order-time").value;
    window.location.href = `/ordersHistoryFilter?status=${status}&time=${time}`;
}

function cancelOrderInHistoryUser(event, orderId){
    event.preventDefault();
    window.location.href = `/cancelOrder?orderId=${orderId}`;
}