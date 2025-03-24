function showAlert(message, color) {
    let alertContainer = document.getElementById("alertContainer");
    let alertBox = document.createElement("div");

    let colors = {
        green: "bg-green-500 shadow-green-200",
        yellow: "bg-yellow-500 shadow-yellow-200",
        red: "bg-red-500 shadow-red-200",
        blue: "bg-blue-500 shadow-blue-200"
    };

    alertBox.className = `text-white font-semibold flex items-center w-max max-w-sm p-4 rounded-md shadow-md ${colors[color]} transition-opacity opacity-100`;
    alertBox.innerHTML = `
        <span class="block sm:inline text-sm mr-3">${message}</span>
        <svg xmlns="http://www.w3.org/2000/svg" class="w-3 cursor-pointer shrink-0 fill-white ml-auto" onclick="this.parentElement.remove()"
            viewBox="0 0 320.591 320.591">
            <path d="M30.391 318.583a30.37 30.37 0 0 1-21.56-7.288c-11.774-11.844-11.774-30.973 0-42.817L266.643 10.665c12.246-11.459 31.462-10.822 42.921 1.424 10.362 11.074 10.966 28.095 1.414 39.875L51.647 311.295a30.366 30.366 0 0 1-21.256 7.288z"/>
            <path d="M287.9 318.583a30.37 30.37 0 0 1-21.257-8.806L8.83 51.963C-2.078 39.225-.595 20.055 12.143 9.146c11.369-9.736 28.136-9.736 39.504 0l259.331 257.813c12.243 11.462 12.876 30.679 1.414 42.922-.456.487-.927.958-1.414 1.414a30.368 30.368 0 0 1-23.078 7.288z"/>
        </svg>
    `;

    alertContainer.appendChild(alertBox);

    // Tự động ẩn sau 3 giây
    setTimeout(() => {
        alertBox.style.opacity = "0";
        setTimeout(() => alertBox.remove(), 500);
    }, 3000);
}

function updateProductDashBoard() {
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
        fetch(`/updateProductsDashBoard`, {
            method: 'POST',
            body: new FormData(document.getElementById("productForm"))
        })
            .then(response => response.json())
            .then(data => {
                showAlert("Update successfully", "green");
            })
            .catch(error => {
                showAlert("Failed to update product.", "red");
            });
    } else {
        showAlert("Invalid input, please check again!", "yellow");
    }
}


