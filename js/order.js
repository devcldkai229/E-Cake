 function toggleCardInputs() {
        const isCardSelected = document.getElementById("card").checked;

        const cardNumber = document.getElementById("cardNumber");
        const expiryDate = document.getElementById("expiryDate");
        const cvv = document.getElementById("cvv");

        if (isCardSelected) {
        cardNumber.disabled = false;
        expiryDate.disabled = false;
        cvv.disabled = false;
        } else {
            cardNumber.disabled = true;
            expiryDate.disabled = true;
            cvv.disabled = true;
        }
    }

    document.addEventListener("DOMContentLoaded", toggleCardInputs);
    function showConfirmOrderSuccess() {
        Swal.fire({
            title: 'Order successfully',
            text: "Thanks for your order!",
            icon: 'success',
            timer: 1800,
            showConfirmButton: false
        });
    }

    function cancelOrderAndBackToMarketplace(){
        window.location.href = '/productlist'
    }
