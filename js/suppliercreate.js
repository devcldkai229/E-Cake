function createSupplierDashBoard(){
    let nameSupplier = document.getElementById("supplierName").value;
    let phoneSupplier = document.getElementById("phone").value;
    let isValid = true;

    document.getElementById("nameError").classList.add("hidden");
    document.getElementById("phoneError").classList.add("hidden");

    if(!/^[a-zA-Z_\-\s]+$/.test(nameSupplier)) {
        document.getElementById("nameError").classList.remove("hidden");
        isValid = false;
    }

    if(!/^[0-9]+$/.test(phoneSupplier)){
        document.getElementById("phoneError").classList.remove("hidden");
        isValid = false;
    }

    if(isValid){
        fetch(`/createSuppliersDashBoard`, {
            method: 'POST',
            body: new FormData(document.getElementById("supplierForm"))
        }).then(data => {
            showAlert("Create successfully", "green");
            document.getElementById("supplierForm").reset();
        }).catch(error => {
            showAlert("Failed to create product.", "red");
        })
    } else {
        showAlert("Invalid input, please check again!", "yellow");
    }
}