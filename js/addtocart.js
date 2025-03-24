function addToCart(idProduct, quantity) {
    fetch(`/addtocart?idProduct=${idProduct}&quantity=${quantity}&currentsize=S`, {
        method: "GET",
    })
        .then(response => response.json())
        .then(data => {
            if(data.status){
                document.getElementById('totalProductsOfCart').textContent = `${data.message}`;
            } else {
                Swal.fire({
                    title: 'Please, Sign in to add this pizza!',
                    icon: 'warning',
                    timer: 2000,
                    showConfirmButton: false
                    }
                );
            }
        })
        .catch(error => {
            console.error("Error:", error);
        });
}


























