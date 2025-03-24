function increaseProcessing(productId, currentSize) {
    const quantityInput = document.getElementById(`quantityCanBeInDe-${productId}-${currentSize}`);
    const currentQuantity = parseInt(quantityInput.value) + 1;

    updateQuantity(productId, currentQuantity, currentSize);
}

function decreaseProcessing(productId, currentSize) {
    const quantityInput = document.getElementById(`quantityCanBeInDe-${productId}-${currentSize}`);
    const currentQuantity = parseInt(quantityInput.value) - 1;

    if (currentQuantity > 0) {
        updateQuantity(productId, currentQuantity, currentSize);
    }
}

function updateQuantity(productId, currentQuantity, currentSize) {
    fetch(`/updatequantity?productId=${productId}&currentQuantity=${currentQuantity}&currentSize=${currentSize}`, {
        method: 'GET',
    })
        .then((response) => response.json())
        .then((data) => {
            if (data.success) {
                document.getElementById("totalProductsOfCart").textContent = `${data.totalQuantity}`;
                document.getElementById(`quantityCanBeInDe-${productId}-${currentSize}`).value = currentQuantity;
                document.getElementById(`totalChange-${productId}-${currentSize}`).innerText = `$${data.updatedItemTotal}`;
                document.getElementById("totalQuantity").innerText = `Items ${data.totalQuantity}`;
                let shippingFee = parseFloat(document.getElementById("shippingfee").innerText.replace("$", ""));
                if(shippingFee > 0) {
                    let totalWithShippingFee = shippingFee + data.finalTotalNotShippingFee;
                    document.getElementById("totalUp").innerText = `$${data.finalTotalNotShippingFee}`;
                    document.getElementById("total").innerText = `$${data.finalTotalNotShippingFee}`;
                    document.getElementById("finaltotal").innerText = `$${totalWithShippingFee}`;
                } else {
                    document.getElementById("totalUp").innerText = `$${data.finalTotalNotShippingFee}`;
                    document.getElementById("total").innerText = `$${data.finalTotalNotShippingFee}`;
                    document.getElementById("finaltotal").innerText = `$${data.finalTotalNotShippingFee}`;
                }
            } else {
                Swal.fire({
                    title: data.message,
                    icon: "warning",
                    showCancelButton: true,
                })
            }
        })
        .catch((error) => console.error("Error updating quantity:", error));
}