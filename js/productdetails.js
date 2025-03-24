function addToCartWithSize(idProduct, quantity, size) {
    fetch(`/addtocart?idProduct=${idProduct}&quantity=${quantity}&currentsize=${size}`, {
        method: "GET",
    })
        .then(response => response.json())
        .then(data => {
            console.log("Response from server:", data);

            if (data.status) {
                if (!isNaN(parseInt(data.message))) {
                    document.getElementById('totalProductsOfCart').textContent = data.message;
                }
            } else {
                Swal.fire({
                    title: 'Please sign in to add this pizza!',
                    icon: 'warning',
                    timer: 2000,
                    showConfirmButton: false
                });
            }
        })
        .catch(error => {
            console.error("Lỗi khi gọi API:", error);
        });
}


function addToOrderNow(idProduct, quantity, size) {
    const {value: shippingFee} = Swal.fire({
        title: "Select the formal delivering",
        input: "select",
        inputOptions: {
            standard: "Standard shipping - $2.0",
            express: "Express shipping (1 hour) - $4.0"
        },
        inputPlaceholder: "Choose the shipping delivering",
        showCancelButton: true,
        inputValidator: (value) => {
            return new Promise((resolve) => {
                if (value === "standard") {
                    window.location.href = `/ordernow?idProduct=${idProduct}&quantity=${quantity}&currentsize=${size}&shippingfee=2.0`;
                } else if (value === "express") {
                    window.location.href = `/ordernow?idProduct=${idProduct}&quantity=${quantity}&currentsize=${size}&shippingfee=4.0`;
                } else {
                    resolve("You need to select the shipping delivering!)");
                }
            });
        }
    })
}
