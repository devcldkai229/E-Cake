
function createProductDashBoard() {
    event.preventDefault();
    let name = document.getElementById("nameProducts").value;
    let quantity = parseInt(document.getElementById("unitsOfStocks").value);
    let price = parseFloat(document.getElementById("price").value);

    let isValid = true;

    document.getElementById("nameError").classList.add("hidden");
    document.getElementById("unitsOfStocksError").classList.add("hidden");
    document.getElementById("priceError").classList.add("hidden");

    // Kiểm tra giá trị Name
    if (!/^[a-zA-Z0-9\s]+$/.test(name)) {
        document.getElementById("nameError").classList.remove("hidden");
        isValid = false;
    }

    // Kiểm tra số lượng
    if (isNaN(quantity) || quantity <= 0) {
        document.getElementById("unitsOfStocksError").classList.remove("hidden");
        isValid = false;
    }

    // Kiểm tra giá
    if (isNaN(price) || price <= 0) {
        document.getElementById("priceError").classList.remove("hidden");
        isValid = false;
    }

    if (isValid) {
        fetch(`/createProductsDashBoard`, {
            method: 'POST',
            body: new FormData(document.getElementById("productForm"))
        })
            .then(data => {
                showAlert("Create successfully", "green");
                document.getElementById("productForm").reset();
            })
            .catch(error => {
                showAlert("Failed to create product.", "red");
            });
    } else {
        showAlert("Invalid input, please check again!", "yellow");
    }
}


