function markCompleteOrder(orderId){
    fetch(`/markcompleteorder?orderId=${orderId}`, {
        method: 'GET'
    })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                let totalOrderUndeliveredBeforeComplete = parseInt(document.getElementById("totalOrderUndelivered").innerText);
                let totalOrderUndeliveredAfterComplete = totalOrderUndeliveredBeforeComplete - 1;
                document.getElementById(`shippedDate-${orderId}`).innerText = data.shippedDate;
                document.getElementById(`status-${orderId}`).innerText = data.statusOrder;
                document.getElementById("totalOrderUndelivered").innerText = totalOrderUndeliveredAfterComplete;
            } else {
                document.getElementById(`messageRemoveError-${orderId}`).innerText = data.message;
            }
        })
        .catch(error => console.error("Error:", error));
}