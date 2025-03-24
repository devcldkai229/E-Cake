function removeOrder(orderId) {
    fetch(`/removeOrderDashBoard?orderId=${orderId}`, {
        method: 'POST'
    })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                // Xóa dòng đơn hàng khỏi bảng
                document.getElementById(`order-row-${orderId}`).remove();
            } else {
                // Hiển thị lỗi nếu không thể xóa
                document.getElementById(`messageRemoveError-${orderId}`).innerText = data.message;
                document.getElementById(`messageRemoveError-${orderId}`).classList.remove("hidden");
            }
        })
        .catch(error => console.error("Error:", error));
}


